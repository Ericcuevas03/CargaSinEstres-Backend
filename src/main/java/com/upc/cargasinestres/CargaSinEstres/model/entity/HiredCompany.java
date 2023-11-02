package com.upc.cargasinestres.CargaSinEstres.model.entity;

import com.upc.cargasinestres.CargaSinEstres.model.entity.BookingHistory;
import jakarta.persistence.*;

@Entity
public class HiredCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "logo", nullable = false)
    private String logo;

    @ManyToOne
    @JoinColumn(name = "bookingHistory_id")
    private BookingHistory bookingHistory;

}
