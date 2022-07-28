package com.api.parkingcontrol.services;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

//TODO para elevar o nível, criar uma interface para o Service
@Service
public class ParkingSpotService {
    
    final ParkingSpotRepository parkingSpotRepository;

    // Cria ponto de injeção
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }


}
