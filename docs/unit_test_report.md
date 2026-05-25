# Unit Test Report — Lab 12

## Selected scope (max 3 requirements)

- REQ-016 — Validação institucional de beneficiários
  - AC automated:
    - Beneficiário com nome válido deve ser validado
    - Beneficiário sem nome deve ser rejeitado

- REQ-017 — Histórico de validações
  - AC automated:
    - Cada validação válida deve ser guardada no histórico

- REQ-018 — Logs de auditoria
  - AC automated:
    - Cada ação crítica deve gerar um log de auditoria

## Tests implemented (minimum 8)

| Test ID | Test name | REQ | AC | Type | Notes |
|---|---|---|---|---|---|
| UT-01 | shouldValidateBeneficiaryWithValidName | REQ-016 | Nome válido | Happy | |
| UT-02 | shouldRejectEmptyName | REQ-016 | Nome vazio inválido | Negative | |
| UT-03 | shouldRejectNullName | REQ-016 | Nome nulo inválido | Negative | |
| UT-04 | shouldStoreValidationInHistory | REQ-017 | Guardar histórico | Happy | |
| UT-05 | shouldCreateAuditLog | REQ-018 | Criar log | Happy | |
| UT-06 | shouldAcceptNameWithSingleCharacter | REQ-016 | Teste limite | Boundary | |
| UT-07 | shouldStoreBeneficiaryNameInHistory | REQ-017 | Guardar nome no histórico | Happy | |
| UT-08 | shouldStoreValidStatusInHistory | REQ-017 | Guardar estado VALID | Happy | |

## Coverage checklist

- Happy path tests: 5
- Negative/error tests: 2
- Boundary tests: 1

## Execution evidence

- Date:
  - <preencher data>

- Command used:
  - `mvn test`

- Result summary:
  - Tests run: 8
  - Passed: 8
  - Failed: 0

- Notes (if any):
  - Os testes focam-se apenas na lógica de validação de beneficiários, histórico e logs de auditoria.
