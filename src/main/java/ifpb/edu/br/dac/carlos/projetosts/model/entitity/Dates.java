package ifpb.edu.br.dac.carlos.projetosts.model.entitity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dates {
	@Id
	@Column(name  = "DATE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int day,month,year;
	
	public Dates(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Dates() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dates other = (Dates) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		String mesNome = null;
		
		switch (month) {
		case 1:
			mesNome = "jan";
			break;
			
		case 2:
			mesNome = "feb";
			break;
			
		case 3:
			mesNome = "mar";
			break;
			
		case 4:
			mesNome = "apr";
			break;
			
		case 5:
			mesNome = "may";
			break;
			
		case 6:
			mesNome = "jun";
			break;
			
		case 7:
			mesNome = "jul";
			break;
			
		case 8:
			mesNome = "aug";
			break;
			
		case 9:
			mesNome = "sep";
			break;
			
		case 10:
			mesNome = "oct";
			break;
			
		case 11:
			mesNome = "nov";
			break;

		case 12:
			mesNome = "dec";
			break;
			
		default:
			break;
		}
		
		return day + "-"+ mesNome + "-" + year;
	}
	
}
