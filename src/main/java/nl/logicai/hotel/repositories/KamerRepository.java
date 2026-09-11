package nl.logicai.hotel.repositories;

import nl.logicai.hotel.models.Kamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KamerRepository extends JpaRepository<Kamer, Integer> // this is using kamer.java
{
//List<kamer> findByVerdieping(int verdieping);

}
