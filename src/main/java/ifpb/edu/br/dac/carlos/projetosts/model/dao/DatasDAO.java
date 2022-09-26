package ifpb.edu.br.dac.carlos.projetosts.model.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Agenda;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Datas;

@Repository
public interface DatasDAO extends PagingAndSortingRepository<Datas, Integer> {
	List<Datas> findByYear(int year);
	List<Agenda> findByDataLessThan(String data, Pageable page);
}
