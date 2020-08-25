Feature: Consultar API
  Como testador
  Quero consultar a API
  Para validar seu funcionamento

  Background: Usuário autenticado
    Given Que realizei o login no sistema com o email carloswinchester07@gmail.com e a senha 001010001

  @automatizado
  Scenario Outline: Consultar a API
    Given Que possua a url da API
    When Realizo uma requisição do tipo GET
    Then Devo receber os dados retornados
    And Exibir o conteúdo do campo name da estrutura list
    And Validar o status code retornado
