package com.zemian.hellojava.app;

import com.zemian.hellojava.AppException;
import com.zemian.hellojava.CommonConfig;
import com.zemian.hellojava.data.domain.User;
import com.zemian.hellojava.service.CommonServiceConfig;
import com.zemian.hellojava.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class CreateUser {

    public static void main(String[] args) {
        ConfigurableApplicationContext spring = new AnnotationConfigApplicationContext(Config.class);
        CreateUser main = spring.getBean(CreateUser.class);
        main.run(args);
        spring.close();
    }

    @Configuration
    @Import({CommonServiceConfig.class, CommonConfig.class})
    public static class Config {
        @Bean
        public CreateUser createUser() {
            return new CreateUser();
        }
    }

    private static Logger LOG = LoggerFactory.getLogger(CreateUser.class);

    @Autowired
    private UserService userService;

    public void run(String[] args) {
        if (args.length < 2) {
            throw new AppException("Wrong args: <username> <password>");
        }
        String username = args[0];
        String password = args[1];
        LOG.info("Create new user: {}", username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.create(user);
        LOG.info("{} has been created successfully.", user);
    }
}
