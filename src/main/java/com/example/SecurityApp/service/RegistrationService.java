package com.example.SecurityApp.service;

import com.example.SecurityApp.models.Person;
import com.example.SecurityApp.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
     }
    @Transactional
    public void register( Person person){
         String password   =passwordEncoder.encode(person.getPassword());
         person.setRole("ROLE_USER");
         person.setPassword(password);
       peopleRepository.save(person);
    }
}
