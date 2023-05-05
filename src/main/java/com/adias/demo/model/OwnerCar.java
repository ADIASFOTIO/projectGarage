package com.adias.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ownercar")

public class OwnerCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;
    private String tel;
    private String mail;
    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ownerCar")
    @JsonIgnore
    private List<Car> cars;



}
