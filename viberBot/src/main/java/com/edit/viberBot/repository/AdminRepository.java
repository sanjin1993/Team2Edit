package com.edit.viberBot.repository;

import com.edit.viberBot.model.Admin;
import com.edit.viberBot.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    public Admin findByUsername(String username);
}
