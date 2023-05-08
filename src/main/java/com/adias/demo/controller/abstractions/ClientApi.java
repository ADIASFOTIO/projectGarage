package com.adias.demo.controller.abstractions;
import com.adias.demo.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adias.demo.utils.Constants.URL_GENERAL;

public interface ClientApi {
    @PostMapping(value = URL_GENERAL + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);
    @GetMapping(value = URL_GENERAL + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);
    @GetMapping(value = URL_GENERAL + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();
    @DeleteMapping(value = URL_GENERAL + "/clients/delete/{idClient}")
    void delete(@PathVariable("idClient") Integer id);
}
