package com.adias.demo.controller.implementations;
import com.adias.demo.controller.abstractions.CarApi;
import com.adias.demo.dto.CarDto;
import com.adias.demo.services.abstractions.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CarController implements CarApi {
    private CarService carService;
    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }
    // fiel injection annotazione sul service
    //set injection
    //constructor injection
    @Override
    public CarDto save(CarDto dto) {
        return carService.save(dto);
    }

    @Override
    public CarDto findById(Integer id) {
        return carService.findById(id);
    }
    @Override
    public CarDto findByRegisterNumber(String registerNumber) {
        return carService.findByRegisterNumber(registerNumber);
    }
    @Override
    public List<CarDto> findAll() {
        return carService.findAll();
    }

    @Override
    public void delete(Integer id) {
        carService.delete(id);
    }
}
