package ifpb.edu.br.dac.carlos.projetosts.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.dao.DatasDAO;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Datas;

@Service
public class DatasService {
	
	@Autowired
	private DatasDAO datasDAO;
	
	public void save(Datas datas) {
		datasDAO.save(datas);
	}
	
	public void delete(Integer id) {
		datasDAO.deleteById(id);
	}
	
	public void deleteAll() {
		datasDAO.deleteAll();
	}

	public void update(Datas datas) {
		datasDAO.save(datas);
	}
	
	public List<Datas> list() {
		return (List<Datas>) datasDAO.findAll();
	}
}
