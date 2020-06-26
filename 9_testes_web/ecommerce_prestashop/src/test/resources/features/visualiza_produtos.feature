# language: pt
Funcionalidade: Visualizar produtos
  Como um usuario não logado
  Eu quero visualizar produtos disponiveis
  Para poder escolher qual eu vou comprar

  Cenario: Deve mostrar uma lista de oito produtos na pagina inicial
    Dado que estou na pagina inicial
    Quando nao estou logado
    Entao visualizo 8 produtos disponiveis
    E carrinho esta zerado