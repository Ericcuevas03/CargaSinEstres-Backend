package com.upc.cargasinestres.CargaSinEstres.Business.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.Business.service.IBookingHistoryService;
import com.upc.cargasinestres.CargaSinEstres.Business.Shared.validations.BookingHistoryValidation;
import com.upc.cargasinestres.CargaSinEstres.Business.repository.IChatRepository;
import com.upc.cargasinestres.CargaSinEstres.Shared.exception.ResourceNotFoundException;
import com.upc.cargasinestres.CargaSinEstres.Business.model.dto.BookingHistory.request.BookingHistoryRequestDto;
import com.upc.cargasinestres.CargaSinEstres.Business.model.dto.BookingHistory.response.BookingHistoryResponseDtoV2;
import com.upc.cargasinestres.CargaSinEstres.Business.model.entity.BookingHistory;
import com.upc.cargasinestres.CargaSinEstres.Business.repository.IBookingHistoryRepository;
import com.upc.cargasinestres.CargaSinEstres.Business.repository.IClientRepository;
import com.upc.cargasinestres.CargaSinEstres.Business.repository.ICompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Implementation of the IBookingHistoryService interface.
 * Handles the business logic for booking history operations.
 * @author Grupo1
 * @version 1.0
 * */
@Service
@Qualifier("bookingHistoryServiceImpl")
public class BookingHistoryServiceImpl implements IBookingHistoryService {

    private final IBookingHistoryRepository bookingHistoryRepository;
    private final ModelMapper modelMapper;
    private final IClientRepository clientRepository;
    private final ICompanyRepository companyRepository;

    private final IChatRepository chatRepository;

    @Autowired
    public BookingHistoryServiceImpl(IBookingHistoryRepository bookingHistoryRepository, ModelMapper modelMapper,
                                     IClientRepository clientRepository, ICompanyRepository companyRepository, IChatRepository chatRepository){
        this.bookingHistoryRepository = bookingHistoryRepository;
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
        this.chatRepository = chatRepository;
    }

    /**
     * Creates a new booking history record.
     *
     * @param clientId               The ID of the client associated with the booking.
     * @param companyId              The ID of the company associated with the booking.
     * @param bookingHistoryRequestDto The data for creating the booking history.
     * @return The created booking history response.
     * @throws ResourceNotFoundException If the client or company is not found.
     */
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
        newBookingHistory.setStatus("En curso");

        /* Convertir movingTime de Date a Time
        String movingTimeDate = bookingHistoryRequestDto.getMovingTime();
        Time movingTime = new Time(movingTimeDate.getTime());
        newBookingHistory.setMovingTime(movingTime);*/

        var createdBookingHistory = bookingHistoryRepository.save(newBookingHistory);
        return modelMapper.map(createdBookingHistory, BookingHistoryResponseDtoV2.class);
    }

    /**
     * Retrieves a list of booking history records associated with a client.
     *
     * @param clientId The ID of the client.
     * @return A list of booking history response DTOs.
     */
    @Override
    public List<BookingHistoryResponseDtoV2> getBookingHistoryByClientId(Long clientId) {
        var existingBookingHistory = bookingHistoryRepository.findByClientId(clientId);

        var toShowBookingHistory = existingBookingHistory.stream()
                .map(BookingHistory -> modelMapper.map(BookingHistory, BookingHistoryResponseDtoV2.class))
                .toList();

        for (BookingHistoryResponseDtoV2 bookingHistory : toShowBookingHistory){
            var chats = chatRepository.findByBookingHistoryId(bookingHistory.getId());
            if(chats == null)
                throw new ResourceNotFoundException("No existe una ningún mensaje");
            bookingHistory.setChats(chats); //se setea la lista de chats para cada reserva
        }

        return toShowBookingHistory;
    }

    /**
     * Retrieves a list of booking history records associated with a company.
     *
     * @param companyId The ID of the company.
     * @return A list of booking history response DTOs.
     */
    @Override
    public List<BookingHistoryResponseDtoV2> getBookingHistoryByCompanyId(Long companyId) {
        var existingBookingHistory = bookingHistoryRepository.findByCompanyId(companyId);
        return existingBookingHistory.stream()
                .map(BookingHistory -> modelMapper.map(BookingHistory, BookingHistoryResponseDtoV2.class))
                .toList();
    }


}
