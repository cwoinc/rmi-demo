package com.wantdo.rmi;

import com.wantdo.rmi.service.DemoService;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Arrays;

/**
 * @author king
 * @version 2018-08-31 1:27 PM
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        // 当服务端是在远程服务器上时，必须使用安全管理器，否则rmi会被禁用
        System.setProperty("java.security.policy", ClientTest.class.getResource("/").getPath() + "policy.txt");
        System.setSecurityManager(new SecurityManager());
        
        // 方法一
        DemoService demoService = (DemoService) LocateRegistry.getRegistry().lookup("user1");
        
        // 方法二
        Context namingContext = new InitialContext();
        DemoService demoService1 = (DemoService) namingContext.lookup("rmi://localhost:1099/user");
        
        //// 方法三
        // DemoService demoService2 = (DemoService) Naming.lookup("user1");
        DemoService demoService2 = (DemoService) Naming.lookup("rmi://140.143.243.70:1099/user1");
        
        //// 显示服务器中所有可用的远程方法
        // String[] arr = Naming.list("rmi://140.143.243.70");
        // String[] arr = Naming.list("rmi://140.143.243.70:1099");
        String[] arr = Naming.list("");
        System.out.println(Arrays.toString(arr));
        
        System.out.println(demoService.getUserCount());
        System.out.println(demoService1.getUserCount());
        System.out.println(demoService2.getUserCount());
        
    }
}
