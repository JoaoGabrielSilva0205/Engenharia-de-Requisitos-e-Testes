Feature: Beneficiary Validation
  Esta funcionalidade valida o comportamento principal da validação de beneficiários,
  incluindo histórico e logs de auditoria.

  # REQ links: REQ-016, REQ-017, REQ-018

  Scenario: Happy path — validar beneficiário com nome válido
    Given que existe um beneficiário com nome "João"
    When a validação do beneficiário é executada
    Then o beneficiário deve ficar validado
    And o histórico deve conter 1 registo
    And os logs devem conter 1 entrada

  Scenario: Negative path — rejeitar beneficiário sem nome
    Given que existe um beneficiário com nome ""
    When a validação do beneficiário é executada
    Then a validação deve falhar
    And os logs devem conter 1 entrada
