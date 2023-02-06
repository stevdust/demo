package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
    List<UserModel> findByEmail(String email);
}
