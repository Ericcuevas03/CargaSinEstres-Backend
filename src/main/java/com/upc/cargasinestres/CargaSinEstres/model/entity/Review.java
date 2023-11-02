package com.upc.cargasinestres.CargaSinEstres.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upc.cargasinestres.CargaSinEstres.model.entity.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating", length = 22, nullable = false)
    private int rating;

    @Column(name = "comment", length = 14, nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false, foreignKey = @ForeignKey(name = "FK_COMPANY_ID"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Company company;

}
