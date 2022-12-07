package com.ejb.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.entity.Etudiant;

/**
 * Session Bean implementation class ManageEtudiantBean
 */
@Stateless
@LocalBean
public abstract class ManageEtudiantBean implements ManageEtudiantBeanRemote {

	
	@PersistenceContext(unitName = "Etudiant")
    private EntityManager entityManager;
 
    /**
     * Default constructor. 
     */
    public ManageEtudiantBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		entityManager.persist(etudiant);

		return true;
	}

	@Override
	public boolean deleteEtudiant(int id) {
		// TODO Auto-generated method stub
		   String q = "SELECT p from " + Etudiant.class.getName() + " p" + "WHERE p.Id = :id";;

	        Query query = entityManager.createQuery(q);
		  	query.setParameter("id", id);
	entityManager.remove(query.getResultList());
		return true;
	}

	@Override
	public boolean updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		entityManager.merge(etudiant);

		return true;
	}

	@Override
	public Etudiant findEtudiant(int id) {
		// TODO Auto-generated method stub
	    Etudiant p = entityManager.find(Etudiant.class,id);
        return p;

	}
	@Override
	 public List<Etudiant> AllEtudiants(){
		   String q = "SELECT p from " + Etudiant.class.getName() + " p";
	        Query query = entityManager.createQuery(q);
	        List<Etudiant> projects = query.getResultList();
	        return projects;
	 }

}
