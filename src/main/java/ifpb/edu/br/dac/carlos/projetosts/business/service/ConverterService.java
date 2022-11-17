package ifpb.edu.br.dac.carlos.projetosts.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.CalendarDTO;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.DatesDTO;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.UserDTO;

@Service
public class ConverterService {
	
	public List<Calendar> dtoToCalendar(List<CalendarDTO> dtos) {
		List<Calendar> entities = new ArrayList<>();
		
		for (CalendarDTO entity : dtos) {
			Calendar dto = dtoToCalendar(entity);
			entities.add(dto);
		}
		
		return entities;
	}
	
	public List<CalendarDTO> calendarToDTO(List<Calendar> entities) {
		List<CalendarDTO> dtos = new ArrayList<>();
		
		for (Calendar dto : entities) {
			CalendarDTO entity = calendarToDTO(dto);
			dtos.add(entity);
		}
		
		return dtos;
	}
	
	public Calendar dtoToCalendar(CalendarDTO dto) {
		Calendar entity = new Calendar();
		
		entity.setId(dto.getId());
		entity.setEventName(dto.getEventName());
		entity.setDate(dto.getDate());
		
		return entity;
	}	
	
	public CalendarDTO calendarToDTO(Calendar entity) {
		CalendarDTO dto = new CalendarDTO();
		
		dto.setId(entity.getId());
		dto.setEventName(entity.getEventName());
		dto.setDate(entity.getDate());
		dto.setUser(entity.getUser());
		
		return dto;
	}
	
/////////////
	
	public List<Dates> dtoToDates(List<DatesDTO> dtos) {
		List<Dates> entities = new ArrayList<>();
		
		for (DatesDTO entity : dtos) {
			Dates dto = dtoToDates(entity);
			entities.add(dto);
		}
		
		return entities;
	}
	
	public List<DatesDTO> datesToDTO(List<Dates> entities) {
		List<DatesDTO> dtos = new ArrayList<>();
		
		for (Dates dto : entities) {
			DatesDTO entity = datesToDTO(dto);
			dtos.add(entity);
		}
		
		return dtos;
	}
	
	public Dates dtoToDates(DatesDTO dto) {
		Dates entity = new Dates();
		
		entity.setId(dto.getId());
		entity.setDay(dto.getDay());
		entity.setMonth(dto.getMonth());
		entity.setYear(dto.getYear());
		
		return entity;
	}	
	
	public DatesDTO datesToDTO(Dates entity) {
		DatesDTO dto = new DatesDTO();
		
		dto.setId(entity.getId());
		dto.setDay(entity.getDay());
		dto.setMonth(entity.getMonth());
		dto.setYear(entity.getYear());
		
		return dto;
	}
	
/////////////

	public List<UserDTO> userToDTO(List<SystemUser> entities) {
	    List<UserDTO> dtos = new ArrayList<>();
        
        for (SystemUser dto : entities) {
            UserDTO entity = userToDTO(dto);
            dtos.add(entity);
        }
        
        return dtos;
	}
	
	public List<SystemUser> dtoToUser(List<UserDTO> dtos) {
	    List<SystemUser> entities = new ArrayList<>();
        
        for (UserDTO entity : dtos) {
            SystemUser dto = dtoToUser(entity);
            entities.add(dto);
        }
        
        return entities;
    }
	
    public SystemUser dtoToUser(UserDTO dto) {
        SystemUser entity = new SystemUser();
        
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        
        return entity;
    }


    public UserDTO userToDTO(SystemUser entity) {
        UserDTO dto = new UserDTO();
        
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        
        return dto;
    }
}

