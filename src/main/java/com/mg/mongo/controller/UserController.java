package com.mg.mongo.controller;

import com.mg.mongo.dto.UserDto;
import com.mg.mongo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        Optional<UserDto> user = userService.findUser(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Boolean> postUser(@RequestBody UserDto userDto) {
        boolean b = userService.saveUser(userDto);
        return ResponseEntity.ok(b);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserDto userDto, @PathVariable String id) {
        userService.updateUser(userDto, id);
        return ResponseEntity.ok().build();
    }
}