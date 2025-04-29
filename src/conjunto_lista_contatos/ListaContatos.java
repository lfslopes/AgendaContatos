package conjunto_lista_contatos;

import conjunto_lista_contatos_exceptions.TelefoneException;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ListaContatos {
    private final Set<Contato> listaContatos;

    public ListaContatos() {
        listaContatos = new TreeSet<>();
    }
    public ListaContatos(Set<Contato> listaContatos){
        this.listaContatos = listaContatos;
    }
    public ListaContatos(Contato...contatos){
        this.listaContatos = new TreeSet<>();
        this.listaContatos.addAll(Arrays.asList(contatos));
    }

    public void adicionarContato(String nome, String telefone){
        try {
            listaContatos.add(new Contato(nome, telefone));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Set<Contato> pesquisaPorNome(String nome){
        Set<Contato> contatos = new TreeSet<>();
        for(Contato c : listaContatos){
            if(c.getNome().contains(nome))
                contatos.add(c);
        }
        return contatos;
    }
    public void atualizarNumeroContato(String nome, String numero){
        for(Contato c : listaContatos){
            if (c.getNome().equals(nome)){
                c.setTelefone(numero);
                break;
            }
        }
    }
    public void exibirContatos(){
        this.listaContatos.stream().
                sorted((c1, c2) -> c1.getNome().compareToIgnoreCase(c2.getNome())).
                forEach(System.out::println);
    }
}
