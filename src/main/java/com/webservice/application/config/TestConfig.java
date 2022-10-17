package com.webservice.application.config;

import com.webservice.application.entities.Category;
import com.webservice.application.entities.Order;
import com.webservice.application.entities.Product;
import com.webservice.application.entities.User;
import com.webservice.application.entities.enums.OrderStatus;
import com.webservice.application.repositories.CategoryRepository;
import com.webservice.application.repositories.OrderRepository;
import com.webservice.application.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");



        User user1 = new User(null, "Maria Brown", "mariabrown@gmail.com", "988888888", "abc1123");
        User user2 = new User(null, "Bob Blue", "boblue@gmail.com", "9123456789", "13248aeiou");
        User user3 = new User(null, "Alex Green", "alexgreen@gmail.com", "944446666", "1a2b3c4d");

        Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2022-10-14T12:22:35Z"), OrderStatus.WAITING_PAYMENT, user3);
        Order order3 = new Order(null, Instant.parse("2022-09-20T16:35:44Z"), OrderStatus.PAID, user1);
        Order order4 = new Order(null, Instant.parse("2022-07-08T12:13:58Z"), OrderStatus.DELIVERED, user2);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}
