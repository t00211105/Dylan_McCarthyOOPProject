package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
//RemoveResGUI.java
/*This java class is accessed through the MainMenu.java. It receives its objects constructors through its constructor class Reservations.java
 *This class asks the user to input resID and the system receives all the details from that specific resID then the system clarifies to the user are they sure about removing the object with a confirmation message.Then the System
 * removes the details from the allRes ArrayList
 */
public class RemoveResGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField resIDField;


    public RemoveResGUI()  {

        super("Remove Reservation");

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

        Object RemoveResGUI = new RemoveResGUI();
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
            JOptionPane.showMessageDialog(null, "Remove  Reservation Window Closed", "Remove Table Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove  Reservation Window Minimised", "Remove Table Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove  Reservation Window Unminimised", "Remove Table Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Remove  Reservation Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Remove Reservation Window Deactivated");
        }
    }



    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Reservation Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel resIDLabel = new JLabel("Reservation ID: ");
        addComponent(jpanel, resIDLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        resIDField = new JTextField(25);
        addComponent(jpanel, resIDField, 1, gridy++, 1, 1, topInsets,
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

        JButton RemoveResButton = new JButton("Cancel Reservation");

        RemoveResButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    try {
                        int rA = 0;
                        String ResI = resIDField.getText();
                        if (ResI != null && !ResI.isEmpty()) {
                            rA = Integer.parseInt(ResI);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You did not enter a valid reservation ID","Error!!",JOptionPane.ERROR_MESSAGE);

                        }
/*****************************************************

 *    Title: RemoveResGUI.java, lines 29

 *    Author: T0021105: Dylan McCarthy

 *    Site owner/sponsor:  John Brosnan lab 12

 *    Date: 5/12/2020

 *    Code version:  NA
 *
 *    Availability:  NA
 *

 *****************************************************/
                        ArrayList<Reservations> allRes = new ArrayList<Reservations>();
                        ArrayList<Reservations> foundRes = new ArrayList<Reservations>();
                        String searchKey = JOptionPane.showInputDialog("Please enter the ID of the reservation you wish to remove");
                        for (Reservations rr: allRes)
                            if (rr.getResID()==searchKey)
                                foundRes.add(rr);
                        for (Reservations rr: allRes)
                            if (rr.getTableNo()==Integer.parseInt(searchKey))
                                foundRes.add(rr);
                        for (Reservations rr: allRes)
                            if (rr.getCustID()==Integer.parseInt(searchKey))
                                foundRes.add(rr);
                        for (Reservations rr: allRes)
                            if (rr.getPeople()==searchKey)
                                foundRes.add(rr);
                        for (Reservations rr: allRes)
                            if (rr.getDate().equals(Integer.parseInt(searchKey)))
                                foundRes.add(rr);

                        String text="";

                        for (Reservations rr: foundRes)
                            if(rr!=null){
                                text+=rr+"\n";
                            }
                        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following reservations matched your search phrase\n\n" + text +
                                "\n\nPlease enter the id of the one you want to remove"));
                        Reservations ResToRemove=null;

                        for (Reservations rr: foundRes)
                            if(rr!=null && rr.getResID()==String.valueOf(searchID))
                                ResToRemove =rr;

                        int removeChoice = JOptionPane.showConfirmDialog(null,"The details of the reservations you wish to amend are:\n\n" +
                                ResToRemove + "\n\nAre you sure you wish to remove this reservation?","Reservation Removal Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

                        if(removeChoice==JOptionPane.YES_OPTION) {
                            allRes.remove(ResToRemove);
                            JOptionPane.showMessageDialog(null, "Reservation now removed from array list!",
                                    "Reservation Removed", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Reservation removal canceled",
                                    "Reservation Not Removed", JOptionPane.INFORMATION_MESSAGE);

                        foundRes.clear();

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Date must be in the form dd-mm-yyyy", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalArgumentException iae) {
                        if(iae.getMessage().contains("0"))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Reservation ID", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "The details of Reservation must have day and month values that must be valid", "Invalid Reservation Details", JOptionPane.ERROR_MESSAGE);

                    }
                } });

        jpanel.add(RemoveResButton);

        return jpanel;
    }
}
