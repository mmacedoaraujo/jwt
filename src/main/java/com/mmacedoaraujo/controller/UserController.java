package com.mmacedoaraujo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.mmacedoaraujo.domain.User;
import com.mmacedoaraujo.dto.UserDTO;
import com.mmacedoaraujo.mapper.UserMapper;
import com.mmacedoaraujo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> returnAllUsersRegistered() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> returnAnUserById(@PathVariable Long id) {
        User userFound = userService.getUserByIdOrThrowException(id);
        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<UserDTO>> returnUserByName(@RequestParam String name) {
        List<User> listOfUsersFoundByName = userService.findByName(name);
        List<UserDTO> userDTOList = UserMapper.INSTANCE.toDTOList(listOfUsersFoundByName);
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        User userSaved = userService.save(user);

        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> partialUpdate(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try {
            User userFound = userService.getUserByIdOrThrowException(id);
            UserMapper.INSTANCE.update(userFound, userDTO);
            User updatedUser = userService.save(userFound);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
