package ifpb.edu.br.dac.carlos.projetosts;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifpb.edu.br.dac.carlos.projetosts.controller.AgendaController;
import ifpb.edu.br.dac.carlos.projetosts.entities.Agenda;

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
			
			switch (opc) {
			case "1":
				agendaController.create();
				break;
				
			case "2":
				List<Agenda> agendas = agendaController.list();
				
				for (Agenda agenda : agendas) {
					System.out.println(agenda);
				}
				break;
				
			case "3":
				agendaController.update();
				break;
				
			case "4":
				agendaController.delete();
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
