package com.alkemy.ong.service.impl;


import com.alkemy.ong.models.Contacts;
import com.alkemy.ong.repository.ContactsRepository;
import com.alkemy.ong.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private EmailService mailService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public ResponseEntity<?> saveContact(Contacts contact) {
        try {
            contactsRepository.save(contact);
            mailService.sendContactMail(contact);
            return new ResponseEntity<>(messageSource.getMessage("contact.creation.success", null, null), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(messageSource.getMessage("contact.creation.failure", null, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Contacts> findContactsList() {
        return contactsRepository.findAllByOrderByName();
    }

}
