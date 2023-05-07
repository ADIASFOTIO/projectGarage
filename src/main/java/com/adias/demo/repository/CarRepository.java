package com.adias.demo.repository;
import com.adias.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    //@Query("slect * from car where model = :mod and brand = :bra")
    //List<Car> findByCustomQuery(@Param("mod") String m, @Param("bra") String b);
    // Query native
    @Query(value = "select * from car where model = :mod and brand = :bra", nativeQuery = true)
    List<Car> findByCustomNativeQuery(@Param("mod") String m, @Param("bra") String b);
    List<Car> findByModelIgnoreCaseAndBrandIgnoreCase(String model, String brand);
}
