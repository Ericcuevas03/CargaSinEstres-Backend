package com.upc.cargasinestres.CargaSinEstres.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.Shared.util.BookingHistoryValidation;
import com.upc.cargasinestres.CargaSinEstres.exception.ResourceNotFoundException;
import com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.request.BookingHistoryRequestDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.response.BookingHistoryResponseDto;
import com.upc.cargasinestres.CargaSinEstres.model.dto.BookingHistory.response.BookingHistoryResponseDtoV2;
import com.upc.cargasinestres.CargaSinEstres.model.entity.BookingHistory;
import com.upc.cargasinestres.CargaSinEstres.repository.IBookingHistoryRepository;
import com.upc.cargasinestres.CargaSinEstres.repository.IClientRepository;
import com.upc.cargasinestres.CargaSinEstres.repository.ICompanyRepository;
import com.upc.cargasinestres.CargaSinEstres.service.IBookingHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Qualifier("bookingHistoryServiceImpl")
public class BookingHistoryServiceImpl implements IBookingHistoryService {

    private final IBookingHistoryRepository bookingHistoryRepository;
    private final ModelMapper modelMapper;
    private final IClientRepository clientRepository;
    private final ICompanyRepository companyRepository;

    @Autowired
    public BookingHistoryServiceImpl(IBookingHistoryRepository bookingHistoryRepository, ModelMapper modelMapper, IClientRepository clientRepository, ICompanyRepository companyRepository ) {
        this.bookingHistoryRepository = bookingHistoryRepository;
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
    }

    //Method : POST
    @Override
    public BookingHistoryResponseDtoV2 createBookingHistory(Long clientId, Long companyId, BookingHistoryRequestDto bookingHistoryRequestDto) {
        // Buscar la cuenta
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el cliente con ID: " + clientId));

        var company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la empresa con ID: " + companyId));

        // Validación
        BookingHistoryValidation.ValidateBookingHistory(bookingHistoryRequestDto);

        // Mapeo
        var newBookingHistory = modelMapper.map(bookingHistoryRequestDto, BookingHistory.class);
        newBookingHistory.setClient(client);
        newBookingHistory.setCompany(company);
        newBookingHistory.setBookingDate(LocalDate.now());
        newBookingHistory.setStatus("Iniciado");

        // Convertir movingTime de Date a Time
        Date movingTimeDate = bookingHistoryRequestDto.getMovingTime();
        Time movingTime = new Time(movingTimeDate.getTime());
        newBookingHistory.setMovingTime(movingTime);

        var createdBookingHistory = bookingHistoryRepository.save(newBookingHistory);
        return modelMapper.map(createdBookingHistory, BookingHistoryResponseDtoV2.class);
    }


    @Override
    public List<BookingHistoryResponseDtoV2> getBookingHistoryByClientId(Long clientId) {
        var existingBookingHistory = bookingHistoryRepository.findByClientId(clientId);
        return existingBookingHistory.stream()
                .map(BookingHistory -> modelMapper.map(BookingHistory, BookingHistoryResponseDtoV2.class))
                .toList();
    }

    @Override
    public List<BookingHistoryResponseDtoV2> getBookingHistoryByCompanyId(Long companyId) {
        var existingBookingHistory = bookingHistoryRepository.findByCompanyId(companyId);
        return existingBookingHistory.stream()
                .map(BookingHistory -> modelMapper.map(BookingHistory, BookingHistoryResponseDtoV2.class))
                .toList();
    }


}
