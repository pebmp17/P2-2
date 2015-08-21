package p2.pkg2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author Aula
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String aluno, disciplina, resposta = null;
        Scanner tec = new Scanner(System.in);
        ArrayList<String> testes = new ArrayList<>();
        String loopAsk;
        while (true) {
            System.out.println("Qual o nome da disciplina:");
            disciplina = tec.next();
            File diretorio = new File("Escola");
            diretorio.mkdir();
            loopAsk = null;
            for (int i = 1; i < 11; i++) {
                System.out.println("Digite a resposta da " + i + "a questao.[V/F]");
                if (loopAsk == null) {
                    loopAsk = tec.next().toUpperCase();
                } else {
                    loopAsk = loopAsk + tec.next().toUpperCase();
                }
                //   System.err.println(loopAsk);
            }
            System.out.println("Localizaçao do Arquivo: " + "Escola\\" + disciplina + "Gabarito.txt");
            FileWriter fw1 = new FileWriter("Escola\\" + disciplina + "Gabarito.txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write(loopAsk);
            bw1.close();
            fw1.close();
            while (true) {
                System.out.println("Nome do Aluno");
                aluno = tec.next();
                System.out.println("Resposta do Aluno");
                for (int i = 1; i < 11; i++) {
                    System.out.println("Digite a resposta da " + i + "a questao.[V/F]");
                    if (resposta == null) {
                        resposta = tec.next().toUpperCase();
                    } else {
                        resposta = resposta + tec.next().toUpperCase();
                    }
                    // System.err.println(loopAsk);
                }
                aluno = aluno + "/" + resposta + "/" + "99";
                testes.add(aluno);
                resposta = null;
                //   System.err.println( testes.indexOf(aluno));
                System.out.println("Continuar cadastrando notas de Alunos? s/n");
                aluno = tec.next();
                if (aluno.equals("n")) {
                    break;
                }
            }
            Collections.sort(testes, String.CASE_INSENSITIVE_ORDER);
            // for (String t : testes) {
            //     System.out.println(t);
            // }
            ////Conferir Respostas
            System.out.println("Conferindo Respostas...");
            String Gab;
            String GabE[];
            String reorder;
            int acertos = 0;
            float media = 0;
            String estudante;
            FileReader fr2 = new FileReader("Escola\\" + disciplina + "Gabarito.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            Gab = br2.readLine();
            br2.close();
            fr2.close();
            fw1 = new FileWriter("Escola\\" + disciplina + "Ordenado01.txt");
            bw1 = new BufferedWriter(fw1);
            ArrayList<String> arrayInv = new ArrayList<>();
            for (String teste : testes) {
                GabE = teste.split("/");
                if ((GabE[1]).equals("VVVVVVVVVV") || GabE[1].equals("FFFFFFFFFF")) {
                    acertos = 0;
                } else {
                    for (int i = 0; i < 10; i++) {
                        if (Gab.charAt(i) == GabE[1].charAt(i)) {
                            acertos++;
                        }
                    }
                }
                if (acertos < 10) {
                    estudante = GabE[0] + "/" + GabE[1] + "/" + "0" + acertos;
                    reorder = "0" + acertos + "/" + GabE[1] + "/" + GabE[0];
                } else {
                    estudante = GabE[0] + "/" + GabE[1] + "/" + acertos;
                    reorder = acertos + "/" + GabE[1] + "/" + GabE[0];
                }
                media = media + acertos;
                arrayInv.add(reorder);
                acertos = 0;
                bw1.write(estudante);
                bw1.newLine();
            }
            bw1.close();
            fw1.close();
            fw1 = new FileWriter("Escola\\" + disciplina + "Ordenado02.txt");
            bw1 = new BufferedWriter(fw1);
            for (int i = arrayInv.size() - 1; i >= 0; i--) {
                bw1.write(arrayInv.get(i));
                bw1.newLine();
            }
            bw1.write("Media:" + media / arrayInv.size());
            bw1.close();
            fw1.close();
            System.out.println("Correcao de notas gerada em arquivos: " + "Escola\\" + disciplina + "Ordenado01.txt" + "Escola\\" + disciplina + "Ordenado02.txt");
            System.out.println("Adicionar outra disciplina? [s/n]");
            testes.clear();
            loopAsk = tec.next();
            if (loopAsk.equals("n")) {
                break;
            }
        }
        float media = 0;
        String GabE[];
        while (true) {
            System.out.println("Nome do Aluno para Gerar Historico");
            loopAsk = tec.next();
            File escola = new File("Escola");
            File lista[] = escola.listFiles();
            for (File lista1 : lista) {
                FileReader fr2 = new FileReader(lista1);
                BufferedReader br2 = new BufferedReader(fr2);
                while (fr2.ready()) {
                    GabE = br2.readLine().split("/");
                    if (GabE.length == 3) {
                        if (GabE[0].equals(loopAsk)) {
                            //System.err.println("GabE[0]: " + GabE[0]);
                            //System.err.println("GabE[2]: " + GabE[2]);
                            testes.add(GabE[0] + "/" + GabE[1] + "/" + GabE[2] + "---" + lista1.getName());
                            media = media + Integer.parseInt(GabE[2]);
                        //     System.err.println("String Adicionada");
                        }
                    }
                }
                br2.close();
                fr2.close();
            }
            FileWriter fw1 = new FileWriter("Escola\\" + loopAsk + ".txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            int i;
            String t;
            for (i = 0; i < testes.size(); i++) {
                t = testes.get(i);
                bw1.write(t);
                bw1.newLine();
             //   System.err.println("String Escrita");
            }
            bw1.write(Float.toString(media / i));
            bw1.close();
            fw1.close();
            System.out.println("Historico Gerado");
            System.out.println("Gerar outro Historico? [s/n]");
            loopAsk = tec.next();
            if (loopAsk.equals("n")) {
                break;
            }
        }
    }
}
