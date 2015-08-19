
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedroporto
 */
public class Main {

    public static void main(String[] args) {
        String arq;
        String loopAsk;
        Scanner tec = new Scanner(System.in);
        ArrayList<Provas> testes = new ArrayList<Provas>();
        Provas p = new Provas();

        System.out.println("");
       // arq = tec.next();
       // File disciplina = new File(arq);
       // disciplina.mkdir();

        while (true) {
           /// System.out.println("Resposta do Aluno");
            p.setResposta(null);
            p.setAcertos(0);
            System.out.println (" Nome do Aluno");
            loopAsk = tec.next();
            p.setNome(loopAsk);
            testes.add(p);
            System.out.println("Continuar s/n");
            loopAsk = tec.next();
            if (loopAsk.equals("n")) {
                break;
            }
        }
        ///testes.sort(Comparator.comparing(Provas::getNome));
        for (Provas t : testes) {
            System.out.println(testes.indexOf(t)+t.getNome());
        }
        System.out.println(testes.size());
    }
}
