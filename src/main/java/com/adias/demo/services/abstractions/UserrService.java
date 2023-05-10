package com.adias.demo.services.abstractions;
import com.adias.demo.dto.UserrDto;
import java.util.List;
public interface UserrService {
    UserrDto save(UserrDto dto);
    UserrDto findById(Integer id);
    List<UserrDto> findAll();
    void delete(Integer id);
    UserrDto findByMail(String mail);

}
