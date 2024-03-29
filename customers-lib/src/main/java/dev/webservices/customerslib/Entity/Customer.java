package dev.webservices.customerslib.Entity;

import dev.webservices.addresses.Entity.Address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    public boolean isEligible() {
        return age > 17;
    }

    public boolean isValid() {
        return !firstName.isEmpty() && !lastName.isEmpty() && age > 17;
    }

}
