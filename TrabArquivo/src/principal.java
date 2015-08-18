
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class principal {

    public static void main(String[] args) {
        Scanner tec = new Scanner();
        String arq;
        try {
            File diretorio = new File("C:\\Alunos");
            diretorio.mkdir();
            File gabarito = new File("C:\\Alunos\\Gabarito.txt");
            File aluno = new File("C:\\Alunos\\Aluno.txt");

            if (!gabarito.exists()) {
                gabarito.createNewFile();
            }
            if (!aluno.exists()) {
                aluno.createNewFile();
            }

            FileWriter fw1 = new FileWriter(gabarito);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write("FVVFFVVFFV");
            bw1.close();
            fw1.close();

            FileWriter fw2 = new FileWriter(aluno);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            ////////////////////////////////////////////////////////////////
            System.out.println("");
            arq = tec.next();
            File disciplina = new File(arq);
            disciplina.mkdir();
            String alunoln;
            while (true) {
                alunoln = null;
                System.out.println("Resposta do Aluno");
                alunoln = tec.next();
                System.out.println("Nome do Aluno");
                alunoln = alunoln + "/" + tec.next();
                bw2.write(alunoln);
                bw2.newLine();
                System.out.println("Continuar s/n");
                alunoln = tec.next();
                if (alunoln.equals("n")) {
                    break;
                }
            }
            bw2.close();
            fw2.close();
            while (true) {
                System.out.println("Nome da Disciplina");
                tec.next();
                int acertos;
                try {
                    FileReader fr2 = new FileReader(aluno + "\\" + "Gabarito.txt");
                    BufferedReader br2 = new BufferedReader(fr2);
                    String Gab = br2.readLine();
                    br2.close();
                    fr2.close();
                    while (br2.ready()) {
                        String vetor[] = GabE.split("/");
                        for (int i = 0; i < 10; i++) {
                            if (Gab.charAt(i) == GabE.charAt(i)) {
                                acertos++;
                            }

                        }
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Nome Invalido");
                }
            }
            ////////////////////////////////////////////////////////
            ArrayList<Estudante> estudantes = new ArrayList<>();

            int acertos = 0;
            FileReader fr1 = new FileReader(aluno);
            BufferedReader br1 = new BufferedReader(fr1);
            String GabE = br1.readLine();
            while (br1.ready()) {
                String vetor[] = GabE.split("/");
                for (int i = 0; i < 10; i++) {
                    if (Gab.charAt(i) == GabE.charAt(i)) {
                        acertos++;
                    }

                }
                Estudante e = new Estudante(vetor[1], acertos);
                estudantes.add(e);
                GabE = br1.readLine();
            }
            br1.close();
            fr1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
