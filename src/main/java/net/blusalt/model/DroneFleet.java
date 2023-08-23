package net.blusalt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DroneFleet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long droneId;
	
	@Size(max = 100)
	private String serialNumber;
	
	private DroneModel model;
	@Max(500)
	private double weightLimit;
	@Min(0)
	@Max(100)
	private double batteryCapacityPercentage;
	
	private BatterytState batteryState;
	
	private DroneState droneState;
	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL)
	private List<Medication> loadedMedications = new ArrayList<>();
	
	@OneToMany(mappedBy="dronefleet")
 private List<BatteryStatusHistory> batteryStatusHistories = new ArrayList<>();


	// to check for excess weight
	public boolean canCarryExcessWeight(double extraWeight) {
		double currentWeight = loadedMedications.stream()
				.mapToDouble(Medication::getWeight)
				.sum();
		return (currentWeight + extraWeight) <= weightLimit;
	}
	public boolean canBeLoaded() {
		return droneState != DroneState.LOADING || batteryCapacityPercentage >= 25;
	}
}
