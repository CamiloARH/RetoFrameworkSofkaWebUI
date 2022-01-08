@FeatureName:ContactUS
Feature:Escribir en contact us
  Como usuario registrado del sistema
  quiero contactarme con servicio al cliente
  para saber cuando llega la nueva coleccion

  @ScenarioName:LlenarTodosLosCamposObligatorios
  Scenario: Llenar todos los campos obligatorios
    Given el usuario esta en la pagina y desea contactarse con servicio al cliente
    When el usuario llena todos los campos
    Then el usuario deberia ver el mensaje "Your message has been successfully sent to our team."

  @ScenarioName:OlvidarEscribirUnMensaje
  Scenario: Olvidar escribir un mensaje
    Given el usuario entra en la pagina y desea contactarse con servicio al cliente
    When el usuario llena los campos pero no escribe el mensaje
    Then el usuario debera ver el mensaje "The message cannot be blank."


