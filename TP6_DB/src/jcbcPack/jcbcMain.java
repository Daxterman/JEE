package jcbcPack;

import java.sql.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class jcbcMain {

	public static void main(String[] args) throws Exception {
		 EntityManagerFactory emf ;
		 emf = Persistence.createEntityManagerFactory("FilmDB");
		 EntityManager entityManager = emf.createEntityManager();
		 Query q = entityManager.createQuery( "from film" , film.class );
		 List<film> films ;
		
		 films = q.getResultList();
		 for (film f : films) {
		 System.out.println( f.toString() );
		 }
		 }



}
