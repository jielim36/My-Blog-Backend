package com.myblog.controller;

import com.myblog.bean.User;
import com.myblog.bean.UserLogin;
import com.myblog.config.JwtUtils;
import com.myblog.dto.AuthenticationRequest;
import com.myblog.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserService userService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            final UserDetails userDetails = new UserLogin(userService.getUserByEmail(request.getEmail()));
            System.out.println(userDetails);
            if (userDetails != null) {
                System.out.println("Authentication successful");
                return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
            } else {
                System.out.println("User not found");
                return ResponseEntity.status(200).body("User not found");
            }
        } catch (BadCredentialsException ex) {
            System.out.println("Authentication failed: " + ex.getMessage());
            return ResponseEntity.status(401).body("Authentication failed: " + ex.getMessage());
        }catch (ExpiredJwtException ex) {
            System.out.println("Authentication failed: " + ex.getMessage());
            return ResponseEntity.status(402).body("Authentication failed: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Some error has occurred: " + e.getMessage());
            return ResponseEntity.status(500).body("Some error has occurred");
        }
    }

    @GetMapping("/token")
    public User getUserByToken(@RequestHeader("Authorization") String jwtToken){
        return userService.getUserByToken(jwtToken);
    }

}
