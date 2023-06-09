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
@Table(name = "client")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String firstName;
    private String lastName;
    private String tel;
    private String mail;
    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    @JsonIgnore
    private List<Car> cars;



}
