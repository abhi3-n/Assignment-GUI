import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class App {
    static private ServerSocket serverSocket = null;
    static BufferedReader bufferedReader = null;
    static InputStreamReader inputStreamReader = null;
    public static void main(String[] args) throws Exception {
        InitialPage iPage = new InitialPage();

        //getting number of clients and properties
        serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();
        inputStreamReader = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
        String message = bufferedReader.readLine();
        System.out.println(message);    //remove later
        serverSocket.close();
        socket.close();

        StringTokenizer st = new StringTokenizer(message," ");
        int numClients = Integer.parseInt(st.nextToken()),numProps = Integer.parseInt(st.nextToken());
        System.out.println(numClients+" "+numProps);  //remove later
        InitialPage.numClients = numClients;
        InitialPage.numProps = numProps;
    }
}

class InitialPage extends JFrame{
    static int numClients= 0; 
    static int numProps= 0; 
    static int brokerID = 1;

    private Socket client = null;
    JCheckBox alreadyReg = null;

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


    int labelwidth = 200,
        labelheight = 50;
    
    JButton InitialToRegister =     null,
            RegisterBack =          null,
            RegisterChoice  =       null,
            RegisterAsOwner =       null,
            FinalRegisterOwnerProperty = null,
            RegisterAsOwnerBack =   null,
            RegisterAsCustomer =    null,
            FinalRegisterCustomer = null,
            RegisterAsCustomerBack =null,
            RegisterChoiceBack =    null,
            SearchForProperty =     null,
            Search =                null,
            SearchPropertyBack =    null,
            SearchResultsBack =     null,
            UpdatePropertyDetails = null,
            ViewUpdateProperty =    null,
            FinalUpdate =           null,
            UpdatePropertyBack =    null,
            RemoveProperty =        null,
            ViewProperty =          null,
            FinalRemove =           null,
            RemovePropertyBack =    null;

    JPanel contPanel =              null,
           InitialPanel =           null,
           RegisterPagePanel =      null,
           RegisterChoicePanel =    null,
           RegisterAsOwnerPanel =   null,
           RegisterAsCustomerPanel =null,
           SearchForPropertyPanel = null,
           searchResultsPanel =     null,
           UpdatePropertyDetailsPanel = null,
           RemovePropertyPanel =    null;
    CardLayout cardLayout =         null;

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
        searchResultsPanelSetup();
        
