package com.upc.cargasinestres.CargaSinEstres.service;


import com.upc.cargasinestres.CargaSinEstres.model.dto.Review.request.ReviewRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Review.response.ReviewResponseDto;

import java.util.List;

public interface IReviewService {

    //create review
    public abstract ReviewResponseDto createReview(Long companyId, ReviewRequestDto review);

    //get review by company id
    public abstract List<ReviewResponseDto> getReviewsByCompanyId(Long companyId);
}
