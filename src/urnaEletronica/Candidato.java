package urnaEletronica;

/**
 * Classe para criar os objetos do candidato
 *
 * @author Maicco Guimarães
 * @RA 20905915
 */
public class Candidato 
{
    private String mNome; // Nome do candidato
    private String mCargo; // Cargo a ser disputado (Vereador ou Prefeito)
    private int mVotos; // Quantidade de votos do candidato
    private int mId; // Número de identificação do candidato
    
    // Contrutores
    /*************************************************/
    public Candidato()
    {
        mVotos = 0;
    }
    
    // Possíveis utilizações (Inicializar todos os dados do candidato)
    public Candidato(int votos, int id, String nome, String cargo)
    {
        mVotos = votos;
        mId = id;
        mNome = nome;
        mCargo = cargo;
    }
    // Possíveis Utilizações (Inicializar apenas o nome e o cargo do candidato)
    public Candidato(String nome, String cargo)
    {
        mVotos = 0;
        mNome = nome;
        mCargo = cargo;
    }
    /*************************************************/

    public String getNome() 
    {
        return mNome;
    }

    public void setNome(String mNome) 
    {
        this.mNome = mNome;
    }

    public String getCargo() 
    {
        return mCargo;
    }

    public void setCargo(String mCargo) 
    {
        this.mCargo = mCargo;
    }

    public int getVotos()
    {
        return mVotos;
    }

    public void setVotos(int mVotos) 
    {
        this.mVotos = mVotos;
    }

    public int getId()
    {
        return mId;
    }

    public void setId(int mId) 
    {
        this.mId = mId;
    }
    
    // Retorna as informações do candidato
    public String candidatoInfo()
    {
        return "\nID: " + (getId()+1) + "\nNome: " + getNome() + "\nCargo: " + getCargo();
    }
    
    // Retorna as informações do candidato
    public String candidatoInfoVotos()
    {
        return "\nID: " + (getId()+1) + "\nNome: " + getNome() + "\nCargo: " + getCargo() + "\nVotos: " + getVotos();
    }
}