
package mypackage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class loginform extends JFrame implements ActionListener{
    JLabel lblloginwith, lblname, lblpassword;
    JTextField txtusername, txtpassword;
    JButton btnsubmit;
    public loginform(){
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
        setSize(600, 600);
        setTitle("Student result management  system");
        
         //creating label for  login first  
        lblloginwith = new JLabel("Login first!");
        lblloginwith.setBounds(240, 5, 200 , 100);
        lblloginwith.setFont(new Font("Arial", Font.ITALIC, 28));
        add(lblloginwith);
        
       //creating label for name  
        lblname = new JLabel("Username:");
        lblname.setBounds(80, 60, 200 , 100);
        lblname.setFont(new Font("Arial", Font.BOLD, 28));
        add(lblname);
        
        //creating label for password
        lblpassword = new JLabel("Password:");
        lblpassword.setBounds(80, 170, 200, 100);
        lblpassword.setFont(new Font("Arial", Font.BOLD, 28));
        add(lblpassword);
        
        // creating textfield for username
        txtusername = new JTextField(30);
        txtusername.setBounds(230, 90, 200, 35);
        txtusername.setFont(new Font("Arial", 0, 18));
        add(txtusername);
        
          // creating textfield for password
        txtpassword = new JPasswordField(30);
        txtpassword.setBounds(230, 200, 200, 35);
        txtpassword.setFont(new Font("Arial", 0, 18));
        add(txtpassword);
        
        // creating submit button
        btnsubmit = new JButton("login");
        btnsubmit.setBounds(225, 300, 200, 50);
        btnsubmit.setFont(new Font("Arial", 0, 20));
        add(btnsubmit);
        btnsubmit.addActionListener(this);
        
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String uname =txtusername.getText();
        String pswd = txtpassword.getText();
            if(uname.equals("admin") && pswd.equals("12345"))
            {
            JOptionPane.showMessageDialog(null,"Logged in successfully!");
            dashboard dash = new dashboard();
            this.dispose();
           
            }
            else{
              JOptionPane.showMessageDialog(null,"login unsuccesfull!");     
            }
    
    }
    
    
}
