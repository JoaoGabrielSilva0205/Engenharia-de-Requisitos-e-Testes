Feature: Beneficiary Validation and Audit
  Esta funcionalidade valida o comportamento principal da validação de beneficiários,
  incluindo criação, validação, histórico e logs de auditoria.

  # REQ links: REQ-016, REQ-017, REQ-018

  Scenario: Happy path — validar beneficiário existente
    # REQ-016, REQ-017, REQ-018
    Given que o repositório de beneficiários está vazio
    And existe um beneficiário com id 1 e nome "João"
    When a validação do beneficiário com id 1 é executada
    Then a validação deve ser concluída com sucesso
    And o histórico deve conter 1 registo
    And os logs devem conter 1 entrada

  Scenario: Negative path — rejeitar beneficiário com nome vazio
    # REQ-016, REQ-018
    Given que o repositório de beneficiários está vazio
    And existe um beneficiário com id 2 e nome ""
    When a validação do beneficiário com id 2 é executada
    Then a validação deve falhar
    And o histórico deve conter 0 registos
    And os logs devem conter 1 entrada

  Scenario: Alternative flow — rejeitar id duplicado
    # REQ-016
    Given que o repositório de beneficiários está vazio
    And existe um beneficiário com id 3 e nome "Maria"
    When tento criar outro beneficiário com id 3 e nome "Ana"
    Then o segundo beneficiário deve ser rejeitado
    And o repositório deve conter 1 beneficiário

  Scenario: Boundary behavior — validar beneficiário com nome de um caractere
    # REQ-016, REQ-017, REQ-018
    Given que o repositório de beneficiários está vazio
    And existe um beneficiário com id 4 e nome "A"
    When a validação do beneficiário com id 4 é executada
    Then a validação deve ser concluída com sucesso
    And o histórico deve conter 1 registo
