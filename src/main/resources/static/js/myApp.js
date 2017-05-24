
function sendNotification(recipe) {
}


var app = angular.module("myApp", [ 'ui.router' ]);
app.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state("dashboard", {
		url : "/dashboard",
		templateUrl : "views/Dashboard.html",
		controller : "myAppController"
	});
	$stateProvider.state("devices", {
		url : "/devices",
		templateUrl : "views/Devices.html",
		controller : "BoitierController"
	});
	$stateProvider.state("user", {
		url : "/users",
		templateUrl : "views/Users.html",
		controller : "UserController"
	});
	$stateProvider.state("note", {
		url : "/note",
		templateUrl : "views/Note.html",
		controller : "NoteController"
	})
	$stateProvider.state("category", {
		url : "/category",
		templateUrl : "views/Category.html",
		controller : "CategoryController"
	})
	$stateProvider.state("manufacture", {
		url : "/manufacture",
		templateUrl : "views/Manufacture.html",
		controller : "ManufactureController"
	})
	$stateProvider.state("aroma", {
		url : "/aroma",
		templateUrl : "views/Aroma.html",
		controller : "AromaController"
	})
	$stateProvider.state("base", {
		url : "/base",
		templateUrl : "views/Base.html",
		controller : "BaseController"
	})
	$stateProvider.state("recipe", {
		url : "/recipe",
		templateUrl : "views/Recipe.html",
		controller : "RecipeController"
	})
	$stateProvider.state("browsRecipe", {
		url : "/brows_recipes",
		templateUrl : "views/BrowsRecipes.html",
		controller : "BrowsRecipeController"
	})
	$stateProvider.state("recipeDetail", {
		url : "/recipe_detail",
		templateUrl : "views/RecipeDetail.html",
		controller : "RecipeDetailController"
	})


});
app.service('recipeService', function() {
	var recipe = null;

	var setRecipe = function(r) {
		recipe = r;
	};

	var getRecipe = function() {
		return recipe;
	};

	return {
		setRecipe : setRecipe,
		getRecipe : getRecipe
	};

});
app.controller("BrowsRecipeController", function($scope, $http, recipeService) {


	$scope.colorArray = [ '#ff9800', '#ea4c89', '#55acee', '#3b5998', '#cc2127', '#333333', '#9c27b0' ]

	$scope.showTable = false;

	$scope.deleteRecipe = function(recipe) {

		swal({
			title : 'Are you sure?',
			text : "You won't be able to revert this!",
			type : 'warning',
			showCancelButton : true,
			confirmButtonClass : 'btn btn-success',
			cancelButtonClass : 'btn btn-danger',
			confirmButtonText : 'Yes, delete it!',
			buttonsStyling : false
		}).then(function() {

			$http({
				method : 'DELETE',
				url : '/recipe/',
				data : recipe,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			})
				.then(function(response) {


					swal({
						title : 'Deleted!',
						text : 'Your file has been deleted.',
						type : 'success',
						confirmButtonClass : "btn btn-success",
						buttonsStyling : false
					})

					$scope.loadRecipe();
				}, function(rejection) {
					swal({
						title : 'Error',
						text : 'Sorry we can\'t delete <br> This Recipe  ',
						type : 'error',
						confirmButtonClass : "btn btn-info",
						buttonsStyling : false
					})
				});

		}).catch(function() {
			swal({
				title : 'Canceled!',
				text : 'Your file has not been deleted.',
				type : 'warning',
				confirmButtonClass : "btn btn-success",
				buttonsStyling : false
			})
		});

	}




	$scope.displayTable = function() {
		$scope.showTable = !$scope.showTable;
	};

	$scope.loadRecipe = function() {

		$http.get("/recipe/").success(function(data) {
			$scope.recipes = data;
		});

	}
	$scope.setSelectedRecipe = function(recipe) {
		recipeService.setRecipe(recipe);
	}

});

