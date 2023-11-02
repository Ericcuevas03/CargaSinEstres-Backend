package com.upc.cargasinestres.CargaSinEstres.Shared.util;

import com.upc.cargasinestres.CargaSinEstres.exception.ValidationException;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Review.request.ReviewRequestDto;

public class ReviewValidation {
    public static void ValidateReview(ReviewRequestDto reviewRequestDto){
        if(reviewRequestDto.getComment() == null || reviewRequestDto.getComment().trim().isEmpty()){
            reviewRequestDto.setComment("...");
        }
        if(reviewRequestDto.getRating() == 0){
            throw new ValidationException("El rating es obligatorio");
        }
    }
}
