/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abc.ejb;

import javax.ejb.Local;

/**
 *
 * @author nimbus
 */
@Local
public interface StudentSessionBeanLocal {

    void insert(String id, String name, boolean gender, int j2ee);

    Student find(String id);
    
}