app.controller("RecipeDetailController", function($scope, $http, recipeService) {
	$scope.recipe = recipeService.getRecipe();


	$scope.setSelectedAroma = function(aroma) {
		$scope.selectedAroma = aroma;
		console.log(JSON.stringify(aroma));
	}


	var series = [];
	var labels = [];


	var baseQuantity = $scope.recipe.baseQuantity;
	series.push(100 * baseQuantity / $scope.recipe.volume);
	labels.push("Base " + $scope.recipe.base.pg + " / " + $scope.recipe.base.vg + " / " + $scope.recipe.base.nicotine + "  ");

	for (i = 0; i < $scope.recipe.aromes.length; i++) {
		var quantity = $scope.recipe.aromes[i].quantity;
		var s = (100 * quantity / $scope.recipe.volume)
		series.push(s);
		labels.push($scope.recipe.aromes[i].arome.arome);

	}

	$scope.initChart = function() {
		console.log("initChart");
		var dataPreferences = {
			labels : labels,
			series : series
		};

		var optionsPreferences = {
			height : '350px'
		};

		Chartist.Pie('#chartPreferences', dataPreferences, optionsPreferences);
	}



});
app.controller("RecipeController", function($scope, $http, $location) {



	$scope.imageUrl = null;
	$scope.startSelection = false;
	$scope.error = false;
	$scope.AromesArray = new Array();
	$scope.showStep1 = true;
	$scope.showStep2 = false;
	$scope.aromesPerRecipe = new Array();
	$scope.totalAromeQuantity = 0;
	$scope.quantityArray = new Array();

	$scope.uploadFile = function() {

		if ($scope.name != undefined && $scope.stip != undefined && $scope.volume != undefined && $scope.description != undefined &&
			$scope.selectedbase != undefined && $scope.baseQuantity != undefined) {
			if ($scope.AromesArray.length == $scope.arome_number) {
				if (document.getElementById('files').files[0] != undefined) {
					var date = new Date();
					fileName = document.getElementById('files').files[0].name + date.toString();
					var storageRef = firebase.storage().ref("recipe/" + fileName);
					var image = document.getElementById('files').files[0];
					var uploadTask = storageRef.put(image);
					uploadTask.on('state_changed', function(snapshot) {
						var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
						console.log('Upload is ' + progress + '% done');
						switch (snapshot.state) {
						case firebase.storage.TaskState.PAUSED:
							console.log('Upload is paused');
							break;
						case firebase.storage.TaskState.RUNNING:
							console.log('Upload is running');
							break;
						}
					}, function(error) {}, function() {

						var downloadURL = uploadTask.snapshot.downloadURL;
						$scope.imageUrl = downloadURL;
						$scope.getAromesQuantity();
						console.log(downloadURL);
					});
				} else {
					swal({
						title : 'Error',
						text : 'You have to choose a picture before submitting...',
						type : 'error',
						confirmButtonClass : "btn btn-info",
						buttonsStyling : false
					})
				}
			} else {
				swal({
					title : 'Error',
					text : 'Please Make sure to choose ' + $scope.arome_number + ' Aroma...',
					type : 'error',
					confirmButtonClass : "btn btn-info",
					buttonsStyling : false
				})

			}
		} else {

			swal({
				title : 'Error',
				text : 'Please fill all fields...',
				type : 'error',
				confirmButtonClass : "btn btn-info",
				buttonsStyling : false
			})

		}





	};



	$scope.getAromesQuantity = function() {

		for (var i = 0; i < $scope.AromesArray.length; i++) {


			if (document.getElementById('AromaVolume' + i).value != "") {
				$scope.totalAromeQuantity += parseFloat(document.getElementById('AromaVolume' + i).value);
				var arome = {
					quantity : document.getElementById('AromaVolume' + i).value,
					arome : $scope.AromesArray[i]
				};
			} else {
				$scope.quantityError = true;
				return;
			}

			$scope.aromesPerRecipe.push(arome);


		}
		console.log(JSON.stringify($scope.aromesPerRecipe));
		$scope.addRecipe();







	}

	$scope.addRecipe = function() {

		var date = new Date();

		var recipe = {
			description : $scope.description,
			date : date.toString(),
			imageUrl : $scope.imageUrl,
			name : $scope.name,
			stip : $scope.stip,
			baseQuantity : $scope.baseQuantity,
			volume : $scope.volume,
			totalAromeQuantity : $scope.totalAromeQuantity,
			base : $scope.selectedbase,
			aromes : $scope.aromesPerRecipe
		}
		$http({
			url : '/recipe',
			method : 'POST',
			data : recipe,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			console.log("success");


			$http.get("http://127.0.0.1/SensOr/Push_Notification.php?recipe_id=" + response.data.id).success(function(data) {
				demo.showNotification('top', 'left');
				$location.path('/brows_recipes');
			});




		}, function errorCallback(response) {});

	}



	$scope.insertQuantity = function() {
		$scope.quantityArray = [];
		$scope.totaAromeForCheck = 0;
		for (var i = 0; i < $scope.AromesArray.length; i++) {

			$scope.totaAromeForCheck += parseFloat(document.getElementById('AromaVolume' + i).value);
			$scope.quantityArray.push(document.getElementById('AromaVolume' + i).value)

		}

		if (($scope.totaAromeForCheck + $scope.baseQuantity) != $scope.volume) {

			$scope.combinationError = true;
		} else {
			$scope.combinationError = false;
		}

	}



	$scope.insertArome = function(arome) {
		var exist = false;
		if ($scope.arome_number <= $scope.AromesArray.length) {
			$scope.AromesArray = [];
			$scope.quantityArray = [];
		}
		if ($scope.AromesArray.length == 0) {
			$scope.AromesArray.push(arome);
		} else {
			for (var i = 0; i < $scope.AromesArray.length; i++) {

				if ($scope.AromesArray[i].id == arome.id) {
					exist = true;
				}

			}
			if (exist) {
				$scope.error = true;
			} else {
				$scope.error = false;
				$scope.AromesArray.push(arome);
			}
		}
	}

	$scope.loadBase = function() {
		$http.get("/base/").success(function(data) {
			$scope.bases = data;
		});
	}
	$scope.loadAroma = function() {
		$scope.AromesArray = new Array();
		$http.get("/arome").success(function(data) {
			$scope.aromes = data;
		});
	}



	$scope.displayAromaPanel = function(num) {
		return new Array(num);
		$scope.AromesArray = new Array();
	}
	$scope.displayStep2 = function() {
		$scope.showStep1 = false;
		$scope.showStep2 = true;
	}
	$scope.displayStep1 = function() {
		$scope.showStep1 = true;
		$scope.showStep2 = false;
	}
	$scope.setSelectedBase = function(b) {
		$scope.selectedbase = b;
	}


})

