package com.upc.cargasinestres.CargaSinEstres.model.dto.HiredCompany.request;

import com.upc.cargasinestres.CargaSinEstres.model.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiredCompanyRequestDto {
    private String name;
    private String logo;
    private BookingHistory bookingHistory;
}
