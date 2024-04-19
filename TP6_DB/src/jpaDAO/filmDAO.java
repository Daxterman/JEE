package jpaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jcbcPack.film;

public class filmDAO {
	
	EntityManagerFactory emf;
	
	
	public filmDAO()
	{
		emf = Persistence.createEntityManagerFactory("FilmDB");
	}
	
	public void AfficherFilms() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            Query q = entityManager.createQuery("FROM film", film.class);
            List<film> films = q.getResultList();
            for (film f : films) {
                System.out.println(f.toString());
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

    public void creerFilm(String titre, int anneeSortie, String nomGenre, String nomReal) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            film f = new film();
            f.setTitre(titre);
            f.setAnnee_sortie(anneeSortie);
            f.setNom_genre(nomGenre);
            f.setNom_real(nomReal);
            entityManager.persist(f);
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
    
    public void supprimerFilmParNom(String titre) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM film f WHERE f.titre = :titre");
            query.setParameter("titre", titre);
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
    
    public void modifierFilmParId(int id, String nouveauTitre, int nouvelleAnneeSortie, String nouveauNomGenre, String nouveauNomReal) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            film f = entityManager.find(film.class, id);
            if (f != null) {
                f.setTitre(nouveauTitre);
                f.setAnnee_sortie(nouvelleAnneeSortie);
                f.setNom_genre(nouveauNomGenre);
                f.setNom_real(nouveauNomReal);
                entityManager.merge(f);
                transaction.commit();
                //System.out.println("Film modifié avec succès.");
            } else {
                //System.out.println("Aucun film trouvé avec l'ID spécifié.");
            }
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
