import cli.PadelCLI;
import repository.PadelRepository;
import service.PadelService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PadelRepository repository = new PadelRepository();
        PadelService service = new PadelService(repository); // Pass the initialized repository to the PadelService constructor
        PadelCLI cli = new PadelCLI(input, service);
        cli.mainMenu();
    }
}