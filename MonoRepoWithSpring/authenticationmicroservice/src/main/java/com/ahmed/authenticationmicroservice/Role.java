package com.ahmed.authenticationmicroservice;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Role {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    /**
     * name
     */
    private String name ;


}
