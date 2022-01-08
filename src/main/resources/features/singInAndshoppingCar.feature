@FeatureName:ComprarPorMedioDelCarroDeCompras
Feature:Comprar por medio del carro de compras
  Como usuario registrado del sistema
  quiero agregar 2 pruductos y pagarlos desde el carro de compras
  para saber si tengo la plata para pagar todo

  @ScenarioName:PagarPorMedioDeUnBanco
  Scenario: Pagar por medio de un banco
    Given el usuario logeado esta en la pagina y desea realizar dos compras
    When el usuario entra a Women y agrega dos productos
    Then el usuario completa los pasos y debera ver el mensaje "Your order on My Store is complete."

  @ScenarioName:PagarPorMedioDeUnCheque
  Scenario: Pagar por medio de un cheque
    Given el usuario logeado entra en la pagina y desea realizar minimo dos compras
    When el usuario entra a Dresses y agrega dos productos
    Then el usuario completa los pasos y deberia ver el mensaje "Your order on My Store is complete."