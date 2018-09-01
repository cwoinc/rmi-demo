package com.wantdo.rmi.entity;

import java.io.Serializable;

/**
 * @author king
 * @version 2018-08-31 1:21 PM
 */

public class User implements Serializable {
    private static final long serialVersionUID = 42L;
    String name;
    int id;
    
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
}