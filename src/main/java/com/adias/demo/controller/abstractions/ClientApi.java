package com.adias.demo.controller.abstractions;
import com.adias.demo.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.adias.demo.utils.Constants.URL_GENERAL;
@Api(URL_GENERAL + "/clients")
public interface ClientApi {
    @PostMapping(value = URL_GENERAL + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "save a client", notes = "the method allows o modify a client",response = ClientDto.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "object client created/modified"),
            @ApiResponse(code = 400, message = "object client is not valid")
    } )
    ClientDto save(@RequestBody ClientDto dto);
    @GetMapping(value = URL_GENERAL + "/clients/{id_client}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find a client with ID", notes = "the method allows to find a client with its ID ",response = ClientDto.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the object client has been found in the database"),
            @ApiResponse(code = 404, message = "no client exists in the database with this ID")
    } )
    ClientDto findById(@PathVariable("id_client") Integer id);
    @GetMapping(value = URL_GENERAL + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list of clients", notes = "the method allows to find the list of clients in the database ",responseContainer = "List<ClientDto>")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the list of clients or a void list ")
    } )
    List<ClientDto> findAll();
    @DeleteMapping(value = URL_GENERAL + "/clients/delete/{id_client}")
    @ApiOperation(value = "delete a client", notes = "the method allows to delete a client with its ID ")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "the client has been deleted"),
    } )
    void delete(@PathVariable("id_client") Integer id);
}
