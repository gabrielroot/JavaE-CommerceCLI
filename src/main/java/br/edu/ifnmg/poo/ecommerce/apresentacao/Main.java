/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.apresentacao;

import br.edu.ifnmg.poo.ecommerce.controle.ClienteControlador;
import br.edu.ifnmg.poo.ecommerce.controle.ProdutoControlador;
import br.edu.ifnmg.poo.ecommerce.controle.VendedorControlador;
import br.edu.ifnmg.poo.ecommerce.controle.ComentarioControlador;
import br.edu.ifnmg.poo.ecommerce.controle.CompraControlador;
import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import br.edu.ifnmg.poo.ecommerce.modelo.Comentario;
import br.edu.ifnmg.poo.ecommerce.modelo.Compra;
import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorBoleto;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorCartao;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import br.edu.ifnmg.poo.ecommerce.modelo.Usuario;
import br.edu.ifnmg.poo.ecommerce.modelo.Vendedor;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        do {            
//            System.out.println("======== E-Commerce ========");
//            System.out.println("1 - Cadastros");
//            System.out.println("");
//        } while (true);
        testarVendedor();
        testarCliente();
        testarComentario();
        testarCompra();
        
    }
    
        public static void testarCliente(){
        Cliente cliente = new Cliente("Felipe", "ff@g.com", "76432", "000.000.000-12");
        Cliente cliente2 = new Cliente("Gabriel", "gg@g.com", "1233", "000.000.000-12");
        EnderecoEntrega endereco01 = new EnderecoEntrega("Felipe", "38.340-999", "SP", "Guarulhos", "desconhecido", "rua 1");
        EnderecoEntrega endereco02 = new EnderecoEntrega("Carla", "33.340-999", "AM", "Guarulhos", "desconhecido", "rua 12");
        EnderecoEntrega endereco3  = new EnderecoEntrega("Gabriel", "31.340-669", "PR", "xxxxxx", "desconhecido", "rua 111");
        
        ArrayList<EnderecoEntrega> enderecos = new ArrayList<>();
        ArrayList<EnderecoEntrega> enderecos3 = new ArrayList<>();
        enderecos.add(endereco01);
        enderecos.add(endereco02);
        enderecos3.add(endereco3);
        
        ProdutoControlador produtoControlador = new ProdutoControlador();
        cliente.setCarrinho(produtoControlador.listarProdutos());
        ClienteControlador.editarCliente(cliente.getId(), cliente);
        
        ClienteControlador clientes = new ClienteControlador();
        clientes.cadastrarCliente(cliente, enderecos);
        clientes.cadastrarCliente(cliente2, enderecos3);
        
        
        for(Cliente row : clientes.listarClientes()){
            System.out.println(row.getId());
            System.out.println(row.getNome());
            System.out.println(row.getEmail());
            System.out.println(row.getCpf());
            
            for(EnderecoEntrega endereco : row.getEnderecosEntrega()){
                System.out.println("=====Endereços");
                System.out.println("    "+endereco.getId());
                System.out.println("    "+endereco.getNome());
                System.out.println("    "+endereco.getCep());
                System.out.println("    "+endereco.getEstado());
                System.out.println("    "+endereco.getCidade());
            }
        }
        System.out.println(clientes.buscarCliente(0).getCarrinho().get(0).getDescricao()+" -> Produto do carrinho");
        
    }
    
    public static void testarVendedor(){
        Vendedor vend = new Vendedor("Felipe", "ff@g.com", "76432", "000.000.000-12");
        Vendedor vend2 = new Vendedor("Gabriel", "gg@g.com", "1233", "000.000.000-12");

        VendedorControlador vendedorControlador = new VendedorControlador();
        ProdutoControlador produtoControlador = new ProdutoControlador();
        vendedorControlador.cadastrarVendedor(vend);
        vendedorControlador.cadastrarVendedor(vend2);
        
        
        for(Vendedor row : vendedorControlador.listarVendedores()){
            System.out.println(row.getId());
            System.out.println(row.getNome());
            System.out.println(row.getEmail());
            System.out.println(row.getCpf());
            System.out.println(row.getReputacao());
        }
        
        Produto produto = new Produto("nomeProduto1", "descricaoProduto", 10, 120.50, "categoriaProduto");
        Produto produto2 = new Produto("nomeProduto2", "descricaoProduto", 10, 120.50, "categoriaProduto");
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        
        vend.setProdutos(produtos);
        vendedorControlador.editarVendedor(0,vend);
        System.out.println(vendedorControlador.listarVendedores().get(0).getProdutos().get(0).getNome());
        System.out.println(vendedorControlador.listarVendedores().get(0).getProdutos().get(1).getNome());
        System.out.println(produtoControlador.listarProdutos().get(0).getPreco());
    }

    private static void testarComentario() {
        ProdutoControlador produtoControlador = new ProdutoControlador();
        ClienteControlador clienteControlador = new ClienteControlador();
        ComentarioControlador comentarioControlador = new ComentarioControlador();
        
        Comentario comentario1 = new Comentario("titulo1", "mensagem do comentario no produto 1", produtoControlador.buscarProduto(0), clienteControlador.buscarCliente(0));
        Comentario comentario2 = new Comentario("titulo2", "mensagem do comentario no produto 2", produtoControlador.buscarProduto(1), clienteControlador.buscarCliente(0));
        comentarioControlador.cadastrarComentario(comentario1);
        comentarioControlador.cadastrarComentario(comentario2);
        System.out.println(comentarioControlador.listarComentarios().get(0).getMensagem());
        System.out.println(comentarioControlador.listarComentarios().get(0).getProduto().getNome());
        System.out.println(comentarioControlador.listarComentarios().get(0).getUsuario().getNome());
        if(comentarioControlador.listarComentarios().get(0).getUsuario() instanceof Cliente){
            Cliente cliente = (Cliente) comentarioControlador.listarComentarios().get(0).getUsuario();        
            System.out.println(cliente.getEnderecosEntrega().get(0).getEstado());
        }
        
        for(Comentario coment:comentarioControlador.buscarComentariosPorProduto(produtoControlador.buscarProduto(0))){
            System.out.println(coment.getMensagem());
        }
        
        comentario1.setMensagem(comentario1.getMensagem()+"[EDITADO]");
        comentarioControlador.editarComentario(comentario1);
        
        Usuario user = (Usuario) clienteControlador.buscarCliente(0);
        for(Comentario coment:comentarioControlador.buscarComentariosPorUsuario(user)){
            System.out.println(coment.getMensagem());
        }
    }

    private static void testarCompra() {
        ClienteControlador clienteControlador = new ClienteControlador();
        CompraControlador compraControlador = new CompraControlador();
        ProdutoControlador produtoControlador = new ProdutoControlador();
        PagamentoPorBoleto pagamentoPorBoleto = new PagamentoPorBoleto("cpf", 0, "codBarra", LocalDateTime.of(2021, 4, 20, 0, 0), "nome");
        PagamentoPorCartao pagamentoPorCartao = new PagamentoPorCartao("NomePagamento","Númerocatao23434", "codSeguranca112", 12);
        
        Compra compra = new Compra(pagamentoPorBoleto, produtoControlador.listarProdutos(), clienteControlador.buscarCliente(0));
        Compra compra2 = new Compra(pagamentoPorCartao, produtoControlador.listarProdutos(), clienteControlador.buscarCliente(0));
        compraControlador.cadastrarCompra(compra);
        compraControlador.cadastrarCompra(compra2);
        
        for(Produto produto:compraControlador.buscarCompra(0).getProdutos()){
            System.out.println(produto.getDescricao()+" <- Produtos da compra ");
        }
        PagamentoPorCartao testeCartao = (PagamentoPorCartao) compraControlador.buscarCompra(1).getPagamento();
        System.out.println(testeCartao.getNumero());
        System.out.println(testeCartao.getParcelas().get(5).getValorParcela()+" -> valor das parcelas");
        System.out.println(testeCartao.getParcelas().get(5).isPaga()+" -> Está paga?");
        System.out.println(testeCartao.getParcelas().get(5).getVencimento());
        System.out.println(compraControlador.buscarCompra(1).getCliente().getNome()+" Cliente comprador");
        System.out.println(clienteControlador.buscarCliente(0).getCompras().get(1).getProdutos().size()+" -> N de produtos na compra 2 do comprador");
    }
}
