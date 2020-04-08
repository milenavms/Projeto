package Principal;

public class Principal {
	
	 public static void main(String args[]) throws InterruptedException {
	        Lista listaA = new Lista();
	        Lista listaB = new Lista();

	        listaA.criaLista();
	        listaB.criaLista();

	        listaA.add('C');
	        listaA.add('A');
	        listaA.add('E');
	        listaA.add('H');
	        listaA.add('J');
	        listaA.add('B');
	        listaA.add('A');
	        
	        listaB.add('D');
	        listaB.add('F'); 

	        listaB.addIntercessao(listaA.getPri().getProximo().getProximo().getProximo().getProximo()); 
	        
	        System.out.println(checkIntersection(listaA, listaB));

	    }

	    private static String checkIntersection(Lista listaA, Lista listaB ) throws InterruptedException {
	        int size1 = size(listaA);
	        int size2 = size(listaB);

	        int diferenca;


	        if(size1 > size2) {
	            diferenca = size1 - size2;
	            return pegaIntercessao(diferenca, listaA, listaB);

	        } else {
	            diferenca = size2 - size1;
	            return pegaIntercessao(diferenca, listaB, listaA);
	        }
	    }

	    private static String pegaIntercessao(int dif, Lista lista1, Lista lista2) throws InterruptedException {
	        int i = 0;
	        No no1Aux= lista1.getPri(); 
	        No no2Aux = lista2.getPri(); 

	        while (i < dif) { 
	            //System.out.println("I: "+i+"="+no1Aux.getValor());
	            if(no1Aux == null) { 
	                return "Intercessão não encontrada 1";
	            }
	            no1Aux = no1Aux.getProximo();
	            i++;
	        }

	        while (no1Aux != null && no2Aux != null) { 

	            if(no1Aux== no2Aux) { 

	                return "Interceção encontrada no Nó: " + no1Aux.getValor();
	            }
	            no1Aux = no1Aux.getProximo(); 
	            no2Aux = no2Aux.getProximo();
	        }

	        System.out.println("Intercessão não encontrada 2");
	        return "Intercessão não encontrada 2";
	    }

	    private static int size(Lista lista) {
	        int count = 0;
	        No aux = lista.getPri(); 
	        while (aux != null) {
	            count++; 
	            aux = aux.getProximo(); 
	        }
	        return count;
	    }


	}

	class No {
	    private char valor;
	    private No proximo;

	    public char getValor() {
	        return valor;
	    }

	    public void setValor(char valor) {
	        this.valor = valor;
	    }

	    public No getProximo() {
	        return proximo;
	    }

	    public void setProximo(No proximo) {
	        this.proximo = proximo;
	    }

	}

	class Lista {
	    private No pri;
	    private No ult;


	    public void criaLista() {
	        pri = null;
	        ult = null;
	    }

	    public void add(char valor) {
	        No no = new No(); 
	        no.setValor(valor);

	        if(pri == null) {
	            no.setProximo(null);
	            pri = no;
	            ult = no;
	        } else {
	            no.setProximo(null);
	            ult.setProximo(no);
	            ult = no;
	        }

	    }

	    public void addIntercessao(No no) {
	        ult.setProximo(no);
	    }

	    public void print() {
	        No aux = pri;
	        while (aux != null) {
	            System.out.println(""+aux.getValor());
	            aux = aux.getProximo();
	        }
	    }

	    public No getPri() {
	        return pri;
	    }

	    public No getUlt() {
	        return ult;
	    }
}
