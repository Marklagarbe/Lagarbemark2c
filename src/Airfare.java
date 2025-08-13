import java.util.Scanner;

public class Airfare {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the distance in kilometers:");
            double distance = scanner.nextDouble();
            
            System.out.println("Select the class (1 for Economy, 2 for Business):");
            int classType = scanner.nextInt();
            
            double baseFarePerKilometer;
            switch (classType) {
                case 1:
                    baseFarePerKilometer = 250; 
                case 2:
                    baseFarePerKilometer = 500;
                    break;
                default:
                    System.out.println("Invalid class type. Assuming Economy Class.");
                    baseFarePerKilometer = 250;
                    break;
            }
            
            double totalFare = distance * baseFarePerKilometer;
            
            if (distance > 1000) {
                totalFare *= 0.90; 
            }
            
            System.out.println("Total Fare: " + totalFare);
        }
    }
}
