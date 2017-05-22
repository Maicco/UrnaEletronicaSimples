package urnaEletronica;

import java.util.ArrayList;

/**
 * Classe que gerencia a Urna eletrônica.
 * 
 * @author Maicco Guimarães
 * @RA 20905915
 */
public class Urna 
{
    private int votosBrancos, votosNulo;
    
    // Construtor
    public Urna()
    {
        
    }
    
    /**
     * Lista o resultado da eleição para cada candidato
     * @param candidatoLista é a ArrayList de candidatos
     * @return O resultado da eleição em um String
     */
    public String resultadoEleicao(ArrayList<Candidato> candidatoLista)
    {
        String output = "";
        
        // For each para listar os candidatos da ArrayList e montar a String
        for(Candidato c : candidatoLista)
            output += c.candidatoInfoVotos() + "\n";
        
        output += "\nVotos Brancos: " + votosBrancos + "\nVotos Nulos: " + votosNulo + "\n";
        
        return output;
    }
    
    /**
     * Cria um candidato para ser cadastrado
     * @param id é o número de indentificação do candidato (index do ArrayList)
     * @return o candidato para ser cadastrado
     */
    public Candidato cadastroCandidato(int id)
    {
        Candidato candidato = new Candidato();
        boolean b = true; // Variável de controle do laço
        
        // Inseri o nome do candidato
        System.out.printf("\nInsira o nome do candidato: ");
        candidato.setNome(UrnaEletronica.scanner.next());
        
        // Laço para verificar o cargo a ser disputado pelo candidato
        while(b)
        {
            System.out.printf("Insira o cargo do candidato (vereador ou prefeito): ");
            String cargo = UrnaEletronica.scanner.next();
            
            // Verifica o cargo
            if(cargo.equalsIgnoreCase("vereador") || cargo.equalsIgnoreCase("prefeito"))
            {
                // Inseri o cargo do candidato
                candidato.setCargo(cargo);
                b = false;
            }
            else
                System.out.println("\nCargo Inválido!\n");
        }
        
        // Inseri o número de identificação do candidato
        candidato.setId(id);
        
        return candidato;
    }
    
    /**
     * Imprime as opções para iniciar a Eleição
     * @return a opção selecionada
     */
    public boolean iniciarEleicao()
    {
        System.out.println("**** ELEIÇÃO ****");
        System.out.println("1 - Votar");
        System.out.println("2 - Sair da votação");
        System.out.printf("Digite a opção: ");
        
        char c = UrnaEletronica.scanner.next().charAt(0);
        
        return c == '1';
    }
    
    /**
     * Menu de opções da urna
     */
    public void menuOpcoes()
    {
        /**
         * 1 - Iniciar Eleição
         * 2 - Resultado da Eleição
         * 3 - Cadastrar Candidato
         * 4 - Terminar Eleição
         */
        System.out.println("**** MENU DE OPÇÕES ****");
        System.out.println("1 - Iniciar Eleição");
        System.out.println("2 - Resultado da Eleição");
        System.out.println("3 - Cadastrar Candidato");
        System.out.println("4 - Terminar Eleição\n");
        System.out.printf("Insira a opção: ");
    }
    
    public void votoBranco()
    {
        votosBrancos++;
    }
    
    public void votoNulo()
    {
        votosNulo++;
    }
}