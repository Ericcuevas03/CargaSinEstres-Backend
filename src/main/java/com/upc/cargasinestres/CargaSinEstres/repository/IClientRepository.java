package com.upc.cargasinestres.CargaSinEstres.repository;

import com.upc.cargasinestres.CargaSinEstres.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.email = :email AND c.password = :password")
    Optional<Client> existsClient(@Param("email") String email, @Param("password") String password);

    List<Client> findByEmailAndPassword(String email, String password);
}
