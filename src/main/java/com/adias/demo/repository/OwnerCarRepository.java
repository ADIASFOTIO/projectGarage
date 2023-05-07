package com.adias.demo.repository;
import com.adias.demo.model.OwnerCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerCarRepository extends JpaRepository<OwnerCar, Integer> {
}
