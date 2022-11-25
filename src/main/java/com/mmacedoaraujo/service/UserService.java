package com.mmacedoaraujo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmacedoaraujo.domain.User;
import com.mmacedoaraujo.repository.UserRepository;
import com.mmacedoaraujo.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    ObjectMapper objectMapper = new ObjectMapper();
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByIdOrThrowException(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado " + id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        getUserByIdOrThrowException(id);
        userRepository.deleteById(id);
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
