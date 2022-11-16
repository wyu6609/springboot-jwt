package com.example.Springbootjwtlogin.repository;

import com.example.Springbootjwtlogin.models.ERole;
import com.example.Springbootjwtlogin.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}