package conjunto_lista_contatos;

import conjunto_lista_contatos_exceptions.NomeException;
import conjunto_lista_contatos_exceptions.TelefoneException;

public class Contato implements Comparable<Contato>{
    private String nome;
    private String telefone;

    private final String NOME_PATTERN = "[A-Z]{1}[a-z]{2,20}|[A-Z]{1}[a-z]{2,20}( )[A-Z]{1}[a-z]{2,20}";
    private final String TELEFONE_PATTERN1 = "[0]{0,1}[0-9]{2}9[98][1289][0-9]{6}";
    private final String TELEFONE_REAL_PATTERN = "[0-9]{2}[ ]{0,1}9[98][1289][0-9]{2}-[0-9]{4}";

    public Contato(String nome, String telefone) throws NomeException, TelefoneException {
        if (nome == null || nome.isEmpty())
            throw new NomeException("Nome vazio");
        if (!this.nomeValido(nome))
            throw new NomeException("Nome Invalido");

        if (telefone == null || telefone.isEmpty())
            throw new TelefoneException("Telefone vazio");
        if (!this.telefoneValido(telefone))
            throw new TelefoneException("Telefone Invalido");

        this.nome = nome;
        this.telefone = this.telefoneFormato(telefone);
    }
    private boolean nomeValido(String nome) {
        return nome.matches(NOME_PATTERN);
    }
    private boolean telefoneValido(String telefone) {
        return telefone.matches(TELEFONE_PATTERN1);
    }
    private String telefoneFormato(String telefone) {
        if (!telefone.matches(TELEFONE_REAL_PATTERN)) {
            StringBuilder telefoneFormato = new StringBuilder();
            if (telefone.charAt(0) == '0') {
                for (int i = 1; i < 4; i++) {
                    if (i == 3)
                        telefoneFormato.append(" ");
                    else
                        telefoneFormato.append(telefone.charAt(i));
                }
                for (int i = 3; i < telefone.length() + 1; i++) {
                    if (i == 8)
                        telefoneFormato.append("-");
                    else if (i > 8)
                        telefoneFormato.append(telefone.charAt(i - 1));
                    else
                        telefoneFormato.append(telefone.charAt(i));
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    if (i == 2)
                        telefoneFormato.append(" ");
                    else
                        telefoneFormato.append(telefone.charAt(i));
                }
                for (int i = 2; i < telefone.length() + 1; i++) {
                    if (i == 7)
                        telefoneFormato.append("-");
                    else if (i > 7)
                        telefoneFormato.append(telefone.charAt(i - 1));
                    else
                        telefoneFormato.append(telefone.charAt(i));
                }
            }
            return telefoneFormato.toString();
        }
        return telefone;
    }

    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = this.telefoneFormato(telefone);
    }

    @Override
    public int compareTo(Contato contato) {
        return this.nome.compareTo(contato.getNome());
    }

    @Override
    public String toString() {
        return "Contato: " + this.nome + " -- Número: " + this.telefone;
    }
}
