package ifpb.edu.br.dac.carlos.projetosts.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.CalendarDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;
import ifpb.edu.br.dac.carlos.projetosts.model.service.CalendarService;
import ifpb.edu.br.dac.carlos.projetosts.model.service.ValidationService;

@Controller
public class CalendarController {
	
	private Integer id;
	private String eventName;
	private Dates date;
	
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private ValidationService validationService;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Dates getDate() {
		return date;
	}

	public void setDate(Dates date) {
		this.date = date;
	}
	
	public void setCalendar(Calendar calendar) {
		id = calendar.getId();
		eventName = calendar.getEventName();
		date = calendar.getDate();
	}
	
	public void save() throws Exception {
		
		if(validationService.validateNomeEvento(eventName)) {
			Calendar calendar = new Calendar();
			calendar.setEventName(eventName);
			calendar.setDate(date);
			
			calendarService.save(calendar);
		} 
		
	}
	
	public void update() throws Exception {
		if(validationService.validateNomeEvento(eventName)) {
			Calendar calendar = new Calendar();
			calendar.setEventName(eventName);
			calendar.setDate(date);
			calendar.setId(id);
			
			calendarService.update(calendar);
		} else 
			throw new Exception("The calendar could not be updated");

	}
	
	public void delete() {
		calendarService.delete(id);
	}
	
	public List<Calendar> getAll() throws Exception {
		return calendarService.list();	
	}
	
	public Calendar getById(Integer id) {
		return calendarService.getById(id);
	}

	public void deleteAll() throws Exception {
		calendarService.deleteAll();
	}
	
}
