/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author osmal
 */
@Stateless
public class CourseFacade extends AbstractFacade<Course> implements CourseFacadeLocal {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseFacade() {
        super(Course.class);
    }

    @Override
    public void addCourse(Course course) {
        em.persist(course);
    }

    @Override
    public void editCourse(Course course) {
        em.merge(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        em.remove(getCourse(courseId));
    }

    @Override
    public Course getCourse(int courseId) {
        return em.find(Course.class, courseId);
    }

    @Override
    public List<Course> getAllCourse() {
        return em.createNamedQuery("Course_1.findAll").getResultList();
    } 
}
