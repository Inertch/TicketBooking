import controllers.UserController;
import repositories.UserRepository;
import data.PostgresDB;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PostgresDB db = new PostgresDB("localhost", "postgres", "password", "cinema_db");

        UserRepository userRepository = new UserRepository(db);

        UserController userController = new UserController(userRepository);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();


        boolean authenticated = false;
        for (var user : userRepository.getAllUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                authenticated = true;
                break;
            }
        }

        if (authenticated) {
            System.out.println("Welcome!");

            while (true) {
                System.out.println("Press 1 to see all movies");
                System.out.println("Press 2 to book ticket");
                System.out.println("Press 3 to exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Movies available:");
                        //System.out.println(movieController.getAllMovies());
                        break;

                    case 2:
                        System.out.println("Booking a ticket is currently under development.");
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid email or password. Access denied.");
        }

        scanner.close();
    }
}