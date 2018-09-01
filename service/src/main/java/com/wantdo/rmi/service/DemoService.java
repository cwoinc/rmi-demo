package com.wantdo.rmi.service;

import com.wantdo.rmi.entity.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author king
 * @version 2018-08-31 1:18 PM
 */
public interface DemoService extends Remote {
    
    String getUserName(int id) throws RemoteException;
    
    int getUserCount() throws RemoteException;
    
    User getUserByName(String name) throws RemoteException;
    
}
