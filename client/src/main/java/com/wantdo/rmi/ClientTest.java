package com.wantdo.rmi;

import com.wantdo.rmi.service.DemoService;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.util.Arrays;

/**
 * @author king
 * @version 2018-08-31 1:27 PM
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.security.policy", ClientTest.class.getResource("/").getPath() + "policy.txt");
        System.setSecurityManager(new SecurityManager());
        
        //DemoService demoService = (DemoService) LocateRegistry.getRegistry().lookup("user1");
        
        Context namingContext = new InitialContext();
        //DemoService demoService1 = (DemoService) namingContext.lookup("rmi://localhost:1099/user");
        
        //DemoService demoService2 = (DemoService) Naming.lookup("user1");
        DemoService demoService2 = (DemoService) Naming.lookup("rmi://140.143.243.70:1099/user1");
        
        String[] arr = Naming.list("rmi://140.143.243.70");
        System.out.println(Arrays.toString(arr));
        
        //System.out.println(demoService.getUserCount());
        //System.out.println(demoService1.getUserCount());
        System.out.println(demoService2.getUserCount());
        
        
    }
}
