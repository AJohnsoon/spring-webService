package com.webservice.application.config;

import com.webservice.application.entities.Order;
import com.webservice.application.entities.User;
import com.webservice.application.repositories.OrderRepository;
import com.webservice.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "mariabrown@gmail.com", "988888888", "abc1123");
        User user2 = new User(null, "Bob Blue", "boblue@gmail.com", "9123456789", "13248aeiou");
        User user3 = new User(null, "Alex Green", "alexgreen@gmail.com", "944446666", "1a2b3c4d");

        Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), user1);
        Order order2 = new Order(null, Instant.parse("2022-10-14T12:22:35Z"), user3);
        Order order3 = new Order(null, Instant.parse("2022-09-20T16:35:44Z"), user1);
        Order order4 = new Order(null, Instant.parse("2022-07-08T12:13:58Z"), user2);

        userRepository.saveAll(Arrays.asList(user1,user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4));

    }
}
