Feature: Beneficiary Validation
  Esta funcionalidade valida o comportamento principal da validação de beneficiários,
  incluindo histórico e logs de auditoria.

  # REQ links: REQ-016, REQ-017, REQ-018

  Scenario: Happy path — validar beneficiário com nome válido
    Given que o repositório de beneficiários está vazio
    And existe um beneficiário com id 1 e nome "Pedrinho"
    When a validação do beneficiário com id 1 é executada
    Then o beneficiário deve ficar validado
    And o histórico deve conter 1 registo
    And os logs devem conter 1 entrada

  Scenario: Negative path — rejeitar beneficiário sem nome
    Given que o repositório de beneficiários está vazio
    And existe um beneficiário com id 2 e nome ""
    When a validação do beneficiário com id 2 é executada
    Then a validação deve falhar
    And o histórico deve conter 0 registos
    And os logs devem conter 1 entrada