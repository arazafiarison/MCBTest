package com.mcb.test.Test.controller.authentication;

import com.mcb.test.Test.config.security.JwtTokenProvider;
import com.mcb.test.Test.model.dto.authentication.JwtAuthenticationResponseDTO;
import com.mcb.test.Test.model.dto.authentication.LoginRequestDTO;
import com.mcb.test.Test.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationAPIController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private AuthenticationService authenticationService;

    /**
     * Authenticate user
     */
    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponseDTO> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getLogin(),
                    loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        System.out.println("JWT : " + jwt);
        return ResponseEntity.ok(new JwtAuthenticationResponseDTO(jwt));
    }
}
