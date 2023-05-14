package com.adias.demo.controller.implementations;
import com.adias.demo.controller.abstractions.CarApi;
import com.adias.demo.dto.CarDto;
import com.adias.demo.services.abstractions.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CarController implements CarApi {
    private CarService carService;
    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }
    @Override
    public ResponseEntity<CarDto> save(CarDto dto) {
        return ResponseEntity.ok(carService.save(dto));
    }
    @Override
    public ResponseEntity<CarDto> findById(Integer id) {
        return ResponseEntity.ok(carService.findById(id));
    }
    @Override
    public ResponseEntity<CarDto> findByRegisterNumber(String registerNumber) {
        return ResponseEntity.ok(carService.findByRegisterNumber(registerNumber));
    }
    @Override
    public ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }
    @Override
    public ResponseEntity delete(Integer id) {
        carService.delete(id);
        return ResponseEntity.ok().build();
    }
    // fiel injection annotazione sul service
    //set injection
    //constructor injection

}
