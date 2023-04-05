package br.com.atividade;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private long id;
    private LocalDate dataPedido;
    private List<Produto> produtos;
    private Cliente cliente;

    public Pedido(long id, LocalDate dataPedido, List<Produto> produtos, Cliente cliente) {
        this.id=id;
        this.dataPedido=dataPedido;
        this.produtos=produtos;
        this.cliente=cliente;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toString() {
        return "Pedido "+ id + ": " + produtos + cliente + "\n" ;
    }

}
