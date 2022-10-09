package ifpb.edu.br.dac.carlos.projetosts;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifpb.edu.br.dac.carlos.projetosts.controller.CalendarController;
import ifpb.edu.br.dac.carlos.projetosts.controller.DatesController;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Calendar;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;

@SpringBootApplication
public class ProjetostsApplication implements CommandLineRunner {
	
	@Autowired
	private CalendarController calendarController;
	@Autowired
	private DatesController datesController;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetostsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner read = new Scanner(System.in);
		
		System.out.println("What do you want to do?");
		
		boolean cond = true;
		
		while(cond) {
			Integer id;
			int day;
			int month;
			int year;
			Dates date = new Dates();
			Calendar calendar = new Calendar();
			System.out.println("1 - Create event \n2 - List events \n3 - Update event"
					+ "\n4 - Delete event \n5 - Delete all \n6 - Exit" );
			String opc = read.nextLine();
		
			switch (opc) {
			case "1":
				System.out.print("Event name: ");
				calendarController.setEventName(read.nextLine());
				
				System.out.println("Event date");
				System.out.print("Day: ");
				day = Integer.parseInt(read.nextLine());
				System.out.print("Month: ");
				month = Integer.parseInt(read.nextLine());
				System.out.print("Year: ");
				year = Integer.parseInt(read.nextLine());
				date = new Dates(day, month, year);
				
				datesController.setDate(date);
				
				try {
					datesController.save();
					calendarController.setDate(datesController.getDate());
					calendarController.save();
					System.out.println("The event was created!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
				break;
				
			case "2":
				List<Calendar> calendars = calendarController.getAll();
				
				for (Calendar calendar2 : calendars) {
					System.out.println(calendar2);
				}
				break;
				
			case "3":
				System.out.print("Insert the agenda's id: ");
				id = Integer.parseInt(read.nextLine());
				
				System.out.println("Insert the new date: ");
				System.out.print("Day: ");
				day = Integer.parseInt(read.nextLine());
				System.out.print("Month: ");
				month = Integer.parseInt(read.nextLine());
				System.out.print("Year: ");
				year = Integer.parseInt(read.nextLine());
				date.setId(id);
				date.setDay(day);
				date.setMonth(month);
				date.setYear(year);
				
				datesController.setDate(date);
				
				try {
					datesController.update();
					System.out.print("Insert the new event's name: ");
					calendar.setId(id);
					calendar.setEventName(read.nextLine());
					calendar.setDate(date);
					calendarController.setCalendar(calendar);
					calendarController.update();
					System.out.println("The event was updated!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case "4":
				System.out.print("Insert the event's id to be deleted: ");
				id = Integer.parseInt(read.nextLine());
				calendarController.setId(id);
				calendarController.delete();
				datesController.setDate(datesController.getById(id));
				datesController.delete();
				
				System.out.println("The event was deleted!");
				break;
				
			case "5":	
				calendarController.deleteAll();
				break;
				
			case "6":
				cond = false;
				break;
			}
		}

	}

}
