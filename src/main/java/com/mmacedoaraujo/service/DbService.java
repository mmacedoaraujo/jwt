package com.mmacedoaraujo.service;

import com.mmacedoaraujo.domain.User;
import com.mmacedoaraujo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class DbService {

    private final UserRepository userRepository;

    public void populateDatabaseMethod() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        User user1 = new User(null, "Marcos", new Timestamp(new Date().getTime()), "9898098", "Rua 1", "Recife", "Pernambuco", 898798, 80989, "marco@gmail.com");
        User user2 = new User(null, "Alessandra", new Timestamp(new Date().getTime()), "9898098", "Rua 1", "Recife", "Pernambuco", 898798, 80989, "marco@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
