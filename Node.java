public class Node {
    
    protected Integer valor;
    protected Node anterior;
  
    public Node(){this.valor = null; this.anterior = null;}
    
    public Integer getValor(){return this.valor;}
    
    public void setValor(Integer v){
        this.valor = v;
    }
    
    public void setAnterior(Node n){
        this.anterior = n;
    };
    
    public Node getAnterior(){return this.anterior;}
}
