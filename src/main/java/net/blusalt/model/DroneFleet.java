package net.blusalt.model;

import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DroneFleet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Size(max=100)
	private UUID serialNumber;
	
	private DroneModel model;
	@Max(500)
	private int weightLimit;
	@Min(0)
	@Max(100)
	private int batteryCapacityPercentage;
	
	private BatterytState batteryState;
	
	private DroneState droneState;
	
	
}
