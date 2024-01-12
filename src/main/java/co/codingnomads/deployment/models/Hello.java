package co.codingnomads.deployment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hello")
@Getter
@Setter
@NoArgsConstructor
public class Hello {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    private String now;

    public Hello(String name) {
        this.name = name;
    }
}