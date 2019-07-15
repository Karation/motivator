package com.example.motivator.Repository;

import com.example.motivator.Model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository  extends CrudRepository<User, Id>{

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findById(@Param("id") long id);
}
