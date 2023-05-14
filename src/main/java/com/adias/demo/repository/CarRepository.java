package com.adias.demo.repository;
import com.adias.demo.model.Car;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface CarRepository extends GenericRepository<Car, Integer> {
    //@Query("select * from car where model = :mod and brand = :bra")
    //List<Car> findByCustomQuery(@Param("mod") String m, @Param("bra") String b);
    // Query native
    //@Query(value = "select * from car where model = :mod and brand = :bra", nativeQuery = true)
    //List<Car> findByCustomNativeQuery(@Param("mod") String m, @Param("bra") String b);
    //List<Car> findByModelIgnoreCaseAndBrandIgnoreCase(String model, String brand);
    Optional<Car> findCarByRegisterNumber(String registerNumber);
}
