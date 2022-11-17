package ifpb.edu.br.dac.carlos.projetosts.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;
import ifpb.edu.br.dac.carlos.projetosts.model.repository.DatesRepository;

@Service
public class DatesService {
	
	@Autowired
	private DatesRepository repository;
	
	public Dates save(Dates date) {
		return repository.save(date);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}

	public Dates update(Dates date) {
		return repository.save(date);
	}
	
	public Dates findById(Integer id) {
		if(id == null)
			throw new IllegalStateException("Id cannot be null");
		
		return repository.findById(id).get();
	}
	
	public Iterable<Dates> findAll() {
		return repository.findAll();
	}
	
	public List<Dates> find(Dates filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching()
				    .withIgnoreNullValues()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	}
}
