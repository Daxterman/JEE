package jpaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jcbcPack.realisateur;

public class realDAO {

EntityManagerFactory emf;
	
	
	public realDAO()
	{
		emf = Persistence.createEntityManagerFactory("FilmDB");
	}
	
	public void AfficherRealisateurs() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            Query q = entityManager.createQuery("FROM realisateur", realisateur.class);
            List<realisateur> realisateurs = q.getResultList();
            for (realisateur r : realisateurs) {
                System.out.println(r.toString());
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

    public void creerRealisateur(String nom_real, String prenom_real ) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            realisateur r = new realisateur();
            r.setnom_real(nom_real);
            r.setprenom_real(prenom_real);
            entityManager.persist(r);
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
    
    public void supprimerRealisateurParNom(String nom_real) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM realisateur r WHERE r.nom_real = :nom_real");
            query.setParameter("nom_real", nom_real);
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
    
    public void supprimerRealisateurParId(int id_real) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM realisateur r WHERE r.id_real = :id_real");
            query.setParameter("id_real", id_real);
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
    
    public void modifierRealisateurParNom(String ancienNom, String nouveauNom, String nouveauPrenom) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("UPDATE realisateur r SET r.nom_real = :nouveauNom, r.prenom_real = :nouveauPrenom  WHERE r.nom_real = :ancienNom");
            query.setParameter("nouveauNom", nouveauNom);
            query.setParameter("nouveauPrenom", nouveauPrenom);
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
    
    public void modifierRealisateurParId(int id_real, String nouveauNom, String nouveauPrenom) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createQuery("UPDATE realisateur r SET r.nom_real = :nouveauNom, r.prenom_real = :nouveauPrenom  WHERE r.id_real = :id_real");
            query.setParameter("nouveauNom", nouveauNom);
            query.setParameter("nouveauPrenom", nouveauPrenom);
            query.setParameter("id_real", id_real);
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
