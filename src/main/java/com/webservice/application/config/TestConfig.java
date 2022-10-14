package com.webservice.application.config;

import com.webservice.application.entities.User;
import com.webservice.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "mariabrown@gmail.com", "988888888", "abc1123");
        User user2 = new User(null, "Bob Blue", "boblue@gmail.com", "9123456789", "13248aeiou");
        User user3 = new User(null, "Alex Green", "alexgreen@gmail.com", "944446666", "1a2b3c4d");

        userRepository.saveAll(Arrays.asList(user1,user2, user3));

    }
}
