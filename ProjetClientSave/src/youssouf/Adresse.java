package youssouf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADRESSE")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "ligne", length = 100)
	private String ligne;
	@Column(name = "Ville", length = 100)
	private String ville;
	@Column(name = "CodePostale", length = 100)
	private int codePostale;
	@Column(name = "ComplementAdresse", length = 100)
	private String complementAdresse;

	public Adresse(String ligne, int codePostale, String ville) {
		this.ligne = ligne;
		this.codePostale = codePostale;
		this.ville = ville;

	}

	public Adresse(String ligne, int codePostale, String ville, String complementAdresse) {
		this.ligne = ligne;
		this.codePostale = codePostale;
		this.ville = ville;
		this.complementAdresse = complementAdresse;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", ville=" + ville + ", ligne=" + ligne + ", codePostale=" + codePostale
				+ ", complementAdresse=" + complementAdresse + "]";
	}

}
