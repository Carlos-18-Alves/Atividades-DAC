package ifpb.edu.br.dac.carlos.projetosts.model.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Agenda;

@Repository
public interface AgendaDAO extends PagingAndSortingRepository<Agenda, Integer> {
	
	List<Agenda> findByNomeEvento(String name);
	List<Agenda> findByDataLessThan(String data, Pageable page);

} 
