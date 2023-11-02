package com.upc.cargasinestres.CargaSinEstres.model.entity;

import com.upc.cargasinestres.CargaSinEstres.model.entity.BookingHistory;
import jakarta.persistence.*;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "dateTime", nullable = false)
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "bookingHistory_id")
    private BookingHistory bookingHistory;

}
