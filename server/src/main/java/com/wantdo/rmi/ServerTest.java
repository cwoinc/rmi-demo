package com.wantdo.rmi;

import com.wantdo.rmi.service.DemoService;
import com.wantdo.rmi.service.impl.DemoServerImpl;
import com.wantdo.rmi.service.impl.TestServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author king
 * @version 2018-08-31 1:24 PM
 */
public class ServerTest {
    
    public static void main(String[] args) throws Exception {
        //System.setProperty("java.rmi.server.hostname", "140.143.243.70");
        DemoService service = new DemoServerImpl();
        
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("user", service);
        
        //LocateRegistry.createRegistry(1099);
        Naming.bind("user2", service);
        
        //LocateRegistry.createRegistry(1099);
        Context namingContext = new InitialContext();
        //namingContext.bind("rmi:" + name, service);
        //namingContext.bind("rmi://192.168.125.222:1099/user1", new TestServiceImpl());
        namingContext.rebind("rmi://localhost:1099/user1", new TestServiceImpl());
        
        System.out.println("ok");
    }
}