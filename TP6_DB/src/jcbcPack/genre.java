package jcbcPack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class genre {
	
	@Id
	private int id_genre;
	private String nom_genre;
	
	public genre()
	{
		
	}
	
	public int getId_genre()
	{
		return id_genre;
	}
	
	public void setId_genre(int id)
	{
		this.id_genre =id;
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
	    return "nomGenre='" + nom_genre + '\'';
	}
	
}
