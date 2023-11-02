package com.upc.cargasinestres.CargaSinEstres.model.dto.Chat.response;

import com.upc.cargasinestres.CargaSinEstres.model.entity.BookingHistory;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponseDto {

    private Long id;
    private String user;
    private String message;
    private String dateTime;
    private BookingHistory bookingHistory;

}
