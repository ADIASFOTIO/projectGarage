package com.adias.demo.auth;

import com.adias.demo.config.JwtService;
import com.adias.demo.model.RoleSecurity;
import com.adias.demo.model.Userr;
import com.adias.demo.repository.UserrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserrRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var userr = Userr.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .roleSecurity(RoleSecurity.USER)
                .build();
        repository.save(userr);
        var jwtToken = jwtService.generateToken(userr);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMail(),
                        request.getPassword()
                )
        );
        var userr = repository.findByMail(request.getMail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(userr);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
