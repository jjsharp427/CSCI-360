import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public loginFrame() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 235);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton createAccountButton = new JButton("Create Account");

        usernameLabel.setBounds(20, 20, 80, 25);
        passwordLabel.setBounds(20, 50, 80, 25);
        usernameField.setBounds(120, 20, 200, 25);
        passwordField.setBounds(120, 50, 200, 25);
        loginButton.setBounds(145, 90, 100, 25);
        createAccountButton.setBounds(120, 130, 150, 25);

        // add to frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(createAccountButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action when login button is clicked
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action when create account button is clicked
                dispose(); // Close the login frame
                new CreateAccountFrame(); // Open the create account frame
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginFrame();
            }
        });
    }
}

class CreateAccountFrame extends JFrame {
    private JTextField nameField;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public CreateAccountFrame() {
        setTitle("Create Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(null);

        JLabel firstLastNameLabel = new JLabel("Name:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        nameField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton backButton = new JButton("Back");
        JButton confirmButton = new JButton("Confirm");

        firstLastNameLabel.setBounds(20, 20, 80, 25);
        usernameLabel.setBounds(20, 50, 80, 25);
        passwordLabel.setBounds(20, 80, 80, 25);
        nameField.setBounds(120, 20, 200, 25);
        usernameField.setBounds(120, 50, 200, 25);
        passwordField.setBounds(120, 80, 200, 25);
        backButton.setBounds(145, 120, 100, 25);
        confirmButton.setBounds(145, 157, 100, 25);

        add(firstLastNameLabel);
        add(usernameLabel);
        add(passwordLabel);
        add(nameField);
        add(usernameField);
        add(passwordField);
        add(backButton);
        add(confirmButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action when back button is clicked
                dispose(); // Close the create account frame
                new loginFrame(); // Open the login frame
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action when create account button is clicked
                String name = nameField.getText();
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // Push to dat file?
            }
        });

        setVisible(true);
    }
}
