Feature: Realizar consulta
  Como consumidor
  Quero pesquisar um produto
  Para escolher um item

  Background: Usuário na tela do Shoestock
    Given Que estou na página do Shoestock

  @automatizado
  Scenario Outline: Efetuar a consulta de um produto
    When Preencho o campo de busca com o <Produto> desejado
    And Clico no botão de busca
    Then Devo visualizar os itens buscados

    Examples: 
      | Produto                                 |
      | Sapatênis Couro Democrata Hit Masculino |