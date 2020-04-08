package principal;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TrataEmail {


    public static void main(String args[]) {

        System.out.println("LISTA DUPLICADA: "+inicializaLista().toString());

        System.out.println("LISTA SEM DUPLIÇÕES 1: "+ removeDuplicaoesModo1(inicializaLista()).toString());

        System.out.println("LISTA SEM DUPLIÇÕES 2: "+ removeDuplicaoesModo2(inicializaLista()).toString());

    }

    private static ArrayList<Email> inicializaLista() {
        ArrayList<Email> listaDuplicadaAux = new ArrayList<>();

        listaDuplicadaAux.add(new Email(1L, "msg1"));
        listaDuplicadaAux.add(new Email(2L, "msg2"));
        listaDuplicadaAux.add(new Email(3L, "msg2"));
        listaDuplicadaAux.add(new Email(4L, "msg3"));
        listaDuplicadaAux.add(new Email(5L, "msg4"));
        listaDuplicadaAux.add(new Email(6L, "msg5"));
        listaDuplicadaAux.add(new Email(7L, "msg4"));

        return listaDuplicadaAux;
    }

    private static ArrayList<Email> removeDuplicaoesModo1(ArrayList<Email> listaDuplicada) {
        Set<Email> semDuplicacao= new HashSet<>();
        semDuplicacao.addAll(listaDuplicada); 
        listaDuplicada = new ArrayList<>(); 
        listaDuplicada.addAll(semDuplicacao); 
        return listaDuplicada;
    }


    private static List<Email> removeDuplicaoesModo2(ArrayList<Email> listaDuplicada) {
        List<Email> semDuplicacao = listaDuplicada.stream().filter(
                mesgDistinta(email -> email.getMsg())
        ).collect(Collectors.toList());

        return semDuplicacao;
    }


    public static <T> Predicate<T> mesgDistinta(Function<? super T, Object> valorExtrator)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(valorExtrator.apply(t), Boolean.TRUE) == null;
    }
}


class Email {
    private Long id;
    private String msg;

    public Email(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

  
    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
    
        if(obj instanceof Email)
        {
            Email temp = (Email) obj;
            if(this.msg == temp.msg)
                return true;
        }
        return false;

    }
    @Override
    public int hashCode() {

        return (this.msg.hashCode());
    }
}