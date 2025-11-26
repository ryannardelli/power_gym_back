//package com.power_gym_back.service;
//
//import com.power_gym_back.dto.AuthResponseDto;
//import com.power_gym_back.dto.LoginRequestDto;
//import com.power_gym_back.dto.RegisterRequestDto;
//import com.power_gym_back.models.User;
//import com.power_gym_back.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthService {
//    private final UserRepository userRepository;
//
//    public AuthService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public AuthResponseDto register(RegisterRequestDto dto) {
//        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
//            return new AuthResponseDto("Usuário já existe!");
//        }
//
//        User user = new User();
//        user.setName(dto.getName());
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
//        userRepository.save(user);
//
//        return new AuthResponseDto("Usuário registrado com sucesso!");
//    }
//
//    public AuthResponseDto login(LoginRequestDto dto) {
//        Optional<User> user = userRepository.findByEmail(dto.getEmail());
//
//        if (!user.get().getPassword().equals(dto.getPassword())) {
//            return new AuthResponseDto("Senha incorreta!");
//        }
//
//        return new AuthResponseDto("Login realizado com sucesso!");
//    }
//}

package com.power_gym_back.service;

import com.power_gym_back.dto.AuthResponseDto;
import com.power_gym_back.dto.LoginRequestDto;
import com.power_gym_back.dto.RegisterRequestDto;
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

    public AuthResponseDto register(RegisterRequestDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return new AuthResponseDto("Usuário já existe!", null, null, null);
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        userRepository.save(user);

        return new AuthResponseDto(
                "Usuário registrado com sucesso!",
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public AuthResponseDto login(LoginRequestDto dto) {
        Optional<User> optionalUser = userRepository.findByEmail(dto.getEmail());

        if (optionalUser.isEmpty()) {
            return new AuthResponseDto("Usuário não encontrado!", null, null, null);
        }

        User user = optionalUser.get();
        if (!user.getPassword().equals(dto.getPassword())) {
            return new AuthResponseDto("Senha incorreta!", null, null, null);
        }

        return new AuthResponseDto(
                "Login realizado com sucesso!",
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}

