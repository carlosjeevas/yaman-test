Feature: Adicionar produto ao carrinho
  Como consumidor
  Quero adicionar um produto ao carrinho
  Para comprar o produto escolhido

  Background: Usuário na tela do Shoestock
    Given Que estou na página do Shoestock

  Scenario Outline: Adicionar um produto no carrinho
    When Preencho o campo de busca com o <Produto> desejado
    And Clico no botão de busca
    And Clico no primeiro item buscado
    And Seleciono o <Tamanho> do tênis
    And Clico no botão comprar
    Then Devo visualizar os itens no carrinho

    Examples: 
      | Produto                                 | Tamanho |
      | Sapatênis Couro Democrata Hit Masculino |      38 |
