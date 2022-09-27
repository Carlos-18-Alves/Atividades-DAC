package ifpb.edu.br.dac.carlos.projetosts;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifpb.edu.br.dac.carlos.projetosts.controller.AgendaController;
import ifpb.edu.br.dac.carlos.projetosts.controller.DatasController;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Agenda;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Datas;

@SpringBootApplication
public class ProjetostsApplication implements CommandLineRunner {
	
	@Autowired
	private AgendaController agendaController;
	@Autowired
	private DatasController datasController;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetostsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner ler = new Scanner(System.in);
		
		Integer id;
		int dia;
		int mes;
		int ano;
		Datas data;
		
		System.out.println("O que deseja fazer?");
		
		boolean cond = true;
		
		while(cond) {
			System.out.println("1 - Criar evento \n2 - Listar eventos \n3 - Atualizar evento "
					+ "\n4 - Deletar evento \n5 - Deletar tudo \n6 - Sair" );
			String opc = ler.nextLine();
		
			switch (opc) {
			case "1":
				System.out.print("Nome do evento: ");
				agendaController.setNomeEvento(ler.nextLine());
				
				System.out.println("Data do evento ");
				System.out.print("Dia: ");
				dia = Integer.parseInt(ler.nextLine());
				System.out.print("Mês: ");
				mes = Integer.parseInt(ler.nextLine());
				System.out.print("Ano: ");
				ano = Integer.parseInt(ler.nextLine());
				data = new Datas(dia, mes, ano);
				
				datasController.setData(data);
				
				try {
					datasController.save();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
				
				agendaController.setData(datasController.getData());
				
				try {
					agendaController.save();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				break;
				
			case "2":
				List<Agenda> agendas = agendaController.getAll();
				
				for (Agenda agenda : agendas) {
					System.out.println(agenda);
				}
				break;
				
			case "3":
				System.out.print("Insira o id da agenda: ");
				id = Integer.parseInt(ler.nextLine());
				
				System.out.println("Insira a nova data");
				System.out.print("Dia: ");
				dia = Integer.parseInt(ler.nextLine());
				System.out.print("Mês: ");
				mes = Integer.parseInt(ler.nextLine());
				System.out.print("Ano: ");
				ano = Integer.parseInt(ler.nextLine());
				data = new Datas(dia, mes, ano);
				data.setId(id);
				
				datasController.setData(data);
				
				try {
					datasController.update();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				System.out.print("Insira o novo nome do evento: ");
				agendaController.setNomeEvento(ler.nextLine());
				agendaController.setData(datasController.getData());
				agendaController.setId(id);
				
				try {
					agendaController.update();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case "4":
				System.out.print("Insira o id do evento a ser deletado: ");
				id = Integer.parseInt(ler.nextLine());
				agendaController.setId(id);
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
