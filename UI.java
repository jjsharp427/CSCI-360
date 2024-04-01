package ProyectCodeFinal;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Login Frame
public class UI extends JFrame {
    
    //Initialize the values that we are going to use as fields
    private JTextField usernameField;
    private JPasswordField passwordField;

    //Create the Login Frame
    public UI() {
        //Set the frame
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 235);
        setLayout(null);

        //Declare the elements in the frame
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton createAccountButton = new JButton("Create Account");

        //Set the elements in the frame
        usernameLabel.setBounds(20, 20, 80, 25);
        passwordLabel.setBounds(20, 50, 80, 25);
        usernameField.setBounds(120, 20, 200, 25);
        passwordField.setBounds(120, 50, 200, 25);
        loginButton.setBounds(145, 90, 100, 25);
        createAccountButton.setBounds(120, 130, 150, 25);

        //Add elements to frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(createAccountButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText(); 
            String password = passwordField.getText();
            String fileName = "ProyectCodeFinal\\CustomerFiles\\customerlogin.txt"; 

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                boolean foundName = false;
                boolean foundPassword = false;
                File file = new File(fileName);

                if (file.length() == 0){
                    foundName = false;
                    foundPassword = false;
                }
                else{
                    while ((line = reader.readLine()) != null) {
                        if (line == username) {
                            foundName = true;
                        }

                        line = reader.readLine();
                        if (line == password){
                            foundPassword = true;
                            break;
                        } 
                        else{
                            break;
                        }
                    }
                }

                if (foundName == true && foundPassword == true) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Welcome back " + username + "!",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    dispose();
                    new FlightSelectionUI();

                } else if (foundName == false && foundPassword == false) {
                    JOptionPane.showMessageDialog(
                        this,
                        "You are not sign in!" + "\n" + "Create an Account please!",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    dispose();
                    new CreateAccountFrame();
                } else if (foundName == true && foundPassword == false) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Password incorrect!" + "\n" + "Try again or Create a new Account please!",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    foundName = false;
                    foundPassword = false;
                    
                } else if (foundName == false && foundPassword == true) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Username incorrect!" + "\n" + "Try again or Create a new Account please!",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    foundName = false;
                    foundPassword = false;
                }

            } catch (IOException i) {
                System.err.println("Error reading file: " + i.getMessage());
            }

            
        });

        //If Create Account Button is clicked
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the login frame
                new CreateAccountFrame(); // Open the create account frame
            }
        });

        setVisible(true);
    }



    //Class to create Account Frame
    class CreateAccountFrame extends JFrame {

        //Initialize the values that we are going to use
        private JTextField nameField;
        private JTextField usernameField;
        private JPasswordField passwordField;

        //Create the account Frame
        public CreateAccountFrame() {
            
            //Set the frame
            setTitle("Create Account");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 250);
            setLayout(null);

            //Declare the elements in the frame
            JLabel firstLastNameLabel = new JLabel("Name:");
            JLabel usernameLabel = new JLabel("Username:");
            JLabel passwordLabel = new JLabel("Password:");
            nameField = new JTextField();
            usernameField = new JTextField();
            passwordField = new JPasswordField();
            JButton backButton = new JButton("Back");
            JButton confirmButton = new JButton("Confirm");

            //Set the elements in the frame
            firstLastNameLabel.setBounds(20, 20, 80, 25);
            usernameLabel.setBounds(20, 50, 80, 25);
            passwordLabel.setBounds(20, 80, 80, 25);
            nameField.setBounds(120, 20, 200, 25);
            usernameField.setBounds(120, 50, 200, 25);
            passwordField.setBounds(120, 80, 200, 25);
            backButton.setBounds(145, 120, 100, 25);
            confirmButton.setBounds(145, 157, 100, 25);

            //Add the elements into the frame
            add(firstLastNameLabel);
            add(usernameLabel);
            add(passwordLabel);
            add(nameField);
            add(usernameField);
            add(passwordField);
            add(backButton);
            add(confirmButton);

            //If we click the back button --> Go back to the login frame
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action when back button is clicked
                    dispose(); // Close the create account frame
                    new UI(); // Open the login frame
                }
            });

            //If the Create Account Button is clicked--> 
            confirmButton.addActionListener(e -> {
                String name = nameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Customer customer = new Customer(name, username, password);
        
                JOptionPane.showMessageDialog(
                    this,
                    "Name: " + customer.getName() + "\n" +
                    "Username: " + customer.getUsername() + "\n" +
                    "Password: " + customer.getPassword(),
                    "Login",
                    JOptionPane.INFORMATION_MESSAGE
                );
        
                try {
                    customer.saveToFile("ProyectCodeFinal\\CustomerFiles\\customerlogin.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Error saving to file: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
    
                
                // Action when login button is clicked
                dispose();
                new FlightSelectionUI();
                
            });

            setVisible(true);
        }

    }


    public class FlightSelectionUI extends JFrame {
        private JComboBox<String> startAirportComboBox;
        private JComboBox<String> destAirportComboBox;
        private JComboBox<String> planeTypeComboBox;
    
        public FlightSelectionUI() {
            // Set up the JFrame
            setTitle("Flight Selection");
            setBackground(Color.ORANGE);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1000, 1000);
            setLayout(new GridLayout(4, 2, 10, 10));
            setLocationRelativeTo(null);
    
            // Create components
            JLabel startAirportLabel = new JLabel("Starting Airport:");
            JLabel destAirportLabel = new JLabel("Destination Airport:");
            JLabel planeTypeLabel = new JLabel("Plane Type:");
    
            startAirportComboBox = new JComboBox<>(new String[]{"Airport A", "Airport B", "Airport C"});
            destAirportComboBox = new JComboBox<>(new String[]{"Airport X", "Airport Y", "Airport Z"});
            planeTypeComboBox = new JComboBox<>(new String[]{"Type 1", "Type 2", "Type 3"});
    
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitButtonClickedFS();
                }
            });
    
            // Add components to the JFrame
            add(startAirportLabel);
            add(startAirportComboBox);
            add(destAirportLabel);
            add(destAirportComboBox);
            add(planeTypeLabel);
            add(planeTypeComboBox);
            add(new JLabel()); // Empty label for spacing
            add(submitButton);
    
            // Set JFrame visibility
            setVisible(true);
        }
    
        private void submitButtonClickedFS() {
            String startAirport = (String) startAirportComboBox.getSelectedItem();
            String destAirport = (String) destAirportComboBox.getSelectedItem();
            String planeType = (String) planeTypeComboBox.getSelectedItem();
    
            // Perform action with the selected values (e.g., print them)
            System.out.println("Start Airport: " + startAirport);
            System.out.println("Destination Airport: " + destAirport);
            System.out.println("Plane Type: " + planeType);
        }
    
    }

    //Main Function
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI();
            }
        });  
    }
}