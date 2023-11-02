package com.upc.cargasinestres.CargaSinEstres.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "photo", nullable = false)
    private String photo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "numeroContacto", nullable = false)
    private String numeroContacto;

    @Column(name = "password", nullable = false)
    private String password;

    //@Column(name = "confirmarpassword", nullable = false)
    //private String confirmarpassword;

    @Column(name = "transporte", nullable = false)
    private boolean transporte;

    @Column(name = "carga", nullable = false)
    private boolean carga;

    @Column(name = "embalaje", nullable = false)
    private boolean embalaje;

    @Column(name = "montaje", nullable = false)
    private boolean montaje;

    @Column(name = "desmontaje", nullable = false)
    private boolean desmontaje;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "userType", nullable = false)
    private String userType;


}
