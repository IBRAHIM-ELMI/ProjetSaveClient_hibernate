package youssouf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Facture")
public class Facture {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private	int id;
	@Column(name="TotalePayer")
	private double totale;
	
	@ManyToOne @JoinColumn(name="CLIENTID")
	private Client client;
	
	public Facture(Client client, double totale) {
		this.client = client;
		client.addFacture(this);
		this.totale = totale;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", totale=" + totale + ", client=" + client + "]";
	}
	

	
	
	
	
	
		
}

