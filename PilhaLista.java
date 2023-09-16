import java.util.Random;
public class PilhaLista {
    
  protected Node topo;
  protected String nomePilha;
  protected int size;
    
    public PilhaLista(String nome){ 
        
      this.topo = null;
      this.nomePilha = nome;
      this.size = 0;
    }
    
    public void insere(Node node){

      if(node != null){

        node.anterior = null;
        System.out.println("Inserido "+node.getValor()+" em "+this.nomePilha);
        
        if (this.topo != null) {
            node.setAnterior(topo);
        }
        
        this.topo = node;
        this.size+=1;
      
      }else{System.out.println("Nao há disco para mover!");}
    }
        
    public Node remover(){

      Node topoAnterior = this.topo;
      
        if(this.topo != null){        

          System.out.println("Removeu "+this.topo.getValor()+" de "+this.nomePilha);

          if(this.topo.getAnterior() != null){
            
            this.topo = this.topo.getAnterior();
            
          }else{this.topo = null;}

          this.size -= 1;
            
        }else{

          System.out.println("Nao ha nada para mover de "+this.nomePilha);
        }

      return topoAnterior;
    }
    
    public void mostrar(){

      if(this.topo != null){
        System.out.println("Discos da "+this.nomePilha+":");
          
          Node atual = this.topo;
          
          while (this.topo.getValor() != null) {
            System.out.println(atual.getValor());
            atual = atual.getAnterior();
            if (atual == null) {
                System.out.println("Fim da Pilha.");
                break;
            }
          }
      }else{System.out.println("Nada na "+this.nomePilha);}
    }
}
