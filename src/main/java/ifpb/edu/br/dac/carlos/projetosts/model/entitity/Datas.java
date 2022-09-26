package ifpb.edu.br.dac.carlos.projetosts.model.entitity;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Carlos Alves
 * Classe que vai ajudar na utilização de datas, já que precisamos trabalhar com datas válidas.
 */
@Entity
public class Datas {
	@Id
	@Column(name = "DATAS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int dia,mes,ano;
	public Datas(int dia, int mes, int ano) throws Exception {
		try {
			LocalDate d1 = LocalDate.of(ano, mes, dia);
		} catch(DateTimeException dte) {
			throw new Exception("Data inválida!");
		} 
		this.mes = mes;
		this.dia = dia;
		this.ano = ano;
	}
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		String mesNome = null;
		
		switch (mes) {
		case 1:
			mesNome = "jan";
			break;
			
		case 2:
			mesNome = "fev";
			break;
			
		case 3:
			mesNome = "mar";
			break;
			
		case 4:
			mesNome = "abr";
			break;
			
		case 5:
			mesNome = "mai";
			break;
			
		case 6:
			mesNome = "jun";
			break;
			
		case 7:
			mesNome = "jul";
			break;
			
		case 8:
			mesNome = "ago";
			break;
			
		case 9:
			mesNome = "set";
			break;
			
		case 10:
			mesNome = "out";
			break;
			
		case 11:
			mesNome = "nov";
			break;

		case 12:
			mesNome = "dez";
			break;
			
		default:
			break;
		}
		
		return dia + "-"+ mesNome + "-" + ano;
	}
	
}
