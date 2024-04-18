package com.ms.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class UserEntity {

    @Id
    private String id;

    private String document;

    @Column(name = "type_document")
    private String typeDocument;

    private String name;

    private String lastname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "creat_at")
    private LocalDateTime creatAt;

    //is_active

}
