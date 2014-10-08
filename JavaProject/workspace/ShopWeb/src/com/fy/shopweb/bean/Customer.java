package com.fy.shopweb.bean;
import java.sql.*;
public class Customer {
        //data
        private int custId ;  // only to get uid
        private String user;
        private String password;
        private String name;
        private String title;  // values F: for female ; M: for male.
        private String email;
        private boolean checkin = false;
        //method
        public Customer() {
        }
      //getXXX/setXXX(){}
        public int getCustid(){ return custId;}
        public String getUser() { return user;}
        public String getPassword(){return password;}
        public String getName() {return name;}
        public String getTitle(){return title;}
        public String getEmail() {return email;}
        public boolean getCheckin() {return this.checkin;}
        public void setCustid(int cid){this.custId = cid;}
        public void setUser(String user){this.user = user;}
        public void setPassword(String password){this.password = password;} 
        public void setName(String name){this.name = name;}
        public void setTitle(String title){this.title = title;}
        public void setEmail(String email){this.email = email;}
        public void setCheckin(boolean checkin){this.checkin = checkin;}
        public void newCustomer(){}
        String driver = "com.mysql.jdbc.Driver";
        public boolean login(String user, String password) 
        		throws SQLException, ClassNotFoundException{
              
        	boolean succ = false;
        	Class.forName(driver);
            Connection con = DriverManager.getConnection
            		   ("jdbc:mysql://localhost:3306/bookstore?user=root&password=dayingfengyu");//DataAccess.getConnection();
            String sql = "select * from bs_customer where user='"
                            + user+"' AND password ='"
                            + password+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
               succ = true;
            }
            rs.close();
            stmt.close();
            con.close();
            return succ;
        }
    /**
     * 
     * @throws Exception
     */
    public void saveInfo() throws Exception {
 		    Class.forName(driver);
        	Connection con =DriverManager.getConnection
 		    		("jdbc:mysql://localhost:3306/bookstore?user=root&password=dayingfengyu"); //DataAccess.getConnection();
 		    String sqlStr = "insert into bs_customer "
 		                    + "  values(" + this.getCustid()+","
 		                                  + "'"+this.getUser()+"',"
 		                                  + "'"+this.getPassword()+"',"
 		                                  + "'"+this.getName()+"',"
 		                                  + "'"+this.getTitle()+"',"
 		                                  + "'"+this.getEmail()+"'" +
 		                                  " )";
 		    Statement stmt = con.createStatement();
 		    stmt.executeUpdate(sqlStr);
 		    stmt.close();
 		    con.close();
     }
    public boolean logOut(){ return false;}     
 }
  

