package com.client.ws.rasmooplus.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.context.annotation.EnableMBeanExport;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_type")
public class UserType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    private Long id;

    private String name;
    private String description;
}
