package com.atividadeaos.service;

import com.exemplo.projeto.exception.UserNotFoundException;
import com.exemplo.projeto.model.User;
import com.exemplo.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Criar um novo usuário
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Obter todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar usuário por ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // Atualizar um usuário
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        return userRepository.save(user);
    }

    // Deletar um usuário
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}