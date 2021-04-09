/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Coursespk;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author osmal
 */
@Stateless
public class CoursespkFacade extends AbstractFacade<Coursespk> implements CoursespkFacadeLocal {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoursespkFacade() {
        super(Coursespk.class);
    }

    @Override
    public void addCoursepk(Coursespk coursepk) {
        em.persist(coursepk);
    }

    @Override
    public void editCoursepk(Coursespk coursepk) {
        em.merge(coursepk);
    }

    @Override
    public void deleteCoursepk(int coursepkId) {
        em.remove(getCoursepk(coursepkId));
    }

    @Override
    public Coursespk getCoursepk(int coursepkId) {
        return em.find(Coursespk.class, coursepkId);
    }

    @Override
    public List<Coursespk> getAllCoursepk() {
        return em.createNamedQuery("Coursespk.findAll").getResultList();        
    }
    
    
    
}
