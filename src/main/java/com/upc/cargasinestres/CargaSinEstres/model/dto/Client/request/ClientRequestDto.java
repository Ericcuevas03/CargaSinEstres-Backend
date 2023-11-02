package com.upc.cargasinestres.CargaSinEstres.model.dto.Client.request;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    private String name;

    private String apellidoMaterno;

    private String apellidoPaterno;

    private String celular;

    private String direccion;

    private String email;

    private String password;

    private String userType;
}