        contPanel.add(InitialPanel,"1");
        contPanel.add(RegisterPagePanel,"2");
        contPanel.add(RegisterChoicePanel,"3");
        contPanel.add(SearchForPropertyPanel,"4");
        contPanel.add(UpdatePropertyDetailsPanel,"5");
        contPanel.add(RemovePropertyPanel,"6");
        contPanel.add(RegisterAsOwnerPanel,"7");
        contPanel.add(RegisterAsCustomerPanel,"8");
        contPanel.add(searchResultsPanel,"9");
        add(contPanel);
        buttonsSetup();
        
    }

    private void buttonsSetup() {
        
        InitialToRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"2");
                try {
                    client = new Socket("192.168.1.19",4444);
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);
                    printWriter.write("3");
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
                alreadyReg.setSelected(false);
                jl1.setVisible(false);jl2.setVisible(false);jl3.setVisible(false);jl4.setVisible(false);
                jl5.setVisible(false);     
                jt1.setVisible(false);jt2.setVisible(false);jt3.setVisible(false);jt4.setVisible(false);
                jt5.setVisible(false);                 
            }
        });
        RegisterAsCustomerBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel, "3");
            }
        });
        FinalRegisterOwnerProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        FinalRegisterCustomer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        ViewProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewProperty.setVisible(false);
                FinalRemove.setVisible(true);
            }
        });

        FinalRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ViewUpdateProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewUpdateProperty.setVisible(false);
                FinalUpdate.setVisible(true);
            }
        });

        FinalUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel, "9");
            }
        });

        SearchResultsBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contPanel,"4");
            }
        });
    }
    
    private void searchResultsPanelSetup() {
        searchResultsPanel = new JPanel();
        searchResultsPanel.setBounds(0,0,600,600);
        searchResultsPanel.setLayout(null);
        searchResultsPanel.setBackground(Color.cyan);

        JLabel heading  = new JLabel("Search Results.");
        heading.setBounds(200,10,labelwidth,labelheight);
        heading.setFont(new Font("Serif",Font.PLAIN,24));
        searchResultsPanel.add(heading);

        SearchResultsBack = new JButton("Go back");
        SearchResultsBack.setBounds(230,500,labelwidth-70,labelheight-25);
        SearchResultsBack.setFont(new Font("Serif", Font.PLAIN,24));
        searchResultsPanel.add(SearchResultsBack);
    }

    private void registerAsCustomerPanelSetup() {
        RegisterAsCustomerPanel = new JPanel();
        RegisterAsCustomerPanel.setBounds(0,0,600,600);
        RegisterAsCustomerPanel.setLayout(null);
        RegisterAsCustomerPanel.setBackground(Color.cyan);

        JLabel heading  = new JLabel("Fill Your Details.");
        heading.setBounds(200,10,labelwidth,labelheight);
        heading.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterAsCustomerPanel.add(heading);

        JLabel fName  = new JLabel("First Name:");
        fName.setBounds(50,44,labelwidth,labelheight);
        fName.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsCustomerPanel.add(fName);
        JTextField fNameF = new JTextField(50);
        fNameF.setBounds(220,62,labelwidth,labelheight-34);
        RegisterAsCustomerPanel.add(fNameF);

        JLabel lName  = new JLabel("Last Name:");
        lName.setBounds(50,70,labelwidth,labelheight);
        lName.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsCustomerPanel.add(lName);
        JTextField lNameF = new JTextField(50);
        lNameF.setBounds(220,88,labelwidth,labelheight-34);
        RegisterAsCustomerPanel.add(lNameF);

        JLabel PhNo = new JLabel("Contact Number:");
        PhNo.setBounds(50,96,labelwidth,labelheight);
        PhNo.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsCustomerPanel.add(PhNo);
        JTextField PhNoF = new JTextField(50);
        PhNoF.setBounds(220,114,labelwidth,labelheight-34);
        RegisterAsCustomerPanel.add(PhNoF);

        JLabel DOB = new JLabel("DOB[YYYY-MM-DD]:");
        DOB.setBounds(50,122,labelwidth,labelheight);
        DOB.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsCustomerPanel.add(DOB);
        JTextField DOBF = new JTextField(50);
         DOBF.setBounds(220,140,labelwidth,labelheight-34);
         RegisterAsCustomerPanel.add(DOBF);


         ///property type
        JLabel property  = new JLabel("Enter Required Property Details.");
        property.setBounds(150,148,labelwidth+150,labelheight);
        property.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterAsCustomerPanel.add(property);

        JLabel propType = new JLabel("Required Type");
        propType.setBounds(50,182,labelwidth,labelheight);
        propType.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsCustomerPanel.add(propType);
        String propTypeOptions[] = {"","Apartment","House","Standalone Shop","Office building"};
        JComboBox<String> propTypeC = new JComboBox<String>(propTypeOptions);
        propTypeC.setBounds(220,202,labelwidth,labelheight-34);
        RegisterAsCustomerPanel.add(propTypeC);
        

        JLabel propCity = new JLabel("City:");
        propCity.setBounds(50,208,labelwidth,labelheight);
        propCity.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsCustomerPanel.add(propCity);
        JTextField propCityF = new JTextField(50);
        propCityF.setBounds(220,228,labelwidth,labelheight-34);
        RegisterAsCustomerPanel.add(propCityF);

        JLabel propState = new JLabel("State:");
        propState.setBounds(50,234,labelwidth,labelheight);
        propState.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsCustomerPanel.add(propState);
        JTextField propStateF = new JTextField(50);
        propStateF.setBounds(220,254,labelwidth,labelheight-34);
        RegisterAsCustomerPanel.add(propStateF);
        
        FinalRegisterCustomer = new JButton("Register");
        FinalRegisterCustomer.setBounds(180,500,labelwidth-70,labelheight-25);
        FinalRegisterCustomer.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterAsCustomerPanel.add(FinalRegisterCustomer);
        
        RegisterAsCustomerBack = new JButton("Go back");
        RegisterAsCustomerBack.setBounds(330,500,labelwidth-70,labelheight-25);
        RegisterAsCustomerBack.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterAsCustomerPanel.add(RegisterAsCustomerBack);
    }

    private void registerAsOwnerPanelSetup() {
        RegisterAsOwnerPanel = new JPanel();
        RegisterAsOwnerPanel.setBounds(0,0,600,600);
        RegisterAsOwnerPanel.setLayout(null);
        RegisterAsOwnerPanel.setBackground(Color.cyan);

        JLabel heading  = new JLabel("Fill Your Details.");
        heading.setBounds(200,10,labelwidth,labelheight);
        heading.setFont(new Font("Serif",Font.PLAIN,24));
        RegisterAsOwnerPanel.add(heading);

        JLabel fName  = new JLabel("First Name:");
        fName.setBounds(50,44,labelwidth,labelheight);
        fName.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(fName);
        JTextField fNameF = new JTextField(50);
        fNameF.setBounds(220,62,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(fNameF);

        JLabel ownerID  = new JLabel("Enter your ID:");
        ownerID.setBounds(50,44,labelwidth,labelheight);
        ownerID.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(ownerID);
        JTextField ownerIDF = new JTextField(50);
        ownerIDF.setBounds(220,62,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(ownerIDF);
        ownerID.setVisible(false);
        ownerIDF.setVisible(false);

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

        alreadyReg = new JCheckBox("Registered Owner");
        alreadyReg.setBounds(440,60,labelwidth-70,labelheight-30);
        RegisterAsOwnerPanel.add(alreadyReg);
        

        alreadyReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(alreadyReg.isSelected()){
                    fName.setVisible(false);fNameF.setVisible(false);
                    lName.setVisible(false);lNameF.setVisible(false);
                    PhNo.setVisible(false);PhNoF.setVisible(false);
                    DOB.setVisible(false);DOBF.setVisible(false);
                    ownerID.setVisible(true);
                    ownerIDF.setVisible(true);
                }
                else{
                    fName.setVisible(true);fNameF.setVisible(true);
                    lName.setVisible(true);lNameF.setVisible(true);
                    PhNo.setVisible(true);PhNoF.setVisible(true);
                    DOB.setVisible(true);DOBF.setVisible(true);
                    ownerID.setVisible(false);
                    ownerIDF.setVisible(false);
                }
                
            }
        });



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
        String avlStatusOptions[] = {"","Soon to be Available","Available for Rent","Available for Purchase",
                                    "Rented","Bought"};
        JComboBox<String> avlStatusC = new JComboBox<String>(avlStatusOptions);
        avlStatusC.setBounds(220,332,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(avlStatusC);

        JLabel propType = new JLabel("Property Type:");
        propType.setBounds(50,286,labelwidth,labelheight);
        propType.setFont(new Font("Serif",Font.PLAIN,16));
        RegisterAsOwnerPanel.add(propType);
        String propTypeOptions[] = {"","Apartment","House","Standalone Shop","Office building"};
        JComboBox<String> propTypeC = new JComboBox<String>(propTypeOptions);
        propTypeC.setBounds(220,306,labelwidth,labelheight-34);
        RegisterAsOwnerPanel.add(propTypeC);
        RegisterAsOwnerPanel.add(jl1);RegisterAsOwnerPanel.add(jl2);RegisterAsOwnerPanel.add(jl3);
        RegisterAsOwnerPanel.add(jl4);RegisterAsOwnerPanel.add(jl5);
        RegisterAsOwnerPanel.add(jt1);RegisterAsOwnerPanel.add(jt2);RegisterAsOwnerPanel.add(jt3);
        RegisterAsOwnerPanel.add(jt4);RegisterAsOwnerPanel.add(jt5);
        propTypeC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                jl1.setVisible(false);jl2.setVisible(false);jl3.setVisible(false);jl4.setVisible(false);jl5.setVisible(false);
                jt1.setVisible(false);jt2.setVisible(false);jt3.setVisible(false);jt4.setVisible(false);jt5.setVisible(false);
                
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
                    jl1.setVisible(true);jl2.setVisible(true);jl3.setVisible(true);jl4.setVisible(true);jl5.setVisible(true);
                    jt1.setVisible(true);jt2.setVisible(true);jt3.setVisible(true);jt4.setVisible(true);jt5.setVisible(true);
                }
                else{
                    jl1.setText("Storeys:");RegisterAsOwnerPanel.add(jl1);RegisterAsOwnerPanel.add(jt1);
                    jl1.setVisible(true);jt1.setVisible(true);
                    if(item == "Office building"){
                        jl2.setText("Cabins:");jl3.setText("Meeting Rooms:");jl4.setText("Cubicles:");
                        RegisterAsOwnerPanel.add(jl2);RegisterAsOwnerPanel.add(jl3);RegisterAsOwnerPanel.add(jl4);
                        RegisterAsOwnerPanel.add(jt2);RegisterAsOwnerPanel.add(jt3);RegisterAsOwnerPanel.add(jt4);
                        jl2.setVisible(true);jl3.setVisible(true);jl4.setVisible(true);
                        jt2.setVisible(true);jt3.setVisible(true);jt4.setVisible(true);
                    }
                    else{
                        jl2.setText("Number of Sections:");
                        RegisterAsOwnerPanel.add(jl2);RegisterAsOwnerPanel.add(jt2);
                        jl2.setVisible(true);jt2.setVisible(true);
                    }
                }
            }
        });
        
        
        FinalRegisterOwnerProperty = new JButton("Register");
        FinalRegisterOwnerProperty.setBounds(180,500,labelwidth-70,labelheight-25);
        FinalRegisterOwnerProperty.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterAsOwnerPanel.add(FinalRegisterOwnerProperty);

        RegisterAsOwnerBack = new JButton("Go back");
        RegisterAsOwnerBack.setBounds(330,500,labelwidth-70,labelheight-25);
        RegisterAsOwnerBack.setFont(new Font("Serif", Font.PLAIN,24));
        RegisterAsOwnerPanel.add(RegisterAsOwnerBack);
    }

    
    private void removePropertyPanelSetup() {
        RemovePropertyPanel = new JPanel();
        RemovePropertyPanel.setBounds(0,0,600,600);
        RemovePropertyPanel.setLayout(null);
        RemovePropertyPanel.setBackground(Color.cyan);

        JLabel heading  = new JLabel("Remove Property from Portal");
        heading.setBounds(200,10,labelwidth+110,labelheight);
        heading.setFont(new Font("Serif",Font.PLAIN,24));
        RemovePropertyPanel.add(heading);    
        
        JLabel propID  = new JLabel("Enter Property ID:");
        propID.setBounds(50,44,labelwidth,labelheight);
        propID.setFont(new Font("Serif",Font.PLAIN,16));
        RemovePropertyPanel.add(propID);
        JTextField propIDF = new JTextField(50);
        propIDF.setBounds(220,62,labelwidth,labelheight-34);
        RemovePropertyPanel.add(propIDF);
        
        ViewProperty = new JButton("View Property");
        ViewProperty.setBounds(140,500,labelwidth-20,labelheight-25);
        ViewProperty.setFont(new Font("Serif", Font.PLAIN,24));
        RemovePropertyPanel.add(ViewProperty);

        FinalRemove = new JButton("Remove");
        FinalRemove.setVisible(false);
        FinalRemove.setBounds(180,500,labelwidth-70,labelheight-25);
        FinalRemove.setFont(new Font("Serif", Font.PLAIN,24));
        RemovePropertyPanel.add(FinalRemove);
        
        RemovePropertyBack = new JButton("Go back");
        RemovePropertyBack.setBounds(330,500,labelwidth-70,labelheight-25);
        RemovePropertyBack.setFont(new Font("Serif", Font.PLAIN,24));
        RemovePropertyPanel.add(RemovePropertyBack);
    }
    
    private void updatePropertyDetailsPanelSetup() {
        UpdatePropertyDetailsPanel = new JPanel();
        UpdatePropertyDetailsPanel.setBounds(0,0,600,600);
        UpdatePropertyDetailsPanel.setLayout(null);
        UpdatePropertyDetailsPanel.setBackground(Color.cyan);

        JLabel heading  = new JLabel("Update Property Details");
        heading.setBounds(200,10,labelwidth+100,labelheight);
        heading.setFont(new Font("Serif",Font.PLAIN,24));
        UpdatePropertyDetailsPanel.add(heading);  
        
        JLabel propID  = new JLabel("Enter Property ID:");
        propID.setBounds(50,44,labelwidth,labelheight);
        propID.setFont(new Font("Serif",Font.PLAIN,16));
        UpdatePropertyDetailsPanel.add(propID);
        JTextField propIDF = new JTextField(50);
        propIDF.setBounds(220,62,labelwidth,labelheight-34);
        UpdatePropertyDetailsPanel.add(propIDF);

        JLabel avlStatus = new JLabel("Availability Status:");
        avlStatus.setBounds(50,312,labelwidth,labelheight);
        avlStatus.setFont(new Font("Serif",Font.PLAIN,16));
        UpdatePropertyDetailsPanel.add(avlStatus);
        String avlStatusOptions[] = {"","Soon to be Available","Available for Rent","Available for Purchase",
                                    "Rented","Bought"};
        JComboBox<String> avlStatusC = new JComboBox<String>(avlStatusOptions);
        avlStatusC.setBounds(220,332,labelwidth,labelheight-34);
        UpdatePropertyDetailsPanel.add(avlStatusC);
        avlStatus.setVisible(false);avlStatusC.setVisible(false);
        

        ViewUpdateProperty = new JButton("View Property");
        ViewUpdateProperty.setBounds(140,500,labelwidth-20,labelheight-25);
        ViewUpdateProperty.setFont(new Font("Serif", Font.PLAIN,24));
        UpdatePropertyDetailsPanel.add(ViewUpdateProperty);
        ViewUpdateProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avlStatus.setVisible(true);avlStatusC.setVisible(true);
            }
        });

        FinalUpdate = new JButton("Update");
        FinalUpdate.setVisible(false);
        FinalUpdate.setBounds(180,500,labelwidth-70,labelheight-25);
        FinalUpdate.setFont(new Font("Serif", Font.PLAIN,24));
        UpdatePropertyDetailsPanel.add(FinalUpdate);
        
        UpdatePropertyBack = new JButton("Go back");
        UpdatePropertyBack.setBounds(330,500,labelwidth-70,labelheight-25);
        UpdatePropertyBack.setFont(new Font("Serif", Font.PLAIN,24));
        UpdatePropertyDetailsPanel.add(UpdatePropertyBack);
        UpdatePropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avlStatus.setVisible(false);avlStatusC.setVisible(false);
                ViewUpdateProperty.setVisible(true);
                FinalUpdate.setVisible(false);
            }
        });
    }

    private void SearchForPropertyPanelSetup() {
        SearchForPropertyPanel = new JPanel();
        SearchForPropertyPanel.setBounds(0,0,600,600);
        SearchForPropertyPanel.setLayout(null);
        SearchForPropertyPanel.setBackground(Color.cyan);

        JLabel heading  = new JLabel("Search for Properties");
        heading.setBounds(200,10,labelwidth+100,labelheight);
        heading.setFont(new Font("Serif",Font.PLAIN,24));
        SearchForPropertyPanel.add(heading); 
        
        //
        JCheckBox searchByType  = new JCheckBox("Search by Property Type");
        searchByType.setBounds(50,70,labelwidth,labelheight);
        searchByType.setFont(new Font("Serif",Font.PLAIN,16));
        SearchForPropertyPanel.add(searchByType);
        searchByType.setBackground(Color.CYAN);
        String propTypeOptions[] = {"","Apartment","House","Standalone Shop","Office building"};
        JComboBox<String> propTypeC = new JComboBox<String>(propTypeOptions);
        //JTextField searchByTypeF = new JTextField(50);
        propTypeC.setBounds(280,85,labelwidth,labelheight-25);
        SearchForPropertyPanel.add(propTypeC);
        propTypeC.setVisible(false);
        searchByType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchByType.isSelected()){
                    propTypeC.setVisible(true);
                }
                else{
                    propTypeC.setVisible(false);
                }
            }
        });

        JCheckBox searchByCity  = new JCheckBox("Search by City");
        searchByCity.setBounds(50,130,labelwidth,labelheight);
        searchByCity.setFont(new Font("Serif",Font.PLAIN,16));
        SearchForPropertyPanel.add(searchByCity);
        searchByCity.setBackground(Color.CYAN);
        JTextField searchByCityF = new JTextField(50);
        searchByCityF.setBounds(280,145,labelwidth,labelheight-25);
        SearchForPropertyPanel.add(searchByCityF);
        searchByCityF.setVisible(false);
        searchByCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchByCity.isSelected()){
                    searchByCityF.setVisible(true);
                }
                else{
                    searchByCityF.setVisible(false);
                }
            }
        });

        JCheckBox searchByState  = new JCheckBox("Search by State");
        searchByState.setBounds(50,190,labelwidth,labelheight);
        searchByState.setFont(new Font("Serif",Font.PLAIN,16));
        SearchForPropertyPanel.add(searchByState);
        searchByState.setBackground(Color.CYAN);
        JTextField searchByStateF = new JTextField(50);
        searchByStateF.setBounds(280,205,labelwidth,labelheight-25);
        SearchForPropertyPanel.add(searchByStateF);
        searchByStateF.setVisible(false);
        searchByState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchByState.isSelected()){
                    searchByStateF.setVisible(true);
                }
                else{
                    searchByStateF.setVisible(false);
                }
            }
        });
        

        Search = new JButton("Search");
        Search.setBounds(180,500,labelwidth-70,labelheight-25);
        Search.setFont(new Font("Serif", Font.PLAIN,24));
        SearchForPropertyPanel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        SearchPropertyBack = new JButton("Go back");
        SearchPropertyBack.setBounds(330,500,labelwidth-70,labelheight-25);
        SearchPropertyBack.setFont(new Font("Serif", Font.PLAIN,24));
        SearchForPropertyPanel.add(SearchPropertyBack);
        SearchPropertyBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByState.setSelected(false);searchByStateF.setVisible(false);
                searchByCity.setSelected(false);searchByCityF.setVisible(false);
                searchByType.setSelected(false);propTypeC.setVisible(false);
            }
        });
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

    private static int getClientID(){
        return ++numClients;
    } 
    private static int getPropertyID(){
        return ++numProps;
    } 

    private static int getBrokerID(){
        int tempbrokerID = (brokerID++)%4;;
        return (tempbrokerID!=0)?tempbrokerID:4; 
    }
}