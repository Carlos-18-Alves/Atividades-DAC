package ifpb.edu.br.dac.carlos.projetosts.model.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;

@Repository
public interface DatesDAO extends PagingAndSortingRepository<Dates, Integer> {
	
	List<Dates> findByYear(int year);
	List<Calendar> findByYearLessThan(String date, Pageable page);
	
}
