import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    public static void main(String[] args) throws Exception {
        ABC abc = new ABC();
    }
}

class ABC extends JFrame{
    public ABC(){
        JLabel l1 = new JLabel("Hello");
        setVisible(true);
        setSize(400, 400);
        
    }
}
