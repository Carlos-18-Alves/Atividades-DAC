package ifpb.edu.br.dac.carlos.projetosts.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.DatesDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;

@Service
public class DatesService {
	
	@Autowired
	private DatesDAO datesDAO;
	
	public void save(Dates date) {
		datesDAO.save(date);
	}
	
	public void delete(Integer id) {
		datesDAO.deleteById(id);
	}
	
	public void deleteAll() {
		datesDAO.deleteAll();
	}

	public void update(Dates date) {
		datesDAO.save(date);
	}
	
	public List<Dates> list() {
		return (List<Dates>) datesDAO.findAll();
	}
	
	public Dates getById(Integer id) {
		List<Dates> datesList = list();
		
		for (Dates date: datesList) {
			if(date.getId()==id)
				return date;
		}
		
		return null;
	}
}
