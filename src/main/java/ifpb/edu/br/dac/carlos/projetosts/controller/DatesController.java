package ifpb.edu.br.dac.carlos.projetosts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.DatesDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;
import ifpb.edu.br.dac.carlos.projetosts.model.service.DatesService;
import ifpb.edu.br.dac.carlos.projetosts.model.service.ValidationService;

@Controller
public class DatesController {

	private Dates date;

	@Autowired
	private DatesService datesService;
	@Autowired
	private ValidationService validationService;
	
	public void setDate(Dates date) {
		this.date = date;
	}
	
	public Dates getDate() {
		return this.date;
	}

	public void save() throws Exception {

		if(validationService.validateDate(date)) {
			datesService.save(date);
		}
		
		else
			throw new Exception("Date was not saved");
	}
	
	public List<Dates> getAll() {
		return (List<Dates>) datesService.list();
	}
	
	public Dates getById(Integer id) {
		return datesService.getById(id);
	}
	
	public void update() throws Exception {
		
		if(validationService.validateDate(date)) {
			datesService.update(date);
		}
		else
			throw new Exception("This data could not be updated");
	}
	
	public void delete() {
		datesService.delete(date.getId());
	}

	
	
}
