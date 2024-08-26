package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false) // 유일해야하고 빈값이면 안된다!
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String roles; // 어떤 권한
}
