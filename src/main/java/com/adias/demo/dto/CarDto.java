package com.adias.demo.dto;
import com.adias.demo.model.Car;
import com.adias.demo.model.Color;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CarDto {
    private String model;
    private String brand;
    private int year;
    private String registerNumber;
    private Color color;
    private String photo;
    private OwnerCarDto ownerCarDto;

    private UserrDto userrDto;

    public static CarDto fromEntity(Car car) {
        if (car == null) {
            return null;
            //TODO THROW THE EXCEPTION
        }
        return CarDto.builder()
                .model(car.getModel())
                .brand(car.getBrand())
                .year(car.getYear())
                .registerNumber(car.getRegisterNumber())
                .color(car.getColor())
                .ownerCarDto(OwnerCarDto.fromEntity(car.getOwnerCar()))
                .photo(car.getPhoto())
                .userrDto(UserrDto.fromEntity(car.getUserr()))
                .build();
    }

    public static Car toEntity(CarDto carDto) {
        if (carDto == null) {
            return null;
            //TODO THROW THE EXCEPTION
        }
        Car car = new Car();
        car.setOwnerCar(OwnerCarDto.toEntity(carDto.getOwnerCarDto()));
        car.setColor(carDto.getColor());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setRegisterNumber(carDto.getRegisterNumber());
        car.setPhoto(carDto.getPhoto());
        car.setYear(carDto.getYear());
        car.setUserr(UserrDto.toEntity(carDto.getUserrDto()));
        return car;
    }

}