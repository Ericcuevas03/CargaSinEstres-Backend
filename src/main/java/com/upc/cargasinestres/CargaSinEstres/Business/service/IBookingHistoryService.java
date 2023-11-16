package com.upc.cargasinestres.CargaSinEstres.Business.service;

import com.upc.cargasinestres.CargaSinEstres.Business.model.dto.BookingHistory.request.BookingHistoryRequestDto;
import com.upc.cargasinestres.CargaSinEstres.Business.model.dto.BookingHistory.response.BookingHistoryResponseDtoV2;

import java.util.List;

public interface IBookingHistoryService {

    //create bookingHistory
    public abstract BookingHistoryResponseDtoV2 createBookingHistory(Long clientId, Long companyId, BookingHistoryRequestDto bookingHistoryRequestDto);

    //get all bookingHistory for a client by Id
    public abstract List<BookingHistoryResponseDtoV2> getBookingHistoryByClientId(Long id);

    //get all bookingHistory for a company by Id
    public abstract List<BookingHistoryResponseDtoV2> getBookingHistoryByCompanyId(Long id);

    //update bookingHistory chat


}
