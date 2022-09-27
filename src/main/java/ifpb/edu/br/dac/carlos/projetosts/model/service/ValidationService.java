package ifpb.edu.br.dac.carlos.projetosts.model.service;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Datas;

@Service
public class ValidationService {

	/**
	 * @param data
	 * @return
	 * Método que vai retornar true se a data for após a atual, já que os eventos devem ser futuros.
	 * @throws Exception 
	 * @throws 
	 */
	public boolean validateDate(Datas data) throws Exception {
		LocalDate actualDate = LocalDate.now();
		LocalDate dataValidacao = null;
		
		try {
			dataValidacao = LocalDate.of(data.getAno(), data.getMes(), data.getDia());
		} catch (DateTimeException dte) {
			throw new Exception("Data inválida!");
		}
	    
	    if(dataValidacao.isAfter(actualDate))
			return true;
	    
		return false;
	}
	
	public boolean validateNomeEvento(String nomeEvento) {
		if((nomeEvento != null) && (!nomeEvento.isBlank())) {
			return true;
		}
	
		return false;
	}
	
}
