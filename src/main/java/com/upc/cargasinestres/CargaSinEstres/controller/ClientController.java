package com.upc.cargasinestres.CargaSinEstres.controller;

import com.upc.cargasinestres.CargaSinEstres.model.dto.Client.request.ClientRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.Client.response.ClientResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.cargasinestres.CargaSinEstres.service.IClientService;

import java.util.List;

@Tag(name="Client")
@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {

        this.clientService = clientService;
    }

    @Operation(summary = "Get clients for login")
    @GetMapping("/clients/login")
    public ResponseEntity<List<ClientResponseDto>> getClientsForLogin(@RequestParam(name="email") String email, @RequestParam(name="password")String password){
        var res = clientService.getClientsForLogin(email, password);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Get a clien by Id")
    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable Long id){
        var res = clientService.getClientById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @Operation(summary = "Create a Client")
    @PostMapping("/clients")
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody ClientRequestDto clientRequestDto) {
        var res = clientService.createClient(clientRequestDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}

