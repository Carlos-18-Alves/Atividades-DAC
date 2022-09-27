package ifpb.edu.br.dac.carlos.projetosts.model.entitity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Agenda implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeEvento;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DATA_ID")
	private Datas data;
	private String dataStr;
	
	public String getEvento() {
		return nomeEvento;
	}

	public void setEvento(String evento) {
		this.nomeEvento = evento;
	}
	
	public Datas getData() {
		return data;
	}

	public void setData(Datas data) {
		this.data = data;
		this.dataStr = data.toString();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public String getDataStr() {
		return dataStr;
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
		Agenda other = (Agenda) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", evento=" + nomeEvento + ", data=" + data.toString() + "]";
	}
	
}
