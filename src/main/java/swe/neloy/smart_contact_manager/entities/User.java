/* 
Created by Neloy on 10 August, 2025.
Email: taufiqneloy.swe@gmail.com
*/

package swe.neloy.smart_contact_manager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name field is required!")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters!")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name can only contain letters and spaces!")
    private String name;

    @NotBlank(message = "Email field is required!")
    @Email(message = "Invalid email format!")
    @Size(max = 50, message = "Email must not exceed 50 characters!")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 8, message = "Password must be at least 8 characters long!")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Password must contain upper, lower, number, and special character!"
    )
    private String password;

    private String role;
    private boolean enabled;
    private String imageUrl;

    @Size(max = 500, message = "About section must not exceed 500 characters!")
    @Column(length = 500)
    private String about;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contact> contactList = new ArrayList<>();
}


