package net.blusalt.service;



import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import net.blusalt.entity.DroneRequest;
import net.blusalt.entity.DroneResponse;
import net.blusalt.entity.MedicationRequest;
import net.blusalt.entity.MedicationResponse;
import net.blusalt.exception.DroneServiceCustomException;
import net.blusalt.exception.MedicationCustomException;

import net.blusalt.model.Medication;
import net.blusalt.repository.MedicationRepository;

@Service
@Log4j2
public class MedicationserviceImpl implements MedicationService {
	
	@Autowired
	MedicationRepository MedicationRepository;
	
	public MedicationserviceImpl(MedicationRepository MedicationRepository) {
		
		this.MedicationRepository = MedicationRepository;
	}

	@Override
	public long addMedication(MedicationRequest medicalRequest) {
		// TODO Auto-generated method stub
		  log.info("Adding Medical Product..");
		  Medication medication = Medication.builder()
				  .name(medicalRequest.getName())
				  .weight(medicalRequest.getWeight())
				  .code(medicalRequest.getCode())
				  .image(medicalRequest.getImage())
				  .build();
		  MedicationRepository.save(medication);
		  log.info("Medication Added ");
		return medication.getId();
	}

	@Override
	public MedicationResponse getById(long Id) {
	log.info("Get the info for productId: {}",Id);
	
	Medication medication = MedicationRepository.findById(Id)
			.orElseThrow(
					()-> new MedicationCustomException("medication with given id not found","Medication Not Found"));
	  MedicationResponse medicationResponse = new MedicationResponse();
	  BeanUtils.copyProperties(medication, medicationResponse);
			
		return medicationResponse ;
	}

	
}
