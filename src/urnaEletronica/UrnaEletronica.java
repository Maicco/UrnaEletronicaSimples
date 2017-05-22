package urnaEletronica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal para a execução do programa.
 * 
 * Realiza a eleição de candidatos concorrendo a cargos de Vereados ou Prefeitos.
 * Programa simples que realiza a votação dos candidatos individualmente e os armazena em um único ArrayList.
 * 
 * @author Maicco Guimarães
 * @RA 20905915
 */
public class UrnaEletronica 
{
    // Cria o objeto da urna
    private static final Urna URNA_ELETRONICA = new Urna();
    // Cria o scanner para leitura do teclado
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        // Cria um ArrayList para o objeto Candidato
        ArrayList<Candidato> candidatos = new ArrayList<>();
        // ID do candidato (Index do ArrayList)
        int id = 0;
        // Variável de controle do laço
        boolean b = true;
        
        // Laço para rodar o programa da urna
        while(b)
        {
            // Chama o menu de opções da Urna
            URNA_ELETRONICA.menuOpcoes();
            char opcao = scanner.next().charAt(0);
            // Seleciona a opção
            switch(opcao)
            {
                // Iniciar Eleição
                case '1': if(!candidatos.isEmpty())
                            eleicao(URNA_ELETRONICA.iniciarEleicao(), candidatos);
                        else
                            System.out.println("\nNão existem candidatos cadastrados.\n");
                    break;
                // Resultado da Eleição
                case '2': if(!candidatos.isEmpty())
                        {
                            System.out.println("**** CANDIDATOS ****");
                            System.out.println(URNA_ELETRONICA.resultadoEleicao(candidatos));
                        }
                        else
                            System.out.println("\nNão existem candidatos cadastrados.\n");
                    break;
                // Cadastrar Candidato
                case '3': candidatos.add(URNA_ELETRONICA.cadastroCandidato(id));
                    System.out.println("");
                    id++;
                    break;
                // Termina eleição (encerra o programa)
                case '4': b = false;
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }
        }
    }

    /**
     * Controla a eleição, selecionando os candidatos a partir do número dado, e adicionando os votos
     * @param b variável para verificar se é para realizar o voto
     * @param candidatos é ArrayList dos candidatos
     * @return retorna a ArrayList dos candidatos atualizada com os candidatos e seus votos
     */
    private static ArrayList<Candidato> eleicao(boolean b, ArrayList<Candidato> candidatos)
    {  
        // Realiza a votação
        if(b)
        {
            System.out.printf("Digite o número do candidato: ");
            int id = scanner.nextInt(); // Somente int para o id do candidato
            
            // Verifica se o candidato existe no ArrayList
            if(id > 0 && id <= candidatos.size())
            {
                // Seleciona o candidato
                Candidato candidato = candidatos.get(id-1);
                // Mostra as informações do candidato
                System.out.println(candidato.candidatoInfo() + "\n");
                
                System.out.println("Confirmar voto (S ou N)? ");
                char confirmacao = scanner.next().charAt(0);
                
                // Confirma o voto
                if(confirmacao == 's' || confirmacao == 'S')
                {
                    // Adiciona o voto para o candidato
                    int votos = candidato.getVotos();
                    candidato.setVotos(votos + 1);
                
                    // Atualiza o ArrayList com o candidato votado
                    candidatos.set(id-1, candidato);
                }
                else
                {
                    System.out.println("Opção inválida!");
                    return candidatos;
                }
            }
            else
            {
                if(id == 0)
                {
                    System.out.println("Confirmar voto em branco (S ou N)? ");
                    char confirmacao = scanner.next().charAt(0);
                
                    // Confirma o voto
                    if(confirmacao == 's' || confirmacao == 'S')
                    {
                        // Adiciona o voto em Branco
                        URNA_ELETRONICA.votoBranco();
                    }
                    else
                        System.out.println("Opção inválida!");
                }
                else
                {
                    System.out.println("Confirmar voto nulo (S ou N)? ");
                    char confirmacao = scanner.next().charAt(0);
                
                    // Confirma o voto
                    if(confirmacao == 's' || confirmacao == 'S')
                    {
                        // Adiciona o voto Nulo
                        URNA_ELETRONICA.votoNulo();
                    }    
                    else
                        System.out.println("Opção inválida!");
                }
            }
        }
        System.out.println("\n**** FIM ****\n");
        
        return candidatos;
    }
}