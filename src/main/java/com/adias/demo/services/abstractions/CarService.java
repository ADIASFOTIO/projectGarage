package com.adias.demo.services.abstractions;

import com.adias.demo.dto.CarDto;

import java.util.List;

public interface CarService {
    CarDto save(CarDto dto);
    CarDto findById(Integer id);
    CarDto findByRegisterNumber(String registerNumber);
    List<CarDto> findAll();
    void delete(Integer id);
}
