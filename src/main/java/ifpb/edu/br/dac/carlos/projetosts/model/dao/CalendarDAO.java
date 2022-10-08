package ifpb.edu.br.dac.carlos.projetosts.model.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;

@Repository
public interface CalendarDAO extends PagingAndSortingRepository<Calendar, Integer> {
	
	List<Calendar> findByEventName(String eventName);
	List<Calendar> findByDateLessThan(String date, Pageable page);

} 
