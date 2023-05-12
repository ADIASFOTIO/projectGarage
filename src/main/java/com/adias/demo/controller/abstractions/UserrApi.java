package com.adias.demo.controller.abstractions;
import com.adias.demo.dto.UserrDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.adias.demo.utils.Constants.URL_GENERAL;
@Api(URL_GENERAL + "/userrs")
public interface UserrApi {
    @PostMapping(value = URL_GENERAL + "/userrs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "save an userr", notes = "the method allows to modify an userr",response = UserrDto.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "object userr created/modified"),
            @ApiResponse(code = 400, message = "object userr is not valid")
    } )
    UserrDto save(@RequestBody UserrDto dto);
    @GetMapping(value = URL_GENERAL + "/userrs/{id_userr}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find an userr with ID", notes = "the method allows to find an userr with its ID ",response = UserrDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "the object userr has been found in the database"),
            @ApiResponse(code = 404, message = "no userr exists in the database with this ID")
    })
    UserrDto findById(@PathVariable("id_userr") Integer id);

    @GetMapping(value = URL_GENERAL + "/userrs/mail/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find an userr with mail", notes = "the method allows to find an userr with its mail ",response = UserrDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "the object userr has been found in the database"),
            @ApiResponse(code = 404, message = "no userr exists in the database with this mail")
    })
    UserrDto findByEmail(@PathVariable("mail") String mail);

    @GetMapping(value = URL_GENERAL + "/userrs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list of userrs", notes = "the method allows to find the list of userrs in the database ",responseContainer = "List<UserrDto>")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the list of userrs o a void list ")
    } )
    List<UserrDto> findAll();

    @DeleteMapping(URL_GENERAL + "/userrs/delete/{id_userr}")
    @ApiOperation(value = "delete an userr", notes = "the method allows to delete an userr with its ID ")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the userr has been deleted")
    } )
    void delete(@PathVariable("id_userr") Integer id);
}
