package com.upc.cargasinestres.CargaSinEstres.service;

import com.upc.cargasinestres.CargaSinEstres.model.dto.Company.request.CompanyRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Company.response.CompanyResponseDto;

import java.util.List;

public interface ICompanyService {

    //get all companies
    public abstract List<CompanyResponseDto> getAllCompanies();

    //get company by id
    public abstract CompanyResponseDto getCompanyById(Long id);

    //create company
    public abstract CompanyResponseDto createCompany(CompanyRequestDto company);


}
