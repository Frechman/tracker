package ru.gavrilov.tracker.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "EMAIL", nullable = false)
    @Email
    @NotNull
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    @NotNull
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    public User(@Email @NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
