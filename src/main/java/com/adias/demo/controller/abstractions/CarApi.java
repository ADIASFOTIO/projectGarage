package com.adias.demo.controller.abstractions;
import com.adias.demo.dto.CarDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.adias.demo.utils.Constants.URL_GENERAL;
@Api(URL_GENERAL + "/cars")
public interface CarApi {
    @PostMapping(value = URL_GENERAL+"/cars/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //requestboby fa capire a spring dal json -> oggetto dto
    @ApiOperation(value = "save a car", notes = "the method allows to modify a car",response = CarDto.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "object car created/modified"),
            @ApiResponse(code = 400, message = "object car is not valid")
    } )
    CarDto save(@RequestBody CarDto dto);
    @GetMapping(value = URL_GENERAL+"/cars/{id_car}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find a car with ID", notes = "the method allows to find a car with its ID ",response = CarDto.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the object car has been found in the database"),
            @ApiResponse(code = 404, message = "no car exists in the database with this ID")
    } )
    CarDto findById(@PathVariable("id_car") Integer id);
    @GetMapping(value = URL_GENERAL+"/cars/{car_register_number}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find a car with register number", notes = "the method allows to find a car with its register number ",response = CarDto.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the object has been found in the database"),
            @ApiResponse(code = 404, message = "no car exists in the database with this rgister number")
    } )
    CarDto findByRegisterNumber(@PathVariable("car_register_number") String registerNumber);
    @GetMapping(value = URL_GENERAL+"/cars/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list of cars", notes = "the method allows to find the list of cars in the database ",responseContainer = "List<CarDto>")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the list of cars o a void list ")
    } )
    List<CarDto> findAll();
    @DeleteMapping(value = URL_GENERAL+"/cars/delete/{id_car}")
    @ApiOperation(value = "delete a car", notes = "the method allows to delete a car with its ID ")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the car has been deleted")
    } )
    void delete(@PathVariable("id_car") Integer id);
}
