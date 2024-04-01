package ProyectCodeFinal;

import java.io.FileWriter;
import java.io.IOException;

public class Customer {
    private String name;
    private String username;
    private String password;

    public Customer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void saveToFile(String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName, true);) {
            fileWriter.append(name);
            fileWriter.append(System.lineSeparator());
            fileWriter.append(username);
            fileWriter.append(System.lineSeparator());
            fileWriter.append(password);
            fileWriter.append(System.lineSeparator());
        }
    }
}
