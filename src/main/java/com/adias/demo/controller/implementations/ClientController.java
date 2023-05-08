package com.adias.demo.controller.implementations;
import com.adias.demo.controller.abstractions.ClientApi;
import com.adias.demo.dto.ClientDto;
import com.adias.demo.services.abstractions.ClientService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientController implements ClientApi {
    private ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }
    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }
    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }
    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
