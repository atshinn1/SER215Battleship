/********************** 
Name: PlayerRecords 
Author: David Ward
Create On: 11/02/15
Updated On: 
Contributors:
battleship_db
team4
3H2qib2$
50.62.209.118:3306
***********************/

import java.sql.*;

public class UserRegistration
{
   private String newUser;
   private String newPass;
   private final String URL = "jdbc:mysql://50.62.209.118:3306/battleship_db";
   private final String USER = "team4", PASS = "3H2qib2$";
   private String sql, createRecords, createUser;
   private Connection conn = null;
   private Statement stmt = null, stmtInsert = null, stmtUserPass = null;
   
   public UserRegistration(String user, String pass)
   {
      newUser = user;
      newPass = pass;
   }
   
   public int dbConnect()
   {
      /*
      resultCode meaning:
      0 username already exists
      1 username has been created
      2 username has not been created successfully
      */
      int resultCode;
      
      try
      {
         try
         {
            Class.forName("com.mysql.jdbc.Driver");
         }
         
         catch(Exception e)
         {
            resultCode = 2;
            System.out.println("Database connection failed!");
            return resultCode;
         }
         
         conn = DriverManager.getConnection(URL,USER,PASS);
         stmt = conn.createStatement();
         
         sql = "SELECT count(*) cnt from bs_player_stats WHERE name = '" + newUser + "';";
         ResultSet rs = stmt.executeQuery(sql);
         
         //if user exists return corresponding code otherwise create new user and return corresponding code
         if(!rs.isBeforeFirst())
         {
            rs.close();
            stmt.close();
            conn.close();
            
            resultCode = 0;
            return resultCode;
         }
         
         else
         {
            stmtUserPass = conn.createStatement();
            stmtInsert = conn.createStatement();
            createRecords = "INSERT into bs_player_stats(name, games_played, games_won, games_lost, ships_destroyed, ships_lost, win_percentage, loss_percentage) VALUES('"
               + newUser + "', 0, 0, 0, 0, 0, 0.00, 0.00);";
            stmtInsert.executeUpdate(createRecords);
            
            rs.close();
            stmt.close();
            conn.close();
            
            resultCode = 1;
            return resultCode;
         }
      }
      
      catch(SQLException se)
      {
         se.printStackTrace();
         System.out.println("Database connection failed!");
         resultCode = 2;
         return resultCode;
      }
   }
}