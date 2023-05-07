package com.adias.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userr")
public class Userr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String mail;
    private String tel;
    private Instant dateOfBurn;
    private String photo;
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userr")
    @JsonIgnore
    private List<Role> roles;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userr")
    @JsonIgnore
    private List<Car> cars;
}
