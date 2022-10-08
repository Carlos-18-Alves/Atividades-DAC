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
public class Calendar implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String eventName;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DATE_ID")
	private Dates date;
	
	private String dateStr;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Dates getDate() {
		return date;
	}

	public void setDate(Dates date) {
		this.date = date;
		setDateStr(date.toString());
	}

	public String getDateStr() {
		return dateStr;
	}

	private void setDateStr(String dateStr) {
		this.dateStr = dateStr;
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
		Calendar other = (Calendar) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", eventName=" + eventName + ", date=" + date + "]";
	}
}
