public final class SuperPadrao{
  private SuperPadrao(){
    System.out.println("Chamando o SuperPadrãozinho");
  }

  private static class LazyHolder {
    private static final SuperPadrao SUPERPADRAO = new SuperPadrao();
  }

  public static SuperPadrao getInstance() {
    return LazyHolder.SUPERPADRAO;
  }
}
