package nl.logicai.hotel.repositories;

import nl.logicai.hotel.models.Resevering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReseveringRepository extends JpaRepository<Resevering, Integer> { //this is using resevering
}
