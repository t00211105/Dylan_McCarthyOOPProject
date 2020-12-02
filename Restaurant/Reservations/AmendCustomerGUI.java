package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;


public class AmendCustomerGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField custIDField;
    private JTextField nameField;
    private JTextField phoneNoField;

    public AmendCustomerGUI()  {

        super("Amend Customer");

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

    }

    public static void main(String args[]){

        Object AmendCustomer =new AmendCustomerGUI();
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
            JOptionPane.showMessageDialog(null, "Amend Customer Window Closed", "Amend Customer Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Amend Customer Window Minimised", "Amend Customer Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Amend Customer Window Unminimised", "Amend CustomerWindow Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Amend Customer Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Amend Customer Window Deactivated");
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

        JLabel custIDLabel = new JLabel("Customer ID: ");
        addComponent(jpanel, custIDLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        custIDField = new JTextField(25);
        addComponent(jpanel, custIDField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel nameLabel = new JLabel("Customer Name: ");
        addComponent(jpanel, nameLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        nameField = new JTextField(25);
        addComponent(jpanel, nameField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        JLabel PhoneNoLabel = new JLabel("Phone Number: ");
        addComponent(jpanel, PhoneNoLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        phoneNoField = new JTextField(25);
        addComponent(jpanel, phoneNoField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

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

        JButton btnAmendCustomer = new JButton("Amend Customers");

        btnAmendCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ci = 0;
                    String custId = custIDField.getText();
                    if (custId != null && !custId.isEmpty()) {
                        ci = Integer.parseInt(custId);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid Customer ID", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                    int nm = 0;
                    String name = nameField.getText();
                    if (name!= null && !name.isEmpty()) {
                        nm = Integer.parseInt(name);
                    }
                    else {

                        JOptionPane.showMessageDialog(null, "You did not enter a valid name", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                    int phnNum=0;
                    String phn = phoneNoField.getText();
                    if (phn!= null && !phn.isEmpty()) {
                        phnNum = Integer.parseInt(phn);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "You did not enter a valid phone number", "Error!!", JOptionPane.ERROR_MESSAGE);

                    Customers c1 = new Customers(1,"Dylan",112345678);
                    Customers c2 = new Customers(2,"Mary",1234567);
                    Customers c3 = new Customers(3,"Raymond",1233656);
                    Customers c4 = new Customers(4,"Tyler",12345432);
                    Customers c5 = new Customers(5,"Evan",1239944);
                    Customers c6 = new Customers(6,"Kyle",1874318);

                    ArrayList<Customers> allCus = new ArrayList<Customers>(Arrays.asList(c1,c2,c3,c4,c5,c6));
                    ArrayList<Customers> foundCustomers = new ArrayList<Customers>();


                    int searchKey = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Customer ID you wish to amend"));
                    for (Customers Ac : allCus)
                        if (Ac.getCustID() == searchKey)
                            foundCustomers.add(Ac);

                    String text = "";

                    for (Customers Ac : foundCustomers)
                        if (Ac != null) {
                            text += Ac + "\n";
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following customers matched your search phrase\n\n" + text +
                            "\n\nPlease enter the id of the one you want to amend"));
                    Customers CustomerToAmend = null;

                    for (Customers Ac : foundCustomers)
                        if (Ac != null && Ac.getCustID() == searchID)
                            CustomerToAmend = Ac;

                    String amendChoice = JOptionPane.showInputDialog("The details of the customer you wish to amend are:\n\n" + CustomerToAmend + "\n\n1. Amend Customer ID\n2. Amend Customers Name" +
                            "\n3. Amend Customer Phone Number\n4. Exit Application\n\nPlease enter your choice");

                    int amendChoiceAsInt = Integer.parseInt(amendChoice);
                    while(amendChoiceAsInt<1 || amendChoiceAsInt>5){
                        amendChoice = JOptionPane.showInputDialog("The details of the Customers you wish to amend are:\n\n" +
                                CustomerToAmend + "\n\n1. Amend Customer ID\n2. Amend Name" +
                                "\n3. Amend Phone Number\n4. Exit Application\n\nInvalid choice entered!! Must be a value between 1 and 3 inclusive");

                        amendChoiceAsInt = Integer.parseInt(amendChoice);
                    }
                    switch(amendChoice){

                        case "1":
                            String newCustIdAsString = JOptionPane.showInputDialog("Please enter the new Customer Id for the Customers:");
                            int newCustId= Integer.parseInt(newCustIdAsString);
                            CustomerToAmend.setCustID(newCustId);
                            break;
                        case "2":
                            String newName = JOptionPane.showInputDialog("Please enter the new name for the Customers:");
                            CustomerToAmend.setName(newName);
                            break;
                        case "3":
                            String newPhnNoAsstring = JOptionPane.showInputDialog("Please enter the new phone number for the Customers:");
                            long newPhnNo=Long.parseLong(newPhnNoAsstring);
                            CustomerToAmend.setPhoneNo(newPhnNo);
                            break;
                        case "4":
                            break;
                    }

                    JOptionPane.showMessageDialog(null,"Customer details now amended!",
                            "Customer Amended",JOptionPane.INFORMATION_MESSAGE);
                    foundCustomers.clear();

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

        jpanel.add(btnAmendCustomer);

        return jpanel;
    }


}
