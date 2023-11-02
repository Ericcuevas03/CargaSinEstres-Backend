package com.upc.cargasinestres.CargaSinEstres.controller;

import com.upc.cargasinestres.CargaSinEstres.model.dto.Review.request.ReviewRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Review.response.ReviewResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upc.cargasinestres.CargaSinEstres.service.IReviewService;

import java.util.List;

@Tag(name="Review")
@RestController
@RequestMapping("/api/v1")
public class ReviewController {
    private final IReviewService reviewService;

    public ReviewController(IReviewService IReviewService){
        this.reviewService = IReviewService;
    }

    @Operation(summary = "Get all reviews by company Id")
    @GetMapping("/reviews/{companyId}")
    public ResponseEntity<List<ReviewResponseDto>> getReviewsByCompanyId(@PathVariable(name="companyId") Long companyId){
        var res = reviewService.getReviewsByCompanyId(companyId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Create a Review")
    @PostMapping("/reviews")
    public ResponseEntity<ReviewResponseDto> createReview(@RequestParam(name = "idCompany") Long companyId, @RequestBody ReviewRequestDto reviewRequestDto){
        var res = reviewService.createReview(companyId, reviewRequestDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


}
