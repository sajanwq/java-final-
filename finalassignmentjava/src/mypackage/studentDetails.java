
package mypackage;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class studentDetails extends JFrame implements ActionListener{
  JTable tbl;
  JButton back,delete,edit;
  String column[] = {"Roll no", "Name", "Address", "Class", "Section"};
  DefaultTableModel model = new DefaultTableModel();
  static int Roll_no;
  public studentDetails(){
      // using look and feel
       try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
      setLayout(null);
      setTitle("student details");
      setSize(1200,800);
      //creating  buttons
      back = new JButton("Back");
      delete = new JButton("Delete");
      edit = new JButton("Edit");
      
      add(back);
      add(delete);
      add(edit);
       
      back.setBounds(100, 20, 100, 40);
      delete.setBounds(450, 650, 100, 40);
      edit.setBounds(650, 650, 100, 40);
      
      back.setFont(new Font("Calibri", 0,19));
      delete.setFont(new Font("Calibri", 0,19));
      edit.setFont(new Font("Calibri", 0,19));
      
      //implementing eventlisteners in buttons
      back.addActionListener(this);
      delete.addActionListener(this);
      edit.addActionListener(this);
      
      
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE); 
      
      tbl = new JTable();
      tbl.setModel(model);
      model.addColumn("Roll no");
      model.addColumn("Name");
      model.addColumn("Address");
      model.addColumn("Class");
      model.addColumn("Section");
      tbl.setFont(new Font("Arial", 0, 18));
    
   try{
       database dbs = new database();
       Statement stmt =dbs.conn.createStatement();
       ResultSet rs = stmt.executeQuery("Select * from student");
       while(rs.next()){
       model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5)});
         }
   }
   catch(SQLException e)
   {
   System.out.println(e);
   }


   
       int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        JScrollPane scrollPane = new JScrollPane(tbl, v, h);
        add(scrollPane);
        scrollPane.setBounds(100, 100, 1000, 500);
     
       




  }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String cmd =e.getActionCommand();
    if(cmd=="Back"){
     this.dispose();
     dashboard dash = new dashboard();
    
    }else if(cmd=="Delete"){
            int i=tbl.getSelectedRow();
            String ab=tbl.getValueAt(i,1).toString();
            database db=new database();
            String sql="select Roll_no from student where Name='"+ab+"'";
            {
                try {
                   db.rs = db.st.executeQuery(sql);
                   while(db.rs.next()){
                    Roll_no=db.rs.getInt("Roll_no");
                   
                    db.deleteStudent(Roll_no);}
                    JOptionPane.showMessageDialog(null,"Deleted Successfully!");
                    this.dispose();
                    new studentDetails();
                            
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
                 //tbl.getSelectedColumn();
                 
                 
                 
        }  else if(cmd=="Edit"){
            addstudentdetail sd=new addstudentdetail();
            int i=tbl.getSelectedRow();
            
            sd.txtname.setText(String.valueOf(tbl.getValueAt(i,1).toString()));
            sd.txtaddress.setText(String.valueOf(tbl.getValueAt(i,2).toString()));
            
            String classes=String.valueOf(tbl.getValueAt(i,3).toString());
            sd.comclass.setSelectedItem(classes);
           
            String section=String.valueOf(tbl.getValueAt(i,4).toString());
            sd.comsection.setSelectedItem(section);

      
            database db=new database();
            String name=String.valueOf(tbl.getValueAt(i,1).toString());
            String sql="select Roll_no from student where Name='"+name+"'";
            try {
                db.rs = db.st.executeQuery(sql);
                while(db.rs.next()){
                Roll_no=db.rs.getInt("ROll_no");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            sd.btnupdate.setVisible(true);
            sd.btnregister.setVisible(false);
            this.dispose();

        }
    
             
            
      
    }
    
    
    
    
    }


