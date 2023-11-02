package com.upc.cargasinestres.CargaSinEstres.repository;

import com.upc.cargasinestres.CargaSinEstres.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
}
