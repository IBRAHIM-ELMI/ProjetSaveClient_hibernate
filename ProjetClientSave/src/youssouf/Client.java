package youssouf;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;

	@Column(name = "Nom", length = 100)
	private String nom;

	@Column(name = "Prenom", length = 100)
	private String prenom;

	public Client() {

	}
	
	@OneToMany(mappedBy="factureID")
private  HashSet<Facture> factures = new HashSet<Facture>();
	public Client(String nom, String prenom, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//faire le jointure entre les deux tables 
	@ManyToOne @JoinColumn(name="adressseId", unique=true)@NotNull
	private Adresse adresse;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}

	public void addFacture(Facture facture) {
		factures.add(facture);
		
	}
	Iterable<Facture> getFactures(){
		return factures;
	}

}
