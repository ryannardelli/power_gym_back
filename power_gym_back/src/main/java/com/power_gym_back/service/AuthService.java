package com.power_gym_back.service;

import com.power_gym_back.models.User;
import com.power_gym_back.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Registro
    public String register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "Usuário registrado com sucesso!";
    }

    // Login
    public String login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return "Usuário não encontrado!";
        }
        if (!user.get().getPassword().equals(password)) {
            return "Senha incorreta!";
        }
        return "Login realizado com sucesso!";
    }
}
