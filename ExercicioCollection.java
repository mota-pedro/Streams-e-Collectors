package br.com.atividade;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExercicioCollection {
    public static void main(String[] args) {

        Cliente c1 = new Cliente(1111222, "Pedro");
        Cliente c2 = new Cliente(5123765, "Jonas");
        Cliente c3 = new Cliente(4567890, "Emanoel");

        List<Cliente> listaClientes = Arrays.asList(c1,c2,c3);

        Produto p1 = new Produto(12756, "Borracha", "Papelaria", 5.0);
        Produto p2 = new Produto(57934, "Caderno", "Papelaria", 12.0);
        Produto p3 = new Produto(29873, "Caneta", "Papelaria", 2.5);
        Produto p4 = new Produto(56789, "The Witcher", "Livro", 30.0);
        Produto p5 = new Produto(23984, "O Hobbit", "Livro", 25.0);
        Produto p6 = new Produto(90127, "Duna", "Livro", 50.0);
        Produto p7 = new Produto(44657, "Elden Ring", "Jogo", 200.0);
        Produto p8 = new Produto(23555, "Hollow Knight", "Jogo", 35.0);
        Produto p9 = new Produto(33455, "Resident Evil 4", "Jogo", 250.0);

        List<Produto> listaProdutos = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9);

        Pedido pd1 = new Pedido(14899,
                LocalDate.of(2023,04,05), Arrays.asList(p4,p7),c1
        );
        Pedido pd2 = new Pedido(15698,
                LocalDate.of(2023,03,22), Arrays.asList(p2,p3,p9),c1
        );
        Pedido pd3 = new Pedido(16879,
                LocalDate.of(2023,03,15), Arrays.asList(p1,p5,p6),c2
        );
        Pedido pd4 = new Pedido(17799,
                LocalDate.of(2023,03,02), Arrays.asList(p2,p8),c2
        );
        Pedido pd5 = new Pedido(18866,
                LocalDate.of(2023,01,1), Arrays.asList(p7,p8,p9),c3
        );
        Pedido pd6 = new Pedido(19829,
                LocalDate.of(2023,02,26), Arrays.asList(p1,p2,p3,p4,p5),c3
        );

        //1

        List<Pedido> listaPedidos = Arrays.asList(pd1,pd2,pd3,pd4,pd5,pd6);

        Stream<Produto> produtoStream = listaProdutos.stream()
                .filter(p -> p.getCategoria().equals("Jogo"))
                .filter(p -> p.getPreco()<100);

        System.out.println("Jogos abaixo de R$ 100.00: \n" + produtoStream.collect(Collectors.toList()));

        System.out.println("-----------------------------------------------------------------------------------------");

        //2

        Stream<Pedido> pedidoStream = listaPedidos.stream()
                .filter(pedido -> pedido.getProdutos().stream().anyMatch(produto -> produto.getCategoria().equals("Papelaria")));

        System.out.println("Pedidos com produtos de papelaria: \n" + pedidoStream.collect(Collectors.toList()));

        System.out.println("-----------------------------------------------------------------------------------------");

        //3

        Stream<Produto> produtosPorCategoriaStream = listaProdutos.stream().sorted(Comparator.comparing(Produto::getCategoria));
        System.out.println("Produtos ordenados por categoria: \n" + produtosPorCategoriaStream.collect(Collectors.toList()));

        System.out.println("-----------------------------------------------------------------------------------------");

        //4

        Stream<Pedido> pedidoMaisRecenteStream = listaPedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getCliente, Collectors.maxBy(Comparator.comparing(Pedido::getDataPedido))))
                .values()
                .stream()
                .map(Optional::get);

        System.out.println("Pedido mais recente por cliente: \n" + pedidoMaisRecenteStream.collect(Collectors.toList()));

    }
}
