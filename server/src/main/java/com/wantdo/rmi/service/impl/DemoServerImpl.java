package com.wantdo.rmi.service.impl;

import com.wantdo.rmi.entity.User;
import com.wantdo.rmi.service.DemoService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author king
 * @version 2018-08-31 1:22 PM
 */
public class DemoServerImpl extends UnicastRemoteObject implements DemoService {
    public DemoServerImpl() throws RemoteException {
        super();
    }
    
    public String getUserName(int id) throws RemoteException {
        return "aa";
    }
    
    public int getUserCount() throws RemoteException {
        return 1;
    }
    
    public User getUserByName(String name) throws RemoteException {
        return new User("bb", 1);
    }
}