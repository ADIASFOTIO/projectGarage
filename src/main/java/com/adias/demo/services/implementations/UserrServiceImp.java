package com.adias.demo.services.implementations;
import com.adias.demo.dto.UserrDto;
import com.adias.demo.exception.EntityNotFoundException;
import com.adias.demo.exception.ErrorCodes;
import com.adias.demo.exception.InvalidEntityException;
import com.adias.demo.repository.UserrRepository;
import com.adias.demo.services.abstractions.UserrService;
import com.adias.demo.validator.UserrValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserrServiceImp implements UserrService {
    private UserrRepository userrRepository;
    @Autowired
    public UserrServiceImp(UserrRepository userrRepository){
        this.userrRepository = userrRepository;
    }
    @Override
    public UserrDto save(UserrDto dto) {
        List<String> errors = UserrValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Userr is not valid {}", dto);
            throw new InvalidEntityException("Il userr non è valido", ErrorCodes.USERR_NOT_VALID, errors);
        }
        return  UserrDto.fromEntity(
                userrRepository.save(
                        UserrDto.toEntity(dto)
                )
        );
    }

    @Override
    public UserrDto findById(Integer id) {
        if (id == null) {
            log.error("Userr ID is null");
            return null;
        }
        return userrRepository.findById(id)
                .map(UserrDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Nessun userr con questo id = " + id + " c'è nella BD",
                        ErrorCodes.USERR_NOT_FOUND)
                );
    }

    @Override
    public List<UserrDto> findAll() {
        return userrRepository.findAll().stream()
                .map(UserrDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Userr ID is null");
            return;
        }
        userrRepository.deleteById(id);
    }

    @Override
    public UserrDto findByMail(String mail) {
        return userrRepository.findUserrByMail(mail)
                .map(UserrDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Nessun userr con questo mail = " + mail + " c'è nella BD",
                        ErrorCodes.USERR_NOT_FOUND)
                );
    }
}
