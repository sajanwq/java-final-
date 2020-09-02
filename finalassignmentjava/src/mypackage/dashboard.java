
package mypackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class dashboard extends JFrame implements ActionListener{
   
    JLabel lblwelcome;
    JMenuBar mbar;
    JMenu student, subject, marks;
    JMenuItem addStudent, studentDetails, searchStudent,addsubject,  subjectdetails;
    public dashboard(){
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
        setSize(700, 700);
        setTitle("Dashboard");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
  
        
        // creating label for the welcome section
        lblwelcome = new JLabel("Welcome to the result management system");
        lblwelcome.setBounds(50, 20, 300, 50);
        lblwelcome.setFont(new Font("Arial Black", 0, 20));
        add(lblwelcome);
        
        // creating menubar
        mbar = new JMenuBar();
        add(mbar);
        setJMenuBar(mbar);
        
        // creating menu 
        student = new JMenu("Student");
        subject= new JMenu("Subject");
        marks= new JMenu("Marks");
        
        student.setFont(new Font("Arial", Font.BOLD, 22));
        subject.setFont(new Font("Arial", Font.BOLD, 22));
        marks.setFont(new Font("Arial", Font.BOLD, 22));
        
      // adding menu in menu bar
       mbar.add(student);mbar.add(subject);mbar.add(marks);
        
        // iniializing  menu item for menu student
        addStudent = new JMenuItem("Add Student");
        studentDetails = new JMenuItem("Student Details");
        searchStudent = new JMenuItem("Search Student");
        
            
        addStudent.setFont(new Font("Arial", 0, 18));
        studentDetails.setFont(new Font("Arial", 0, 18));
        searchStudent.setFont(new Font("Arial", 0, 18));
        
        addStudent.addActionListener(this);
        studentDetails.addActionListener(this);
        searchStudent.addActionListener(this);
        
        // adding menubar item inside menu
       student.add(addStudent);student.add(studentDetails);student.add(searchStudent);
       
  // creating menu item for subject menu
  addsubject = new JMenuItem("Add Subject");
  subjectdetails = new JMenuItem("View Subject");
  
  
  addsubject.setFont(new Font("Arial", 0, 18));
  subjectdetails.setFont(new Font("Arial", 0, 18));
  
  // adding menu items inside menu subject
  subject.add(addsubject);subject.add(subjectdetails);
        
  addsubject.addActionListener(this);
  subjectdetails.addActionListener(this);
     
        
      
   
     
      
       
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd == "Add Student"){
         this.dispose();
       addstudentdetail detail = new addstudentdetail();
       
      }else if(cmd == "Student Details")
      {
        this.dispose();
        studentDetails viewstdnt = new studentDetails(); 
        
      }
      else if(cmd == "Add Subject"){
      this.dispose();
      addsubject  addsub = new addsubject();
      
      } else if (cmd == "View Subject"){
      this.dispose();
      viewsubject vsub = new viewsubject();
      }
                
  }
}
