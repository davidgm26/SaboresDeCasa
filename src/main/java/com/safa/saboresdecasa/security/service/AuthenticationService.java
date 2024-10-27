package com.safa.saboresdecasa.security.service;

import com.safa.saboresdecasa.model.Rol;
import com.safa.saboresdecasa.model.Usuario;
import com.safa.saboresdecasa.repository.UsuarioRepository;
import com.safa.saboresdecasa.security.JwtService;
import com.safa.saboresdecasa.security.dto.AuthenticationRequest;
import com.safa.saboresdecasa.security.dto.AuthenticationResponse;
import com.safa.saboresdecasa.security.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var usuario = Usuario.builder()
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .username(registerRequest.getUsername())
                .rol(Rol.CLIENTE)
                .build();

        usuarioRepository.save(usuario);

        var token = jwtService.generateToken(usuario);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = usuarioRepository.findTopByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }






}
