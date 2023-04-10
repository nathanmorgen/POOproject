public class App {
    public static void main(String[] args){
        //Campeonato.imprime();
        Campeonato campeonato = new Campeonato();
        campeonato.adicionaClube("esportes");
        campeonato.adicionaClube("framengo");
        campeonato.adicionaClube("hobbiton");
        campeonato.adicionaClube("fabiana");

        campeonato.jogarCampeonato();
    }
}
