package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//ViewCustomerGUI.java
/*This java class is accessed through the MainMenu.java. It receives its objects constructors through its constructor class Customers.java
 *The system loads up a button that views all the objects in customers and the user presses the button and Then the System displays all the details from the allCus ArrayList on a
 * JOptionPane Dialog box.
 */
public class ViewCustomerGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);

    public ViewCustomerGUI()  {

        super("View all Customers");

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));

        jpanel.add(Box.createVerticalStrut(50));
        jpanel.add(createTitlePanel());
        jpanel.add(createDetailsPanel());
        jpanel.add(Box.createVerticalStrut(40));
        jpanel.add(createSubmitPanel());
        jpanel.add(Box.createVerticalStrut(20));

        add(jpanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,200);
        setVisible(true);
        setResizable(false);
        setIconImage(new ImageIcon("res1.jpg").getImage());

    }

    public static void main(String args[]){

        Object ViewCustomer =new ViewCustomerGUI();
    }
    private class WindowEventHandler implements WindowListener {

        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Window now opened", "Window Opened",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        public void windowClosing(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Now closing window", "Closing Window",
                    JOptionPane.INFORMATION_MESSAGE);
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit this application?", "Exiting Application Confirmation",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (choice == JOptionPane.YES_OPTION)
                dispose();
        }

        @Override
        public void windowClosed(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "View Customers Window Closed", "View Table Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "View Customers Window Minimised", "View Customers Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "View Customers Window Unminimised", "View Customers Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("View Customers Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("View Customers Window Deactivated");
        }
    }



    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Customer Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;
        return jpanel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                              int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }

    private JPanel createSubmitPanel() {

        JPanel jpanel = new JPanel();

        JButton btnViewCustomer = new JButton("View All Customers");

        btnViewCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Customers c1 = new Customers(1,"Dylan",112345678);
                    Customers c2 = new Customers(2,"Mary",1234567);
                    Customers c3 = new Customers(3,"Raymond",1233656);
                    Customers c4 = new Customers(4,"Tyler",12345432);
                    Customers c5 = new Customers(5,"Evan",1239944);
                    Customers c6 = new Customers(6,"Kyle",1874318);

                    ArrayList<Customers> allCus = new ArrayList<Customers>(Arrays.asList(c1,c2,c3,c4,c5,c6));
                    String allCustomerData = "";
                    Customers ac;

                    Iterator<Customers> iterator = allCus.iterator();

                    while (iterator.hasNext()) {
                        ac = iterator.next();
                        if (ac != null)

                            allCustomerData += ac + "\n";
                    }
                    JOptionPane.showMessageDialog(null,allCustomerData,
                            "List of all Customers",JOptionPane.INFORMATION_MESSAGE);





                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer Id!", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog( null, iae.getMessage(), "Invalid Name!", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Phone Number! ", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } });

        jpanel.add(btnViewCustomer);

        return jpanel;
    }
}
