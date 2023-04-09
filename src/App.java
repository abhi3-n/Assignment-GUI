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
    int labelwidth = 200,
        labelheight = 50;
    
    JButton InitialToRegister = null,
            RegisterBack = null,
            RegisterProperty  = null,
            RegisterDetailsBack = null,
            SearchForProperty = null,
            SearchPropertyBack = null,
            UpdatePropertyDetails = null,
            UpdatePropertyBack = null,
            RemoveProperty = null,
            RemovePropertyBack = null;

    JPanel contPanel = null,
           InitialPanel = null,
           RegisterPagePanel = null,
           RegisterDetailsPanel = null,
           SearchForPropertyPanel = null,
           UpdatePropertyDetailsPanel = null,
           RemovePropertyPanel = null;
    CardLayout cardLayout = null;

    InitialPage(){
        setTitle("Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(100,100,600,600);
        
        cardLayout = new CardLayout();
        
        contPanel = new JPanel();
        contPanel.setLayout(cardLayout);
        contPanel.setBounds(0,0,600,600);

        initialPanelSetup();
        registerPanelSetup();
        registerDetailsPanelSetup();
        SearchForPropertyPanelSetup();
        updatePropertyDetailsPanelSetup();
        removePropertyPanelSetup();
        
        contPanel.add(InitialPanel,"1");
        contPanel.add(RegisterPagePanel,"2");
        contPanel.add(RegisterDetailsPanel,"3");
        contPanel.add(SearchForPropertyPanel,"4");
        contPanel.add(UpdatePropertyDetailsPanel,"5");
        contPanel.add(RemovePropertyPanel,"6");
        add(contPanel);
        buttonsSetup();
        
    }

    private void buttonsSetup() {
        
        InitialToRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
            }
        });

        RegisterBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"1");
            }    
        });

        RegisterProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"3");
            }
        });

        RegisterDetailsBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
            }
        });

        SearchForProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"4");
            }
        });

        SearchPropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
            }
        });

        UpdatePropertyDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"5");
            }
        });

        UpdatePropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
            }
        });

        RemoveProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"6");
            }
        });

        RemovePropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
            }
        });
    }

    private void removePropertyPanelSetup() {
        RemovePropertyPanel = new JPanel();
        RemovePropertyPanel.setBounds(0,0,600,600);
        RemovePropertyPanel.setLayout(null);
        RemovePropertyPanel.setBackground(Color.cyan);

        
        
        RemovePropertyBack = new JButton("Go back");
        RemovePropertyBack.setBounds(230,450,labelwidth-70,labelheight-25);
        RemovePropertyBack.setFont(new Font("Serif", Font.PLAIN,24));
        RemovePropertyPanel.add(RemovePropertyBack);
    }
    
    private void updatePropertyDetailsPanelSetup() {
        UpdatePropertyDetailsPanel = new JPanel();
        UpdatePropertyDetailsPanel.setBounds(0,0,600,600);
        UpdatePropertyDetailsPanel.setLayout(null);
        UpdatePropertyDetailsPanel.setBackground(Color.cyan);

        
        
        UpdatePropertyBack = new JButton("Go back");
        UpdatePropertyBack.setBounds(230,450,labelwidth-70,labelheight-25);
        UpdatePropertyBack.setFont(new Font("Serif", Font.PLAIN,24));
        UpdatePropertyDetailsPanel.add(UpdatePropertyBack);
    }

    private void SearchForPropertyPanelSetup() {
        SearchForPropertyPanel = new JPanel();
        SearchForPropertyPanel.setBounds(0,0,600,600);
        SearchForPropertyPanel.setLayout(null);
        SearchForPropertyPanel.setBackground(Color.cyan);

        
        SearchPropertyBack = new JButton("Go back");
        SearchPropertyBack.setBounds(230,450,labelwidth-70,labelheight-25);
        SearchPropertyBack.setFont(new Font("Serif", Font.PLAIN,24));
        SearchForPropertyPanel.add(SearchPropertyBack);
    }

    private void registerDetailsPanelSetup() {
        RegisterDetailsPanel = new JPanel();
        RegisterDetailsPanel.setBounds(0,0,600,600);
        RegisterDetailsPanel.setLayout(null);
        RegisterDetailsPanel.setBackground(Color.cyan);

        RegisterDetailsBack = new JButton("Go back");
        RegisterDetailsBack.setBounds(230,450,labelwidth-70,labelheight-25);
        RegisterDetailsBack.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterDetailsPanel.add(RegisterDetailsBack);
    }

    private void registerPanelSetup() {
        RegisterPagePanel = new JPanel();
        RegisterPagePanel.setBounds(0,0,600,600);
        RegisterPagePanel.setLayout(null);
        RegisterPagePanel.setBackground(Color.CYAN);

        JLabel choice  = new JLabel("Select your choice.");
        choice.setBounds(200,30,labelwidth,labelheight);
        choice.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterPagePanel.add(choice);

        RegisterProperty = new JButton("Register Your Property");
        RegisterProperty.setBounds(150,100,labelwidth+80,labelheight);
        RegisterProperty.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterPagePanel.add(RegisterProperty);

        SearchForProperty = new JButton("Search for Property");
        SearchForProperty.setBounds(150,200,labelwidth+80,labelheight);
        SearchForProperty.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterPagePanel.add(SearchForProperty);

        UpdatePropertyDetails = new JButton("Update Property Details");
        UpdatePropertyDetails.setBounds(150,300,labelwidth+80,labelheight);
        UpdatePropertyDetails.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterPagePanel.add(UpdatePropertyDetails);

        RemoveProperty = new JButton("Remove Property");
        RemoveProperty.setBounds(150,400,labelwidth+80,labelheight);
        RemoveProperty.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterPagePanel.add(RemoveProperty);

        RegisterBack = new JButton("Go back");
        RegisterBack.setBounds(230,500,labelwidth-70,labelheight-25);
        RegisterBack.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterPagePanel.add(RegisterBack);
    }

    private void initialPanelSetup() {
        InitialPanel = new JPanel();
        InitialPanel.setBounds(0,0,600,600);
        InitialPanel.setLayout(null);
        InitialPanel.setBackground(Color.cyan);

        JLabel name = new JLabel("Abhinandan Narang");
        name.setBounds(180,130,labelwidth,labelheight);
        name.setFont(new Font("Serif",Font.PLAIN,24));
        InitialPanel.add(name);

        JLabel RollNo = new JLabel("2022mt93301");
        RollNo.setBounds(200,190,labelwidth,labelheight);
        RollNo.setFont(new Font("Serif",Font.PLAIN,24));
        InitialPanel.add(RollNo);

        JLabel ProjName = new JLabel("Real estate Renting and Selling.");
        ProjName.setBounds(150,250,labelwidth+150,labelheight);
        ProjName.setFont(new Font("Serif",Font.PLAIN,24));
        InitialPanel.add(ProjName);

        InitialToRegister = new JButton("Start");
        InitialToRegister.setBounds(230,300,labelwidth-100,labelheight-25);
        InitialToRegister.setFont(new Font("Serif", Font.PLAIN,24));
        InitialPanel.add(InitialToRegister);
    }
}