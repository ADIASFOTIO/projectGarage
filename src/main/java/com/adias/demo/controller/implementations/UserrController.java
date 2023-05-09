package com.adias.demo.controller.implementations;
import com.adias.demo.controller.abstractions.UserrApi;
import com.adias.demo.dto.UserrDto;
import com.adias.demo.services.abstractions.UserrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserrController implements UserrApi {
    private UserrService userrService;
    @Autowired
    public UserrController(UserrService userrService){
        this.userrService = userrService;
    }
    @Override
    public UserrDto save(UserrDto dto) {
        return userrService.save(dto);
    }

    @Override
    public UserrDto findById(Integer id) {
        return userrService.findById(id);
    }

    @Override
    public UserrDto findByEmail(String mail) {
        return userrService.findByMail(mail);
    }

    @Override
    public List<UserrDto> findAll() {
        return userrService.findAll();
    }

    @Override
    public void delete(Integer id) {
        userrService.delete(id);
    }
}
