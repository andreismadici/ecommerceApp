package com.example.ecommerceApp.dao;

import com.example.ecommerceApp.mongoEntity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    @Query("{'first_name': ?0}")
    Optional<Student> findByFirstName(String name);

}