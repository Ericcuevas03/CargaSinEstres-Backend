package com.upc.cargasinestres.CargaSinEstres.controller;

import com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.request.BookingHistoryRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.response.BookingHistoryResponseDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.response.BookingHistoryResponseDtoV2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.upc.cargasinestres.CargaSinEstres.service.IBookingHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Tag(name="BookingHistory")
@RestController
@RequestMapping("/api/v1/")
public class BookingHistoryController {

    private final IBookingHistoryService bookingHistoryService;

    public BookingHistoryController(IBookingHistoryService bookingHistoryService) {
        this.bookingHistoryService = bookingHistoryService;
    }

    @Operation(summary = "Create a Booking History")
    @PostMapping("/bookingHistory")
    public ResponseEntity<BookingHistoryResponseDtoV2> createBookingHistory(@RequestParam(name = "idClient") Long clientId, @RequestParam(name = "idCompany") Long companyId, @RequestBody BookingHistoryRequestDto bookingHistoryRequestDto) {
        var res = bookingHistoryService.createBookingHistory(clientId, companyId, bookingHistoryRequestDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @Operation(summary = "Obtain a list of Booking History by client Id")
    @GetMapping("/bookingHistory/client/{id}")
    public ResponseEntity<List<BookingHistoryResponseDtoV2>> getBookingHistoryByClientId(@PathVariable(name="id") Long id){
        var res = bookingHistoryService.getBookingHistoryByClientId(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Obtain a list of Booking History by company Id")
    @GetMapping("/bookingHistory/company/{id}")
    public ResponseEntity<List<BookingHistoryResponseDtoV2>> getBookingHistoryByCompanyId(@PathVariable(name="id") Long id){
        var res = bookingHistoryService.getBookingHistoryByCompanyId(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}

