package model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class User extends Entity<Integer> {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private LocalDate birthday;
    private Role role;

    public User(String login, String password, String firstName, String lastName, String email, String sex, LocalDate birthday, Role role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", role=" + role +
                "} " + super.toString();
    }
}