app.controller("BaseController", function($scope, $http) {


	$scope.deleteBase = function(base) {

		swal({
			title : 'Are you sure?',
			text : "You won't be able to revert this!",
			type : 'warning',
			showCancelButton : true,
			confirmButtonClass : 'btn btn-success',
			cancelButtonClass : 'btn btn-danger',
			confirmButtonText : 'Yes, delete it!',
			buttonsStyling : false
		}).then(function() {

			$http({
				method : 'DELETE',
				url : '/base/',
				data : base,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			})
				.then(function(response) {


					swal({
						title : 'Deleted!',
						text : 'Your file has been deleted.',
						type : 'success',
						confirmButtonClass : "btn btn-success",
						buttonsStyling : false
					})

					$scope.loadBase();
				}, function(rejection) {
					swal({
						title : 'Error',
						text : 'Sorry we can\'t delete <br> This base already used in many Recipes ',
						type : 'error',
						confirmButtonClass : "btn btn-info",
						buttonsStyling : false
					})
				});

		}).catch(function() {
			swal({
				title : 'Canceled!',
				text : 'Your file has not been deleted.',
				type : 'warning',
				confirmButtonClass : "btn btn-success",
				buttonsStyling : false
			})
		});

	}




	$scope.uploadFile = function() {
		var date = new Date();
		fileName = document.getElementById('files').files[0].name + date.toString();
		var storageRef = firebase.storage().ref("base/" + fileName);
		var image = document.getElementById('files').files[0];
		var uploadTask = storageRef.put(image);
		uploadTask.on('state_changed', function(snapshot) {
			var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
			console.log('Upload is ' + progress + '% done');
			switch (snapshot.state) {
			case firebase.storage.TaskState.PAUSED:
				console.log('Upload is paused');
				break;
			case firebase.storage.TaskState.RUNNING:
				console.log('Upload is running');
				break;
			}
		}, function(error) {}, function() {

			var downloadURL = uploadTask.snapshot.downloadURL;
			$scope.url = downloadURL;
			$scope.addBase();
			console.log(downloadURL);
		});


	};

	$scope.addBase = function() {
		var date = new Date();


		$http({
			url : '/base',
			method : 'POST',
			data : JSON.stringify({
				nicotine : $scope.nicotine,
				pg : $scope.pg,
				vg : $scope.vg,
				date : date.toString(),
				description : $scope.description,
				imageUrl : $scope.url
			}),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.nicotine = "";
			$scope.pg = "";
			$scope.description = "";
			document.getElementById('selected_file').innerHTML = "";
			document.getElementById('placeholder').style.display = "inline";
			$scope.loadBase();
		}, function errorCallback(response) {});
	};
	$scope.loadBase = function() {
		$http.get("/base").success(function(data) {
			$scope.bases = data;

		});
	}


});

