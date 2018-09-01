package com.wantdo.rmi.service.impl;

import com.wantdo.rmi.entity.User;
import com.wantdo.rmi.service.DemoService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author king
 * @version 2018-08-31 1:50 PM
 */
public class TestServiceImpl implements DemoService {
    // 如果不想继承UnicastRemoteObject类，则需要使用 UnicastRemoteObject类的静态方法exportObject(Remote obj, int port)将对象导出
    
    public TestServiceImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        // 其中如果端口设为 0 的话，则表示任何合适的端口都可用来监听客户连接
    }
    
    public String getUserName(int id) throws RemoteException {
        return "sos";
    }
    
    public int getUserCount() throws RemoteException {
        return 0;
    }
    
    public User getUserByName(String name) throws RemoteException {
        return new User("king", 18);
    }
}
