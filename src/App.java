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
        setLayout(null);
        setBounds(100,100,600,600);
        
        cardLayout = new CardLayout();

        int labelwidth = 200,
            labelheight = 50;

        contPanel = new JPanel();
        contPanel.setLayout(cardLayout);
        contPanel.setBounds(0,0,600,600);

        initialPanelSetup(labelwidth,labelheight);
        registerPanelSetup(labelwidth,labelheight);
        
        contPanel.add(InitialPanel,"1");
        contPanel.add(RegisterPagePanel,"2");
        add(contPanel);
        buttonsSetup();
        
    }

    private void buttonsSetup() {
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

    private void registerPanelSetup(int labelwidth, int labelheight) {
        RegisterPagePanel = new JPanel();
        RegisterPagePanel.setBounds(0,0,600,600);
        RegisterPagePanel.setLayout(null);
        RegisterPagePanel.setBackground(Color.CYAN);

        backButton = new JButton("Go back");
        backButton.setBounds(230,300,labelwidth-100,labelheight-25);
        backButton.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterPagePanel.add(backButton);
    }

    private void initialPanelSetup(int labelwidth, int labelheight) {
        InitialPanel = new JPanel();
        InitialPanel.setBounds(0,0,600,600);
        InitialPanel.setLayout(null);
        InitialPanel.setBackground(Color.cyan);
        name = new JLabel("Abhinandan Narang");
        name.setBounds(180,130,labelwidth,labelheight);
        name.setFont(new Font("Serif",Font.PLAIN,24));
        InitialPanel.add(name);

        RollNo = new JLabel("2022mt93301");
        RollNo.setBounds(200,190,labelwidth,labelheight);
        RollNo.setFont(new Font("Serif",Font.PLAIN,24));
        InitialPanel.add(RollNo);

        ProjName = new JLabel("Real estate Renting and Selling.");
        ProjName.setBounds(150,250,labelwidth+150,labelheight);
        ProjName.setFont(new Font("Serif",Font.PLAIN,24));
        InitialPanel.add(ProjName);

        Start = new JButton("Start");
        Start.setBounds(230,300,labelwidth-100,labelheight-25);
        Start.setFont(new Font("Serif", Font.PLAIN,24));
        InitialPanel.add(Start);
    }
}