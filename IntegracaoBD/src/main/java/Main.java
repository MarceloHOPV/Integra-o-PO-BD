import DAO.*;
import Model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //=========================================================//
        //Varíáveis auxiliares BD:
        ProfessorDAO professorDAO = new ProfessorDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        MateriaDAO materiaDAO = new MateriaDAO();
        TurmaDAO turmaDAO = new TurmaDAO();
        Horarios_AulasDAO horariosAulasDAO = new Horarios_AulasDAO();
        HabilidadesDAO habilidadesDAO = new HabilidadesDAO();

        Professor professorAUX = null;
        Aluno alunoAUX = null;
        Materia materiaAUX = null;
        Turma turmaAUX = null;
        Horarios_Aulas horariosAulasAUX = null;
        int entrada;
        boolean achou;
        //=========================================================//

        //=========================================================//
        //Criando um scanner
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        //=========================================================//

        //=========================================================//
        //Laço dew repetição
        while(escolha != (-1)) {
            switch (escolha) {
                case 0:
                    System.out.println("1 Para adicionar Professor\n" +
                            "2 Para remover o Professor com o cpf\n" +
                            "3 Para ver os Professores\n" +
                            "4 Para modificar uma informação sobre o professor\n" +
                            "5 Para adicionar alguma hobilibade ao professor\n" +
                            "-----------------------------------------------\n" +
                            "6 Para cadastrar alunos a uma determinada turma\n" +
                            "7 Para remover algum aluno \n" +
                            "8 Para mudar alguma informação sobre alguma aluno\n" +
                            "9 Para ver os alunos da facudade\n" +
                            "-----------------------------------------------\n" +
                            "10 Para adcionar alguma matéria a grade curricular\n" +
                            "11 Para remover alhuma matéria da grade curricular\n" +
                            "12 Para mudar alguma informação sobre algum aluno\n" +
                            "13 Para a lista das matérias da facudade\n" +
                            "------------------------------------------------\n" +
                            "14 Para Adicionar Alguma turma\n" +
                            "15 Para remover alguma turma\n" +
                            "16 Para ver as informações da turmas\n" +
                            "------------------------------------------------\n" +
                            "17 Para mandar um email para o professor fazer alguma ação\n" +
                            "18 Para mandar um email para o aluno fazer alguma ação\n" +
                            "-1 Para sair");
                    escolha = sc.nextInt();
                    sc.nextLine();
                    break;
                    //professor
                case 1:
                    System.out.println("Digite em ordem CPF, NOME, NÚMERO DE MATÉRIAS ");
                    professorAUX = new Professor(sc.nextLine(),sc.nextLine(),sc.nextInt());
                    sc.nextLine();
                    professorDAO.insertProfessor(professorAUX);
                    escolha = 99;
                    break;
                case 2:
                    System.out.println("Digite o cpf do professor a ser deletado");
                    professorDAO.deleteProfessor(sc.nextLine());
                    escolha = 99;
                    break;
                case 3:
                    //userDAO.selectUser();//mostra o user
                    professorDAO.selectProfessor();
                    escolha = 99;
                    break;
                case 4:
                    System.out.println("Digite em ordem: cpf do professor que deseja atualizar e em seguida os dados a serem atualuzados(nome, número de diciplinas)");
                    professorAUX = new Professor(sc.nextLine(),sc.nextLine(),sc.nextInt());
                    sc.nextLine();
                    professorDAO.updateProfessor(professorAUX);
                    escolha = 99;
                    break;
                case 5:
                    System.out.println("Digite o cpf do professor e uma entre as habilidades disponíveis para adicionar no professor:\n" +
                            "Codar\n" +
                            "Careca\n" +
                            "Calvo\n" +
                            "Derivar\n" +
                            "Integrar");

                    professorAUX = new Professor(sc.nextLine(),sc.nextLine());
                    habilidadesDAO.insertHabilidade(professorAUX);
                    escolha = 99;
                    break;
                    //turma
                case 6:
                    System.out.println("Digite a matricula nome e data de nascimento do aluno:");
                    alunoAUX = new Aluno(sc.nextLine(),sc.nextLine(),sc.nextLine());
                    alunoDAO.insertAluno(alunoAUX);
                    escolha = 99;
                    break;
                case 7:
                    System.out.println("Digite a matricula do aluno a ser deletado");
                    alunoDAO.deleteAluno(sc.nextLine());
                    escolha = 99;
                    break;
                case 8:
                    System.out.println("Digite em ordem: matricula do aluno que deseja atualizar e em seguida os dados a serem atualuzados(nome, data de nascimento)");
                    alunoAUX = new Aluno(sc.nextLine(),sc.nextLine(),sc.nextLine());
                    alunoDAO.updateAluno(alunoAUX);
                    escolha = 99;
                    break;
                case 9:
                    alunoDAO.selectAluno();
                    escolha = 99;
                    break;
                    //matéria
                case 10:
                    System.out.println("Digite a sigla da matéria e o peso da matéria:");
                    materiaAUX = new Materia(sc.nextLine(),sc.nextInt());
                    materiaDAO.insertMateria(materiaAUX);
                    escolha = 99;
                    break;
                case 11:
                    System.out.println("Digite a sigla da matéria a ser deletada");
                    materiaDAO.deleteMateria(sc.nextLine());
                    escolha = 99;
                    break;
                case 12:
                    System.out.println("Digite em ordem: sigla da matéria que deseja atualizar e em seguida os dados a serem atualuzados(peso)");
                    materiaAUX = new Materia(sc.nextLine(),sc.nextInt());
                    sc.nextLine();
                    materiaDAO.updateMateria(materiaAUX);
                    escolha = 99;
                    break;
                case 13:
                    materiaDAO.selectMateria();
                    escolha = 99;
                    break;
                    //turma
                case 14:
                    System.out.println("Digite o sigla da turma, o número de alunos, o cpf do professor, nome do professor, o número de turmas, o número da sala que acontecerá a aula, \n" +
                            "o número do predio que acontecerá a aula, a sigla da matéria e o peso da matéria:");
                    String turma = sc.nextLine();
                    int numAlunos = sc.nextInt();
                    sc.nextLine();
                    String cpfProf = sc.nextLine();
                    String nomeProf = sc.nextLine();
                    int numDiciplinas = sc.nextInt();
                    sc.nextLine();
                    int numSala = sc.nextInt();
                    sc.nextLine();
                    int numPredio = sc.nextInt();
                    sc.nextLine();
                    String sigla = sc.nextLine();
                    int peso = sc.nextInt();
                    sc.nextLine();
                    // s n s s n n n s n
                    turmaAUX = new Turma(turma,numAlunos,cpfProf,nomeProf,numDiciplinas,numSala,numPredio,sigla,peso);
                    turmaDAO.insertTurma(turmaAUX);
                    escolha = 99;
                    break;
                case 15:
                    System.out.println("Digite a o nome da turma e a sigla de sua respectiva matéria para deleta-la");
                    turmaDAO.deleteTurma(sc.nextLine(),sc.nextLine());
                    escolha = 99;
                    break;
                case 16:
                    turmaDAO.selectTurma();
                    escolha = 99;
                    break;
                    //habilidade
                case 17:
                    System.out.println("Digite a matricula do aluno e: \n" +
                            "1 para ver se o aluno sabe codar\n" +
                            "2 para ver se o aluno saba derivar\n" +
                            "3 para ver se o aluno sabe integrar");
                    achou = false;
                    while (achou == false) {
                        String matricula = sc.nextLine();
                        for (Aluno a : alunoDAO.selectNnPrintaAluno()) {
                            try {
                                if (a.getMatricula().equals(matricula)) {
                                    alunoAUX = a;
                                    achou = true;
                                }
                            } catch (NullPointerException e) {
                            }
                        }
                    }
                    entrada = sc.nextInt();
                    sc.nextLine();
                    switch (entrada)
                    {
                        case 1:
                            alunoAUX.podeCodar();
                            break;
                        case 2:
                            alunoAUX.consegueDerivar();
                            break;
                        case 3:
                            alunoAUX.consegueIntegrar();
                            break;
                    }
                    escolha = 99;
                    break;
                case 18:
                    System.out.println("Digite o cpf do professor e: \n" +
                            "1 para ver se o professor tem cabelo\n" +
                            "2 para ver se o professor sabe codar\n" +
                            "3 para ver se o professor saba derivar\n" +
                            "4 para ver se o professor sabe integrar");
                    achou = false;
                    while (achou == false) {
                        String cpf = sc.nextLine();
                        for (Professor prof : professorDAO.selectNnPrintaProfessor()) {
                            try {
                                if (prof.getCpf().equals(cpf)) {
                                    professorAUX = prof;
                                    achou = true;
                                }
                            } catch (NullPointerException e) {
                            }
                        }
                    }
                    entrada = sc.nextInt();
                    sc.nextLine();
                    switch (entrada)
                    {
                        case 1:
                            professorAUX.qtdCabelo();
                            break;
                        case 2:
                            professorAUX.podeCodar();
                            break;
                        case 3:
                            professorAUX.consegueDerivar();
                            break;
                        case 4:
                            professorAUX.consegueIntegrar();
                            break;
                    }
                    escolha = 99;
                    break;
                case 99:
                    System.out.println("Continuar = 0,sair = -1");
                    int continuar = sc.nextInt();
                    sc.nextLine();
                    escolha = continuar;
                    break;

            }
        }
        //=========================================================//

    }
}
