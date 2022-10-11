package ifpb.edu.br.dac.carlos.projetosts.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
	
} 
