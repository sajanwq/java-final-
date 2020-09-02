
package mypackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


public class viewsubject implements ActionListener {
    JFrame frame;
    JTable tabl;
    JButton btndelete, btnback, btnupdate;
   
    DefaultTableModel model = new DefaultTableModel();
    public viewsubject(){
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
        
    frame = new JFrame();
    frame.setLayout(null);
    frame.setTitle("viewsubject");
    frame.setSize(800, 600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // adding table
    tabl =new JTable(model);
    model.addColumn("Subject Code");
    model.addColumn("Subject Name");
    model.addColumn("Class");
    tabl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    tabl.setFillsViewportHeight(true);
    tabl.setFont(new Font("Arial",0,18));
    
    // adding scrollbar in the table
    JScrollPane scroll = new JScrollPane(tabl);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scroll.setBounds(50, 70, 700, 300);
    frame.add(scroll);
    
    // adding buttons
    btnback = new JButton("Back");
    frame.add(btnback);
    btnback.setFont(new Font("Arial", 0, 19));
    btnback.setBounds(50, 20, 100, 40);
    btnback.addActionListener(this);
    
    btndelete = new JButton("Delete");
    frame.add(btndelete);
    btndelete.setFont(new Font("Arial", 0, 19));
    btndelete.setBounds(400, 400, 150, 40);
    btndelete.addActionListener(this);
            
    btnupdate = new JButton("Update");
    frame.add(btnupdate);
    btnupdate.setFont(new Font("Arial", 0, 19));
    btnupdate.setBounds(150, 400, 150, 40);
    btnupdate.addActionListener(this);
    
    
    try {
    database dbs = new database();
    String sql = "select * from subject ";
    String sub_cod;
    String sub_name;
    String clss;
    
    dbs.rs1 = dbs.st.executeQuery(sql);
    while(dbs.rs1.next()){
        sub_cod = dbs.rs1.getString("Subject Code");
         sub_name = dbs.rs1 .getString("Subject Name");
         clss = dbs.rs1.getString("Class");
         model.addRow(new Object[]{sub_cod,sub_name,clss});
    
    }
    
    
    
    }catch(SQLException e){
        System.out.println("e");
    }
    
    
    
    
    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String cmd = e.getActionCommand();
    if(cmd == "Back")
    {
        frame.dispose();
    dashboard dash = new dashboard();
    
    }else if(cmd == "Delete"){
        int i = tabl.getSelectedRow();
        String scode = tabl.getValueAt(i, 0).toString();
        String sname = tabl.getValueAt(i, 1).toString();
        String classs = tabl.getValueAt(i, 2).toString();
        
    
    }
    
    
  }

   
    
    
}
