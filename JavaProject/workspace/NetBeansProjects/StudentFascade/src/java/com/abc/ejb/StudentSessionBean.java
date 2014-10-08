

package com.abc.ejb;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class StudentSessionBean implements StudentSessionBeanRemote, StudentSessionBeanLocal {

    @PersistenceContext(unitName="StudentEJBPU")
    protected EntityManager em;

    public void insert(String id, String name, boolean gender, int j2ee) {
    }

    public Student find(String id) {
        return em.find(Student.class, id);
    }
  
 
}
