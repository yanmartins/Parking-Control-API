package com.api.parkingcontrol.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
// Definindo tabela que será gerada
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable{
    private static final long serialVersionUID = 1L; // Controle para conversões da JVM

    @Id // Uma entedidate PRECISA de um ID
    @GeneratedValue(strategy = GenerationType.AUTO) // O ID será gerado de forma automática
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)// Não pode ser nulo e deve ser um valor único na tabela
    private String parkingSpotNumber;
    
    //TODO criar uma entidade para o carro (relacionamentos JPA)
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false, length = 70)
    private String brandCar;
    @Column(nullable = false, length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String colorCar;

    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 130)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;

}
