package com.upc.cargasinestres.CargaSinEstres.service;

import com.upc.cargasinestres.CargaSinEstres.model.dto.Client.request.ClientRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Client.response.ClientResponseDto;
import com.upc.cargasinestres.CargaSinEstres.model.entity.Client;

import java.util.List;

public interface IClientService {

    //GET
    public abstract List<ClientResponseDto> getClientsForLogin(String email, String password);

    public abstract ClientResponseDto getClientById(Long id);

    //CREATE
    public abstract ClientResponseDto createClient(ClientRequestDto client);

    //UPDATE
    //public abstract Client updateClient(Long id, Client client);

}
