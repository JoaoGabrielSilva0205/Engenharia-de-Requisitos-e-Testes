Feature: Gestão de autenticação e validação no EcoDoar
  O objetivo desta funcionalidade é validar autenticação,
  segurança e validação de beneficiários.

  # REQ links: REQ-004, REQ-005, REQ-006, REQ-016

  Scenario: Happy path — Login com credenciais válidas
    Given que o utilizador está registado
    And possui email e password válidos
    When introduz as credenciais corretas
    Then deve conseguir aceder ao sistema
    And o sistema inicia sessão do utilizador

  Scenario: Negative path — Bloqueio após múltiplas tentativas falhadas
    Given que o utilizador possui uma conta ativa
    When introduz password incorreta 5 vezes consecutivas
    Then a conta deve ser bloqueada por 15 minutos
    And o sistema deve registar as tentativas falhadas

  Scenario: Alternative flow — Validação institucional de beneficiário
    Given que existe um beneficiário pendente
    And a instituição está autenticada
    When a instituição valida os documentos submetidos
    Then o beneficiário deve ficar validado
    And o sistema deve guardar o histórico da validação
