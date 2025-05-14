public class Dromedary implements TransportationAnimal{
    @Override
    public void ride(String destination){
        System.out.printf("Riding a %s to %s\n", getClass().getSimpleName().toLowerCase(), destination);
    }
}
