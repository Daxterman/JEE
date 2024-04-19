	package jcbcPack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class film {
	
	@Id
	private int id_film;
	private String titre;
	private int annee_sortie;
	private int id_genre;
	private int id_real;
	
    @ManyToOne
    @JoinColumn(name = "id_genre" , insertable = false, updatable = false)
    private genre genre;

    @ManyToOne
    @JoinColumn(name = "id_real" , insertable = false, updatable = false)
    private realisateur real;
	
	
	
	public film()
	{
		
	}
	
	public int getId()
	{
		return this.id_film;
	}
	
	public void setId(int id)
	{
		this.id_film = id;
	}


	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public int getAnnee_sortie() {
		return annee_sortie;
	}



	public void setAnnee_sortie(int annee_sortie) {
		this.annee_sortie = annee_sortie;
	}



	public int getId_genre() {
		return id_genre;
	}



	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}



	public int getId_real() {
		return id_real;
	}



	public void setId_real(int id_real) {
		this.id_real = id_real;
	}
	
	@Override
	public String toString() {
	    return "Titre='" + titre + '\'' +
	           ", anneeSortie=" + annee_sortie +
	           ", genre=" + genre.getnom_genre() +
	           ", real=" + real.getnom_real();
	           
	}
	
	

}
