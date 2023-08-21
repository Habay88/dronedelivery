package net.blusalt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.blusalt.model.DroneFleet;
@Repository
public interface DroneRepository extends JpaRepository<DroneFleet, Long> {

}
