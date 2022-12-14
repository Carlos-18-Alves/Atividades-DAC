package ifpb.edu.br.dac.carlos.projetosts.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.dac.carlos.projetosts.business.service.CalendarService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.ConverterService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.DatesService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.ValidationService;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.CalendarDTO;

@RestController
@RequestMapping("api/calendar")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private DatesService datesService;
	@Autowired
	private ValidationService validationService;
	@Autowired
	private ConverterService converterService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody CalendarDTO dto) {
		
		try {
			Calendar entity = converterService.dtoToCalendar(dto);
			
			if(validationService.validateNomeEvento(entity.getEventName())&&validationService.validateDate(entity.getDate())) {
			    datesService.save(entity.getDate());
			    entity = calendarService.save(entity);
			    dto = converterService.calendarToDTO(entity);
		    }
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody CalendarDTO dto) {
		try {
			dto.setId(id);
			Calendar entity = converterService.dtoToCalendar(dto);
			if(validationService.validateNomeEvento(entity.getEventName())&&validationService.validateDate(entity.getDate()))
				datesService.update(entity.getDate());
			entity = calendarService.update(entity);
			dto = converterService.calendarToDTO(entity);
			
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		try {
			calendarService.delete(id);
			datesService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping
	public ResponseEntity find(
				@RequestParam(value = "eventName", required = false) String eventName,
				@RequestParam(value = "id", required = false) Integer id,
				@RequestParam(value = "date", required = false) Dates date
			) {
		try {
			Calendar filter = new Calendar();
			filter.setId(id);
			filter.setEventName(eventName);
			filter.setDate(date);
			
			List<Calendar> entities = calendarService.find(filter);
			List<CalendarDTO> dtos = converterService.calendarToDTO(entities);
			
			return ResponseEntity.ok(dtos);
		} catch (Exception  e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
