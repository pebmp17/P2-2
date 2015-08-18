
import java.io.*;
import java.util.ArrayList;
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
        String alunoln;
        Scanner tec = new Scanner(System.in);
        ArrayList <Provas> testes = new ArrayList<>();
        Provas p = new Provas();
        
        System.out.println("");
        arq = tec.next();
        File disciplina = new File(arq);
        disciplina.mkdir();
        
        while (true) {
            alunoln = null;
            System.out.println("Resposta do Aluno");
            p.setResposta(tec.next());
            System.out.println("Nome do Aluno");
            p.setNome(tec.next());
            System.out.println("Continuar s/n");
            alunoln = tec.next();
            if (alunoln.equals("n")) {
                break;
            }
        }
    }

}
