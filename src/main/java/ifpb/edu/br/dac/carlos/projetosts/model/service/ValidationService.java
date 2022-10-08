package ifpb.edu.br.dac.carlos.projetosts.model.service;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.Dates;

@Service
public class ValidationService {
	
	public boolean validateDate(Dates date) throws Exception {
		LocalDate actualDate = LocalDate.now();
		LocalDate dataValidacao = null;
		
		try {
			dataValidacao = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
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
