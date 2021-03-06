package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;

//RemoveCustomerGUI.java
/*This java class is accessed through the MainMenu.java. It receives its objects constructors through its constructor class Customers.java
 *This class asks the user to input custID and the system receives all the details from that specific custID then the system clarifies to the user are they sure about removing the object with a confirmation message.Then the System
 * removes the details from the allCus ArrayList
 */
public class RemoveCustomerGUI extends JFrame {

    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(30, 10, 0, 10);


    public RemoveCustomerGUI()  {

        super("Remove Customer");

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
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        setIconImage(new ImageIcon("res1.jpg").getImage());

    }

    public static void main(String args[]){

        Object RemoveCustomer = new RemoveCustomerGUI();
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
            JOptionPane.showMessageDialog(null, "Remove Customers Window Closed", "Remove Table Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove Customers Window Minimised", "Remove Customers Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove Customers Window Unminimised", "Remove Customers Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Remove Customers Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Remove Customers Window Deactivated");
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

        JButton btnRemoveCustomer = new JButton("Remove Customers");

        btnRemoveCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
/*****************************************************

 *    Title: RemoveCustomerGUI.java, lines 164-203

 *    Author: T0021105: Dylan McCarthy

 *    Site owner/sponsor:  John Brosnan lab 12/13/14

 *    Date: 5/12/2020

 *    Code version:  NA
 *
 *    Availability:  NA
 *

 *****************************************************/
                    Customers c1 = new Customers(1,"Dylan",112345678);
                    Customers c2 = new Customers(2,"Mary",1234567);
                    Customers c3 = new Customers(3,"Ryan",1233656);
                    Customers c4 = new Customers(4,"Tyler",12345432);
                    Customers c5 = new Customers(5,"Evan",1239944);
                    Customers c6 = new Customers(6,"Kyle",1874318);

                    ArrayList<Customers> allCus = new ArrayList<Customers>(Arrays.asList(c1,c2,c3,c4,c5,c6));
                    ArrayList<Customers> foundCustomers = new ArrayList<Customers>();
                    String searchKey = JOptionPane.showInputDialog("Please enter the id of the customer you wish to remove");
                    for (Customers rc: allCus)
                        if (rc.getName().toLowerCase().contains(searchKey.toLowerCase()))
                            foundCustomers.add(rc);

                    String text="";

                    for (Customers rc: foundCustomers)
                        if(rc!=null){
                            text+=rc+"\n";
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following customers matched your search phrase\n\n" + text +
                            "\n\nAre you sure?\nPlease re-enter the id of the one you want to remove"));
                    Customers CustomerToRemove=null;

                    for (Customers rc: foundCustomers)
                        if(rc!=null && rc.getCustID()==searchID)
                            CustomerToRemove =rc;
                    for (Customers rc: foundCustomers)
                        if(rc!=null && rc.getName().equals(searchID))
                            CustomerToRemove =rc;
                    for (Customers rc: foundCustomers)
                        if(rc!=null && rc.getPhoneNo()==searchID)
                            CustomerToRemove =rc;

                    int removeChoice = JOptionPane.showConfirmDialog(null,"The details of the customer you wish to amend are:\n\n" +
                            CustomerToRemove + "\n\nAre you sure you wish to remove this customer?","Customer Removal Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

                    if(removeChoice==JOptionPane.YES_OPTION) {
                        allCus.remove(CustomerToRemove);
                        JOptionPane.showMessageDialog(null, "Customer now removed from array list!",
                                "Customer Removed", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Customer removal canceled",
                                "Customer Not Removed", JOptionPane.INFORMATION_MESSAGE);

                    foundCustomers.clear();


                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer ID!", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer ID! ", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } });

        jpanel.add(btnRemoveCustomer);

        return jpanel;
    }
}
