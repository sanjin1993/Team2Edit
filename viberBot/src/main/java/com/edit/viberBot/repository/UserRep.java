package com.edit.viberBot.repository;

import com.edit.viberBot.model.Route;
import com.edit.viberBot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRep extends JpaRepository<User,Long> {
    User findByViberId(String viberId);

    List<User> findAll();

<<<<<<< HEAD
    //void add(User captenMorgan);
}
=======
}
>>>>>>> e1715571d9d0df6d0dfaafc218249bdf0f3db28e
