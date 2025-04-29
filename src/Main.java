import conjunto_lista_contatos.Contato;
import conjunto_lista_contatos.ListaContatos;
import conjunto_lista_contatos_exceptions.NomeException;
import conjunto_lista_contatos_exceptions.TelefoneException;

public class Main {
    public static void main(String[] args) throws NomeException, TelefoneException {
        Contato contato = null;
        Contato contato2 = null;

        try {
            contato = new Contato("Jorge Luiz", "73988735522");
            contato2 = new Contato("Pedro", "55981756971");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (contato != null && contato2 != null) {
                ListaContatos lista = new ListaContatos(contato, contato2);
                lista.adicionarContato("Amadeus Almeida", "11981553239");
                lista.adicionarContato("Pedro Souza", "33998543219");
                lista.pesquisaPorNome("Pedro").forEach(System.out::println);
                System.out.println("\n");
                lista.atualizarNumeroContato("Amadeus Almeida", "11982553239");
                lista.exibirContatos();
            }
        }
    }
}
