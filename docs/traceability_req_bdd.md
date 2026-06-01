# Traceability — Requirements ↔ BDD Scenarios (Lab 13)

## Selected requirements

- REQ-016 — Validação institucional de beneficiários
- REQ-017 — Histórico de validações de beneficiários
- REQ-018 — Registo de ações críticas em logs de auditoria

## Mapping (REQ → Scenario)

| Requirement (REQ-###) | Scenario name | Feature file | Notes |
|---|---|---|---|
| REQ-016 | Happy path — validar beneficiário existente | bdd/features/lab13.feature | Validação bem-sucedida |
| REQ-017 | Happy path — validar beneficiário existente | bdd/features/lab13.feature | Histórico atualizado |
| REQ-018 | Happy path — validar beneficiário existente | bdd/features/lab13.feature | Log criado |
| REQ-016 | Negative path — rejeitar beneficiário com nome vazio | bdd/features/lab13.feature | Dados inválidos |
| REQ-018 | Negative path — rejeitar beneficiário com nome vazio | bdd/features/lab13.feature | Log de falha criado |
| REQ-016 | Alternative flow — rejeitar id duplicado | bdd/features/lab13.feature | ID deve ser único |
| REQ-016 | Boundary behavior — validar beneficiário com nome de um caractere | bdd/features/lab13.feature | Limite inferior válido |
| REQ-017 | Boundary behavior — validar beneficiário com nome de um caractere | bdd/features/lab13.feature | Histórico atualizado |
| REQ-018 | Boundary behavior — validar beneficiário com nome de um caractere | bdd/features/lab13.feature | Log criado |
