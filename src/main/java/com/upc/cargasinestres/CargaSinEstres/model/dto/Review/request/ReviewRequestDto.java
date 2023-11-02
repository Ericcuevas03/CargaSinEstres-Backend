package com.upc.cargasinestres.CargaSinEstres.model.dto.Review.request;
import com.upc.cargasinestres.CargaSinEstres.model.entity.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDto {
    private int rating;
    private String comment;
}
