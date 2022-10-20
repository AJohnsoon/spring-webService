package com.webservice.application.config;

import com.webservice.application.entities.*;
import com.webservice.application.entities.enums.OrderStatus;
import com.webservice.application.repositories.*;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        OrderItem orderItem1 = new OrderItem(order1, p1, 2, p1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, p3, 1, p3.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, p3, 2, p3.getPrice());
        OrderItem orderItem4 = new OrderItem(order3, p5, 2, p5.getPrice());

        Payment payment1 = new Payment(null, Instant.parse("2022-06-20T21:53:07Z"), order1);

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        order1.setPayment(payment1);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2,orderItem3, orderItem4));

    }
}