app.controller("AromaController", function($scope, $http) {



	$scope.enableArome = function(arome) {
		$http({
			method : 'PUT',
			url : '/arome/' + arome.id,
			headers : {
				'Content-type' : 'application/json;charset=utf-8'
			}
		})
			.then(function(response) {


				swal({
					title : 'Approved!',
					text : 'Your file has been updated.',
					type : 'success',
					confirmButtonClass : "btn btn-success",
					buttonsStyling : false
				})

				$scope.loadAroma();
				$scope.loadDisabledAroma();
			}, function(rejection) {
				swal({
					title : 'Error',
					text : 'Sorry we can\'t update <b>' + arome.name + '</b><br> Server Error ',
					type : 'error',
					confirmButtonClass : "btn btn-info",
					buttonsStyling : false
				})
			});
	}


	$scope.url = null;
	var filename = null;
	var allAromas = [];

	$scope.selectedCategory = null;
	$scope.selectedManufacture = null;


	$scope.$watch('choosenCategory', function() {

		if ($scope.choosenCategory != undefined) {

			var aromas = [];
			for (var i = 0; i < allAromas.length; i++) {

				if (allAromas[i].category.id == $scope.choosenCategory.id) {
					aromas.push(allAromas[i]);
				}

			}
			$scope.aromas = aromas;
		} else {
			$scope.aromas = allAromas;
		}
	}, true);


	$scope.$watch('choosenManufacturer', function() {

		if ($scope.choosenManufacturer != undefined) {

			var aromas = [];
			for (var i = 0; i < allAromas.length; i++) {

				if (allAromas[i].manufacture.id == $scope.choosenManufacturer.id) {
					aromas.push(allAromas[i]);
				}

			}
			$scope.aromas = aromas;
		} else {
			$scope.aromas = allAromas;
		}
	}, true);




	$scope.setSelectedCategory = function(c) {
		$scope.selectedCategory = c;
	};
	$scope.setSelectedManufacture = function(m) {
		$scope.selectedManufacture = m;
	}

	$scope.loadCategory = function() {
		$http.get("/category").success(function(data) {
			$scope.categories = data;

		});
	}
	$scope.loadManufacture = function() {
		$http.get("/manufacture/").success(function(data) {
			$scope.manufactures = data;


		});
	}


	$scope.uploadFile = function() {
		var date = new Date();
		fileName = document.getElementById('files').files[0].name + date.toString();
		var storageRef = firebase.storage().ref("aroma/" + fileName);
		var image = document.getElementById('files').files[0];
		var uploadTask = storageRef.put(image);
		uploadTask.on('state_changed', function(snapshot) {
			var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
			console.log('Upload is ' + progress + '% done');
			switch (snapshot.state) {
			case firebase.storage.TaskState.PAUSED:
				console.log('Upload is paused');
				break;
			case firebase.storage.TaskState.RUNNING:
				console.log('Upload is running');
				break;
			}
		}, function(error) {}, function() {

			var downloadURL = uploadTask.snapshot.downloadURL;
			$scope.url = downloadURL;
			$scope.addAroma();
			console.log(downloadURL);
		});


	};




	$scope.addAroma = function() {
		var date = new Date();
		$http({
			url : '/arome',
			method : 'POST',
			data : angular.toJson({
				arome : $scope.arome,
				imageUrl : $scope.url,
				description : $scope.description,
				date : date.toString(),
				manufacture : $scope.selectedManufacture,
				category : $scope.selectedCategory
			}),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			document.getElementById('selected_file').innerHTML = "";
			document.getElementById('placeholder').style.display = "inline";
			$scope.arome = "";
			$scope.description = "";
			demo.showSwal('aroma-success');
			$scope.loadAroma();
		}, function errorCallback(response) {});
	}

	$scope.loadAroma = function() {
		$http.get("/arome/").success(function(data) {
			$scope.aromas = data;
			allAromas = data;

		});
	}

	$scope.loadDisabledAroma = function() {
		$http.get("/arome/disabled").success(function(data) {
			$scope.desabledAromas = data;
			allAromas = data;

		});
	}

	$scope.displayAromaDetail = function(aroma) {
		$scope.aromaForDetail = aroma;
	}


	$scope.deleteArome = function(arome) {

		swal({
			title : 'Are you sure?',
			text : "You won't be able to revert this!",
			type : 'warning',
			showCancelButton : true,
			confirmButtonClass : 'btn btn-success',
			cancelButtonClass : 'btn btn-danger',
			confirmButtonText : 'Yes, delete it!',
			buttonsStyling : false
		}).then(function() {

			$http({
				method : 'DELETE',
				url : '/arome/',
				data : arome,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			})
				.then(function(response) {


					swal({
						title : 'Deleted!',
						text : 'Your file has been deleted.',
						type : 'success',
						confirmButtonClass : "btn btn-success",
						buttonsStyling : false
					})
					$scope.loadDisabledAroma();
					$scope.loadAroma();
				}, function(rejection) {
					swal({
						title : 'Error',
						text : 'Sorry we can\'t delete <br> This Aroma is already used in many Recipes ',
						type : 'error',
						confirmButtonClass : "btn btn-info",
						buttonsStyling : false
					})
				});

		}).catch(function() {
			swal({
				title : 'Canceled!',
				text : 'Your file has not been deleted.',
				type : 'warning',
				confirmButtonClass : "btn btn-success",
				buttonsStyling : false
			})
		});

	}


});

