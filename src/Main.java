package src;

import src.util.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }
}
