package com.upc.cargasinestres.CargaSinEstres.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookingHistory")
public class BookingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idCompany", nullable = false, foreignKey = @ForeignKey(name="FK_bookingHistory_company"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Company company;

    @ManyToOne
    @JoinColumn(name="idClient", nullable = false, foreignKey = @ForeignKey(name="FK_bookingHistory_client"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client client;

    @Column(name="bookingDate", nullable = false)
    private LocalDate bookingDate;

    @Column(name="pickupAddress", nullable = false)
    private String pickupAddress;

    @Column(name="destinationAddress", nullable = false)
    private String destinationAddress;

    @Column(name="movingDate", nullable = false)
    private Date movingDate;

    @Temporal(TemporalType.TIME)
    @Column(name="movingTime", nullable = false)
    private Date movingTime;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name="Services", nullable = false)
    private String Services;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    private HiredCompany hiredCompany;

    @OneToMany(mappedBy = "bookingHistory", cascade = CascadeType.ALL)
    private List<Chat> chats;

}

