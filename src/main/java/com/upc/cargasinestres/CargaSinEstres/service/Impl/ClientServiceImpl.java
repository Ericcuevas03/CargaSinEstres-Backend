package com.upc.cargasinestres.CargaSinEstres.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.Shared.util.ClientValidation;
import com.upc.cargasinestres.CargaSinEstres.exception.ResourceNotFoundException;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Client.request.ClientRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Client.response.ClientResponseDto;
import com.upc.cargasinestres.CargaSinEstres.model.entity.Client;
import com.upc.cargasinestres.CargaSinEstres.repository.IClientRepository;
import com.upc.cargasinestres.CargaSinEstres.service.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService{


    private final IClientRepository clientRepository;
    private final ModelMapper modelMapper;

    //inyeccion de dependencias
    public ClientServiceImpl(IClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ClientResponseDto createClient(ClientRequestDto clientRequestDto) {

        if(clientRepository.existsClient(clientRequestDto.getEmail(), clientRequestDto.getPassword()).isPresent())
            throw new RuntimeException("Ya existe un cliente con ese email y password");

        ClientValidation.ValidateClient(clientRequestDto);

        var newClient = modelMapper.map(clientRequestDto, Client.class);
        var createdClient = clientRepository.save(newClient);
        return modelMapper.map(createdClient, ClientResponseDto.class);
    }


    @Override
    public List<ClientResponseDto> getClientsForLogin(String email, String password) {
        var clients = clientRepository.findByEmailAndPassword(email, password);
        return clients.stream()
                .map(Client -> modelMapper.map(Client, ClientResponseDto.class))
                .toList();
    }


    @Override
    public ClientResponseDto getClientById(Long id) {
        var client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontro el cliente con id: "+id));
        return modelMapper.map(client, ClientResponseDto.class);
    }

    /*
    @Override
    public Client updateClient(Long id, Client client) {
        return clientRepository.updateClient(id, client);
    }
    */


}
