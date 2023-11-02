package com.upc.cargasinestres.CargaSinEstres.Shared.util;

import com.upc.cargasinestres.CargaSinEstres.exception.ValidationException;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Company.request.CompanyRequestDto;

public class CompanyValidation {

    public static void ValidateCompany(CompanyRequestDto companyRequestDto){

        if(companyRequestDto.getName().isEmpty()){
            throw new ValidationException("El nombre de la empresa no puede estar vacio");
        }
        if(companyRequestDto.getPhoto().isEmpty()){
            throw new ValidationException("La foto de la empresa no puede estar vacio");
        }
        if(companyRequestDto.getName().length()>30) {
            throw new ValidationException("El nombre de la empresa no puede exceder los 30 caracteres");
        }
        if(companyRequestDto.getDescription().length() > 250){
            throw new ValidationException("La descripcion de la empresa no puede exceder los 250 caracteres");
        }

        if(!companyRequestDto.isTransporte() && !companyRequestDto.isCarga() && !companyRequestDto.isEmbalaje()
                && !companyRequestDto.isMontaje() && !companyRequestDto.isDesmontaje()
        ){
            throw new ValidationException("Como empresa debe ofrecer al menos un servicio");
        }

    }

}
