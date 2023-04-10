//:)

import java.util.Random;
/**
 *
 * @author Nathanzin
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
    public void /*int[][]*/ jogarCampeonato() {
        
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

        // Faz os times jogarem
        for (int i = 0; i < combinacoes.length; i++) {
            //System.out.printf("Combinação : [%d, %d]\n", combinacoes[i][0], combinacoes[i][1]);
            jogarPartida(clubes[combinacoes[i][0]-1], clubes[combinacoes[i][1]-1]);
        }

    }
    
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
