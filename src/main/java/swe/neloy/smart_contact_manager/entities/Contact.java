/* 
Created by Neloy on 10 August, 2025.
Email: taufiqneloy.swe@gmail.com
*/

package swe.neloy.smart_contact_manager.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;
    private String name;
    private String secondName;
    private String work;
    private String email;
    private String phone;
    private String image;

    @Column(length = 500)
    private String description;

    @ManyToOne
    private User user;
}
