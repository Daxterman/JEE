package jcbcPack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class genre {
	
	@Id
	private String nom_genre;
	
	public genre()
	{
		
	}
	
	public String getnom_genre()
	{
		return nom_genre;
	}
	
	public void setnom_genre(String nom)
	{
		this.nom_genre =nom;
	}
	
	@Override
	public String toString() {
	    return "Genre{" +
	           "nomGenre='" + nom_genre + '\'' +
	           '}';
	}
	
}
