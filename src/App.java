import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    JButton backButton = null;
    JPanel contPanel = null;
    JPanel InitialPanel = null;
    JPanel RegisterPagePanel = null;
    CardLayout cardLayout = null;
    InitialPage(){
        setTitle("Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);
        //setLayout(new CardLayout());
        cardLayout = new CardLayout();

        int labelwidth = 200,
            labelheight = 50;

        contPanel = new JPanel();
        contPanel.setLayout(cardLayout);
        InitialPanel = new JPanel();
        InitialPanel.setBackground(Color.cyan);
        RegisterPagePanel = new JPanel();
        RegisterPagePanel.setBackground(Color.LIGHT_GRAY);

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

        backButton = new JButton("Go back");
        backButton.setBounds(230,300,labelwidth-100,labelheight-25);
        backButton.setFont(new Font("Serif", Font.PLAIN,24));

        InitialPanel.add(name);
        InitialPanel.add(RollNo);
        InitialPanel.add(ProjName);
        InitialPanel.add(Start);
        RegisterPagePanel.add(backButton);
        
        contPanel.add(InitialPanel,"1");
        contPanel.add(RegisterPagePanel,"2");
        add(contPanel);
        Start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
            }
            
        });
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"1");
            }
            
        });
    }
}