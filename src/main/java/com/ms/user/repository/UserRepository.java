package com.ms.user.repository;

import com.ms.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,String> {

    @Query("""
        SELECT u
        FROM
            UserEntity  u
            WHERE  u.document = ?1
            AND    u.typeDocument = ?2
            ORDER BY u.creatAt desc
     """)
    Optional<UserEntity> findByDocumentAndTypeDocumentOrderByCreatAtDesc(String document,String typeDocument);
}
