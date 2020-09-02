
package mypackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class addsubject implements ActionListener{
    JFrame frame;
    JLabel lbltitle, lblsubcode,lblsubject,lblclass;
    JTextField txtsubcode, txtsubject, txtclass;
    JButton btnsubmit, btnupdate, btnback;
    JComboBox comclass;
    
   public addsubject(){
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
       frame.setTitle("Add subject");
       frame.setSize(700, 700);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       // creating labels
       lbltitle = new JLabel("Add subjects");
       lblsubcode= new JLabel("Subject Code:");
       lblsubject= new JLabel("Subject Name:");
       lblclass = new JLabel("Class:");
       
       frame.add(lbltitle);
       frame.add(lblsubcode);
       frame.add(lblsubject);
       frame.add(lblclass);
       
       lbltitle.setBounds(250, 20, 200, 30);
       lblsubcode.setBounds(40, 150, 200, 30);
       lblsubject.setBounds(40, 250, 200, 30);
       lblclass.setBounds(40, 350, 100, 20);
       
       lbltitle.setFont(new Font("Arial", Font.BOLD, 28));
       lbltitle.setForeground(Color.blue);
       lblsubcode.setFont(new Font("Arial", Font.BOLD, 28));
       lblsubject.setFont(new Font("Arial", Font.BOLD, 28));
       lblclass.setFont(new Font("Arial", Font.BOLD, 28));
       
       //creating textfields
       txtsubcode = new JTextField();
       txtsubject = new JTextField();
   
       
       frame.add(txtsubcode);
       frame.add(txtsubject);
   
       
        txtsubcode.setBounds(250, 140, 200, 40);
        txtsubject.setBounds(250, 240, 200, 40);
        txtsubcode.setFont(new Font("Arial", 0, 19));
        txtsubject.setFont(new Font("Arial", 0, 19));
        
        comclass = new JComboBox();
        comclass.addItem("23");
        comclass.addItem("24");
        comclass.addItem("25");
        comclass.addItem("26");
        comclass.addItem("27");
        comclass.addItem("28");
        
        frame.add(comclass);
        
        comclass.setBounds(250, 340, 200, 40);
        comclass.setFont(new Font("Arial", 0, 19));
        
        // creating buttons
        btnsubmit = new JButton("Submit");
        btnupdate = new JButton("update");
        btnback = new JButton("Back");
                
        
        frame.add(btnsubmit);
        frame.add(btnupdate);
        frame.add(btnback);
        
        btnsubmit.setBounds(200, 450, 100, 40);
        btnupdate.setBounds(330, 450, 100, 40);
        btnback.setBounds(20, 17, 100, 40);
        btnsubmit.setFont(new Font("Arial", 0, 19));
        btnupdate.setFont(new Font("Arial", 0, 19));
        btnback.setFont(new Font("Arial", 0, 19));
        
        // adding event listenrs in buttons
        btnsubmit.addActionListener(this);
        btnupdate.addActionListener(this);
        btnback.addActionListener(this);
        
   }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    String cmd = e.getActionCommand();
    
    if(cmd == "Back"){
        dashboard dash = new dashboard();
        frame.dispose();
         
    } else if(cmd == "Submit"){
        String subcode = txtsubcode.getText();
        String subname = txtsubject.getText();
        String classs = comclass.getSelectedItem().toString();
         
        try {
            database dbs = new database();
            int result = dbs.submitsubject(subcode, subname, classs);
         if(result>0){
        JOptionPane.showMessageDialog(null, "submitted successfully!");
        }
        else{
        JOptionPane.showMessageDialog(null, "submission unsuccessfull!");
        }
            
        }catch(Exception f){
            System.out.println(f);
        }
               
        }
        
            
    }
}
