Feature: Validar tela de pagamento
  Como consumidor
  Quero visualizar a tela de pagamento
  Para prosseguir com a compra

  Background: Usuário autenticado
    Given Que realizei o login no sistema com o email testeautomatizado@teste.com e a senha 0123456789

  Scenario Outline: Validar tela de pagamento
    When Preencho o campo de busca com o <Produto> desejado
    And Clico no botão de busca
    And Clico no primeiro item buscado
    And Seleciono o <Tamanho> do tênis
    And Clico no botão comprar
    And Clico no botão continuar
    Then Devo visualizar a tela de pagamento com o itens adicionados

    Examples: 
      | Produto                                 | Tamanho | Email                        | Senha     |
      | Sapatênis Couro Democrata Hit Masculino |      38 | carloswinchester07@gmail.com | 001010001 |
