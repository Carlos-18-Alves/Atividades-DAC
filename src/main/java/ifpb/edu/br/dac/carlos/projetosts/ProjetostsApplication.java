package ifpb.edu.br.dac.carlos.projetosts;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifpb.edu.br.dac.carlos.projetosts.controller.AgendaController;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Agenda;

@SpringBootApplication
public class ProjetostsApplication implements CommandLineRunner {
	
	@Autowired
	private AgendaController agendaController;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetostsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("O que deseja fazer?");
		
		boolean cond = true;
		
		while(cond) {
			System.out.println("1 - Criar evento \n2 - Listar eventos \n3 - Atualizar evento "
					+ "\n4 - Deletar evento \n5 - Deletar tudo \n6 - Sair" );
			String opc = ler.nextLine();
			
			Agenda agenda = new Agenda();
			
			switch (opc) {
			case "1":
				System.out.print("Nome do evento: ");
				agenda.setEvento(ler.nextLine());
				System.out.println("Data do evento: ");
				agenda.setData(ler.nextLine());
				agendaController.create(agenda);
				break;
				
			case "2":
				List<Agenda> agendas = agendaController.list();
				
				for (Agenda agendaa : agendas) {
					System.out.println(agendaa);
				}
				break;
				
			case "3":
				System.out.print("Insira um id: ");
				Integer id = Integer.parseInt(ler.nextLine());
				System.out.print("Insira o nome do evento para atualizar(em branco para não mudar): ");
				String evento = ler.nextLine();
				System.out.print("Insira a data a ser atualizada(em branco para não mudar): ");
				String data = ler.nextLine();
				List<Agenda> agendas2 = agendaController.list();

				for (Agenda agendaa : agendas2) {
					if(agendaa.getId()==id) {
						if(!evento.isBlank())
							agendaa.setEvento(evento);
						
						if(!data.isBlank())
							agendaa.setData(data);
						
						agendaController.update(agendaa);
						break;
					}
				}
				
				break;
				
			case "4":
				System.out.print("Insira o id do evento a ser deletado: ");
				Integer id1 = Integer.parseInt(ler.nextLine());
				agendaController.delete(id1);
				break;
				
			case "5":	
				agendaController.deleteAll();
				break;
				
			case "6":
				cond = false;
				break;
			}
		}

	}

}
