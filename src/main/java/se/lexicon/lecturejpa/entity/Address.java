package se.lexicon.lecturejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Address {

    @Id
    private Long id;

    @Column(nullable = false)
    private String Street;

    private String city;

    @Column(nullable = false, length = 6)
    private String zipCode;
}