app.controller("ManufactureController", function($scope, $http) {
	$scope.url = null;
	var filename = null;


	$scope.flushUpdate = function(manufacture) {
		$http({
			method : 'PUT',
			url : '/manufacture/',
			data : manufacture,
			headers : {
				'Content-type' : 'application/json;charset=utf-8'
			}
		})
			.then(function(response) {


				swal({
					title : 'Updated!',
					text : 'Your file has been updated.',
					type : 'success',
					confirmButtonClass : "btn btn-success",
					buttonsStyling : false
				})

				$scope.loadManufacture();
			}, function(rejection) {
				swal({
					title : 'Error',
					text : 'Sorry we can\'t update <b>' + manufacture.name + '</b><br> Server Error ',
					type : 'error',
					confirmButtonClass : "btn btn-info",
					buttonsStyling : false
				})
			});
	}

	$scope.updateManufacture = function(manufacture) {

		if (document.getElementById('newFiles').files[0] != undefined) {
			var date = new Date();
			var fileName = document.getElementById('newFiles').files[0].name + date.toString();
			var storageRef = firebase.storage().ref("manufacture/" + fileName);
			var image = document.getElementById('newFiles').files[0];
			var uploadTask = storageRef.put(image);
			uploadTask.on('state_changed', function(snapshot) {
				var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
				console.log('Upload is ' + progress + '% done');
				switch (snapshot.state) {
				case firebase.storage.TaskState.PAUSED:
					console.log('Upload is paused');
					break;
				case firebase.storage.TaskState.RUNNING:
					console.log('Upload is running');
					break;
				}
			}, function(error) {}, function() {

				var downloadURL = uploadTask.snapshot.downloadURL;
				manufacture.imageUrl = downloadURL;
				manufacture.name = $scope.newName;
				manufacture.description = $scope.newDescription;
				manufacture.address = $scope.newAddress;
				$scope.flushUpdate(manufacture);
			});
		} else {
			manufacture.name = $scope.newName;
			manufacture.description = $scope.newDescription;
			manufacture.address = $scope.newAddress;
			$scope.flushUpdate(manufacture);


		}




	}



	$scope.setSelectedManufacture = function(manufacture) {
		$scope.selectedManufacture = manufacture;
		$scope.newName = manufacture.name;
		$scope.newAddress = manufacture.address;
		$scope.newDescription = manufacture.description;



	}

	$scope.uploadFile = function() {
		var date = new Date();
		fileName = document.getElementById('files').files[0].name + date.toString();
		var storageRef = firebase.storage().ref("manufacture/" + fileName);
		var image = document.getElementById('files').files[0];
		var uploadTask = storageRef.put(image);
		uploadTask.on('state_changed', function(snapshot) {
			var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
			console.log('Upload is ' + progress + '% done');
			switch (snapshot.state) {
			case firebase.storage.TaskState.PAUSED:
				console.log('Upload is paused');
				break;
			case firebase.storage.TaskState.RUNNING:
				console.log('Upload is running');
				break;
			}
		}, function(error) {}, function() {

			var downloadURL = uploadTask.snapshot.downloadURL;
			$scope.url = downloadURL;
			$scope.addManufacture();
			console.log(downloadURL);
		});


	};

	$scope.addManufacture = function() {
		var date = new Date();


		$http({
			url : '/manufacture',
			method : 'POST',
			data : JSON.stringify({
				address : $scope.address,
				name : $scope.name,
				imageUrl : $scope.url,
				description : $scope.description,
				date : date.toString()
			}),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			document.getElementById('selected_file').innerHTML = "";
			document.getElementById('placeholder').style.display = "inline";
			$scope.name = "";
			$scope.address = "";
			$scope.description = "";
			$scope.loadManufacture();
		}, function errorCallback(response) {});
	}

	$scope.loadManufacture = function() {
		$http.get("/manufacture/").success(function(data) {
			$scope.manufactures = data;

		});
	}
	$scope.deleteManufacture = function(manufacture) {

		swal({
			title : 'Are you sure?',
			text : "You won't be able to revert this!",
			type : 'warning',
			showCancelButton : true,
			confirmButtonClass : 'btn btn-success',
			cancelButtonClass : 'btn btn-danger',
			confirmButtonText : 'Yes, delete it!',
			buttonsStyling : false
		}).then(function() {

			$http({
				method : 'DELETE',
				url : '/manufacture/',
				data : manufacture,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			})
				.then(function(response) {


					swal({
						title : 'Deleted!',
						text : 'Your file has been deleted.',
						type : 'success',
						confirmButtonClass : "btn btn-success",
						buttonsStyling : false
					})

					$scope.loadManufacture();
				}, function(rejection) {
					swal({
						title : 'Error',
						text : 'Sorry we can\'t delete <b>' + manufacture.name + '</b><br> Delete Aroma Before ',
						type : 'error',
						confirmButtonClass : "btn btn-info",
						buttonsStyling : false
					})
				});

		}).catch(function() {
			swal({
				title : 'Canceled!',
				text : 'Your file has not been deleted.',
				type : 'warning',
				confirmButtonClass : "btn btn-success",
				buttonsStyling : false
			})
		});

	}


})


