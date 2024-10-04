package com.atividadeaos.repository;

import com.exemplo.projeto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}