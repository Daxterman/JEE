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
	private String nom_genre;
	private String nom_real;
	
    @ManyToOne
    @JoinColumn(name = "nom_genre" , insertable = false, updatable = false)
    private genre genre;

    @ManyToOne
    @JoinColumn(name = "nom_real" , insertable = false, updatable = false)
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



	public String getNom_genre() {
		return nom_genre;
	}



	public void setNom_genre(String nom_genre) {
		this.nom_genre = nom_genre;
	}



	public String getNom_real() {
		return nom_real;
	}



	public void setNom_real(String nom_real) {
		this.nom_real = nom_real;
	}
	
	@Override
	public String toString() {
	    return "Film{" +
	           "id=" + id_film +
	           ", titre='" + titre + '\'' +
	           ", anneeSortie=" + annee_sortie +
	           ", genre=" + genre.getnom_genre() +
	           ", real=" + real.getnom_real() +
	           '}';
	}
	
	

}
