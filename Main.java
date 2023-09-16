import java.util.Scanner;
import java.util.Random;
class Main {

  static void resolucao(Integer crescente, int qtd, PilhaLista A, PilhaLista C, PilhaLista B){
    Node nodeMovida = null; 

    if (crescente == 0){
      while(C.size < qtd){

        if (A.topo != null && (C.topo == null || A.topo.valor <= C.topo.valor)) {
     
          nodeMovida = A.remover();
          C.insere(nodeMovida);
        }
        
        else if(A.topo != null && (C.topo.valor < A.topo.valor)){
       
          nodeMovida = A.remover();
          B.insere(nodeMovida);
          nodeMovida = C.remover();
          A.insere(nodeMovida);
        }
        else if(B.topo != null &&(C.topo == null || B.topo.valor <= C.topo.valor)){
     
          nodeMovida = B.remover();
          C.insere(nodeMovida);
        }
        else if(B.topo != null &&(B.topo.valor > C.topo.valor)){
     
          nodeMovida = B.remover();
          A.insere(nodeMovida);
          nodeMovida = C.remover();
          B.insere(nodeMovida);
        }
      //---------------------------
        else if(A.topo.valor > B.topo.valor && A.topo.valor > C.topo.valor){

          if(B.topo.valor > C.topo.valor){
           
            nodeMovida = C.remover();
            B.insere(nodeMovida);
            
          }else{
         
            nodeMovida = B.remover();
            C.insere(nodeMovida);
          }
        }

        else if(B.topo.valor > C.topo.valor && B.topo.valor > A.topo.valor){

          if(A.topo.valor > C.topo.valor){
            
            nodeMovida = C.remover();
            A.insere(nodeMovida);
            
          }else{
            
            nodeMovida = A.remover();
            C.insere(nodeMovida);
          }
        }

        //-----------------------------------
      }
    }else{
      //----------------------------
        while(C.size < qtd){
          // Check if nodeMovida can be moved to C
          if (A.topo != null && (C.topo == null || A.topo.valor >= C.topo.valor)) {
     
            nodeMovida = A.remover();
            C.insere(nodeMovida);
          }
          
          else if(A.topo != null && (C.topo.valor > A.topo.valor)){
      
            nodeMovida = A.remover();
            B.insere(nodeMovida);
            nodeMovida = C.remover();
            A.insere(nodeMovida);
          }
          else if(B.topo != null &&(C.topo == null || B.topo.valor >= C.topo.valor)){
      
            nodeMovida = B.remover();
            C.insere(nodeMovida);
          }
          else if(B.topo != null &&(B.topo.valor < C.topo.valor)){
       
            nodeMovida = B.remover();
            A.insere(nodeMovida);
            nodeMovida = C.remover();
            B.insere(nodeMovida);
          }

          //-----------------------

          else if(A.topo.valor > B.topo.valor && A.topo.valor > C.topo.valor){

          if(B.topo.valor > C.topo.valor){
           
            nodeMovida = C.remover();
            B.insere(nodeMovida);
            
          }else{
         
            nodeMovida = B.remover();
            C.insere(nodeMovida);
          }
        }

        else if(B.topo.valor < C.topo.valor && B.topo.valor < A.topo.valor){

          if(A.topo.valor < C.topo.valor){
            
            nodeMovida = C.remover();
            A.insere(nodeMovida);
            
          }else{
            
            nodeMovida = A.remover();
            C.insere(nodeMovida);
          }
        }

        }
      
    }
    if (C.size == qtd){
      C.mostrar();
      return;
    }
  }
  
  public static void main(String[] args) {

    int num_jogadas = 0;
    boolean c = true;
    Scanner sc = new Scanner(System.in);
    PilhaLista pilha_A = new PilhaLista("pilha_A");
    PilhaLista pilha_B = new PilhaLista("pilha_B");
    PilhaLista pilha_C = new PilhaLista("pilha_C");

    PilhaLista[] arrayPilha = new PilhaLista[3];
    arrayPilha[0] = pilha_A;
    arrayPilha[1] = pilha_B;
    arrayPilha[2] = pilha_C;

    System.out.println("--- HANOI ---");
    System.out.println("Digite 0 para ordem crescente, 1 para ordem decrescente:");
    Integer crescente = sc.nextInt();
    System.out.println(">Digite numero de discos:");
    Integer quant_discos = sc.nextInt();

    for(int i = 0; i < quant_discos; i++){
      
      Node newNode = new Node();
      Random random = new Random();
      int randomNumber = random.nextInt(100) + 1;

      newNode.setValor(randomNumber);
      pilha_A.insere(newNode);
    }

    while(c){
      System.out.println(">> Digite 0 para sair, 1 para jogar ou 2 para solucao automatica:");

      Integer option = sc.nextInt();

      pilha_A.mostrar();
      pilha_B.mostrar();
      pilha_C.mostrar();
      
      switch(option){

        case 0:
          System.out.println("Saindo do jogo...");
          c = false;
          break;
          
        case 1:
          System.out.println("Mover de 0. A, 1.B, 2.C:");
          Integer saida = sc.nextInt();
          System.out.println("Para 0.A, 1.B, 2.C:");
          Integer entrada = sc.nextInt();
          
          if(arrayPilha[entrada].topo!=null){

            if(crescente == 0){
            if(arrayPilha[saida].topo.valor<arrayPilha[entrada].topo.valor){

              Node nodeMovida = arrayPilha[saida].remover();
              arrayPilha[entrada].insere(nodeMovida);
              num_jogadas+=1;
              
            }
            else{
              System.out.println("Erro de jogada: "+arrayPilha[saida].topo.valor+" > "+arrayPilha[entrada].topo.valor);
            }
          }else{
            //-----------------
              if(arrayPilha[saida].topo.valor>arrayPilha[entrada].topo.valor){

            Node nodeMovida = arrayPilha[saida].remover();
            arrayPilha[entrada].insere(nodeMovida);
            num_jogadas+=1;
              
            }
            else{
              System.out.println("Erro de jogada: "+arrayPilha[saida].topo.valor+" < "+arrayPilha[entrada].topo.valor);
            }

            //-----------------
          }
        }
          else{
            Node nodeMovida = arrayPilha[saida].remover();
            arrayPilha[entrada].insere(nodeMovida);
            num_jogadas+=1;
          }
          
          if(pilha_B.size == quant_discos || pilha_C.size == quant_discos){

            System.out.println("Ordenação concluída em "+num_jogadas+" jogadas!");
            c = false;
          }
          
          break;
  
        case 2:

          resolucao(crescente, quant_discos, pilha_A, pilha_C, pilha_B);
          c = false;
          break;

        default:
          System.out.println("Erro de input.");
          break;
      }
    }
  }
}
