package com.upc.cargasinestres.CargaSinEstres.model.dto.Chat.request;

import com.upc.cargasinestres.CargaSinEstres.model.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequestDto {
    private Long id;
    private String user;
    private String message;
    private String dateTime;
    private BookingHistory bookingHistory;
}
