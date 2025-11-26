//package com.power_gym_back.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class AuthResponseDto {
//    private String message;
//
//    public AuthResponseDto(String message) {
//        this.message = message;
//    }
//
//    public String getMessage() { return message; }
//}

package com.power_gym_back.dto;

public class AuthResponseDto {
    private String message;
    private Integer id;
    private String name;
    private String email;

    // Construtor completo
    public AuthResponseDto(String message, Integer id, String name, String email) {
        this.message = message;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getMessage() { return message; }
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
