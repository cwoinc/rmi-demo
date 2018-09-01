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
        //// 当服务端是远程服务器的时候，需要设置hostname，否则会报127.0.0.1的错误，也许还存在其他的解决方法，这只是其中一种方式
        // System.setProperty("java.rmi.server.hostname", "140.143.243.70");
        DemoService service = new DemoServerImpl();
        
        // 方法一
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("user", service);
        
        //// 方法二 该方法如果单独使用，需要设置
        // Registry registry = LocateRegistry.createRegistry(1099);
        Naming.bind("user2", service);
        
        ////方法三 该方法如果单独使用，需要设置
        // Registry registry = LocateRegistry.createRegistry(1099);
        Context namingContext = new InitialContext();
        namingContext.rebind("rmi://localhost:1099/user1", new TestServiceImpl());
        /// 默认host和端口的简写法
        // namingContext.bind("rmi:" + name, service);
        
        System.out.println("server is start...");
    }
}