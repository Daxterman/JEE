package jpaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jcbcPack.film;

public class filmDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("FilmDB");
	EntityManager entityManager = emf.createEntityManager();
	
	//Création d'une transaction (lorsqu'on modifie la base)
	EntityTransaction transaction = entityManager.getTransaction();
	
	public filmDAO()
	{
		
	}
	
	/*@Override
	public void nationsAvecPlus(int nb) {
		
		try {
			TypedQuery<Nation> query = entityManager.createQuery("SELECT n FROM Nation n WHERE n.population >= :population", Nation.class);
		    query.setParameter("population", nb);
		    List<Nation> nations = query.getResultList();
		    if (nations != null) {
		    	System.out.println("--------------------------------------");
		    	for(Nation n : nations)
				{
					System.out.println(n.toString());
				}
	        }
		}
		catch(Exception e)
		{
			
		}
		
	}

	@Override
	public void modifNBHab(Nation n, int nb) {
		// TODO Auto-generated method stub
		
		try {
			//Modification de la population de l'Espagne
			transaction.begin();
			
			TypedQuery<Nation> query = entityManager.createQuery("SELECT n FROM Nation n WHERE n.nom = :nom", Nation.class);
		    query.setParameter("nom", n.getNom());
		    Nation nationAModifier = query.getSingleResult();
		    if (nationAModifier != null) {
	            nationAModifier.setPopulation(nb);
	        }

	        transaction.commit();
		}
		catch(Exception e)
		{
			transaction.rollback();
		}
		
	}*/
	
	public void AfficherFilms()
	{
		 Query q = entityManager.createQuery( "from film" , film.class );
		 List<film> films ;
			
		 films = q.getResultList();
		 for (film f : films) {
		 System.out.println( f.toString() );
		 }
	}
	
	
	/*public Nation trouverNation(String nomNation)
	{
		try {
    		TypedQuery<Nation> nationQuery = entityManager.createQuery("SELECT n FROM Nation n WHERE n.nom = :nom", Nation.class);
        	nationQuery.setParameter("nom", nomNation);
        	Nation nation = nationQuery.getSingleResult();
        	
        	return nation;
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
	}
	
	public void creerCitoyen(String nom, String prenom, Nation nation)
	{
		transaction.begin();
		
		Citoyen cit = new Citoyen();
		cit.setNom(nom);
		cit.setPrenom(prenom);
		cit.setNation(nation);
		
		entityManager.persist(cit);
		
		transaction.commit();
    	
	}
	public void getCitoyensParNation(String nomNation) {
        TypedQuery<Citoyen> query = entityManager.createQuery("SELECT c FROM Citoyen c WHERE c.nation.nom = :nomNation", Citoyen.class);
        query.setParameter("nomNation", nomNation);
        List<Citoyen> citoyens = query.getResultList();
        if (citoyens != null) {
	    	System.out.println("--------------------------------------");
	    	for(Citoyen c : citoyens)
			{
				System.out.println(c.toString());
			}
        }
    }*/

}
