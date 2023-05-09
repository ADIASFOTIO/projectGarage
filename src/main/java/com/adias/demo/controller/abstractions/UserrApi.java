package com.adias.demo.controller.abstractions;
import com.adias.demo.dto.UserrDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.adias.demo.utils.Constants.URL_GENERAL;
public interface UserrApi {
    @PostMapping(URL_GENERAL + "/create")
    UserrDto save(@RequestBody UserrDto dto);
    @GetMapping(URL_GENERAL + "/{id_userr}")
    UserrDto findById(@PathVariable("id_userr") Integer id);

    @GetMapping(URL_GENERAL + "/find/{mail}")
    UserrDto findByEmail(@PathVariable("mail") String mail);

    @GetMapping(URL_GENERAL + "/all")
    List<UserrDto> findAll();

    @DeleteMapping(URL_GENERAL + "/delete/{id_userr}")
    void delete(@PathVariable("id_userr") Integer id);
}
