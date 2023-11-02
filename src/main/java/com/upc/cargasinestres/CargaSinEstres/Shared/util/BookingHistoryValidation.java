package com.upc.cargasinestres.CargaSinEstres.Shared.util;


import com.upc.cargasinestres.CargaSinEstres.exception.ValidationException;
import com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.request.BookingHistoryRequestDto;

public class BookingHistoryValidation {

    public static void ValidateBookingHistory(BookingHistoryRequestDto bookingHistoryRequestDto){

        if(bookingHistoryRequestDto.getPickupAddress() == null || bookingHistoryRequestDto.getPickupAddress().isEmpty()){
            throw new ValidationException("La dirección de recogida debe ser obligatoria"); //error 400
        }

        if(bookingHistoryRequestDto.getDestinationAddress() == null || bookingHistoryRequestDto.getDestinationAddress().isEmpty()){
            throw new ValidationException("La dirección de destino debe ser obligatoria"); //error 400
        }

        if(bookingHistoryRequestDto.getMovingDate() == null){
            throw new ValidationException("La fecha de recogida debe ser obligatoria"); //error 400
        }

        if(bookingHistoryRequestDto.getMovingTime() == null){
            throw new ValidationException("El tiempo de recogida debe ser obligatorio"); //error 400
        }

        if(bookingHistoryRequestDto.getServices() == null || bookingHistoryRequestDto.getServices().isEmpty()){
            throw new ValidationException("La reserva debe presentar almenos 1 servicio, es obligatorio"); //error 400
        }


    }

}
