package com.upc.cargasinestres.CargaSinEstres.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.Shared.util.CompanyValidation;
import com.upc.cargasinestres.CargaSinEstres.exception.ResourceNotFoundException;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Company.request.CompanyRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Company.response.CompanyResponseDto;
import com.upc.cargasinestres.CargaSinEstres.model.entity.Company;
import com.upc.cargasinestres.CargaSinEstres.service.ICompanyService;
import com.upc.cargasinestres.CargaSinEstres.repository.ICompanyRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService{

    private final ICompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    //inyeccion de dependencias
    public CompanyServiceImpl(ICompanyRepository companyRepository, ModelMapper modelMapper) {

        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompanyResponseDto> getAllCompanies() {
        var companies = companyRepository.findAll();

        return companies.stream().map(
                Company->modelMapper.map(Company, CompanyResponseDto.class)
        ).toList();
    }

    @Override
    public CompanyResponseDto getCompanyById(Long id) {
        var company = companyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontro la empresa con id: "+id));
        return modelMapper.map(company, CompanyResponseDto.class);
    }

    @Override
    public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto) {
        if (companyRepository.findByNameAndNumeroContacto(companyRequestDto.getName(), companyRequestDto.getNumeroContacto()).isPresent())
            throw new RuntimeException("Ya existe una empresa con ese nombre y numero de contacto");

        CompanyValidation.ValidateCompany(companyRequestDto);

        var newCompany = modelMapper.map(companyRequestDto, Company.class);
        var createdCompany = companyRepository.save(newCompany);
        return modelMapper.map(createdCompany, CompanyResponseDto.class);
    }

}
