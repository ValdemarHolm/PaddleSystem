package cli;

import model.PadelBat;
import model.PadelPlayer;
import service.PadelService;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class PadelCLI {
    private final Scanner input;
    private final PadelService service;

    public PadelCLI(Scanner input, PadelService service) {
        this.input = input;
        this.service = service;
    }

    public void mainMenu() {
        while (true) {
            printMenu();
            try {
                switch (ask("Vælg")) {
                    case "1" -> handlePlayersMenu();
                    case "2" -> handleBatsMenu();
                    case "3" -> System.exit(0);
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

    public void seeAllPlayers() throws SQLException {
        List<PadelPlayer> players = service.findAllPlayers();
        if (players.isEmpty()) {
            System.out.println("No players found.");
        }
        for (PadelPlayer player : players) {
            System.out.println(player);
        }
    }

    public void handlePlayersMenu() throws SQLException {
        printPlayersMenu();
        String choice = ask("Enter your choice: ");
        switch (choice) {
            case "1" -> seeAllPlayers();
            case "2" -> createPlayer();
//            case "3" -> editPlayer();
//            case "4" -> deletePlayer();
//            case "5" -> givePlayerABat();
//            case "6" -> editPlayersBat();
            case "7" -> mainMenu();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void createPlayer() throws SQLException{
        String name = ask("Enter player name: ");
        Integer age = Integer.parseInt(ask("Enter player age: "));
        Double level = Double.parseDouble(ask("Enter player level: "));
        String club = ask("Enter player club: ");
        Integer batId = Integer.parseInt(ask("Enter player bat id: "));
        service.addPlayer(name, age, level, club, batId);
    }

    public void handleBatsMenu() throws SQLException {
        printBatsMenu();
        String choice = ask("Enter your choice: ");
        switch (choice) {
            case "1" -> seeAllBats();
//            case "2" -> createBat();
//            case "3" -> editBat();
//            case "4" -> deleteBat();
            case "5" -> mainMenu();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void seeAllBats() throws SQLException {
        try {
            List<PadelBat> bats = service.findAllBats();
            if (bats.isEmpty()) {
                System.out.println("No bats found.");
            }
            for (PadelBat bat : bats) {
                System.out.println(bat);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving bats: " + e.getMessage());
        }

    }

    public void printMenu() {
        System.out.println("Welcome to Padel Database Menu CLI!\n");
        System.out.println("1. Players menu");
        System.out.println("2. Bats menu");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void printPlayersMenu() {
        System.out.println("1. See all players");
        System.out.println("2. Create player");
        System.out.println("3. Edit player");
        System.out.println("4. Delete player");
        System.out.println("5. Give player a bat");
        System.out.println("6. Edit players bat");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public void printBatsMenu() {
        System.out.println("1. See all bats");
        System.out.println("2. Create bat");
        System.out.println("3. Edit bat");
        System.out.println("4. Delete bat");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private String ask(String prompt) {
        System.out.print(prompt + ": ");
        return input.nextLine().strip();
    }
}
