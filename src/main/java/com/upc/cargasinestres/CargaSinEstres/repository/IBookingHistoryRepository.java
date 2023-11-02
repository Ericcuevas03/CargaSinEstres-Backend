package com.upc.cargasinestres.CargaSinEstres.repository;

import com.upc.cargasinestres.CargaSinEstres.model.entity.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookingHistoryRepository extends JpaRepository<BookingHistory, Long>{

    List<BookingHistory> findByClientId(Long ClientId);

    List<BookingHistory> findByCompanyId(Long CompanyId);

    //Boolean existsByPickupAddressAndDestinationAddress(String pickupAddress, String destinationAddress);


}
