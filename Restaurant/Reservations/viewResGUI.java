package Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

//ViewResGUI.java
/*This java class is accessed through the MainMenu.java. It receives its objects constructors through its constructor class Reservations.java
 *The system loads up a button that views all the objects in allRes arraylist and the user presses the button and Then the System displays all the details from the allRes ArrayList on a
 * JOptionPane Dialog box.
 */
public class viewResGUI extends JFrame {

    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);


    public viewResGUI()  {

        super("View Reservations");

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

    public static void main(String args[]){

        Object viewRes =new viewResGUI();
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
            JOptionPane.showMessageDialog(null, "View Reservation Window Closed", "Remove Table Window Closed",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "View Reservation Window Minimised", "Remove Table Window Minimised",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "View Reservation Window Unminimised", "Remove Table Window Unminimised",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenu mnu = new MainMenu();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("View Reservation Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("View Reservation Window Deactivated");
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

        JButton viewResButton = new JButton("View Reservations");

        viewResButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Reservations reservations;

                try {

                    Reservations r1 = new Reservations(1,1,1,1, new GregorianCalendar(2020,12,31),"CI",83.12f);
                    Reservations r2 = new Reservations(2,6,5,2, new GregorianCalendar(2020,12,12),"PB",73.12f);
                    Reservations r3 = new Reservations(3,5,3,2, new GregorianCalendar(2020,12,22),"CI",84.12f);
                    Reservations r4 = new Reservations(4,4,2,6, new GregorianCalendar(2020,12,21),"C",1223.12f);
                    Reservations r5 = new Reservations(5,3,4,5, new GregorianCalendar(2021,01,2),"W",13.12f);
                    Reservations r6 = new Reservations(6,2,7,4, new GregorianCalendar(2021,01,3),"W",123.12f);



                    ArrayList<AddResGUI> allRes = new ArrayList<AddResGUI>(Arrays.asList(r1,r2,r3,r4,r5,r6));
                        String allResData = "";
                        AddResGUI Ar;

                        Iterator<AddResGUI> iterator = allRes.iterator();
                    while (iterator.hasNext()) {
                        Ar = iterator.next();
                        if (Ar != null)
                            allResData += Ar + "\n";

                    }
                    JOptionPane.showMessageDialog(null,allResData,
                            "List of all Reservations",JOptionPane.INFORMATION_MESSAGE);




                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Date must be in the form dd-mm-yyyy", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalArgumentException iae) {
                        if(iae.getMessage().contains("0"))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Reservation ID", JOptionPane.ERROR_MESSAGE);
                        else if(iae.getMessage().contains("custID"))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid Customer ID", JOptionPane.ERROR_MESSAGE);
                        else if(iae.getMessage().contains("people"))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);
                        else if(iae.getMessage().contains("mdcemekc"))
                            JOptionPane.showMessageDialog(null, iae.getMessage(), "Invalid People Amount: ", JOptionPane.ERROR_MESSAGE);

                        else
                            JOptionPane.showMessageDialog(null, "The Date of Reservation must have day and month values that must be valid", "Invalid Date", JOptionPane.ERROR_MESSAGE);

                    }
                }});

        jpanel.add(viewResButton);

        return jpanel;
    }
}
