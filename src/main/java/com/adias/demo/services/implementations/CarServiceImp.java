package com.adias.demo.services.implementations;
import com.adias.demo.dto.CarDto;
import com.adias.demo.exception.EntityNotFoundException;
import com.adias.demo.exception.ErrorCodes;
import com.adias.demo.exception.InvalidEntityException;
import com.adias.demo.model.Car;
import com.adias.demo.repository.CarRepository;
import com.adias.demo.services.abstractions.CarService;
import com.adias.demo.validator.CarValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarServiceImp implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public CarDto save(CarDto dto) {
    // prima di registrare un car devo fare la validazione
      List<String> errors = CarValidator.validate(dto);
      if (!errors.isEmpty()){
        log.error("Car is not valid",dto);
        throw new InvalidEntityException("La macchina non è valida", ErrorCodes.CAR_NOT_VALID, errors);
      }
       return CarDto.fromEntity(
            carRepository.save(
                    CarDto.toEntity(dto)
            )
       );
    }

    @Override
    public CarDto findById(Integer id) {
        if (id == null){
            log.error("Car id is null");
            return null;
        }
        Optional<Car>  car = carRepository.findById(id);
        //CarDto dto = CarDto.fromEntity(car.get());
        return Optional.of(CarDto.fromEntity(car.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "nessun macchina con l'ID = " + id + "nalla BD",
                        ErrorCodes.CAR_NOT_FOUND)
                );

    }
    @Override
    public CarDto findByRegisterNumber(String registerNumber) {
        if (!StringUtils.hasLength(registerNumber)){
            log.error("Car register number is null");
            return null;
        }
        Optional<Car>  car = carRepository.findCarByRegisterNumber(registerNumber);
        //CarDto dto = CarDto.fromEntity(car.get());
        return Optional.of(CarDto.fromEntity(car.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "nessun macchina con il register number = " + registerNumber + "nalla BD",
                        ErrorCodes.CAR_NOT_FOUND)
        );
    }
    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll().stream()
                .map(CarDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Car id is null");
            return;
        }
        carRepository.deleteById(id);
    }
}
