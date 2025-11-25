package com.power_gym_back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "feeling")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feeling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

}
