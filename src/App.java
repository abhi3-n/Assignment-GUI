import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;



public class App {
    public static void main(String[] args) throws Exception {
        // ABC abc = new ABC();
        X x = new X();
    }
}


class ABC extends JFrame{
    JTextField jTextField = null;
    JRadioButton jr1 = null, jr2 = null;
    JLabel jl = null;    
    JButton jButton = null;
    JCheckBox jc1 = null, jc2 = null;
     public ABC(){

        jTextField = new JTextField(20);
        jr1 = new JRadioButton("Male");
        jr2 = new JRadioButton("Female");
        jButton = new JButton("Enter");
        jl = new JLabel();
        ButtonGroup buttonGroup = new ButtonGroup();
        jc1 = new JCheckBox("Python");
        jc2 = new JCheckBox("C++");


        buttonGroup.add(jr1);
        buttonGroup.add(jr2);
        add(jTextField);
        add(jButton);
        add(jr1);
        add(jr2);
        add(jl);
        add(jc1);
        add(jc2);

        jc1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                System.out.println("Python");
            }
            
        });
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String string = jTextField.getText();
                if(jr1.isSelected()){
                    string = "Mr."+string;
                }
                else if(jr2.isSelected()){
                    string = "Mrs."+string;

                }
                if(jc1.isSelected()){string+="Python";}
                if(jc2.isSelected()){string+="C++";}
                jl.setText(string);
            }
            
        });

        // addMouseListener(new MouseListener() {}); Won't use this because then we will have to implment all the methods declared in the interface.
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event){
                int x = event.getX();
                int y = event.getY();
                System.out.println(x+" "+y);
            } 
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
    }
}

class X extends JFrame{
    public X(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
        JButton jButton = new JButton("Start");
        add(jButton);
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new ABC();
                dispose();
            }
            
        });
    }
}


// class ABC extends JFrame /*implements ActionListener*/{
//     JTextField t2= null;
//     JTextField t1= null;
//     JLabel j1= null;

//     JRadioButton r1, r2;

//     public ABC(){
//         // JLabel l1 = new JLabel("Hello");
//         // add(l1);
        
//         t1 = new JTextField(20);
//         t2 = new JTextField(20);

//         Button b1 = new Button("Calculate");
//         j1 =new JLabel("Result");
//         add(t1);add(t2);add(b1);add(j1);
//         // int a = t1.

//         ///b1.addActionListener(this);
//         // b1.addActionListener(new ActionListener() {
            
//         //     @Override
//         //     public void actionPerformed(ActionEvent e) {
//         //         // TODO Auto-generated method stub
//         //         int num1 = Integer.parseInt(t1.getText()); 
//         //         int num2 = Integer.parseInt(t2.getText());
//         //         int num3 = num1+num2;
//         //         j1.setText(num3+ "");
//         //     }
//         // });

//         r1 = new JRadioButton("Male");
//         r2 = new JRadioButton("Female");
//         add(r1);add(r2);
//         ButtonGroup buttonGroup = new ButtonGroup();
//         buttonGroup.add(r1);
//         buttonGroup.add(r2);

//         b1.addActionListener(new ActionListener() {

//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // TODO Auto-generated method stub
//                 JLabel jj=null;
//                 String string = "";
//                 if(r1.isSelected()){
//                     string +="Mr."; 
//                 }
//                 else if (r2.isSelected()){
//                     string +="Ms."; 
//                 }
//                 jj.setText(string);
//                 add(jj);
//             }
            
//         });
        

//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setVisible(true);
//         setSize(400, 400);
//         setLayout(new FlowLayout());
        
//     }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     // TODO Auto-generated method stub
    //     int num1 = Integer.parseInt(t1.getText()); 
    //     int num2 = Integer.parseInt(t2.getText());
           //if(ae.getSource()==b1)     to check which button was pressed
    //     int num3 = num1+num2;
    //     j1.setText(num3+ "");
    //     //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    // }
//}
