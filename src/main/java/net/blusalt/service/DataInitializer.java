import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.blusalt.model.BatterytState;
import net.blusalt.model.DroneFleet;
import net.blusalt.model.DroneModel;
import net.blusalt.model.DroneState;
import net.blusalt.repository.DroneRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DroneRepository droneRepository;

    public DataInitializer(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public void run(String... args) {
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
    }
}
