package ifpb.edu.br.dac.carlos.projetosts.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifpb.edu.br.dac.carlos.projetosts.dao.AgendaDAO;
import ifpb.edu.br.dac.carlos.projetosts.entities.Agenda;

@Controller
public class AgendaController {

	@Autowired
	private AgendaDAO agendaDAO;
	
	Scanner ler = new Scanner(System.in);
	
	public void create() {
		Agenda agenda = new Agenda();
		System.out.print("Nome do evento: ");
		agenda.setEvento(ler.nextLine());
		System.out.println("Data do evento: ");
		agenda.setData(ler.nextLine());
		agendaDAO.save(agenda);
		System.out.println("Evento salvo com sucesso!");
		
//		for (int i = 1; i < 8; i++) {
//			Agenda agenda = new Agenda();
//			agenda.setEvento("Evento "+i);
//			agenda.setData(10+i+"/"+0+i+"/"+200+i);
//			
//			agendaDAO.save(agenda);
//		}
	}
	
	public void delete() {
		System.out.print("Insira o id do evento a ser deletado: ");
		Integer id = Integer.parseInt(ler.nextLine());
		agendaDAO.deleteById(id);
	}
	
	public void deleteAll() {
		agendaDAO.deleteAll();
	}

	public void update() {
		System.out.print("Insira um id: ");
		Integer id = Integer.parseInt(ler.nextLine());
		System.out.print("Insira o nome do evento para atualizar(em branco para não mudar): ");
		String evento = ler.nextLine();
		System.out.print("Insira a data a ser atualizada(em branco para não mudar): ");
		String data = ler.nextLine();
		List<Agenda> agendas = (List<Agenda>) agendaDAO.findAll();

		for (Agenda agenda : agendas) {
			if(agenda.getId()==id) {
				if(!evento.isBlank())
					agenda.setEvento(evento);
				
				if(!data.isBlank())
					agenda.setData(data);
				
				agendaDAO.save(agenda);
				break;
			}
		}
	}

	
	public List<Agenda> list() {
		return (List<Agenda>) agendaDAO.findAll();
	}
	
}