app.controller("CategoryController", function($scope, $http) {

	$scope.url = null;
	var fileName = null;
	$scope.flushUpdate = function(category) {
		$http({
			method : 'PUT',
			url : '/category/',
			data : category,
			headers : {
				'Content-type' : 'application/json;charset=utf-8'
			}
		})
			.then(function(response) {


				swal({
					title : 'Updated!',
					text : 'Your file has been updated.',
					type : 'success',
					confirmButtonClass : "btn btn-success",
					buttonsStyling : false
				})

				$scope.loadManufacture();
			}, function(rejection) {
				swal({
					title : 'Error',
					text : 'Sorry we can\'t update <b>' + category.name + '</b><br> Server Error ',
					type : 'error',
					confirmButtonClass : "btn btn-info",
					buttonsStyling : false
				})
			});
	}
	$scope.updateCategory = function(category) {

		if (document.getElementById('newFiles').files[0] != undefined) {
			var date = new Date();
			var fileName = document.getElementById('newFiles').files[0].name + date.toString();
			var storageRef = firebase.storage().ref("category/" + fileName);
			var image = document.getElementById('newFiles').files[0];
			var uploadTask = storageRef.put(image);
			uploadTask.on('state_changed', function(snapshot) {
				var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
				console.log('Upload is ' + progress + '% done');
				switch (snapshot.state) {
				case firebase.storage.TaskState.PAUSED:
					console.log('Upload is paused');
					break;
				case firebase.storage.TaskState.RUNNING:
					console.log('Upload is running');
					break;
				}
			}, function(error) {}, function() {

				var downloadURL = uploadTask.snapshot.downloadURL;
				category.imageUrl = downloadURL;
				category.category = $scope.newName;
				category.description = $scope.newDescription;

				$scope.flushUpdate(category);
			});
		} else {
			category.category = $scope.newName;
			category.description = $scope.newDescription;
			$scope.flushUpdate(category);


		}




	}


	$scope.setSelectedCategory = function(category) {
		$scope.selectedCategory = category;
		$scope.newName = category.category;
		$scope.newDescription = category.description
	}


	$scope.uploadFile = function() {

		var date = new Date();
		fileName = document.getElementById('files').files[0].name + date.toString();

		var storageRef = firebase.storage().ref("category/" + fileName);
		var image = document.getElementById('files').files[0];
		var uploadTask = storageRef.put(image);
		uploadTask.on('state_changed', function(snapshot) {
			var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
			console.log('Upload is ' + progress + '% done');
			switch (snapshot.state) {
			case firebase.storage.TaskState.PAUSED:
				console.log('Upload is paused');
				break;
			case firebase.storage.TaskState.RUNNING:
				console.log('Upload is running');
				break;
			}
		}, function(error) {}, function() {

			var downloadURL = uploadTask.snapshot.downloadURL;
			$scope.url = downloadURL;
			$scope.addCategory();
			console.log(downloadURL);
		});

	};

	$scope.addCategory = function() {
		var date = new Date();


		$http({
			url : '/category',
			method : 'POST',
			data : JSON.stringify({
				category : $scope.category,
				imageName : fileName,
				imageUrl : $scope.url,
				description : $scope.description,
				date : date.toString()
			}),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			document.getElementById('selected_file').innerHTML = "";
			document.getElementById('placeholder').style.display = "inline";
			$scope.category = "";
			$scope.description = "";
			$scope.loadCategory();
		}, function errorCallback(response) {});
	}
	$scope.loadCategory = function() {
		$http.get("/category/").success(function(data) {
			$scope.categories = data;

		});
	}


	$scope.deleteCategory = function(category) {

		swal({
			title : 'Are you sure?',
			text : "You won't be able to revert this!",
			type : 'warning',
			showCancelButton : true,
			confirmButtonClass : 'btn btn-success',
			cancelButtonClass : 'btn btn-danger',
			confirmButtonText : 'Yes, delete it!',
			buttonsStyling : false
		}).then(function() {

			$http({
				method : 'DELETE',
				url : '/category/',
				data : category,
				headers : {
					'Content-type' : 'application/json;charset=utf-8'
				}
			})
				.then(function(response) {


					swal({
						title : 'Deleted!',
						text : 'Your file has been deleted.',
						type : 'success',
						confirmButtonClass : "btn btn-success",
						buttonsStyling : false
					})

					$scope.loadCategory();
				}, function(rejection) {
					swal({
						title : 'Error',
						text : 'Sorry we can\'t delete <b>' + category.category + '</b><br> Delete Aroma Before ',
						type : 'error',
						confirmButtonClass : "btn btn-info",
						buttonsStyling : false
					})
				});

		}).catch(function() {
			swal({
				title : 'Canceled!',
				text : 'Your file has not been deleted.',
				type : 'warning',
				confirmButtonClass : "btn btn-success",
				buttonsStyling : false
			})
		});



	}




});
app.controller("MainController", function($scope) {

	$scope.selectDashboard = function() {
		document.getElementById("dashboard").className = "active";
		document.getElementById("devices").className = "";
		document.getElementById("users").className = "";
		document.getElementById("notes").className = "";

	};
	$scope.selectDevices = function() {
		document.getElementById("devices").className = "active";
		document.getElementById("dashboard").className = "";
		document.getElementById("users").className = "";
		document.getElementById("notes").className = "";


	};
	$scope.selectUsers = function() {
		document.getElementById("users").className = "active";
		document.getElementById("dashboard").className = "";
		document.getElementById("devices").className = "";
		document.getElementById("notes").className = "";


	};
	$scope.selectNote = function() {
		document.getElementById("users").className = "";
		document.getElementById("dashboard").className = "";
		document.getElementById("devices").className = "";
		document.getElementById("notes").className = "active";


	};
});
app.controller("BoitierController", function($scope, $http) {
	
	$scope.loadBoitier = function(){
		$http.get("/boitier/").success(function(data) {
			$scope.boitiers = data;

		});
	}
	
	$scope.addDevice = function() {
		var date = new Date();
		$http({
			url : '/boitier',
			method : 'POST',
			data : JSON.stringify({
				macAddress : $scope.macAddress,
				date : date.toString(),
				enabled : false
			}),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {

			swal({
				title : 'Good Job!',
				text : 'Your file has been successfully added.',
				type : 'success',
				confirmButtonClass : "btn btn-success",
				buttonsStyling : false
			})
			$scope.macAddress = "";
			$scope.loadBoitier();
		}, function errorCallback(response) {});

	}
	
});
app.controller("NoteController", function($scope, $http) {


	$scope.loadNote = function() {
		$http.get("/notes/").success(function(data) {
			$scope.notes = data;

		});
	}

	$scope.addNote = function() {
		$http({
			url : '/notes',
			method : 'POST',
			data : JSON.stringify({
				name : $scope.noteName,
				prix : $scope.notePrix,
				quantity : "",
				imageUrl : ""
			}),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.noteName = "";
			$scope.notePrix = "";
			$scope.loadNote();
		}, function errorCallback(response) {});

	}
});


app.controller("UserController", function($scope, $http) {
	$scope.users = "";
	$scope.startEdit = function() {
		document.getElementById("user_id").removeAttribute("disabled");
		document.getElementById("user_name").removeAttribute("disabled");
		document.getElementById("user_login").removeAttribute("disabled");
		document.getElementById("user_password").removeAttribute("disabled");
		document.getElementById("update_button").removeAttribute("style");
	};
	$scope.displayUserDetail = function($u) {

		document.getElementById("user_id").setAttribute("disabled", "disabled");
		document.getElementById("user_name").setAttribute("disabled", "disabled");
		document.getElementById("user_login").setAttribute("disabled", "disabled");
		document.getElementById("user_password").setAttribute("disabled", "disabled");
		document.getElementById("update_button").setAttribute("style", "display: none;");


		document.getElementById("user_id").value = $u.id;
		document.getElementById("user_name").value = $u.email
		document.getElementById("user_login").value = $u.login
		document.getElementById("user_password").value = $u.password


	};
	$http.get("/user/").success(function(data) {
		$scope.users = data;
	});
});
app.controller("myAppController", function($scope, $http) {
	$scope.products = "";
	$scope.productName = "";

	$scope.loadProduct = function() {


		$http.get("/products/" + $scope.productName).success(function(data) {

			$scope.products = data;
			sendNotification();

		});
	};
	$scope.defaultImageUrl = "http://www.thebakerymadewithlove.com/wp-content/uploads/2014/08/placeholder.png"
	$scope.picSelectedImage = function() {
		$scope.defaultImageUrl = $scope.pImageUrl;
	};
	$scope.showSuccessAlert = false;
	$scope.showErrorAlert = false;

	$scope.switchBool = function(value) {
		$scope[value] = !$scope[value];
	};
	$scope.switchBool2 = function(value) {
		$scope[value] = !$scope[value];
	};
	$scope.pName = "";
	$scope.addProduct = function() {
		$http({
			url : '/products',
			method : 'POST',
			data : JSON.stringify({
				name : $scope.pName,
				prix : $scope.pPrix,
				imageUrl : $scope.pImageUrl
			}),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.productName = "";
			$scope.showSuccessAlert = true;
			$scope.showErrorAlert = false;
			$scope.pImageUrl = "";
			$scope.loadProduct();
		}, function errorCallback(response) {});
		$scope.showErrorAlert = true;
	}

	$scope.customize = function(p) {
		$http.get("/notes/").success(function(data) {
			$scope.notes = data;
		});
	}




});
app.controller("productController", function($scope, $http) {})