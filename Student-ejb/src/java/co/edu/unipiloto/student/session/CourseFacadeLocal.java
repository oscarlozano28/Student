/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Course;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author osmal
 */
@Local
public interface CourseFacadeLocal {

    void create(Course course);

    void edit(Course course);

    void remove(Course course);

    Course find(Object id);

    List<Course> findAll();

    List<Course> findRange(int[] range);

    int count();

    void addCourse(Course course);

    void editCourse(Course course);

    void deleteCourse(int courseId);

    Course getCourse(int courseId);

    List<Course> getAllCourse();

    
    
}
