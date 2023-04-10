//:)
//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author user
 */
public class Campeonato {
    static Clube[] clubes = new Clube[10];
    int numClubes = 0;
    static Random gol = new Random();
    
    public void adicionaClube(String nomeClube){
        Clube clube = new Clube(nomeClube);
        clubes[numClubes] = clube;
        numClubes++; 
    }
    /*public void jogaCampeonato(){
        int numJogos = numClubes*(numClubes -1);
        int a = 10;
    }*/
    public void /*int[][]*/ jogarCampeonato() {
        
        //ArrayList<int[]> combinacoes = new ArrayList<>();
        //int[][] combinacoes;
        int n = numClubes;

        int[][] combinacoes = new int[n*(n-1)/2][2]; // tamanho nx2

        // Gera todas as combinações de elementos tomados 2 a 2 e adiciona ao array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                combinacoes[index][0] = i+1;
                combinacoes[index][1] = j+1;
                index++;
            }
        }

        // Imprime o array de combinações
        for (int i = 0; i < combinacoes.length; i++) {
            //System.out.printf("Combinação : [%d, %d]\n", combinacoes[i][0], combinacoes[i][1]);
            jogarPartida(clubes[combinacoes[i][0]-1], clubes[combinacoes[i][1]-1]);
        }


        /*for(int p = 1; p < 3; p++){
            for (int i = 1; i < a; i++) {
                for (int j = i + 1; j < a; j++) {
                    int[] combinacao = {i, j};
                    combinacoes.add(combinacao);
                    //combinacoes = combinacao;
                    //jogarPartida(clubes[i],clubes[j]);
                    
                }
            }
        }
        
        for (int i = 0; i < combinacoes.size(); i++) {
            int[] linha = combinacoes.get(i);
            System.out.println("Linha " + i + ": " + linha[0] + " " + linha[1]);
            jogarPartida(clubes[linha[0]], clubes[linha[1]]);
        }*/

        /*for (int i = 0; i < combinacoes.length; i++) {
            System.out.println(combinacoes[i][0] + " " + combinacoes[i][1]);
        }*/

        /*int[][] resultado = combinacoes.toArray(new int[combinacoes.size()][2]);
        return resultado;*/
    }
    /*public static void imprime() {
        
        int[][] resultado = jogarCampeonato(4);
        
        for (int[] combinacao : resultado) {
            System.out.println("(" + combinacao[0] + ", " + combinacao[1] + ")");
        }
    }*/
    /*public void jogarCampeonato(){
        int[][] jogos = combinacoesDeDois(numClubes);
        
    }*/
    public void jogarPartida(Clube i, Clube j){
        int golsi =  gol.nextInt(7);
        int golsj =  gol.nextInt(7);
        
        if(golsi > golsj){
            i.ganhar(golsi -golsj);
            j.perder(golsj -golsi);
            
            System.out.println("\n"+i.nome+" ganhou do "+j.nome+" de "+golsi+"X"+golsj);
        }
        if(golsi < golsj){
            j.ganhar(golsj -golsi);
            i.perder(golsi -golsj);
            
            System.out.println("\n"+j.nome+" ganhou do "+i.nome+" de "+golsj+"X"+golsi);
        }
        if(golsi == golsj){
            j.empatar(golsj);
            i.empatar(golsi);
            
            System.out.println("\n"+j.nome+" empatou para o "+i.nome+" de "+golsj+"X"+golsi);
        }
    }
}
