package nl.logicai.hotel.repositories;

import nl.logicai.hotel.models.Gast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastRepository extends JpaRepository<Gast, Long> { //this is using gast
}
