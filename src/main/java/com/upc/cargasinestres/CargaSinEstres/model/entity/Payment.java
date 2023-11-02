package com.upc.cargasinestres.CargaSinEstres.model.entity;

import com.upc.cargasinestres.CargaSinEstres.model.entity.BookingHistory;
import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "totalAmount", nullable = false)
    private double totalAmount;

    @Column(name = "paymentMethod", nullable = false)
    private String paymentMethod;

    @OneToOne(mappedBy = "payment")
    private BookingHistory bookingHistory;

}