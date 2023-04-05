package br.com.atividade;

public class Produto {
    private long id;
    private String nome;
    private String categoria;
    private double preco;

    public Produto(long id, String nome, String categoria, double preco) {
        this.id=id;
        this.nome=nome;
        this.categoria=categoria;
        this.preco=preco;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString() {
        return categoria +": "+nome;
    }

}
