package com.upc.cargasinestres.CargaSinEstres.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.Shared.util.ReviewValidation;
import com.upc.cargasinestres.CargaSinEstres.exception.ResourceNotFoundException;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Review.request.ReviewRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Review.response.ReviewResponseDto;
import com.upc.cargasinestres.CargaSinEstres.model.entity.Review;
import com.upc.cargasinestres.CargaSinEstres.repository.ICompanyRepository;
import com.upc.cargasinestres.CargaSinEstres.service.IReviewService;
import com.upc.cargasinestres.CargaSinEstres.repository.IReviewRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {

    private final IReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    private final ICompanyRepository companyRepository;

    //inyeccion de dependencias
    public ReviewServiceImpl(IReviewRepository reviewRepository, ModelMapper modelMapper, ICompanyRepository companyRepository){
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<ReviewResponseDto> getReviewsByCompanyId(Long companyId){
        var reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().map(
                Review->modelMapper.map(Review, ReviewResponseDto.class)
        ).toList();
    }

    @Override
    public ReviewResponseDto createReview(Long companyId, ReviewRequestDto reviewRequestDto) {
        var company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontro la empresa con id: "+companyId));

        ReviewValidation.ValidateReview(reviewRequestDto);

        var newReview = modelMapper.map(reviewRequestDto, Review.class);
        newReview.setCompany(company);
        var createdReview = reviewRepository.save(newReview);
        return modelMapper.map(createdReview, ReviewResponseDto.class);
    }

}
