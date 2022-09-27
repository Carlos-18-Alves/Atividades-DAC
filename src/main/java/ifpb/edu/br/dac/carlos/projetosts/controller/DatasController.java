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

	private Datas data = new Datas();

	@Autowired
	private DatasService datasService;
	@Autowired
	private ValidationService validationService;
	
	public void setData(Datas data) {
		this.data.setId(data.getId());
		this.data.setDia(data.getDia());
		this.data.setMes(data.getMes());
		this.data.setAno(data.getAno());
	}
	
	public Datas getData() {
		return this.data;
	}

	public void save() throws Exception {

		if(validationService.validateDate(data)) {
			datasService.save(data);
		}
		
		else
			System.out.println("A data inserida não foi salva");
	}
	
	public List<Datas> getAll() {
		return (List<Datas>) datasService.list();
	}
	
	public void update() throws Exception {
		
		if(validationService.validateDate(data)) {
			datasService.save(data);
		}
		else
			System.out.println("A data não pôde ser atualizada");
	}
	
	public void delete() {
		datasService.delete(data.getId());
	}
	
	
}
