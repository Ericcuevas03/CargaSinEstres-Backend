package com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.response;

import com.upc.cargasinestres.CargaSinEstres.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingHistoryResponseDto {
    private Long id;
    private Company company;
    private Client client;
    private LocalDate bookingDate;
    private String pickupAddress;
    private String destinationAddress;
    private Date movingDate;
    private Time movingTime;
    private String status;
    private String Services;
    //private Payment payment;
    //private HiredCompany hiredCompany;
    private List<Chat> chats;

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
