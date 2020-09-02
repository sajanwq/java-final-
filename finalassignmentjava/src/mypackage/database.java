
package mypackage;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;
import javax.swing.JOptionPane;


public class database {
    Connection conn;
    ResultSet rs, rs1;
    Statement st;
    PreparedStatement pstmt;    
    public database(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3302/db_javafinalassignment","root","");
            st = conn. createStatement();
        }
        catch(Exception e){
            System.out.println("Error" +e);
        }
    }
        public void close() {
        try {
            conn.close();
            rs.close();
        } catch (SQLException e) {
        }
    }

    public int register(String aname, String address, String classes, String sec){
        int result = 0;
        try
        {
            pstmt = conn.prepareStatement("insert into student values(?,?,?,?,?)");
            pstmt.setInt(1, result);
            pstmt.setString(2, aname);
            pstmt.setString(3, address);
            pstmt.setString(4, classes);
            pstmt.setString(5, sec);
            pstmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Error" +e);
        }
        return  result;
            
    

    }

    void deleteStudent(int S_Id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try {
            String sql = "DELETE FROM student WHERE Roll_no='" + S_Id + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    
      }

     public void updateStudent( int Roll_no, String name, String addrs, String classs, String sect) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            String sql="UPDATE student SET Name=?, Address=?,Class=?,Section=? where Roll_no='"+Roll_no+"'";
            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2,addrs);
            pst.setString(3, classs);
            pst.setString(4, sect);
            System.out.println(pst);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

       int submitsubject(String subcode, String subname, String classs) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int result = 0;
        try{
        String sql = "insert into subject value(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, subcode);
        pst.setString(2, subname);
        pst.setString(3, classs);
        pst.executeUpdate();
  
    }catch(SQLException e){ 
    System.out.println(e);
      }
  return result;
    }

}



    
    
    

