
package mypackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class addstudentdetail extends JFrame implements ActionListener{
    JLabel lblname,lblclass, lblsection, lbladdress;
    JTextField txtname, txtclass, txtsection, txtaddress;
    JComboBox comclass,comsection;
    JButton btnregister,btnback,btnupdate;
            
    public addstudentdetail(){
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
        setSize(1000, 1000);
        setTitle("addstudentdetail");
       
        
       // For label section
       lblname = new JLabel("Full Name:");
       lbladdress= new JLabel("Address:");
       lblclass= new JLabel("Class:");
       lblsection= new JLabel("Section:");
      
       
       lblname.setBounds(50, 100, 200, 30);
       lbladdress.setBounds(50, 200, 200, 30);
       lblclass.setBounds(50, 300, 200, 30);
       lblsection.setBounds(50, 400, 200, 30);
    
       
       lblname.setFont(new Font("Arial", Font.BOLD, 28) );
       lbladdress.setFont(new Font("Arial", Font.BOLD, 28) );
       lblclass.setFont(new Font("Arial", Font.BOLD, 28) );
       lblsection.setFont(new Font("Arial", Font.BOLD, 28) );
     
             
        add(lblname);
        add(lblclass);
        add(lblsection);
        add(lbladdress);
             
       txtname = new JTextField();
       txtaddress= new JTextField();
        
       txtname.setFont(new Font("Arial", 0, 20));
       txtaddress.setFont(new Font("Arial", 0, 20));
       
       txtname.setBounds(300, 100, 250, 40);
       txtaddress.setBounds(300, 200, 250, 40);
        
        add(txtname);
        add(txtaddress);
       // combobox for class 
        comclass =new JComboBox();
        comclass.addItem("23");
        comclass.addItem("24");
        comclass.addItem("25");
        comclass.addItem("26");
        comclass.addItem("27");
        comclass.addItem("28");
   
        //combobox for section
        comsection = new JComboBox();
      
        comsection.addItem("batch-23A");
        comsection.addItem("batch-23B");
        comsection.addItem("batch-24A");
        comsection.addItem("batch-24B");
        comsection.addItem("batch-25A");
        comsection.addItem("batch-25B");
        comsection.addItem("batch-26A");
        comsection.addItem("batch-26B");
      
        
        comclass.setFont(new Font("Arial", 0, 20));
        comsection.setFont(new Font("Arial", 0, 20));
        
        
        
        comclass.setBounds(300, 300, 100, 40);
        comsection.setBounds(300, 395, 150, 40);
        
        add(comclass);
        add(comsection);
        
        //adding button
        btnregister = new JButton("register");
        btnregister.setBounds(110, 500, 150, 40);
        btnregister.setFont(new Font("Arial Black", 0, 18));
        add(btnregister);
        btnregister.addActionListener(this);
       
        // for back button
        btnback = new JButton("Back");
        btnback.setBounds(110, 10, 100, 40);
        btnback.setFont(new Font("Arial Black", 0, 18));
        add(btnback);
        btnback.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnupdate = new JButton("update");
        btnupdate.setBounds(300, 500, 100, 40);
        btnupdate.setFont(new Font("Arial Black", 0, 18));
        add(btnupdate);
        btnupdate.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String aname,address,classes,sec;
        String cmd =e.getActionCommand();
       if(cmd == "Back")
     {
       dashboard dash = new dashboard();
       this.dispose();
    }else if(cmd == "register"){
        aname = txtname.getText();
        address = txtaddress.getText();
        classes =comclass.getSelectedItem().toString();
        sec =comsection.getSelectedItem().toString();
        
        try{
            database db =new database();
            int result = db.register(aname, address, classes, sec);
            if(result>0)
            {
                JOptionPane.showMessageDialog(null,"unable to save!" );  
            }else{
                JOptionPane.showMessageDialog(null, "saved  successfully!");
            }
        }catch(Exception f){
            System.out.println("Error" +f);
        }
        
    }    
    else if(cmd=="update"){
             String name=txtname.getText();
             String addrs=txtaddress.getText();
             String classs =comclass.getSelectedItem().toString();
             String sect =comsection.getSelectedItem().toString();
     
            database db=new database();
            studentDetails  ss = new studentDetails();
            ss.dispose();
            int a = ss.Roll_no; 
            db.updateStudent(a,name,addrs,classs,sect);
            this.dispose();
            new studentDetails();

        }
     
     
   }
}