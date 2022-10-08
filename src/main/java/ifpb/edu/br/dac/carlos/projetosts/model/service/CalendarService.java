package ifpb.edu.br.dac.carlos.projetosts.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.CalendarDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarDAO calendarDAO;
	
	public void save(Calendar calendar) {
		calendarDAO.save(calendar);
	}
	
	public void delete(Integer id) {
		calendarDAO.deleteById(id);
	}
	
	public void deleteAll() {
		calendarDAO.deleteAll();
	}

	public void update(Calendar calendar) {
		calendarDAO.save(calendar);
	}
	
	public List<Calendar> list() {
		return (List<Calendar>) calendarDAO.findAll();
	}
	
	public Calendar getById(Integer id) {
		List<Calendar> calendarList = list();
		
		for (Calendar calendar: calendarList) {
			if(calendar.getId()==id)
				return calendar;
		}
		
		return null;
	}
	
}
