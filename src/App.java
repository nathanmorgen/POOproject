public class App {
    public static void main(String[] args){
        //Campeonato.imprime();
        Campeonato campeonato = new Campeonato();
        campeonato.adicionaClube("flamengo");
        campeonato.adicionaClube("Palmeiras");
        campeonato.adicionaClube("Vasco");
        campeonato.adicionaClube("Fluminense");

        campeonato.jogarCampeonato();
    }
}
