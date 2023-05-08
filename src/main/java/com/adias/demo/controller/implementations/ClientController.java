package com.adias.demo.controller.implementations;

import com.adias.demo.controller.abstractions.ClientApi;
import com.adias.demo.dto.ClientDto;

import java.util.List;

public class ClientController implements ClientApi {
    @Override
    public ClientDto save(ClientDto dto) {
        return null;
    }

    @Override
    public ClientDto findById(Integer id) {
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
