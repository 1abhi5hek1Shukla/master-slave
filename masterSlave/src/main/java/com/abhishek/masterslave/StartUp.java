package com.abhishek.masterslave;


import com.abhishek.masterslave.entities.User;
import com.abhishek.masterslave.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class StartUp {

    private final UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void startUp() {
        System.out.println("App Started!");

        List<User> users = userRepository.findAllBy();

        log.info("users: {}", users);

    }
}
