public class Serpent implements DangerousAnimal{
    @Override
    public void kill(String target){
        System.out.printf("%s kills %s\n",getClass().getSimpleName(), target);
    }
}
