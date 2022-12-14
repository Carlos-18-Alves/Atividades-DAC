package ifpb.edu.br.dac.carlos.projetosts.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.repository.CalendarRepository;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarRepository repository;
	@Autowired
	private AuthenticationService authenticationService;
	
	public Calendar save(Calendar calendar) {
	    if(calendar.getId() != null) {
	        throw new IllegalStateException("Calendar is already in the database. Maybe you can try to update it.");
	    }
	    calendar.setUser(authenticationService.getLoggedUser().getId());
	    
		return repository.save(calendar);
	}
	
	public void delete(Integer id) {
	    if(id == null) {
            throw new IllegalStateException("Id cannot be null.");
        }
        
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}

	public Calendar update(Calendar calendar) {
	    if(calendar.getId() == null) {
            throw new IllegalStateException("Id cannot be null.");
        }

		return repository.save(calendar);
	}
	
	public Calendar findById(Integer id) {
		if(id == null)
			throw new IllegalStateException("Id cannot be null");
		
		return repository.findById(id).get();
	}
	
	public Iterable<Calendar> findAll() {
		return repository.findAll();
	}
	
	public List<Calendar> find(Calendar filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	}
}
