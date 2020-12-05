package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
//AddCustomerGUI.java
/*This java class is accessed through the MainMenu.java. It receives its objects constructors through its constructor class Customers.java
 *This class asks the user to input custID, name and phone number and all details are validated then the system clarifies to the user are they sure about it with a confirmation message.Then the System
 * adds the details in the allCus ArrayList
 */

public class AddCustomerGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField custIDField;
    private JTextField nameField;
    private JTextField phoneNoField;

    public AddCustomerGUI()  {

        super("Add Customer");

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
    public void setImage(String s){
        return;
    }

    public static void main(String args[]) throws Exception{

        Object AddCustomer =new AddCustomerGUI();
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
            JOptionPane.showMessageDialog(null, "Add Customers Window Closed", "Remove Table Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Add Customers Window Minimised", "Add Customers Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Add Customers Window Unminimised", "Add Customers Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Add Customers Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Add Customers Window Deactivated");
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

        JButton btnAddCustomer = new JButton("Add Customers");

        btnAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File outfile = new File("Restaurant/customerData");

                     /* FileOutputStream Cus = new FileOutputStream(outfile);
                     Customers c1 = new Customers(1,"Dylan",112345678);
                      Customers c2 = new Customers(2,"Mary",1234567);
                      Customers c3 = new Customers(3,"Raymond",1233656);
                      Customers c4 = new Customers(4,"Tyler",12345432);
                      Customers c5 = new Customers(5,"Evan",1239944);
                      Customers c6 = new Customers(6,"Kyle",1874318);

                      ArrayList<Customers> allCus = new ArrayList<Customers>(Arrays.asList(c1,c2,c3,c4,c5,c6));
                      ObjectOutputStream CusOos = new ObjectOutputStream(Cus);

                      CusOos.writeObject(allCus);

                      CusOos.close();

                  } catch(FileNotFoundException fnfe){
                       System.out.println(fnfe.getStackTrace());
                       JOptionPane.showMessageDialog(null,"File could not be found!",
                               "Problem Finding File!",JOptionPane.ERROR_MESSAGE);*/

                    //File inFile = new File("Restaurant/customerData");
                    try {
                        //  FileInputStream inStream = new FileInputStream(inFile);

                        //ObjectInputStream objectInStream = new ObjectInputStream(inStream);

                     /*  Customers c1 = (Customers) objectInStream.readObject();
                         Customers c2 = (Customers) objectInStream.readObject();
                         Customers c3 = (Customers) objectInStream.readObject();
                         Customers c4 = (Customers) objectInStream.readObject();
                         Customers c5 = (Customers) objectInStream.readObject();
                         Customers c6 = (Customers) objectInStream.readObject();
                         Customers c7 = (Customers) objectInStream.readObject();
                         Customers c8 = (Customers) objectInStream.readObject();*/

                        //ArrayList<Customers> custObj = (ArrayList<Customers>) objectInStream.readObject();

                        //String custMix = "";

                        //for (Customers cs : custObj)
                        //  custMix += cs + "\n";

                        //inStream.close();
                        //  }
                        // catch(FileNotFoundException fnfe){
                        //   fnfe.printStackTrace();
                        // JOptionPane.showMessageDialog(null,"File could not be found!",
                        //       "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
                   /*  }
                     catch(IOException ioe){
                         ioe.printStackTrace();
                         JOptionPane.showMessageDialog(null,"File could not be read","problem writing to file",JOptionPane.ERROR_MESSAGE);
                     } catch (ClassNotFoundException cnfe) {
                         cnfe.printStackTrace();

                         JOptionPane.showMessageDialog(null,"Could not convert object to the appropriate class!","Problem Converting Object Read From File!",JOptionPane.ERROR_MESSAGE);


                     }

                     catch (ClassCastException cce) {
                         cce.printStackTrace();
                         JOptionPane.showMessageDialog(null,"Could not convert the object to the appropriate class!","Problem Converting Object!",JOptionPane.ERROR_MESSAGE);
                     }*/

                        int ci = 0;
                        String custId = custIDField.getText();
                        if (custId != null && !custId.isEmpty()) {
                            ci = Integer.parseInt(custId);
                        } else {
                            JOptionPane.showMessageDialog(null, "You did not enter a valid Customer ID", "Error!!", JOptionPane.ERROR_MESSAGE);
                        }
                        int nm = 0;
                        String name = nameField.getText();
                        if (name != null && !name.isEmpty()) {

                        } else {

                            JOptionPane.showMessageDialog(null, "You did not enter a valid name", "Error!!", JOptionPane.ERROR_MESSAGE);
                        }
                        long phnNum = 0;
                        String phn = phoneNoField.getText();
                        if (phn != null && !phn.isEmpty()) {
                            phnNum = Long.parseLong(phn);
                        } else {
                            JOptionPane.showMessageDialog(null, "You did not enter a valid phone number", "Error!!", JOptionPane.ERROR_MESSAGE);
                        }
                        Customers c1 = new Customers(1, "Dylan", 112345678);
                        Customers c2 = new Customers(2, "Mary", 1234567);
                        Customers c3 = new Customers(3, "Raymond", 1233656);
                        Customers c4 = new Customers(4, "Tyler", 12345432);
                        Customers c5 = new Customers(5, "Evan", 1239944);
                        Customers c6 = new Customers(6, "Kyle", 1874318);

                        Customers c = new Customers(ci, name, phnNum);
                        ArrayList<Customers> allCus = new ArrayList<Customers>(Arrays.asList(c1,c2,c3,c4,c5,c6));
                        allCus.add(c);
                        JOptionPane.showMessageDialog(null,"Table Details are added to the table file","Table Added",JOptionPane.INFORMATION_MESSAGE);

                    } catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                    }


                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }

            } });

        jpanel.add(btnAddCustomer);

        return jpanel;
    }
}
