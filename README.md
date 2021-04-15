# Sistema para E-Commerce

Trabalho prático final da disciplina de Programnação orientada a objetos, trabalhando com a linguagem JAVA.

## Sobre o sistema

Trata-se de um sistema para gestão de vendedores e clientes, onde teremos vários vendedores e clientes, adicionando produtos e comprando os diversos itens disponíveis. O sistema será composto por:

- Vendedor: Poderá adicionar produtos ao sistema, terá uma reputação, formada através das avaliações de clientes e poderá manter seu saldo em vendas armazenados no sistema, podendo realizar o saque quando quiser;

- Cliente: Poderá comprar os mais variados itens no e-commerce, para isso poderá registrar mais de um endereço para entrega e poderá pagar via boleto ou cartão de crédito (Na qual poderá parcelar de 1 à 12x). Este usuário também poderá expressar suas opiniões sobre o produto na sessão de comentários;

- Administrador: Terá um tipo de privilégio na qual poderá moderar os clientes, vendedores e seus produtos. E só ele poderá adicionar novos administradores.

Ao realizar o pagamento do boleto ou acionar o cartão de crédito, o pedido é automaticamente enviado ao cliente.
 
## Sobre o código

O código está obedecendo a arquitetura MVCD, tendo classes representando modelo, dados, controlador e apresentação.
O sistema possui uma função init( ) que realiza uma instância para cada um dos três tipos de usuários, ambos com o Email=a@a.com e Senha=123. Ao usuário vendedor, é associado 3 produtos: teclado, mouse e headset.

## Passos para execução

Basta clonar o repositório no GIT e executar a classe Main, no pacote de apresentação.
https://github.com/gabrielroot/JavaE-CommerceCLI
[Repositório GIT]




## Uso do sistema
### Login
O sistema conta com três opções e login:
#### - Cliente
Este, conta com um painel e 4 opções: Listar produtos, Detalhar produto, Comprar item e Gerir Compras:

  - Listar produtos: Apenas exibe uma visão geral de todos os produtos.

  - Detalhar produto: Irá solicitar o ID do produto, retornar a descrição completa e questionar se deseja ver os comentários referente aquele produto. Ao aceitar, serão  listados todos os comentários e caso o usuário logado queira, poderá inserir um novo comentário.

  - Comprar item: Retorna uma lista de produtos, e solicita  o id e quantidade, dos produtos que o usuário deseja adicionar ao carrinho. Ao finalizar a escolha, o usuário poderá pagar por boleto ou cartão. O boleto terá uma validade de 2 dias a partir da data de emissão e o cartão poderá parcelar a compra de 1 - 12x. O vendedor apenas terá o recebimento das referentes quantias, conforme forem pagas pelo cliente. Ao final, o cliente poderá avaliar todos os vendedores envolvidos em seu carrinho de produtos com uma nota de 0 à 10.0.

  - Gerir compras: Feito a compra, o cliente poderá informar o ID da compra para obter seus detalhes, bem como pagar o boleto único (Pagamento por boleto) ou a próxima parcela do produto (Pagamento por cartão).

#### - Vendedor
Este, conta com um painel e 4 opções: Meus produtos, Novo produto, Ver reputação e Sacar:

  - Meus produtos: Retorna uma lista com todos os produtos do vendedor logado. Na lista conterá todos os comentários, podendo ele enviar uma resposta caso queira.

  - Novo produto: o vendedor poderá adicionar um novo produto.

  - Ver Reputação: Simplesmente verá a sua reputação atual.

  - Sacar: Poderá retirar valores de sua conta no e-commerce.

#### - Administrador
Este, conta com um painel e 4 opções: Deletar vendedor, Deletar cliente, Deletar produto, Cadastrar administrador. Para deletar, serão listadas as opções existentes e para cadastrar serão solicitados os dados do administrador.

### Cadastro
Para o cadastro, apenas serão solicitados os dados do novo usuário.
