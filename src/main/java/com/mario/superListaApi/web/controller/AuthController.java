package com.mario.superListaApi.web.controller;

import com.mario.superListaApi.domain.dto.AuthenticationRequest;
import com.mario.superListaApi.domain.dto.AuthenticationResponse;
import com.mario.superListaApi.domain.service.SuperListaUserDetailService;
import com.mario.superListaApi.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth", method = RequestMethod.GET)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SuperListaUserDetailService superListaUserDetailService;

    @Autowired
    private JWTUtil jwtUtil;

@PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
   try {
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
       UserDetails userDetails = superListaUserDetailService.loadUserByUsername(request.getUsername());
       String jwt= jwtUtil.generateToken(userDetails);
       return new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);
   }
   catch (BadCredentialsException e){
    return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
   }
    }
}
