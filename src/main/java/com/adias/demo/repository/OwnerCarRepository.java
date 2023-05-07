package com.adias.demo.repository;

import com.adias.demo.model.OwnerCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerCarRepository extends JpaRepository<OwnerCar, Integer> {
}
