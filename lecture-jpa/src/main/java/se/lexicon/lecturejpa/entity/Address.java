package se.lexicon.lecturejpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "student")

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Street;

    private String city;

    @Column(nullable = false, length = 6)
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Student student;

    public Address(String street, String city, String zipCode) {
        Street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

}
