import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
/**
 * @author miguel
 */
public class Main {

    static Scanner scan = new Scanner(System.in);
    static HashMap<String,Utente> listaUtentes = new HashMap<>();

    public static void main(String[] args) {
        adicionaUtente(new Utente("Stephen","Masculino",16,1.70f,65));//valor inicial para testes
        int volta ,op;
        do {
            menu();
            op = scan.nextInt();
             volta = escolha(op);
        }while(volta !=-1);

    }//fim do metodo main

    /**
     * menu
     */
    public static void menu(){
        System.out.println("_______________________CLíNICA__________________________");
        System.out.println("|                      1 - adicionar cliente                          |");
        System.out.println("|                2 - verificar imc do cliente                    |");
        System.out.println("|                     3 - pesquisa utente                          |");
        System.out.println("|                        4 - exercicio fisico                         |");
        System.out.println("|                              5 - Sair                                       |");
        System.out.println("|__________________________________________________________|");
    }//fim o metodo menu

    /**
     * Escolha da opção do menu
     * @param opcao opção escolhida
     * @return returna 1 ou -1 se for 1 significa que vai repetir o menu se for -1 fecha o programa
     */
    public static int escolha(int opcao){
        if(opcao== 1 )
        {
            // String nome, String genero, int idade, float altura, int peso
            System.out.println("Nome do utente");
            String nome = scan.next();
            System.out.println("idade do utente ");

            int idade = scan.nextInt();
            while(idade<=0 && idade >= 130){
                System.out.println("idade impossivel");
                idade = scan.nextInt();
            }
            System.out.println("genero do utente(Masculino , Feminino, Outro)");
            String genero = scan.next();
            while(!genero.equalsIgnoreCase("Masculino")
                    && !genero.equalsIgnoreCase("Feminino")
                    && !genero.equalsIgnoreCase("Outro")){
                System.out.println("o genero do utente tem de ser um dos seguintes:  Masculino , Feminino, Outro");
                System.out.println(genero);
                genero = scan.next();
            }

            System.out.println("altura do utente");
            float altura = scan.nextFloat();
            while(idade<=0 && idade >= 130){
                System.out.println("idade impossivel");
                idade = scan.nextInt();
            }
            scan.nextLine();
            System.out.println("peso do utente");
            int peso = scan.nextInt();
            adicionaUtente(new Utente(nome,genero,idade,altura,peso));
            return 1;
        }else if (opcao == 2)
        {
            System.out.println("Nome do cliente");
            String nome = scan.next();
            mostraImc(nome);
            return 1;
        }else if(opcao == 3){
            System.out.println("Nome do cliente");
            String nome = scan.next();
            pesquisaUtente(nome);
            return 1;
        }else if(opcao == 4){
            System.out.println("Nome do cliente");
            String nome = scan.next();
            System.out.println("horas de treino");
            int horas = scan.nextInt();
            exercicioFisico(nome,horas);
            return 1;
        }else {
            return -1;
        }
    }//fim do metodo escolha

    /**
     * Adiciona um novo utente na clinica
     * @param novoUtente Objeto do utente
     */
    public static void adicionaUtente(Utente novoUtente){
        if(listaUtentes.containsKey(novoUtente.getNome()))
        {
            System.out.println("Já existe um utente com o nome " + novoUtente.getNome());
            return;
        }
        listaUtentes.put(novoUtente.getNome(),novoUtente);

    }

    /**
     * Pesquisa um utente pelo nome
     * @param nomeUtente nome do utente que se quer procurar
     */
    public static void pesquisaUtente(String nomeUtente){
        System.out.println(listaUtentes.containsKey(nomeUtente) ? listaUtentes.get(nomeUtente) : "Esse utente não existe" );
    }

    /**
     * DImiui peso do utente
     * @param nome nome do utente
     * @param horas horas de treino do utente
     */
    public static void exercicioFisico(String nome,int horas){
        Utente utenteRef;
        if (listaUtentes.containsKey(nome)) {
            utenteRef = listaUtentes.get(nome);

            double pesoPerdido = utenteRef.getPeso() * (horas/(double)100);
            System.out.println(pesoPerdido);
            utenteRef.setPeso((int) (utenteRef.getPeso() - pesoPerdido));
            System.out.println("o utente perdeu " + pesoPerdido + " kg ficando com " + utenteRef.getPeso());
            return;
        }else{
            System.out.println("Esse cliente não existe");
        }
    }//fim do metodo exercicioFisico

    /**
     * mostra imc de um utente
     * @param utente nome do utente
     */
    public static void mostraImc(String utente){
        if (listaUtentes.containsKey(utente)) {
            listaUtentes.get(utente).calculaImc();
        }
        else{
            System.out.println("esse nome não existe");
        }
    }//fim do metodo mostraImc

    /**
     * imprime todos os dados  de cada utente por ordem alfabetica
     */
    public static void maiorEMenorImc(){
        for(Utente value: listaUtentes.values()) {
            System.out.print(value);
            System.out.print(", ");
        }
    }//fim do metodo
}//fim da classe
