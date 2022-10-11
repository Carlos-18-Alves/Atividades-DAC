package ifpb.edu.br.dac.carlos.projetosts.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Integer> {
	
}
