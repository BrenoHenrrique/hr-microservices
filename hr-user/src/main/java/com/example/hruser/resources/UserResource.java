package com.example.hruser.resources;

import com.example.hruser.entities.User;
import com.example.hruser.repositories.UserRepository;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
