/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.apresentacao;

import br.edu.ifnmg.poo.ecommerce.controle.AdminControlador;
import br.edu.ifnmg.poo.ecommerce.controle.ClienteControlador;
import br.edu.ifnmg.poo.ecommerce.controle.ProdutoControlador;
import br.edu.ifnmg.poo.ecommerce.controle.VendedorControlador;
import br.edu.ifnmg.poo.ecommerce.controle.ComentarioControlador;
import br.edu.ifnmg.poo.ecommerce.controle.CompraControlador;
import br.edu.ifnmg.poo.ecommerce.modelo.Admin;
import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import br.edu.ifnmg.poo.ecommerce.modelo.Comentario;
import br.edu.ifnmg.poo.ecommerce.modelo.Compra;
import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorBoleto;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorCartao;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import br.edu.ifnmg.poo.ecommerce.modelo.Usuario;
import br.edu.ifnmg.poo.ecommerce.modelo.Vendedor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Main {
    private static Usuario SESSAO = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testarVendedor();
        testarCliente();
        testarComentario();
        testarCompra();
        testarAdmin();
        
        int key = -1;
        Scanner scanner = new Scanner(System.in);
        
        while(key != 0){
            System.out.println("============= E-Commerce =============");
            if(SESSAO == null){
                System.out.println("1 - Logar()");
                System.out.println("2 - Cadastrar()");
                System.out.println("0 - Encerrar Programa()");

                key = Integer.parseInt(scanner.nextLine());
                if(key == 1){
                    login();
                }
                if(key == 2){
                    cadastrar();
                }
                if(key == 0){
                    break;
                }
            }else if(SESSAO instanceof Cliente){
                Cliente clienteLogado = (Cliente) SESSAO;
                System.out.println("        Bem Vindo(a), "+clienteLogado.getNome()+"!\n");
                ProdutoControlador produtoControlador = new ProdutoControlador();
                ClienteControlador clienteControlador = new ClienteControlador();
                
                painelCliente();
                int option = Integer.parseInt(scanner.nextLine());
                
                if(option == 1){
                        System.out.println("            Produtos");
                        System.out.println("------------------------------------------");
                    for(Produto produto : produtoControlador.listarProdutos()){
                        System.out.println("    ID: "+produto.getId());
                        System.out.println("    Nome: "+produto.getNome());
                        System.out.println("    -------------------------------");
                    }
                        System.out.println("------------------------------------------");
                    
                }
                if(option == 2){
                    System.out.println("Informe o id do produto:");
                    int id = Integer.parseInt(scanner.nextLine());
                    Produto produto = produtoControlador.buscarProduto(id);
                    System.out.println("            "+produto.getNome());
                    System.out.println("    -------------------------------");
                    System.out.println("    ID: "+produto.getId());
                    System.out.println("    Descrição: "+produto.getDescricao());
                    System.out.println("    Preco: "+produto.getPreco());
                    System.out.println("    Quantidade: "+produto.getEstoque());
                    System.out.println("    Categoria: "+produto.getCategoria());
                    System.out.println("    Avaliação: "+produto.getAvaliacao());
                    System.out.println("    -------------------------------");
                    System.out.println("Ver comentarios? (S/N)");
                    char bool = scanner.nextLine().charAt(0);
                    if(bool == 's' || bool == 'S'){
                        ComentarioControlador comentarioControlador = new ComentarioControlador();
                        ArrayList<Comentario> comentarios = comentarioControlador.buscarComentariosPorProduto(produto);
                            System.out.println("                Comentarios");
                        System.out.println("    ------------------------------------------");
                        for(Comentario comentario : comentarios){
                            System.out.println("        Título: "+comentario.getTitulo());
                            System.out.println("        Autor: "+comentario.getUsuario().getNome());
                            System.out.println("        Mensagem:"+comentario.getMensagem());
                            System.out.println("        Data/Hora: "+comentario.getData().getYear()+"/"+comentario.getData().getMonth()+"/"+
                                    comentario.getData().getDayOfMonth()+" - "+comentario.getData().getHour()+"h:"+comentario.getData().getMinute());
                            System.out.println("        -------------------------------");
                        }
                    }
                    System.out.println("Comentar? (S/N)");
                    bool = scanner.nextLine().charAt(0);
                    if(bool == 's' || bool == 'S'){
                        System.out.print("    Titulo do Comentario: ");
                        String titulo = scanner.nextLine();
                        System.out.print("    Mensagem do Comentario: ");
                        String mensagem = scanner.nextLine();
                        Comentario comentario = new Comentario(titulo, mensagem, produto, clienteLogado);
                        ComentarioControlador comentarioControlador = new ComentarioControlador();
                        comentarioControlador.cadastrarComentario(comentario);
                    }
                }
                if(option == 3){
                    CompraControlador compraControlador = new CompraControlador();
                    ArrayList<Produto> produtos = new ArrayList<>();
                    int id = -1;
                    while(id != 0){
                        for(Produto produto : produtoControlador.listarProdutos()){
                            System.out.println("    ID: "+produto.getId());
                            System.out.println("    Nome: "+produto.getNome());
                        }

                        System.out.println("Id do produto que deseja: (0 para finalizar)");
                        id = Integer.parseInt(scanner.nextLine());
                        if(id != 0){
                            System.out.println("Quantidade");
                            int qtde = Integer.parseInt(scanner.nextLine());
                            Produto produto = produtoControlador.buscarProduto(id);
                            if(produto != null){
                                if(produto.getEstoque() >= qtde){
                                    for(int i=0;i<qtde;i++){
                                        produtos.add(produto);
                                        produto.setEstoque(produto.getEstoque()-1);
                                    }
                                }else{
                                    System.out.println("Falha: Quantidade em estoque é insuficiente.");
                                }
                            }
                        }
                    }
                    
                    clienteLogado.setCarrinho(produtos);
                    clienteControlador.editarCliente(clienteLogado.getId(), clienteLogado);
                    
                    System.out.println("Informe o método de pagamento:");
                    System.out.println("1 - Cartão");
                    System.out.println("2 - Boleto");
                    int metodoPagamento = Integer.parseInt(scanner.nextLine());
                    
                    Compra compra = null;
                    
                    if(metodoPagamento == 1){
                        System.out.println("Nome para o cartão:");
                        System.out.println("Número do cartão:");
                        System.out.println("Código de Segurança:");
                        PagamentoPorCartao pagamentoPorCartao = new PagamentoPorCartao("NomePagamento","Númerocatao23434", "codSeguranca112", 12);
                        compra = new Compra(pagamentoPorCartao, clienteLogado.getCarrinho(), clienteLogado);
                        System.out.println("Compra realizada!!");
                        System.out.println("Primeira parcela vence em:");
                        System.out.println("Valor das parcelas:");
                    }else if(metodoPagamento == 2){
                        System.out.println("Nome do pagador:");
                        System.out.println("CPF:");
                        String codBarra = "231047543719457";
                        
                        double valorTotal = 0;
                        for(Produto produto:clienteLogado.getCarrinho()){
                            valorTotal += produto.getPreco();
                        }
                        
                        PagamentoPorBoleto pagamentoPorBoleto = new PagamentoPorBoleto("cpf", valorTotal, codBarra, "nome");
                        compra = new Compra(pagamentoPorBoleto, clienteLogado.getCarrinho(), clienteLogado);
                    }
                    
                    compraControlador.cadastrarCompra(compra);
                    produtos.clear();
                    clienteLogado.setCarrinho(produtos);
                    clienteControlador.editarCliente(clienteLogado.getId(), clienteLogado);
                }
                if(option == 0){
                    break;
                }
            }
        }
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
        Produto produto3 = new Produto("nomeProduto3", "descricaoProduto", 10, 120.50, "categoriaProduto");
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        produtos.add(produto3);
        
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
        PagamentoPorBoleto pagamentoPorBoleto = new PagamentoPorBoleto("cpf", 10, "codBarra", "nome");
        PagamentoPorCartao pagamentoPorCartao = new PagamentoPorCartao("NomePagamento","Númerocatao23434", "codSeguranca112", 12);
        
        Compra compraBoleto = new Compra(pagamentoPorBoleto, produtoControlador.listarProdutos(), clienteControlador.buscarCliente(0));
        Compra compraCartao = new Compra(pagamentoPorCartao, produtoControlador.listarProdutos(), clienteControlador.buscarCliente(0));
        compraControlador.cadastrarCompra(compraBoleto);
        compraControlador.cadastrarCompra(compraCartao);
        
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
    
        PagamentoPorBoleto testeBoleto = (PagamentoPorBoleto) compraControlador.buscarCompra(0).getPagamento();
        System.out.println(testeBoleto.getCpf());
        System.out.println(testeBoleto.getValor());
        System.out.println(testeBoleto.getVencimento());
        System.out.println(testeBoleto.isPago()+" -> Está pago?");
        testeBoleto.pagarBoleto();
        System.out.println(testeBoleto.isPago()+" -> Está pago?");
    }

    private static void testarAdmin() {
        AdminControlador adminControlador = new AdminControlador();
        ProdutoControlador produtoControlador = new ProdutoControlador();
        ClienteControlador clienteControlador = new ClienteControlador();
        VendedorControlador vendedorControlador = new VendedorControlador();
        
        ArrayList<Produto> produtosDeletados = new ArrayList<>();
        
        produtosDeletados.add(produtoControlador.buscarProduto(0));
        
        Admin admin = new Admin("nomeAdmin", "emailAdmin", "senhaAdmin", "cpfAdmin");
        adminControlador.cadastrarAdmin(admin);
        System.out.println(adminControlador.buscarAdmin(0).getProdutosDeletados());
        admin.setProdutosDeletados(produtosDeletados);
        adminControlador.editarAdmin(0, admin);
        System.out.println(adminControlador.buscarAdmin(0).getProdutosDeletados().get(0).getNome()+" - Produto deletado pelo admin");

        
        ArrayList<Cliente> clientesDeletados = new ArrayList<>();
        
        clientesDeletados.add(clienteControlador.buscarCliente(0));
        admin.setClientesDeletados(clientesDeletados);
        adminControlador.editarAdmin(0, admin);
        System.out.println(adminControlador.buscarAdmin(0).getClientesDeletados().get(0).getNome()+" - Cliente deletado pelo admin");
        
        
        ArrayList<Vendedor> vendedoresDeletados = new ArrayList<>();
        
        vendedoresDeletados.add(vendedorControlador.buscarVendedor(0));
        admin.setVendedoresDeletados(vendedoresDeletados);
        adminControlador.editarAdmin(0, admin);
        System.out.println(adminControlador.buscarAdmin(0).getVendedoresDeletados().get(0).getNome()+" - Vendedor deletado pelo admin");
        
        System.out.println("");
        
        for(Produto produto : produtoControlador.listarProdutos()){
            System.out.println(produto.getNome()+" - Produto restante");
        }
        for(Cliente cliente : clienteControlador.listarClientes()){
            System.out.println(cliente.getNome()+" - cliente restante");
        }
        for(Vendedor vendedor : vendedorControlador.listarVendedores()){
            System.out.println(vendedor.getNome()+" - Vendedor restante");
        }
        
        Admin admin2 = new Admin("nome", "email", "senha", "cpf");
        admin.addAdmin(admin2);
    }

    private static void login() {
        System.out.println("Seu email:...");
        System.out.println("Sua senha:...");
        SESSAO = new Cliente("nome", "email", "senha", "cpf");
    }

    private static void cadastrar() {
        System.out.println("Cliente ou Vendedor?");
        System.out.println("nome");
        System.out.println("email");
        System.out.println("senha");
        System.out.println("cpf");
        
        System.out.println("cadastrar endereco?");
        System.out.println("    Nome");
        System.out.println("    Cep");
        System.out.println("    estado");
        System.out.println("    cidade");
        System.out.println("    bairro");
        System.out.println("    Rua/Avenida");
        
        System.out.println("cadastrar produto?");
        System.out.println("    nome");
        System.out.println("    descricao");
        System.out.println("    estoque");
        System.out.println("    preco");
        System.out.println("    categoria");
    }
    
    private static void painelCliente(){
        System.out.println("1 - Listar Produtos()");
        System.out.println("2 - Detalhar Produto()");
        System.out.println("3 - Comprar Item()");
        System.out.println("4 - Histórico de Compras()");
    }
}
