package com.integration.payroll.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integration.payroll.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
