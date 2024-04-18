package com.ms.user.service;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<UserEntity> create(UserDto userDto);

    //Jonathan
    ResponseEntity<List<UserEntity>> getAll();
    //Jhoan
    ResponseEntity<UserEntity> getById(String id);
    //Juan Pedro Mendoza
    ResponseEntity<?> deleteById(String id);
    //Diego
    ResponseEntity<UserEntity> updateById(UserEntity userEntity , String id);
    //Juan Pablo rodriguez
    ResponseEntity<UserEntity> getByDocumentTypeDocument(String document, String typeDocument);
}
