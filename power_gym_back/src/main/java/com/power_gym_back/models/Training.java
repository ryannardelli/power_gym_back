package com.power_gym_back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "training")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Size(min = 4, max = 120)
    private String name;

    @Size(min = 12, max = 200 )
    private String howMake;

    @Column(nullable = false, unique = true, length = 500)
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "feeling_id", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Feeling> feeling;
}
