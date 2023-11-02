package com.upc.cargasinestres.CargaSinEstres.model.dto.Company.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDto {
    private Long id;
    private String name;
    private String photo;
    private String description;
    private String email;
    private String NumeroContacto;
    private String direccion;
    private boolean transporte;
    private boolean carga;
    private boolean embalaje;
    private boolean montaje;
    private boolean desmontaje;
}