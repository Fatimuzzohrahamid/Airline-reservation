package AirLineManagementSystem;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver"); 
//        	Class.forName("com.mysql.cj.jdbc.Driver"); 
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsysytem","root","");  
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsysytem","root","");  
            s =c.createStatement(); 
            
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  