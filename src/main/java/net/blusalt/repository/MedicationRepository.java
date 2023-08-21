package net.blusalt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.blusalt.model.Medication;

public interface MedicationRepository extends JpaRepository<Medication,Long>{

}
