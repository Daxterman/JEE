package jpaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jcbcPack.genre;

public class genreDAO {
	
EntityManagerFactory emf;
	
	
	public genreDAO()
	{
		emf = Persistence.createEntityManagerFactory("FilmDB");
	}
	
	public void AfficherGenres() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            Query q = entityManager.createQuery("FROM genre", genre.class);
            List<genre> genres = q.getResultList();
            for (genre g : genres) {
                System.out.println(g.toString());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void creerGenre(String nom_genre) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            genre g = new genre();
            g.setnom_genre(nom_genre);
            entityManager.persist(g);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
    public void supprimerGenreParNom(String nom_genre) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM genre g WHERE g.nom_genre = :nom_genre");
            query.setParameter("nom_genre", nom_genre);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
    public void supprimerGenreParId(int id_genre) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM genre g WHERE g.id_genre = :id_genre");
            query.setParameter("id_genre", id_genre);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
    public void modifierGenreParNom(String ancienNom, String nouveauNomDeGenre) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("UPDATE genre g SET g.nom_genre = :nouveauNom WHERE g.nom_genre = :ancienNom");
            query.setParameter("nouveauNom", nouveauNomDeGenre);
            query.setParameter("ancienNom", ancienNom);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
    public void modifierGenreParId(int id_genre, String nouveauNomDeGenre) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("UPDATE genre g SET g.nom_genre = :nouveauNom WHERE g.id_genre = :id_genre");
            query.setParameter("nouveauNom", nouveauNomDeGenre);
            query.setParameter("id_genre", id_genre);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
}
