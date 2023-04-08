import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    
    public static void main(String[] args) throws Exception {
        InitialPage iPage = new InitialPage();
        
    }
}

class InitialPage extends JFrame{
    JLabel name = null,
           RollNo = null,
           ProjName = null;
    JButton Start = null;

    InitialPage(){
        int labelwidth = 200, labelheight = 50;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);
        setLayout(null);

        name = new JLabel("Abhinandan Narang");
        name.setBounds(180,130,labelwidth,labelheight);
        name.setFont(new Font("Serif",Font.PLAIN,24));

        RollNo = new JLabel("2022mt93301");
        RollNo.setBounds(200,190,labelwidth,labelheight);
        RollNo.setFont(new Font("Serif",Font.PLAIN,24));

        ProjName = new JLabel("Real estate Renting and Selling.");
        ProjName.setBounds(150,250,labelwidth+150,labelheight);
        ProjName.setFont(new Font("Serif",Font.PLAIN,24));

        Start = new JButton("Start");
        Start.setBounds(230,300,labelwidth-100,labelheight-25);
        Start.setFont(new Font("Serif", Font.PLAIN,24));

        add(name);add(RollNo);add(ProjName);add(Start);
    }
}