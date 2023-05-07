package com.adias.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String model;
    private String brand;
    private int year;
    private StringBuilder registerNumber;
    @Enumerated(EnumType.STRING)
    private Color color;
    private String photo;
    @ManyToOne
    @JoinColumn(name = "id_ownercar")
    private OwnerCar ownerCar;
    @ManyToOne
    @JoinColumn(name = "id_userr")
    private Userr userr;
    public Userr getUserr() {
        return userr;
    }


}
