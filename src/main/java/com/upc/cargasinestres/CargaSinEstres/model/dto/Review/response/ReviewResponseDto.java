package com.upc.cargasinestres.CargaSinEstres.model.dto.Review.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.upc.cargasinestres.CargaSinEstres.model.entity.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private int rating;
    private String comment;
    private Company company;
}
