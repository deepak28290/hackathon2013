package com.ebay.redis.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/hackathon?"
              + "user=root&password=");
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      
      preparedStatement = connect
              .prepareStatement("select * from hackathon.ebay_offline_master where category=?");
      preparedStatement.setString(1, "title1");
          resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);
      // PreparedStatements can use variables and are more efficient
//      preparedStatement = connect
//          .prepareStatement("insert into hackathon.ebay_offline_master values (?,?,?,?,?,?,?,?)");
//      preparedStatement.setString(1, "title1");
//      preparedStatement.setString(2, "title1");
//      preparedStatement.setString(3, "title1");
//      preparedStatement.setString(4, "title1");
//      preparedStatement.setString(5, "title1");
//      preparedStatement.setString(6, "title1");
//      preparedStatement.setString(7, "title1");
//      preparedStatement.setString(8, "title1");
      
      
      // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      // Parameters start with 1
     /* preparedStatement.setString(1, "Test");
      preparedStatement.setString(2, "TestEmail");
      preparedStatement.setString(3, "TestWebpage");
      preparedStatement.setString(5, "TestSummary");
      preparedStatement.setString(6, "TestComment");*/
   //   preparedStatement.executeUpdate();
/*
      preparedStatement = connect
          .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);

      // Remove again the insert comment
      preparedStatement = connect
      .prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
      preparedStatement.setString(1, "Test");
      preparedStatement.executeUpdate();
      
      resultSet = statement
      .executeQuery("select * from FEEDBACK.COMMENTS");
      writeMetaData(resultSet);
*/      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      System.out.println(resultSet.getString("title"));
      break;
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }
  public static void main(String[] args) throws Exception {
	    MySQLAccess dao = new MySQLAccess();
	    dao.readDataBase();
	  }
} 