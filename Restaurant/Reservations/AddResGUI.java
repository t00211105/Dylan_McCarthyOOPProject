package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.*;
//AddResGUI.java
/*This java class is accessed through the MainMenu.java. It receives its objects constructors through its constructor class Reservations.java
 *This class asks the user to input ResID,tableNo,custID,people,date,status, billAmount and all details are validated then the system clarifies to the user are they sure about it with a confirmation message.Then the System
 * adds the details in the allRes ArrayList
 */
    public class AddResGUI extends JFrame {

        private Insets normalInsets = new Insets(10, 10, 0, 10);
        private Insets topInsets = new Insets(30, 10, 0, 10);
        private JTextField resIDField;
        private JTextField tableNoField;
        private JTextField custIDField;
        private JTextField peopleField;
        private JTextField dateField;
        private JTextField resStatusField;
        private JTextField billAmountField;
        private GregorianCalendar dateChosen;

        public AddResGUI() {

            super("Add Reservation");

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
            setSize(500, 500);
            setVisible(true);
            setResizable(false);
            setIconImage(new ImageIcon("res1.jpg").getImage());

        }

        public static void main(String args[])throws Exception {

            Object AddRes = new AddResGUI();
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
                JOptionPane.showMessageDialog(null, "Add Reservation Window Closed", "Remove Table Window Closed",
                        JOptionPane.INFORMATION_MESSAGE);

                MainMenu mnu = new MainMenu();
            }

            @Override
            public void windowIconified(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Add Reservation Window Minimised", "Remove Table Window Minimised",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Add Reservation Window Unminimised", "Remove Table Window Unminimised",
                        JOptionPane.INFORMATION_MESSAGE);

                MainMenu mnu = new MainMenu();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Add Reservation Window Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Add Reservation Window Deactivated");
            }
        }


        private JPanel createTitlePanel() {

            JPanel jpanel = new JPanel();

            JLabel titleLabel = new JLabel("Reservation Details");
            titleLabel.setFont(new Font("sans-serif", Font.PLAIN, 18));

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

            JLabel tableNoLabel = new JLabel("Table Number: ");
            addComponent(jpanel, tableNoLabel, 0, gridy, 1, 1, topInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            tableNoField = new JTextField(25);
            addComponent(jpanel, tableNoField, 1, gridy++, 1, 1, topInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            JLabel peopleLabel = new JLabel("People Amount: ");
            addComponent(jpanel, peopleLabel, 0, gridy, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            peopleField = new JTextField(25);
            addComponent(jpanel, peopleField, 1, gridy++, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            JLabel custIDLabel = new JLabel("Customer ID: ");
            addComponent(jpanel, custIDLabel, 0, gridy, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            custIDField = new JTextField(25);
            addComponent(jpanel, custIDField, 1, gridy++, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            JLabel resStatusLabel = new JLabel("Reservation Status: ");
            addComponent(jpanel, resStatusLabel, 0, gridy, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            resStatusField = new JTextField(1);
            addComponent(jpanel, resStatusField, 1, gridy++, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            JLabel dateLabel = new JLabel("Date of reservation: ");
            addComponent(jpanel, dateLabel, 0, gridy, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            dateField = new JTextField(25);
            dateField.setText("enter in form dd-mm-yyyy or use date-chooser");
            addComponent(jpanel, dateField, 1, gridy, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            JButton dateButton = new JButton("...");
            dateButton.setPreferredSize(new Dimension(20, 15));
            addComponent(jpanel, dateButton, 2, gridy++, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
            dateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DateChooser dateChooser = new DateChooser(AddResGUI.this);
                    dateChosen = dateChooser.getDateChosen();
/*****************************************************

 *    Title: DateChooser.java

 *    Author: T0021105: Dylan McCarthy

 *    Site owner/sponsor:  John Brosnan Mini-Project-stuff

 *    Date: 5/12/2020

 *    Code version:  NA
 *
 *    Availability:  NA
 *

 *****************************************************/
                    if (dateChosen != null) {
                        System.out.println(dateChosen.get(Calendar.DATE) + "-" +
                                dateChosen.get(Calendar.MONTH) + "-" +
                                dateChosen.get(Calendar.YEAR));

                        String dayString = "", monthString = "";

                        if (dateChosen.get(Calendar.DATE) < 10)
                            dayString = "0" + dateChosen.get(Calendar.DATE);
                        else
                            dayString = "" + dateChosen.get(Calendar.DATE);

                        if (dateChosen.get(Calendar.MONTH) < 10)
                            monthString = "0" + dateChosen.get(Calendar.MONTH);
                        else
                            monthString = "" + dateChosen.get(Calendar.MONTH);

                        dateField.setText(dayString + "-" + monthString + "-" + dateChosen.get(Calendar.YEAR));
                    }
                }
            });
            JLabel billAmountLabel = new JLabel("Bill Amount: ");
            addComponent(jpanel, billAmountLabel, 0, gridy, 1, 1, normalInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

            billAmountField = new JTextField(1);
            addComponent(jpanel, billAmountField, 1, gridy++, 1, 1, normalInsets,
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

            JButton addButton = new JButton("Add Reservation");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String date = dateField.getText();

                    /*(ArrayList<Reservations> allRes = new ArrayList<>();

                    Reservations r1 = new Reservations(1, 1, 1, 1,new GregorianCalendar(2021,4,4), "CI", 83.12f);
                    Reservations r2 = new Reservations(2, 6, 5, 2,new GregorianCalendar(2021,3,21), "PB", 73.12f);
                    Reservations r3 = new Reservations(3, 5, 3, 2,new GregorianCalendar(2021,2,2), "CI", 84.12f);
                    Reservations r4 = new Reservations(4, 4, 2, 6,new GregorianCalendar(2020,12,25), "C", 1223.12f);
                    Reservations r5 = new Reservations(5, 3, 4, 5, new GregorianCalendar(2021,1,23), "W", 13.12f);
                    Reservations r6 = new Reservations(6, 2, 7, 4, new GregorianCalendar(2020,12,12), "W", 123.12f);
                    allRes.add(r1);
                    allRes.add(r2);
                    allRes.add(r3);
                    allRes.add(r4);
                    allRes.add(r5);
                    allRes.add(r6);*/
                    /*try
                    {
                        FileOutputStream resStream = new FileOutputStream("resData");
                        ObjectOutputStream ResOut = new ObjectOutputStream(resStream);
                        ResOut.writeObject(allRes);
                        ResOut.close();
                        resStream.close();
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }*/
/*****************************************************

 *    Title: DateChooser.java

 *    Author: T0021105: Dylan McCarthy

 *    Site owner/sponsor:  John Brosnan Mini-Project-stuff

 *    Date: 5/12/2020

 *    Code version:  NA
 *
 *    Availability:  NA
 *

 *****************************************************/
                    if (date.length() >= 7) { //if date of birth comes from the date chooser app it'll be good anyway but
                        //                    //we need some tests if the user supplies it manually in the text-field

                        try {
                            int day = Integer.parseInt(date.substring(0, 2));
                            int month = Integer.parseInt(date.substring(3, 5));
                            int year = Integer.parseInt(date.substring(6, date.length()));

                            GregorianCalendar dateGC = new GregorianCalendar(year, month - 1, day);
                            dateGC.setLenient(false); //do this to ensure values like 13 are considered invalid as the month value, 32 invalid as the day value etc
                            dateGC.getTime(); //throws an exception if the date of birth was dodgy

                            System.out.println(dateGC.get(Calendar.DATE) + "-" +
                                    (dateGC.get(Calendar.MONTH) + 1) + "-" +
                                    dateGC.get(Calendar.YEAR));

                            float bA = 0;
                            String billA = billAmountField.getText();
                            if (billA != null && !billA.isEmpty()) {
                                bA = Float.parseFloat(billA);
                            } else {
                                JOptionPane.showMessageDialog(null, "You did not enter a valid bill Amount", "Error!!", JOptionPane.ERROR_MESSAGE);

                            }
                            int rA = 0;
                            String ResI = resIDField.getText();
                            if (ResI != null && !ResI.isEmpty()) {
                                rA = Integer.parseInt(ResI);
                            } else {
                                JOptionPane.showMessageDialog(null, "You did not enter a valid reservation ID", "Error!!", JOptionPane.ERROR_MESSAGE);
                            }
                            int tN = 0;
                            String TabN = tableNoField.getText();
                            if (TabN != null && !TabN.isEmpty()) {
                                tN = Integer.parseInt(TabN);
                            } else {
                                JOptionPane.showMessageDialog(null, "You did not enter a valid table number", "Error!!", JOptionPane.ERROR_MESSAGE);

                            }
                            int cus = 0;
                            String CusI = custIDField.getText();
                            if (CusI != null && !CusI.isEmpty()) {
                                cus = Integer.parseInt(CusI);
                            } else {
                                JOptionPane.showMessageDialog(null, "You did not enter a valid customer ID!", "Error!!", JOptionPane.ERROR_MESSAGE);
                            }
                            int ppl = 0;
                            String Pp = peopleField.getText();
                            if (Pp != null && !Pp.isEmpty()) {
                                ppl = Integer.parseInt(Pp);
                            } else {
                                JOptionPane.showMessageDialog(null, "You did not enter a valid people  amount  ", "Error!!", JOptionPane.ERROR_MESSAGE);

                            }



                            Reservations r1 = new Reservations(1, 1, 1, 1,new GregorianCalendar(2021,4,4), "CI", 83.12f);
                            Reservations r2 = new Reservations(2, 6, 5, 2,new GregorianCalendar(2021,3,21), "PB", 73.12f);
                            Reservations r3 = new Reservations(3, 5, 3, 2,new GregorianCalendar(2021,2,2), "CI", 84.12f);
                            Reservations r4 = new Reservations(4, 4, 2, 6,new GregorianCalendar(2020,12,25), "C", 1223.12f);
                            Reservations r5 = new Reservations(5, 3, 4, 5, new GregorianCalendar(2021,1,23), "W", 13.12f);
                            Reservations r6 = new Reservations(6, 2, 7, 4, new GregorianCalendar(2020,12,12), "W", 123.12f);
                            ArrayList<Reservations> allRes = new ArrayList<>(Arrays.asList(r1,r2,r3,r4,r5,r6));



                            Reservations r = new Reservations(rA, tN, cus, ppl, dateGC, resStatusField.getText(), bA);
                            allRes.add(r);

                            JOptionPane.showMessageDialog(null, "Reservation details added\n\nDetails are:  " + r, "Reservation Is Added", JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(null, "Date must be in the form dd-mm-yyyy", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException iae) {
                            if (iae.getMessage().contains("0"))
                                JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Reservation ID", JOptionPane.ERROR_MESSAGE);
                            else if (iae.getMessage().contains("custID"))
                                JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer ID", JOptionPane.ERROR_MESSAGE);
                            else if (iae.getMessage().contains("people"))
                                JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);
                            else if (iae.getMessage().contains("mdcemekc"))
                                JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);

                            else
                                JOptionPane.showMessageDialog(null, "The Date of Reservation must have day and month values that must be valid", "Invalid Date", JOptionPane.ERROR_MESSAGE);

                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Date of Reservation must be at least 7 characters long", "Invalid Date of Reservation", JOptionPane.ERROR_MESSAGE);
                }
            });

            jpanel.add(addButton);

            return jpanel;
        }
    }

