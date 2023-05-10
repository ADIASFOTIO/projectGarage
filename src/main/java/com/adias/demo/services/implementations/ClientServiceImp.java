package com.adias.demo.services.implementations;
import com.adias.demo.dto.ClientDto;
import com.adias.demo.exception.EntityNotFoundException;
import com.adias.demo.exception.ErrorCodes;
import com.adias.demo.exception.InvalidEntityException;
import com.adias.demo.exception.InvalidOperationException;
import com.adias.demo.model.Car;
import com.adias.demo.repository.CarRepository;
import com.adias.demo.repository.ClientRepository;
import com.adias.demo.services.abstractions.ClientService;
import com.adias.demo.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImp implements ClientService {
    private ClientRepository clientRepository;
    private CarRepository carRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository, CarRepository carRepository) {
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Il client non  valido",
                    ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                )
        );
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        return clientRepository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Nessun Client con l'ID = " + id + " c'è nella BD",
                        ErrorCodes.CLIENT_NOT_FOUND)
                );
    }
    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        Optional<Car> cars = carRepository.findById(id);
        if (!cars.isEmpty()) {
            throw new InvalidOperationException("Impossibile di cancellare un client che ha delle macchine in officina",
                    ErrorCodes.CLIENT_ALREADY_IN_USE);
        }
        clientRepository.deleteById(id);
    }
}
