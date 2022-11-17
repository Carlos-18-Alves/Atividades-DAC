package ifpb.edu.br.dac.carlos.projetosts.presentation.dto;

import java.util.List;
import java.util.stream.Collectors;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;

public class CalendarDTO {
	
	private Integer id;
	private String eventName;
	private Dates date;
	private Integer userId;
	
	public CalendarDTO() {
		
	}
	
	public CalendarDTO(Calendar calendar) {
		id = calendar.getId();
		eventName = calendar.getEventName();
		date = calendar.getDate();
	}
	
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
	
	public Integer getUserId() {
        return userId;
    }

    public void setUser(Integer integer) {
        this.userId = integer;
    }

    public static List<CalendarDTO> toConvert(List<Calendar> calendars){
		return calendars.stream().map(CalendarDTO:: new).collect(Collectors.toList());
	}
	
}
