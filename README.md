# Selenium Java Mercado Libre Tests

Projeto de Tarefa Final do módulo de Selenium para testes e2e do programa VemSer DBC.

Este projeto utiliza **Selenium**, **Java**, **JUnit**, **Allure Reports** e **JavaFaker** para realizar testes end-to-end (E2E) no site Mercado Libre. Ele abrange cenários que validam funcionalidades essenciais, desde autenticação até navegação e busca de produtos.

## Tecnologias Utilizadas

- [Selenium WebDriver](https://www.selenium.dev/): Framework para automação de testes em navegadores.
- [JUnit](https://junit.org/): Framework para escrita e execução de testes em Java.
- [Allure Reports](https://docs.qameta.io/allure/): Ferramenta para geração de relatórios de execução de testes.
- [JavaFaker](https://github.com/DiUS/java-faker): Biblioteca para geração de dados falsos.

## Cenários de Teste Implementados

### Login
1. **Login com email inválido**: Testa a mensagem de erro ao inserir um email inválido.
2. **Login com email vazio**: Valida a mensagem de erro ao tentar logar sem preencher o campo de email.

### Carrinho e Favoritos
3. **Adicionar Produto ao Carrinho**: Verifica se o produto é adicionado corretamente ao carrinho.
4. **Adicionar Produto aos Favoritos**: Testa a funcionalidade de favoritar um produto.

### Busca e Filtros
5. **Busca de Produto Válido**: Valida que produtos correspondentes ao termo buscado são exibidos.
6. **Buscar CEP pelo Modal de Informar o CEP**: Testa a funcionalidade de busca e exibição de informações baseadas no CEP inserido.
7. **Filtrar por Produtos Mais Vendidos**: Valida se a aplicação retorna os produtos mais vendidos corretamente ao aplicar o filtro.

### Outros Cenários
8. **Navegação pelas Categorias**: Testa a navegação entre diferentes categorias do site.
9. **Exibição de Detalhes do Produto**: Verifica se as informações do produto são exibidas corretamente na página de detalhes.

## Pré-requisitos

- Java (versão 8 ou superior)
- Maven (versão 3.8 ou superior)
- Navegador Google Chrome

## Instalação

1. Clone este repositório:

   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd selenium-e2e-web-mercado-livre
   ```

2. Instale as dependências:

   ```bash
   mvn clean install
   ```

3. Configure o Allure CLI para visualizar os relatórios:

   ```bash
   npm install -g allure-commandline
   ```

## Executando os Testes

### Rodar todos os testes

1. Execute os testes com Maven:

   ```bash
   mvn test
   ```

### Gerar relatórios Allure

1. Após executar os testes, gere os relatórios com o seguinte comando:

   ```bash
   allure serve allure-results
   ```

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias ou novos cenários de teste.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.
