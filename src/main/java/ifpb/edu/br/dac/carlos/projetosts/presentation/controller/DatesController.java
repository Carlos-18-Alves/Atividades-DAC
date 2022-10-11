package ifpb.edu.br.dac.carlos.projetosts.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.dac.carlos.projetosts.business.service.ConverterService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.DatesService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.ValidationService;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;
import ifpb.edu.br.dac.carlos.projetosts.model.repository.DatesRepository;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.CalendarDTO;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.DatesDTO;

@RestController
@RequestMapping("api/dates")
public class DatesController {

	@Autowired
	private DatesService service;
	@Autowired
	private ValidationService validationService;
	@Autowired
	private ConverterService converterService;

	@PostMapping
	public ResponseEntity save(@RequestBody DatesDTO dto) {

		try {
			Dates entity = converterService.dtoToDates(dto);
			entity = service.save(entity);
			dto = converterService.datesToDTO(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody DatesDTO dto) /*throws Exception*/{
		try {
			dto.setId(id);
			Dates entity = converterService.dtoToDates(dto);
			entity = service.update(entity);
			dto = converterService.datesToDTO(entity);
			
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		try {
			service.delete(id);
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity find(
				@RequestParam(value = "day", required = false) int day,
				@RequestParam(value = "month", required = false) int month,
				@RequestParam(value = "year", required = false) int year,
				@RequestParam(value = "id", required = false) Integer id
			) {
		try {
			Dates filter = new Dates();
			filter.setId(id);
			filter.setDay(day);
			filter.setMonth(month);
			filter.setYear(year);
			
			List<Dates> entities = service.find(filter);
			List<DatesDTO> dtos = converterService.datesToDTO(entities);
			
			return ResponseEntity.ok(dtos);
		} catch (Exception  e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
}
