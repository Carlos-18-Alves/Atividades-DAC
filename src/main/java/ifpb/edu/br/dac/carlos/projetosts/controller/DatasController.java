package ifpb.edu.br.dac.carlos.projetosts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.DatasDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Datas;
import ifpb.edu.br.dac.carlos.projetosts.model.service.DatasService;
import ifpb.edu.br.dac.carlos.projetosts.model.service.ValidationService;

@Controller
public class DatasController {
	
	private Integer id;
	private int dia,mes,ano;

	@Autowired
	private DatasService datasService;
	@Autowired
	private ValidationService validationService;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void save() {
		Datas data = null;
		try {
			data = new Datas(dia, mes, ano);
		} catch (Exception e) {
			System.out.println("Data inválida");
		}
		
		if(validationService.validateDate(data)) {
			datasService.save(data);
		}
		else
			System.out.println("A data inserida não foi salva");
	}
	
	public List<Datas> getAll() {
		return (List<Datas>) datasService.list();
	}
	
	public void update() {
		Datas data = null;
		try {
			data = new Datas(dia, mes, ano);
		} catch (Exception e) {
			System.out.println("Data inválida");
		}
		
		if(validationService.validateDate(data)) {
			datasService.save(data);
		}
		else
			System.out.println("A data não pôde ser atualizada");
	}
	
	public void delete() {
		datasService.delete(id);
	}
	
	
}
