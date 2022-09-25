package ifpb.edu.br.dac.carlos.projetosts.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.AgendaDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Agenda;

@Controller
public class AgendaController {

	@Autowired
	private AgendaDAO agendaDAO;
	
	Scanner ler = new Scanner(System.in);
	
	public void create(Agenda agenda) {
		agendaDAO.save(agenda);
	}
	
	public void delete(Integer id) {
		agendaDAO.deleteById(id);
	}
	
	public void deleteAll() {
		agendaDAO.deleteAll();
	}

	public void update(Agenda agenda) {
		agendaDAO.save(agenda);
	}
	
	public List<Agenda> list() {
		return (List<Agenda>) agendaDAO.findAll();
	}
	
}
