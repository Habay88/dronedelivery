package net.blusalt.service;



import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import net.blusalt.entity.DroneRequest;
import net.blusalt.entity.DroneResponse;
import net.blusalt.exception.DroneServiceCustomException;
import net.blusalt.model.DroneFleet;
import net.blusalt.model.Medication;
import net.blusalt.repository.DroneRepository;

@Service
@Log4j2
public class DroneserviceImpl implements DroneFleetService {
	
	@Autowired
	DroneRepository droneRepository;
	
	public DroneserviceImpl(DroneRepository droneRepository) {
		
		this.droneRepository = droneRepository;
	}

	@Override
	public long addFleet(DroneRequest droneRequest) {
		// TODO Auto-generated method stub
		  log.info("Adding Drone Product..");
		  DroneFleet droneFleet = DroneFleet.builder()
				  .serialNumber(droneRequest.getSerialNumber())
				  .model(droneRequest.getModel())
				  .weightLimit(droneRequest.getWeightLimit())
				  .batteryCapacityPercentage(droneRequest.getBatteryCapacityPercentage())
				  .batteryState(droneRequest.getBatteryState())
				  .build();
		  droneRepository.save(droneFleet);
		  log.info("drone added");
		return droneFleet.getDroneId();
	}

	@Override
	public DroneResponse getDroneById(long droneId) {
	log.info("Get the drone for productId: {}",droneId);
	
	DroneFleet droneFleet = droneRepository.findById(droneId)
			.orElseThrow(
					()-> new DroneServiceCustomException("drone with given id not found","Drone Not Found"));
	  DroneResponse droneResponse = new DroneResponse();
	  BeanUtils.copyProperties(droneFleet, droneResponse);
			
		return droneResponse ;
	}


}
