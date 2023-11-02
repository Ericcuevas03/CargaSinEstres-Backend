package com.upc.cargasinestres.CargaSinEstres.model.dto.HiredCompany.response;
import com.upc.cargasinestres.CargaSinEstres.model.entity.BookingHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiredCompanyResponseDto {
    private Long id;
    private String name;
    private String logo;
    private BookingHistory bookingHistory;
}
