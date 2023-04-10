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
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class App {
    
    public static void main(String[] args) throws Exception {
        InitialPage iPage = new InitialPage();
    }
}

class InitialPage extends JFrame{
    private Socket client = null;
    


    int labelwidth = 200,
        labelheight = 50;
    
    JButton InitialToRegister = null,
            RegisterBack = null,
            RegisterChoice  = null,
            RegisterAsOwner = null,
            RegisterAsOwnerBack = null,
            RegisterAsCustomer = null,
            RegisterAsCustomerBack = null,
            RegisterChoiceBack = null,
            SearchForProperty = null,
            SearchPropertyBack = null,
            UpdatePropertyDetails = null,
            UpdatePropertyBack = null,
            RemoveProperty = null,
            RemovePropertyBack = null;

    JPanel contPanel = null,
           InitialPanel = null,
           RegisterPagePanel = null,
           RegisterChoicePanel = null,
           RegisterAsOwnerPanel = null,
           RegisterAsCustomerPanel = null,
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
        RegisterChoicePanelSetup();
        registerAsOwnerPanelSetup();
        registerAsCustomerPanelSetup();
        SearchForPropertyPanelSetup();
        updatePropertyDetailsPanelSetup();
        removePropertyPanelSetup();
        
        contPanel.add(InitialPanel,"1");
        contPanel.add(RegisterPagePanel,"2");
        contPanel.add(RegisterChoicePanel,"3");
        contPanel.add(SearchForPropertyPanel,"4");
        contPanel.add(UpdatePropertyDetailsPanel,"5");
        contPanel.add(RemovePropertyPanel,"6");
        contPanel.add(RegisterAsOwnerPanel,"7");
        contPanel.add(RegisterAsCustomerPanel,"8");
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

        RegisterChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"3");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("1");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        RegisterChoiceBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("return");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        SearchForProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"4");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("2");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        SearchPropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("return");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        UpdatePropertyDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"5");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("1");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        UpdatePropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("return");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        RemoveProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"6");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("1");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        RemovePropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("return");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        RegisterAsOwner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel, "7");
            }
        });

        RegisterAsCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel, "8");
            }
        });

        RegisterAsOwnerBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel, "3");
            }
        });
        RegisterAsCustomerBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel, "3");
            }
        });
    }
    
    
    private void registerAsCustomerPanelSetup() {
        RegisterAsCustomerPanel = new JPanel();
        RegisterAsCustomerPanel.setBounds(0,0,600,600);
        RegisterAsCustomerPanel.setLayout(null);
        RegisterAsCustomerPanel.setBackground(Color.cyan);

        RegisterAsCustomerBack = new JButton("Go back");
        RegisterAsCustomerBack.setBounds(230,450,labelwidth-70,labelheight-25);
        RegisterAsCustomerBack.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterAsCustomerPanel.add(RegisterAsCustomerBack);
    }

    private void registerAsOwnerPanelSetup() {
        RegisterAsOwnerPanel = new JPanel();
        RegisterAsOwnerPanel.setBounds(0,0,600,600);
        RegisterAsOwnerPanel.setLayout(null);
        RegisterAsOwnerPanel.setBackground(Color.cyan);

        JLabel choice  = new JLabel("Fill Your Details.");
        choice.setBounds(200,10,labelwidth,labelheight);
        choice.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterAsOwnerPanel.add(choice);

        JLabel fName  = new JLabel("First Name:");
        fName.setBounds(50,44,labelwidth,labelheight);
        fName.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(fName);
        JTextField fNameF = new JTextField(50);
        fNameF.setBounds(220,62,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(fNameF);

        JLabel lName  = new JLabel("Last Name:");
        lName.setBounds(50,70,labelwidth,labelheight);
        lName.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(lName);
        JTextField lNameF = new JTextField(50);
        lNameF.setBounds(220,88,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(lNameF);

        JLabel PhNo = new JLabel("Contact Number:");
        PhNo.setBounds(50,96,labelwidth,labelheight);
        PhNo.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(PhNo);
        JTextField PhNoF = new JTextField(50);
        PhNoF.setBounds(220,114,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(PhNoF);

        JLabel DOB = new JLabel("DOB[YYYY-MM-DD]:");
        DOB.setBounds(50,122,labelwidth,labelheight);
        DOB.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(DOB);
        JTextField DOBF = new JTextField(50);
         DOBF.setBounds(220,140,labelwidth,labelheight-34);
         RegisterAsOwnerPanel.add(DOBF);

        JLabel property  = new JLabel("Enter Property Details.");
        property.setBounds(200,148,labelwidth+50,labelheight);
        property.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterAsOwnerPanel.add(property);

        JLabel address = new JLabel("Property Address:");
        address.setBounds(50,182,labelwidth,labelheight);
        address.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(address);
        JTextField addressF = new JTextField(50);
        addressF.setBounds(220,202,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(addressF);

        JLabel propCity = new JLabel("City:");
        propCity.setBounds(50,208,labelwidth,labelheight);
        propCity.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(propCity);
        JTextField propCityF = new JTextField(50);
        propCityF.setBounds(220,228,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(propCityF);

        JLabel propState = new JLabel("State:");
        propState.setBounds(50,234,labelwidth,labelheight);
        propState.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(propState);
        JTextField propStateF = new JTextField(50);
        propStateF.setBounds(220,254,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(propStateF);

        JLabel floorSize = new JLabel("Floor Size(Sq.Ft.):");
        floorSize.setBounds(50,260,labelwidth,labelheight);
        floorSize.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(floorSize);
        JTextField floorSizeF = new JTextField(50);
        floorSizeF.setBounds(220,280,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(floorSizeF);


        JLabel avlStatus = new JLabel("Availability Status:");
        avlStatus.setBounds(50,312,labelwidth,labelheight);
        avlStatus.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(avlStatus);
        String avlStatusOptions[] = {"Soon to be Available","Available for Rent","Available for Purchase",
                                    "Rented","Bought"};
        JComboBox<String> avlStatusC = new JComboBox<String>(avlStatusOptions);
        avlStatusC.setBounds(220,332,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(avlStatusC);

        JLabel propType = new JLabel("Property Type:");
        propType.setBounds(50,286,labelwidth,labelheight);
        propType.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(propType);
        String propTypeOptions[] = {"Apartment","House","Standalone Shop","Office building"};
        JComboBox<String> propTypeC = new JComboBox<String>(propTypeOptions);
        propTypeC.setBounds(220,306,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(propTypeC);
        
        propTypeC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //JLabel jl1 = null, jl2 = null, jl3 = null, jl4 = null, jl5 = null;
                //JTextField jt1 = null, jt2 = null, jt3 = null, jt4 = null, jt5 = null;
                JLabel jl1 = new JLabel();
                JLabel jl2 = new JLabel();
                JLabel jl3 = new JLabel();
                JLabel jl4 = new JLabel();
                JLabel jl5 = new JLabel();
                JTextField jt1 = new JTextField(50);
                JTextField jt2 = new JTextField(50);
                JTextField jt3 = new JTextField(50);
                JTextField jt4 = new JTextField(50);
                JTextField jt5 = new JTextField(50);

                jl1.setBounds(50,338,labelwidth,labelheight);
                jl1.setFont(new Font("Serif",Font.PLAIN,16));
                jt1.setBounds(220,358,labelwidth,labelheight-34);

                
                jl2.setBounds(50,364,labelwidth,labelheight);
                jl2.setFont(new Font("Serif",Font.PLAIN,16));
                jt2.setBounds(220,384,labelwidth,labelheight-34);

                
                jl3.setBounds(50,390,labelwidth,labelheight);
                jl3.setFont(new Font("Serif",Font.PLAIN,16));
                jt3.setBounds(220,410,labelwidth,labelheight-34);

                
                jl4.setBounds(50,416,labelwidth,labelheight);
                jl4.setFont(new Font("Serif",Font.PLAIN,16));
                jt4.setBounds(220,436,labelwidth,labelheight-34);

                
                jl5.setBounds(50,442,labelwidth,labelheight);
                jl5.setFont(new Font("Serif",Font.PLAIN,16));
                jt5.setBounds(220,462,labelwidth,labelheight-34);


                String item = (String)propTypeC.getSelectedItem();
                if(item == "Apartment" || item == "House"){
                    jl1.setText("Bedrooms:");jl2.setText("Bathrooms:");jl3.setText("Balconies:");
                    if(item == "Apartment"){
                        jl4.setText("Floor Number:");jl5.setText("Building Name:");
                    }   
                    else{
                        jl4.setText("Storeys:");jl5.setText("Garage Availability[Y/N]:");
                    }
                    RegisterAsOwnerPanel.add(jl1);RegisterAsOwnerPanel.add(jl2);RegisterAsOwnerPanel.add(jl3);
                    RegisterAsOwnerPanel.add(jl4);RegisterAsOwnerPanel.add(jl5);
                    RegisterAsOwnerPanel.add(jt1);RegisterAsOwnerPanel.add(jt2);RegisterAsOwnerPanel.add(jt3);
                    RegisterAsOwnerPanel.add(jt4);RegisterAsOwnerPanel.add(jt5);
                }
                else{
                    jl1.setText("Storeys:");RegisterAsOwnerPanel.add(jl1);RegisterAsOwnerPanel.add(jt1);
                    if(item == "Office building"){
                        jl2.setText("Cabins:");jl3.setText("Meeting Rooms:");jl4.setText("Cubicles:");
                        RegisterAsOwnerPanel.add(jl2);RegisterAsOwnerPanel.add(jl3);RegisterAsOwnerPanel.add(jl4);
                        RegisterAsOwnerPanel.add(jt2);RegisterAsOwnerPanel.add(jt3);RegisterAsOwnerPanel.add(jt4);
                    }
                    else{
                        jl2.setText("Number of Sections:");
                        RegisterAsOwnerPanel.add(jl2);RegisterAsOwnerPanel.add(jt2);
                    }
                }
            }
        });
        
        RegisterAsOwnerBack = new JButton("Go back");
        RegisterAsOwnerBack.setBounds(230,550,labelwidth-70,labelheight-25);
        RegisterAsOwnerBack.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterAsOwnerPanel.add(RegisterAsOwnerBack);
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

    private void RegisterChoicePanelSetup() {
        RegisterChoicePanel = new JPanel();
        RegisterChoicePanel.setBounds(0,0,600,600);
        RegisterChoicePanel.setLayout(null);
        RegisterChoicePanel.setBackground(Color.cyan);

        JLabel choice  = new JLabel("Select your choice.");
        choice.setBounds(200,30,labelwidth,labelheight);
        choice.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterChoicePanel.add(choice);

        RegisterAsOwner = new JButton("Register as Owner");
        RegisterAsOwner.setBounds(150,100,labelwidth+80,labelheight);
        RegisterAsOwner.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterChoicePanel.add(RegisterAsOwner);

        RegisterAsCustomer = new JButton("Register as Customer");
        RegisterAsCustomer.setBounds(150,200,labelwidth+80,labelheight);
        RegisterAsCustomer.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterChoicePanel.add(RegisterAsCustomer);

        RegisterChoiceBack = new JButton("Go back");
        RegisterChoiceBack.setBounds(230,450,labelwidth-70,labelheight-25);
        RegisterChoiceBack.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterChoicePanel.add(RegisterChoiceBack);
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

        RegisterChoice = new JButton("Register Your Property");
        RegisterChoice.setBounds(150,100,labelwidth+80,labelheight);
        RegisterChoice.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterPagePanel.add(RegisterChoice);

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