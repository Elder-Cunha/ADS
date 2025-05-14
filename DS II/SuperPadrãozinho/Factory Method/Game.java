import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        ScenarioFactory factory = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Where do you wanna play?");
        System.out.println("1 - Jungle");
        System.out.println("2 - Desert");
        String choice = scanner.nextLine();
        scanner.close();

        switch (choice){
            case "1": factory = new JungleFactory(); break;
            case "2": factory = new DesertFactory(); break;
            default: System.out.println("Either 1 to go to the Jungle, or 2 to go to the Desert"); break;
        }
        Scenario scenario = factory.createScenario();
        scenario.launchScenario();
    }
}
