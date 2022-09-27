package ifpb.edu.br.dac.carlos.projetosts.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.AgendaDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Agenda;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Datas;
import ifpb.edu.br.dac.carlos.projetosts.model.service.AgendaService;
import ifpb.edu.br.dac.carlos.projetosts.model.service.ValidationService;

@Controller
public class AgendaController {
	
	private Integer id;
	private String nomeEvento;
	private Datas data;
	
	@Autowired
	private AgendaService agendaService;
	@Autowired
	private ValidationService validationService;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Datas getData() {
		return data;
	}

	public void setData(Datas data) {
		this.data = data;
	}
	
	public void save() {
		try {
			if(validationService.validateNomeEvento(nomeEvento) && validationService.validateDate(data)) {
				Agenda agenda = new Agenda();
				agenda.setEvento(nomeEvento);
				agenda.setData(data);
				
				agendaService.save(agenda);
				System.out.println("Agenda criada! ID = "+id);
			} 
			else
				System.out.println("Agenda não foi criada, o nome ou data é inválido");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update() throws Exception {
		if(validationService.validateNomeEvento(nomeEvento) && validationService.validateDate(data)) {
			Agenda agenda = new Agenda();
			agenda.setEvento(nomeEvento);
			agenda.setData(data);
			
			agendaService.save(agenda);
			System.out.println("A agenda foi atualizada! ID = "+id);
		} 
		else
			System.out.println("Agenda não foi atualizada, o nome ou data é inválido");
	}
	
	public void delete() {
		agendaService.delete(id);
		System.out.println("A agenda foi deletada! ID = "+id);
	}
	
	public List<Agenda> getAll() {
		return agendaService.list();
		
	}

	public void deleteAll() {
		agendaService.deleteAll();
		System.out.println("Todos os eventos foram deletados!");
	}
	
}
