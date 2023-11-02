package com.upc.cargasinestres.CargaSinEstres.model.dto.Client.response;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String name;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String celular;
    private String direccion;
}
