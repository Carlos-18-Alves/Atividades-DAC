package ifpb.edu.br.dac.carlos.projetosts.model.service;

import java.time.LocalDate;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Datas;

public class ValidationService {

	/**
	 * @param data
	 * @return
	 * Método que vai retornar true se a data for após a atual, já que os eventos devem ser futuros.
	 * @throws Exception 
	 */
	public boolean validateDate(Datas data) {
		LocalDate actualDate = LocalDate.now();
		LocalDate dataValidacao = LocalDate.of(data.getAno(), data.getMes(), data.getAno());
	    
	    if(dataValidacao.isAfter(actualDate))
			return true;
	    
		return false;
	}
	
	public boolean validateNomeEvento(String nomeEvento) {
		if(nomeEvento != null && !nomeEvento.isBlank()) {
			return true;
		}
	
		return false;
	}
	
}
