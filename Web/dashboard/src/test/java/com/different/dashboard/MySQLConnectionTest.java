package com.different.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySQLConnectionTest {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
   static final String DRIVER = "com.mysql.cj.jdbc.Driver";
   //static final String URL = "jdbc:mysql://127.0.0.1:3306/board?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
   static final String URL = "jdbc:mysql://dbinstance.cu9ea2dveoph.us-east-2.rds.amazonaws.com/different?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
   static final String USERNAME = "different";
   static final String PASSWORD = "elvjfjsxm";

   @Test
   public void getMySQLConnectionTest() {
       
       Connection conn = null;
       Statement stmt = null;
       
       try {
           
           logger.info("==================== MySQL Connection START ====================");
           
           Class.forName(DRIVER);
           
           conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           stmt = conn.createStatement();

           String sql = "SELECT COL, STUDENT_NAME, SUTDENT_ID, STUDENT_CURRI FROM STUDENTTEST";

           ResultSet rs = stmt.executeQuery(sql);
           while (rs.next()) {
               /*
               String boardSubject = rs.getString("BOARD_SUBJECT");
               String boardContent = rs.getString("BOARD_CONTENT");
               String boardWriter = rs.getString("BOARD_WRITER");

               System.out.print("boardSubject : " + boardSubject + ", ");
               System.out.print("boardContent: " + boardContent + ", ");
               System.out.println("boardWriter: " + boardWriter);
               */
               String c = rs.getString("COL");
               String sn = rs.getString("STUDENT_NAME");
               String si = rs.getString("SUTDENT_ID");
               String sc = rs.getString("STUDENT_CURRI");

               System.out.print("boardSubject : " + c + ", ");
               System.out.print("boardContent: " + sn + ", ");
               System.out.println("boardWriter: " + si+ ", ");
               System.out.println("boardWriter: " + sc);

           }

           rs.close();
           stmt.close();
           conn.close();

       } catch (SQLException se1) {
           se1.printStackTrace();
       } catch (Exception ex) {
           ex.printStackTrace();
       } finally {
           try {
               if (stmt != null) {
                   stmt.close();
               }
           } catch (SQLException se) {
               se.printStackTrace();
           }
           try {
               if (conn != null) {
                   conn.close();
               }
           } catch (SQLException se) {
               se.printStackTrace();
           }
       }
       
       System.out.println("==================== MySQL Connection END ====================");
   }
}

