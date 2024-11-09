Feature: Registro de Usuario

  Scenario: Registro exitoso
    Given el usuario está en la página de registro
    When llena el formulario con los siguientes datos
      | campo             | valor                         |
      | Nombre            | Miguelito                 |
      | Apellido          | Deprueba               |
      | Correo electrónico | esunodeprueba@gmail.com            |
      | Contraseña        | Supersegura             |
    And hace clic en el botón "Crear"
    Then debería ser redirigido a "https://casamyl.cl/account"


  Scenario: Registro fallido - Campos obligatorios vacíos
    Given el usuario está en la página de registro
    When llena el formulario con los siguientes datos
      | campo             | valor            |
      | Nombre            |                  |
      | Apellido          |                  |
      | Correo electrónico |                  |  # También vacío
      | Contraseña        |                  |  # También vacío
    And hace clic en el botón "Crear"
    Then debería ver un mensaje de error en "//*[@id='RegisterForm']/div[1]/div" que contiene "//*[@id="RegisterForm-FirstName"]"
    And debería ver un mensaje de error en "//*[@id='RegisterForm']/div[2]/div" que contiene "//*[@id="RegisterForm-LastName"]"
    And debería ver un mensaje de error en "//*[@id='RegisterForm']/div[3]/div" que contiene "//*[@id="RegisterForm-Email"]"
    And debería ver un mensaje de error en "//*[@id='RegisterForm']/div[4]/div" que contiene "//*[@id="RegisterForm-Password"]"

  Scenario: Registro fallido - Email inválido
    Given el usuario está en la página de registro
    When llena el formulario con los siguientes datos
      | campo             | valor          |
      | Nombre            | NombreDePrueba  |
      | Apellido          | ApellidoDePrueba |
      | Correo electrónico | emailinvalido  | # Inválido
      | Contraseña        | ContraseñaSegura |
    And hace clic en el botón "Crear"
    Then debería ver un mensaje de error que contiene "Por favor, introduce una dirección de correo electrónico válida"

  Scenario: Registro fallido - Contraseña débil
    Given el usuario está en la página de registro
    # ... (Completar con datos para contraseña débil y  verificación del mensaje de error)

  Scenario: Registro fallido - Usuario ya existente
    Given el usuario está en la página de registro
    # ... (Completar con datos para usuario existente y verificación del mensaje de error)