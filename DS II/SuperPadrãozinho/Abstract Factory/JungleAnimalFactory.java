public class JungleAnimalFactory implements AbstractAnimalFactory{
    @Override
    public DangerousAnimal createDangerousAnimal(){
        return new TRex();
    }
    @Override
    public TransportationAnimal createTransportationAnimal(){
        return new Pterodactyl();
    }

    @Override
    public String toString(){
        return "Instantiating a new %s".formatted(getClass().getSimpleName());
    }
}
