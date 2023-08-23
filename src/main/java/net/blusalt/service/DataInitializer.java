package net.blusalt.service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.blusalt.model.BatterytState;
import net.blusalt.model.DroneFleet;
import net.blusalt.model.DroneModel;
import net.blusalt.model.DroneState;
import net.blusalt.model.Medication;
import net.blusalt.repository.DroneRepository;
import net.blusalt.repository.MedicationRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DroneRepository droneRepository;
     private final MedicationRepository medicationRepository;
    public DataInitializer(DroneRepository droneRepository,MedicationRepository medicationRepository) {
        this.droneRepository = droneRepository;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public void run(String... args) {
      //  if (!droneRepository.existsBySerialNumber("your_serial_number") ||){
        DroneFleet drone = new DroneFleet();
        drone.setSerialNumber("qwertyuiop12345");
        drone.setModel(DroneModel.CRUISERWEIGHT);
        drone.setWeightLimit(450);
        drone.setBatteryCapacityPercentage(100);
        drone.setBatteryState(BatterytState.DRAINING);
        drone.setDroneState(DroneState.IDLE);
        droneRepository.save(drone);

         DroneFleet drone1 = new DroneFleet();
        drone1.setSerialNumber("qwertyuiop12346");
        drone1.setModel(DroneModel.HEAVYWEIGHT);
        drone1.setWeightLimit(500);
        drone1.setBatteryCapacityPercentage(100);
        drone1.setBatteryState(BatterytState.FULL);
        drone1.setDroneState(DroneState.DELIVERED);
        droneRepository.save(drone1);

          DroneFleet drone2 = new DroneFleet();
        drone2.setSerialNumber("qwertyuiop12347");
        drone2.setModel(DroneModel.LIGHTWEIGHT);
        drone2.setWeightLimit(300);
        drone2.setBatteryCapacityPercentage(80);
        drone2.setBatteryState(BatterytState.DRAINING);
        drone2.setDroneState(DroneState.DELIVERED);
        droneRepository.save(drone2);

         DroneFleet drone3 = new DroneFleet();
        drone3.setSerialNumber("qwertyuiop12348");
        drone3.setModel(DroneModel.MIDDLEWEIGHT);
        drone3.setWeightLimit(250);
        drone3.setBatteryCapacityPercentage(24);
        drone3.setBatteryState(BatterytState.CHARGING);
        drone3.setDroneState(DroneState.IDLE);
        droneRepository.save(drone3);

        Medication medication = new  Medication();
        medication.setName("paracetamol");
        medication.setWeight(323);
        medication.setCode("SKY303___1334");
        medication.setImage("ddfuujefakdfadkj");
        medicationRepository.save(medication);

         Medication medication1 = new  Medication();
        medication1.setName("bunto-bloodtonic");
        medication1.setWeight(320);
        medication1.setCode("SKY303___1335");
        medication1.setImage("poiuytrewqasdf");
        medicationRepository.save(medication1);

         Medication medication2 = new  Medication();
        medication2.setName("chloroquine");
        medication2.setWeight(234);
        medication2.setCode("SKY303___1336");
        medication2.setImage("poiuytrewqasdfyuiu");
        medicationRepository.save(medication2);

         Medication medication3 = new  Medication();
        medication3.setName("pennicillin-notatum");
        medication3.setWeight(120);
        medication3.setCode("SKY303___1337");
        medication3.setImage("poiuytrewqasdfyyu");
        medicationRepository.save(medication3);
    }
}
//}
