package com.alkemy.ong.service;

import com.alkemy.ong.models.Contacts;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactsService {
    List<Contacts> findContactsList();

    ResponseEntity<?> saveContact(Contacts contact);
}
