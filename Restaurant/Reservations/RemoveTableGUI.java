package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;

//RemoveTableGUI.java
/*This java class is accessed through the MainMenu.java. It receives its objects constructors through its constructor class Tables.java
 *This class asks the user to input TableNo and the system receives all the details from that specific tableNo then the system clarifies to the user are they sure about removing the object with a confirmation message.Then the System
 * removes the details from the allTables ArrayList
 */
public class RemoveTableGUI extends JFrame {

    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField tableNoField;


    public RemoveTableGUI()  {

        super("Remove Table");
/*****************************************************

 *    Title: RemoveTableGUI.java, lines 40-55

 *    Author: T0021105: Dylan McCarthy

 *    Site owner/sponsor:  John Brosnan lab 12

 *    Date: 5/12/2020

 *    Code version:  NA
 *
 *    Availability:  NA
 *

 *****************************************************/

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
        /*****************************************************

         *    Title: RemoveTableGUI.java, lines 72-77

         *    Author: T0021105: Dylan McCarthy

         *    Site owner/sponsor:  John Brosnan

         *    Date: 5/12/2020

         *    Code version:  NA
         *
         *    Availability:  NA
         *

         *****************************************************/
        setIconImage(new ImageIcon("res1.jpg").getImage());

    }
    public void setIconImage(String s){
        return;
    }

    public static void main(String args[]){

        Object RemoveTable =new RemoveTableGUI();
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
            JOptionPane.showMessageDialog(null, "Remove Table Window Closed", "Remove Table Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove Table Window Minimised", "Remove Table Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Remove Table Window Unminimised", "Remove Table Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Remove Tables Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Remove Tables Window Deactivated");
        }
    }



    private JPanel createTitlePanel() {

        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Table Details");
        titleLabel.setFont(new Font("sans-serif",Font.PLAIN,18));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel tableNoLabel = new JLabel("Table Number: ");
        addComponent(jpanel, tableNoLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        tableNoField = new JTextField(25);
        addComponent(jpanel, tableNoField, 1, gridy++, 1, 1, topInsets,
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

        JButton btnRemoveTable = new JButton("Remove Tables");

        btnRemoveTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tables t1 = new Tables(1, 2, "High table", "A");
                Tables t2 = new Tables(2, 2, "High table", "A");
                Tables t3 = new Tables(3, 3, "Corner Table", "U");
                Tables t4 = new Tables(4, 4, "Window Table", "A");
                Tables t5 = new Tables(5, 1, "Balcony table", "U");
                Tables t6 = new Tables(6, 6, "Low table", "A");
                Tables t7 = new Tables(7, 5, "Circular table", "A");
                Tables t8 = new Tables(8, 4, "High table", "D");
                Tables t9 = new Tables(9, 4, "High table", "U");

                ArrayList<Tables> allTables = new ArrayList<Tables>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9 ));

                try {
                    int tN = 0;
                    String tableNo = tableNoField.getText();
                    if (tableNo != null && !tableNo.isEmpty()) {
                        tN = Integer.parseInt(tableNo);
                    } else {
                        JOptionPane.showMessageDialog(null, "You did not enter a valid table number", "Error!!", JOptionPane.ERROR_MESSAGE);

                    }

                    ArrayList<Tables> foundTables = new ArrayList<Tables>();
                    int searchKey = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of the table you wish to remove"));
                    for (Tables rt : allTables)
                        if (rt.getTableNo() == searchKey)
                            foundTables.add(rt);

                    String text = "";

                    for (Tables rt : foundTables)
                        if (rt != null) {
                            text += rt + "\n";
                        }
                    int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following tables matched your search phrase\n\n" + text +
                            "\n\nPlease enter the id of the one you want to remove"));
                    Tables TableToRemove = null;

                    for (Tables rt : foundTables)
                        if (rt != null && rt.getTableNo() == searchID)
                            TableToRemove = rt;

                    int removeChoice = JOptionPane.showConfirmDialog(null, "The table you wish to remove are:\n\n" +
                            TableToRemove + "\n\nAre you sure you wish to remove this Table?", "Table Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (removeChoice == JOptionPane.YES_OPTION) {
                        allTables.remove(TableToRemove);
                        JOptionPane.showMessageDialog(null, "Table now removed from array list!",
                                "Table Removed", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Table removal canceled",
                                "Table Not Removed", JOptionPane.INFORMATION_MESSAGE);

                    foundTables.clear();
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
            }});

        jpanel.add(btnRemoveTable);

        return jpanel;
    }
}
