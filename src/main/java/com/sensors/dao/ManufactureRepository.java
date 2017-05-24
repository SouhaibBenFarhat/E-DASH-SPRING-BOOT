package com.sensors.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensors.entities.Manufacture;

public interface ManufactureRepository extends JpaRepository<Manufacture, Long>{

}
