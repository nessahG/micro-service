package com.ahmed.authenticationmicroservice;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    /**
     * email
     */
    private String email;
    /**
     * password
     */
    private String password;
    /**
     * username
     */
    @Column(unique = true)
    private String username;
    /**
     * list of roles
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
