public class DesertAnimalFactory implements AbstractAnimalFactory{
    @Override
    public DangerousAnimal createDangerousAnimal(){
        return new Serpent();
    }
    @Override
    public TransportationAnimal createTransportationAnimal(){
        return new Dromedary();
    }

    @Override
    public String toString(){
        return "Instantiating a new %s".formatted(getClass().getSimpleName());
    }
}
