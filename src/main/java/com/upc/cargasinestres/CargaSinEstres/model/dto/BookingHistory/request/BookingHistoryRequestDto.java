package com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.request;

import com.upc.cargasinestres.CargaSinEstres.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistoryRequestDto {
    //private Company company;
    //private Client client;
    //private LocalDate bookingDate;
    private String pickupAddress;
    private String destinationAddress;
    private Date movingDate;
    private Date movingTime;
    private String Services;
    //private Payment payment;
    //private HiredCompany hiredCompany;

    /*
    private Long id;  -------------------------------
    private Company company; -------------------------------
    private Client client; -------------------------------
    private LocalDate bookingDate;  -------------------------------
    private String pickupAddress;   -------------------------------
    private String destinationAddress; -------------------------------
    private Date movingDate; -------------------------------
    private Time movingTime; -------------------------------
    private String status; -------------------------------
    private String Services; -------------------------------
    private Payment payment;
    private HiredCompany hiredCompany;
    private List<Chat> chats;
     */

}
