package com.wantdo.rmi.entity;

import java.io.Serializable;

/**
 * @author king
 * @version 2018-08-31 1:21 PM
 */

public class User implements Serializable {
    private static final long serialVersionUID = 42L;
    private String name;
    private int id;
    
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}