package ifpb.edu.br.dac.carlos.projetosts.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.AgendaDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Agenda;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaDAO agendaDAO;
	
	public void save(Agenda agenda) {
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
