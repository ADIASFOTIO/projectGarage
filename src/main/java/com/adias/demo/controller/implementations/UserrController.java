package com.adias.demo.controller.implementations;
import com.adias.demo.controller.abstractions.UserrApi;
import com.adias.demo.dto.UserrDto;
import com.adias.demo.services.abstractions.UserrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserrDto> save(UserrDto dto) {
        return ResponseEntity.ok(userrService.save(dto));
    }
    @Override
    public ResponseEntity<UserrDto> findById(Integer id) {
        return ResponseEntity.ok(userrService.findById(id));
    }
    @Override
    public ResponseEntity<UserrDto> findByEmail(String mail) {
        return ResponseEntity.ok(userrService.findByMail(mail));
    }

    @Override
    public ResponseEntity<List<UserrDto>> findAll() {
        return ResponseEntity.ok(userrService.findAll());
    }
    @Override
    public ResponseEntity delete(Integer id) {
        userrService.delete(id);
        return ResponseEntity.ok().build();
    }
}
