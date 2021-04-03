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
import br.edu.ifnmg.poo.ecommerce.controle.PagamentoPorBoletoControlador;
import br.edu.ifnmg.poo.ecommerce.controle.PagamentoPorCartaoControlador;
import br.edu.ifnmg.poo.ecommerce.modelo.Admin;
import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import br.edu.ifnmg.poo.ecommerce.modelo.Comentario;
import br.edu.ifnmg.poo.ecommerce.modelo.Compra;
import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorBoleto;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorCartao;
import br.edu.ifnmg.poo.ecommerce.modelo.Parcela;
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
        init();
        
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
                System.out.println("        Bem Vindo(a), "+clienteLogado.getNome()+"! [CLIENTE]\n");
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
                        System.out.println("    Quantidade: "+produto.getEstoque());
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
                            System.out.println("        Data/Hora: "+comentario.getDate());
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
                    int id = -2;
                    for(Produto produto : produtoControlador.listarProdutos()){
                        System.out.println("-----------------------------------");
                        System.out.println("            "+produto.getNome());
                        System.out.println("    -------------------------------");
                        System.out.println("    ID: "+produto.getId());
                        System.out.println("    Preco: "+produto.getPreco());
                        System.out.println("    Quantidade: "+produto.getEstoque());
                    }
                    while(id != -1){
                        System.out.println("Id do produto que deseja: (-1 para finalizar)");
                        id = Integer.parseInt(scanner.nextLine());
                        if(id != -1){
                            System.out.println("Quantidade");
                            int qtde = Integer.parseInt(scanner.nextLine());
                            Produto produto = produtoControlador.buscarProduto(id);
                            if(produto != null){
                                if(produto.getEstoque() >= qtde){
                                    for(int i=0;i<qtde;i++){
                                        produtos.add(produto);
                                    }
                                }else{
                                    System.out.println("Falha: Quantidade em estoque é insuficiente.");
                                }
                            }
                        }
                    }
                    if(produtos.size()>0){
                        
                        clienteLogado.setCarrinho(produtos);
                        clienteControlador.editarCliente(clienteLogado.getId(), clienteLogado);

                        System.out.println("Informe o método de pagamento:");
                        System.out.println("1 - Cartão");
                        System.out.println("2 - Boleto");
                        int metodoPagamento = Integer.parseInt(scanner.nextLine());

                        Compra compra = null;

                        if(metodoPagamento == 1){
                            System.out.print("Nome para o cartão: ");
                            String nome = scanner.nextLine();
                            System.out.print("Número do cartão: ");
                            String numero = scanner.nextLine();
                            System.out.print("Código de Segurança: ");
                            String codSeguranca = scanner.nextLine();
                            System.out.print("Deseja parcelar? (S/N)");
                            char bool = scanner.nextLine().charAt(0);
                            int numeroParcelas = 1;
                            if(bool == 's' || bool == 'S'){
                                while(numeroParcelas > 12 || numeroParcelas == 1){
                                    System.out.println("Quantas parcelas? (MÁX = 12)");
                                    numeroParcelas = Integer.parseInt(scanner.nextLine());
                                }
                            }
                            PagamentoPorCartao pagamentoPorCartao = new PagamentoPorCartao(nome,numero, codSeguranca, numeroParcelas);
                            System.out.println("                Compra realizada!!");
                            PagamentoPorCartaoControlador pagamentoPorCartaoControlador = new PagamentoPorCartaoControlador();
                            pagamentoPorCartaoControlador.cadastrarPagamentoPorCartao(pagamentoPorCartao);
                            compra = new Compra(pagamentoPorCartao, clienteLogado.getCarrinho(), clienteLogado);
                            pagamentoPorCartaoControlador.parcelar(pagamentoPorCartao, compra);
                            PagamentoPorCartao dadosPagamento = pagamentoPorCartaoControlador.buscarPagamentoPorCartao(pagamentoPorCartao.getId());

                            System.out.println("Primeira parcela vence em: "+dadosPagamento.getParcelas().get(0).getDate());
                            System.out.printf("Valor das parcelas: %.2f\n",dadosPagamento.getParcelas().get(0).getValorParcela());
                        }else if(metodoPagamento == 2){
                            System.out.println("Nome do pagador:");
                            String nome = scanner.nextLine();
                            System.out.println("CPF:");
                            String cpf = scanner.nextLine();
                            String codBarra = "231047543719457";

                            double valorTotal = 0;
                            for(Produto produto:clienteLogado.getCarrinho()){
                                valorTotal += produto.getPreco();
                            }

                            PagamentoPorBoleto pagamentoPorBoleto = new PagamentoPorBoleto(cpf, valorTotal, codBarra, nome);
                            PagamentoPorBoletoControlador pagamentoPorBoletoControlador = new PagamentoPorBoletoControlador();
                            pagamentoPorBoletoControlador.cadastrarPagamentoPorBoleto(pagamentoPorBoleto);
                            compra = new Compra(pagamentoPorBoleto, clienteLogado.getCarrinho(), clienteLogado);

                            System.out.println("    Valor do boleto: "+pagamentoPorBoleto.getValor());
                            System.out.println("    Vencimento: "+pagamentoPorBoleto.getDate());
                            System.out.println("                Compra realizada!!");
                        }
                        compra.setProdutos(clienteLogado.getCarrinho());
                        clienteLogado.comprar(compra);
                        System.out.println("Avaliar Vendedor? (S/N)");
                        char bool = scanner.nextLine().charAt(0);
                        if(bool == 's' || bool == 'S'){
                            System.out.println("Pontuação de 0.0 à 10.0:");
                            double pontuacao = Double.parseDouble(scanner.nextLine());
                            if(clienteLogado.avaliarVendedor(compra, pontuacao)){
                                System.out.println("Obrigado!");
                            }
                        }
                    }else{
                        System.out.println("        Carrinho Vazio. Compra não realizada");
                    }
                }else if(option == 4){
                    CompraControlador compraControlador = new CompraControlador();
                    System.out.println("--------------------------------");
                    for(Compra compra:compraControlador.listarCompras()){
                        if(compra.getCliente().equals(clienteLogado)){
                            
                            System.out.println("    ID: "+compra.getId());
                            if(compra.getPagamento() instanceof PagamentoPorBoleto){
                                PagamentoPorBoleto pagamentoPorBoleto = (PagamentoPorBoleto) compra.getPagamento();
                                if(pagamentoPorBoleto.isPago()){
                                    System.out.println("    Está paga?: SIM.");
                                }else{
                                    System.out.println("    Está paga?: NÃO.");
                                }
                                System.out.println("    Método de Pagamento: BOLETO");
                                System.out.println("    Data de Vencimento: "+pagamentoPorBoleto.getDate());
                            }else if(compra.getPagamento() instanceof PagamentoPorCartao){
                                PagamentoPorCartao pagamentoPorCartao = (PagamentoPorCartao) compra.getPagamento();
                                System.out.println("    Método de Pagamento: CARTÃO");
                                System.out.println("    Número de parcelas: "+pagamentoPorCartao.getParcelas().size());
                                System.out.println("    Valor das parcelas: "+pagamentoPorCartao.getParcelas().get(0).getValorParcela());
                            }
                            System.out.println("    Número de produtos: "+compra.getProdutos().size());
                            System.out.printf("    Valor Total: R$ %.2f\n",compra.valorTotal());
                            System.out.println("    ----------------------");
                        }
                    }
                    System.out.println("--------------------------------");

                    System.out.println("1 - Detalhar compra()");
                    System.out.println("0 - Voltar()");
                    int opt = Integer.parseInt(scanner.nextLine());
                    if(opt == 1){
                        System.out.print("Informe o ID da compra: ");
                        int idCompra = Integer.parseInt(scanner.nextLine());
                        Compra compra = compraControlador.buscarCompra(idCompra);
                        if(compra != null){
                            System.out.println("        Produtos:");
                            for(Produto produto:compra.getProdutos()){
                                System.out.println("            Nome: "+produto.getNome());
                                System.out.printf("            Preco: %.2f\n",produto.getPreco());
                                System.out.println("            ----------------------");
                            }
                            if(compra.getPagamento() instanceof PagamentoPorBoleto){
                                PagamentoPorBoleto pagamentoPorBoleto = (PagamentoPorBoleto) compra.getPagamento();
                                if(!pagamentoPorBoleto.isPago()){
                                    PagamentoPorBoletoControlador pagamentoPorBoletoControlador = new PagamentoPorBoletoControlador();
                                    VendedorControlador vendedorControlador = new VendedorControlador();
                                    System.out.println("Pagar boleto? (S/N)");
                                    char bool = scanner.nextLine().charAt(0);
                                    if(bool == 's' || bool == 'S'){
                                        for(Produto produto : compra.getProdutos()){
                                            Vendedor vendedor = vendedorControlador.buscarVendedorPorProduto(produto);
                                            vendedor.setSaldo(vendedor.getSaldo()+produto.getPreco());
                                            vendedorControlador.editarVendedor(vendedor.getId(), vendedor);
                                            System.out.println("OK. Boleto pago!");
                                        }
                                    }
                                }
                            }
                            if(compra.getPagamento() instanceof PagamentoPorCartao){
                                int numeroParcelasPagas = 0;

                                PagamentoPorCartao pagamentoPorCartao = (PagamentoPorCartao) compra.getPagamento();
                                for(Parcela parcela:pagamentoPorCartao.getParcelas()){
                                    if(parcela.isPaga()){
                                        numeroParcelasPagas++;
                                    }else{
                                        System.out.println("        Número de parcelas pagas: "+numeroParcelasPagas);
                                        System.out.println("        Próxima parcela: "+parcela.getVencimento().getDayOfMonth()+"/"+
                                                parcela.getVencimento().getMonth());
                                        break;
                                    }
                                }
                                if(pagamentoPorCartao.getParcelas().get(pagamentoPorCartao.getParcelas().size()-1).isPaga() == false){
                                    System.out.println("Pagar próxima parcela? (S/N)");
                                    char bool = scanner.nextLine().charAt(0);
                                    if(bool == 's' || bool == 'S'){
                                        PagamentoPorCartaoControlador pagamentoPorCartaoControlador = new PagamentoPorCartaoControlador();
                                        VendedorControlador vendedorControlador = new VendedorControlador();
                                        for(Parcela parcela:pagamentoPorCartao.getParcelas()){
                                            if(!parcela.isPaga()){
                                                parcela.setPaga(true);
                                                pagamentoPorCartaoControlador.editarPagamentoPorCartao(pagamentoPorCartao.getId(), pagamentoPorCartao);
                                                for(Produto produto : compra.getProdutos()){
                                                    Vendedor vendedor = vendedorControlador.buscarVendedorPorProduto(produto);
                                                    vendedor.setSaldo(vendedor.getSaldo()+parcela.getValorParcela()/compra.getProdutos().size());
                                                    vendedorControlador.editarVendedor(vendedor.getId(), vendedor);
                                                }
                                                System.out.println("OK. Parcela Paga!");
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(option == 0){
                    SESSAO = null;
                }
            }else if(SESSAO instanceof Vendedor){
                Vendedor vendedorLogado = (Vendedor) SESSAO;
                System.out.println("        Bem Vindo(a), "+vendedorLogado.getNome()+"! [VENDEDOR]\n");

                painelVendedor();
                int option = Integer.parseInt(scanner.nextLine());
                ComentarioControlador comentarioControlador = new ComentarioControlador();
                ArrayList<Comentario> comentarios;
                if(option == 1){
                    for(Produto produto:vendedorLogado.getProdutos()){
                        System.out.println("-----------------------------------");
                        System.out.println("            "+produto.getNome());
                        System.out.println("    -------------------------------");
                        System.out.println("    ID: "+produto.getId());
                        System.out.println("    Preco: "+produto.getPreco());
                        System.out.println("    Quantidade: "+produto.getEstoque());
                        System.out.println("                Comentarios");
                        System.out.println("    ------------------------------------------");
                        comentarios = comentarioControlador.buscarComentariosPorProduto(produto);
                        for(Comentario comentario : comentarios){
                            System.out.println("        Título: "+comentario.getTitulo());
                            System.out.println("        Autor: "+comentario.getUsuario().getNome());
                            System.out.println("        Mensagem:"+comentario.getMensagem());
                            System.out.println("        Data/Hora: "+comentario.getDate());
                            System.out.println("        -------------------------------");
                        }
                    }
                    ProdutoControlador produtoControlador = new ProdutoControlador();
                    if(produtoControlador.listarProdutos().size() > 0){
                        
                        System.out.println("Comentar? (S/N)");

                        char bool = scanner.nextLine().charAt(0);
                        if(bool == 's' || bool == 'S'){
                            System.out.println("Informe o ID do produto: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            Produto produto = produtoControlador.buscarProduto(id);
                            System.out.print("    Titulo do Comentario: ");
                            String titulo = scanner.nextLine();
                            System.out.print("    Mensagem do Comentario: ");
                            String mensagem = scanner.nextLine();
                            Comentario comentario = new Comentario(titulo, mensagem, produto, vendedorLogado);
                            comentarioControlador.cadastrarComentario(comentario);
                        }
                    }
                }else if(option == 2){
                    System.out.println("            Novo Produto");
                    System.out.print("    Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("    Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("    Quantidade em Estoque: ");
                    int estoqueProduto = Integer.parseInt(scanner.nextLine());
                    System.out.print("    Valor unitário: ");
                    double preco = Double.parseDouble(scanner.nextLine());
                    System.out.print("    Categoria: ");
                    String categoria = scanner.nextLine();
                    
                    Produto produto = new Produto(nome, descricao, estoqueProduto, preco, categoria);
                    vendedorLogado.addProduto(produto);
                    System.out.println("Pronto!!");
                }else if(option == 3){
                    System.out.printf("Reputação: %.2f\n",vendedorLogado.getReputacao());
                }else if(option == 4){
                    System.out.printf("Saldo: %.2f\n",vendedorLogado.getSaldo());
                    System.out.println("Valor do saque: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    vendedorLogado.sacar(valor);
                }else if(option == 0){
                    SESSAO = null;
                }
            }else if(SESSAO instanceof Admin){
                Admin adminLogado = (Admin) SESSAO;
                
                System.out.println("        Bem Vindo(a), "+adminLogado.getNome()+"! [ADMINISTRADOR]\n");
                painelAdmin();
                int option = Integer.parseInt(scanner.nextLine());
                if(option == 1){
                    VendedorControlador vendedorControlador = new VendedorControlador();
                    System.out.println("            Vendedores");
                    System.out.println("-----------------------------------------");
                    for(Vendedor vendedor:vendedorControlador.listarVendedores()){
                        System.out.println("    ID: "+vendedor.getId());
                        System.out.println("    Nome: "+vendedor.getNome());
                        System.out.println("    --------------------");
                    }
                    System.out.print("Informe o ID do vendedor: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if(adminLogado.deletarVendedor(id)){
                        System.out.println("Vendedor deletado!");
                    }else{
                        System.out.println("Vendedor não encontrado.");
                    }
                    
                }else if(option == 2){
                    ClienteControlador clienteControlador = new ClienteControlador();
                    System.out.println("            Clientes");
                    System.out.println("-----------------------------------------");
                    for(Cliente cliente:clienteControlador.listarClientes()){
                        System.out.println("    ID: "+cliente.getId());
                        System.out.println("    Nome: "+cliente.getNome());
                        System.out.println("    --------------------");
                    }
                    System.out.print("Informe o ID do cliente: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if(adminLogado.deletarCliente(id)){
                        System.out.println("Cliente deletado!");
                    }else{
                        System.out.println("Cliente não encontrado.");
                    }
                }else if(option == 3){
                    ProdutoControlador produtoControlador = new ProdutoControlador();
                    System.out.println("            Produtos");
                    System.out.println("-----------------------------------------");
                    for(Produto produto:produtoControlador.listarProdutos()){
                        System.out.println("    ID: "+produto.getId());
                        System.out.println("    Nome: "+produto.getNome());
                        System.out.println("    --------------------");
                    }
                    System.out.print("Informe o ID do produto: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if(adminLogado.deletarProduto(id)){
                        System.out.println("Produto deletado!");
                    }else{
                        System.out.println("Produto não encontrado.");
                    }
                }else if(option == 4){
                    System.out.print("    Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("    Email: ");
                    String email = scanner.nextLine();
                    System.out.print("    Senha: ");
                    String senha = scanner.nextLine();
                    System.out.print("    CPF: ");
                    String cpf = scanner.nextLine();
                    
                    Admin admin = new Admin(nome, email, senha, cpf);
                    
                    adminLogado.addAdmin(admin);
                    System.out.println("Cadastro realizado!!");
                }else if(option == 0){
                    SESSAO = null;
                }
            }
        }
    }
    
    public static void init(){
        ClienteControlador clienteControlador = new ClienteControlador();
        VendedorControlador vendedorControlador = new VendedorControlador();
        AdminControlador adminControlador = new AdminControlador();
        
        Cliente cliente = new Cliente("João", "a@a.com", "123", "000.000.000-12");
        EnderecoEntrega endereco = new EnderecoEntrega("José Santos", "38.340-999", "SP", "Guarulhos", "desconhecido", "rua 1");
        ArrayList<EnderecoEntrega> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        
        Vendedor vendedor = new Vendedor("Maria", "a@a.com", "123", "000.000.000-12");
        Produto produto1 = new Produto("Mouse", "Mouse gamer 3000dpi", 30, 79.90, "Acessórios Informática");
        Produto produto2 = new Produto("Teclado", "Teclado mecânico RedDragon", 70, 120.80, "Acessórios Informática");
        Produto produto3 = new Produto("Headset", "Headset Gamer RGB com microfone", 50, 98, "Acessórios Informática");
        vendedorControlador.cadastrarVendedor(vendedor);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        vendedor.setProdutos(produtos);
        vendedor.setReputacao(5);
        vendedor.setSaldo(100);
        vendedorControlador.editarVendedor(vendedor.getId(), vendedor);
        
        Admin admin = new Admin("Admin", "a@a.com", "123", "000.000.000-12");
        
        clienteControlador.cadastrarCliente(cliente, enderecos);
        adminControlador.cadastrarAdmin(admin);
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("            Login ");
        System.out.println("1 - Cliente ");
        System.out.println("2 - Vendedor");
        System.out.println("3 - Administrador ");
        int opt = Integer.parseInt(scanner.nextLine());
        
        System.out.println("    Seu email: ");
        String email = scanner.nextLine();
        System.out.println("    Sua senha: ");
        String senha = scanner.nextLine();
        
        String mensagem = "Email e/ou senha incorretos.";
        if(opt == 1){
            ClienteControlador clienteControlador = new ClienteControlador();
            for(Cliente cliente:clienteControlador.listarClientes()){
                if(email.equals(cliente.getEmail()) && senha.equals(cliente.getSenha())){
                    SESSAO = cliente;
                    return;
                }
            }
        }else if(opt == 2){
            VendedorControlador vendedorControlador = new VendedorControlador();
            for(Vendedor vendedor:vendedorControlador.listarVendedores()){
                System.out.println(vendedor.getEmail()+"|"+ vendedor.getSenha());
                if(email.equals(vendedor.getEmail()) && senha.equals(vendedor.getSenha())){
                    SESSAO = vendedor;
                    return;
                    
                }
            }            
        }else if(opt == 3){
            AdminControlador adminControlador = new AdminControlador();
            for(Admin admin:adminControlador.listarAdmins()){
                if(email.equals(admin.getEmail()) && senha.equals(admin.getSenha())){
                    SESSAO = admin;
                    return;
                }
            }            
        }
        System.out.println(mensagem);
    }

    private static void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("            CADASTRAR");
        System.out.println("1 - Cliente");
        System.out.println("2 - Vendedor");
        int opt = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        if(opt == 1){
            System.out.println("Endereço");
            System.out.print("  Nome para Endereço: ");
            String nomeEndereco = scanner.nextLine();
            System.out.print("  CEP: ");
            String cep = scanner.nextLine();
            System.out.print("  Estado: ");
            String estado = scanner.nextLine();
            System.out.print("  Cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("  Bairro: ");
            String bairro = scanner.nextLine();
            System.out.print("  Rua/Avenida: ");
            String ruaAv = scanner.nextLine();
                
            Cliente cliente = new Cliente(nome, email, senha, cpf);
            EnderecoEntrega endereco = new EnderecoEntrega(nomeEndereco, cep, estado, cidade, bairro, ruaAv);
            ArrayList<EnderecoEntrega> enderecos = new ArrayList<>();
            enderecos.add(endereco);
            cliente.setEnderecosEntrega(enderecos);
            ClienteControlador clienteControlador = new ClienteControlador();
            clienteControlador.cadastrarCliente(cliente, enderecos);
            System.out.println("CADASTRADO!");
        }else if(opt == 2){
            Vendedor vendedor = new Vendedor(nome, email, senha, cpf);
            VendedorControlador vendedorControlador = new VendedorControlador();
            vendedorControlador.cadastrarVendedor(vendedor);
            System.out.println("CADASTRADO!");
        }
    }
    
    private static void painelCliente(){
        System.out.println("1 - Listar Produtos()");
        System.out.println("2 - Detalhar Produto()");
        System.out.println("3 - Comprar Item()");
        System.out.println("4 - Gerir Compras()");
        System.out.println("0 - Sair()");
    }

    private static void painelVendedor() {
        System.out.println("1 - Meus Produtos()");
        System.out.println("2 - Novo Produto()");
        System.out.println("3 - Ver reputação()");
        System.out.println("4 - Sacar()");
        System.out.println("0 - Sair()");
    }

    private static void painelAdmin() {
        System.out.println("1 - Deletar Vendedor()");
        System.out.println("2 - Deletar Cliente()");
        System.out.println("3 - Deletar Produto()");
        System.out.println("4 - Cadastrar Administrador()");
        System.out.println("0 - Sair()");
    }
}
