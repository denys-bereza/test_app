package com.denys_bereza.test_app.repositories;

import com.denys_bereza.test_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> { }
