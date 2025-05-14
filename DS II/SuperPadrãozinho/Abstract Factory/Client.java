public class Client {

    public Client(String factory){
        AbstractAnimalFactory concreteFactory = whichFactory(factory);
        System.out.println(concreteFactory);
    }

    public Client(String factory, String action, String targetOrDestination){
        AbstractAnimalFactory concreteFactory = whichFactory(factory);
        System.out.println(concreteFactory);
        whichAction(concreteFactory, action, targetOrDestination);
    }

    public static AbstractAnimalFactory whichFactory(String factory){
        return switch (factory.toLowerCase()){
            case "desert" -> new DesertAnimalFactory();
            case "jungle" -> new JungleAnimalFactory();
            default -> throw new IllegalArgumentException("Unknown scenario: " + factory);
        };
    }

    public static void whichAction(AbstractAnimalFactory factory,String action, String string){
        switch (action.toLowerCase()){
            case "murder", "kill", "assassinate", "eliminate" -> {
                DangerousAnimal animal = factory.createDangerousAnimal();
                animal.kill(string);
            }
            case "ride", "travel" -> {
                TransportationAnimal animal = factory.createTransportationAnimal();
                animal.ride(string);
            }
            default -> throw new IllegalArgumentException("Unknown action: " + action);
        };
    }

    public static void main(String[] args) {
        Client constructor1 = new Client("desert");
        Client anotherConstructor1 = new Client("JUNGLE");
        Client constructor2 = new Client("desert", "murder", "another human");
    }
}
