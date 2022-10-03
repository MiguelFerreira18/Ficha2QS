/**
 * @author miguel
 */
public class Utente {
    private String nome;
    private String genero;
    private int iidade;
    private float altura;
    private int peso;

    //variaveis finais
    private final int MINSSAUDAVEL = 20;
    private final int MAXSAUDAVEL = 24;

    public Utente(String nome, String genero, int idade, float altura, int peso) {
        this.nome = nome;
        this.genero = genero;
        this.iidade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIidade() {
        return iidade;
    }

    public void setIidade(int iidade) {
        this.iidade = iidade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", iidade=" + iidade +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }

    /**
     * calcula o imc do utente
     */
    public double calculaImc(){
        if(altura <= 0 && altura >= 2.15f &&  peso <=0 && peso >=600)
        {
            System.out.println("os seus dados não estão corretos");
            return -1;
        }
        Double imc = Double.valueOf(peso /(altura*altura));
        if(imc <= 19){
            System.out.println("Abaixo do peso normal");

            double minSaudavel = MINSSAUDAVEL * altura*altura - peso;
            double maxSaudavel = MAXSAUDAVEL * altura*altura - peso;

            System.out.println("precisa de engordar " +minSaudavel + " kg ou " + maxSaudavel + " kg para ser saudavel");

        }else if(imc <=25){
            System.out.println("peso normal");
            double minSaudavel = MINSSAUDAVEL * altura*altura;
            double maxSaudavel = MAXSAUDAVEL * altura*altura;

            System.out.println("precisa de se manter entre" +minSaudavel + " kg e " + maxSaudavel + " kg para se manter saudavel");

        } else if(imc <= 30) {
            System.out.println("Excesso de peso");

            double minSaudavel = peso - MINSSAUDAVEL * altura*altura ;
            double maxSaudavel = peso - MAXSAUDAVEL * altura*altura;

            System.out.println("precisa de emagrecer  " +minSaudavel + " kg ou  " + maxSaudavel + " kg para ser saudavel");

        }else{
        System.out.println("Obeso");
        double minSaudavel = peso - MINSSAUDAVEL * altura*altura ;
        double maxSaudavel = peso - MAXSAUDAVEL * altura*altura;
        System.out.println("precisa de emagrecer " +minSaudavel + " kg ou de " + maxSaudavel + " kg para ser saudavel");

        }
        return imc;
    }//fim do metodo calculaImc
}//fim da classe
