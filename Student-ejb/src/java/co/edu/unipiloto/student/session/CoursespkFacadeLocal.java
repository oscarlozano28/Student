/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Coursespk;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author osmal
 */
@Local
public interface CoursespkFacadeLocal {

    void create(Coursespk coursespk);

    void edit(Coursespk coursespk);

    void remove(Coursespk coursespk);

    Coursespk find(Object id);

    List<Coursespk> findAll();

    List<Coursespk> findRange(int[] range);

    int count();

    void addCoursepk(Coursespk coursepk);

    void editCoursepk(Coursespk coursepk);

    void deleteCoursepk(int coursepkId);

    Coursespk getCoursepk(int coursepkId);

    List<Coursespk> getAllCoursepk();
    
}
