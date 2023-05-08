package com.adias.demo.controller.abstractions;
import com.adias.demo.dto.CarDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.adias.demo.utils.Constants.URL_GENERAL;
public interface CarApi {
    @PostMapping(value = URL_GENERAL+"/cars/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    //requestboby fa capire a spring dal json -> oggetto dto
    CarDto save(@RequestBody CarDto dto);
    @GetMapping(value = URL_GENERAL+"/cars/{id_car}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CarDto findById(@PathVariable("id_car") Integer id);
    @GetMapping(value = URL_GENERAL+"/cars/{car_register_number}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CarDto findByRegisterNumber(@PathVariable("car_register_number") String registerNumber);
    @GetMapping(value = URL_GENERAL+"/cars/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<CarDto> findAll();
    @DeleteMapping(value = URL_GENERAL+"/car/delete/{id_car}")
    void delete(@PathVariable("id_car") Integer id);
}
