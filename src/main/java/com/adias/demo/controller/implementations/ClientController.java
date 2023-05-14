package com.adias.demo.controller.implementations;
import com.adias.demo.controller.abstractions.ClientApi;
import com.adias.demo.dto.ClientDto;
import com.adias.demo.services.abstractions.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientController implements ClientApi {
    private ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @Override
    public ResponseEntity<ClientDto> save(ClientDto dto) {
        return ResponseEntity.ok(clientService.save(dto));
    }
    @Override
    public ResponseEntity<ClientDto> findById(Integer id) {
        return ResponseEntity.ok(clientService.findById(id));
    }
    @Override
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }
    @Override
    public ResponseEntity delete(Integer id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
