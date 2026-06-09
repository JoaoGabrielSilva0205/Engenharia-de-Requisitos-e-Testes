# Traceability Master — Lab 14 (REQ → AC → Tests → Evidence)

Este documento consolida a rastreabilidade entre requisitos, critérios de aceitação, testes automatizados e cenários BDD do projeto EcoDoar.

O foco principal atual do projeto está em autenticação/login e validação institucional de beneficiários.

---

## Matriz Consolidada

| REQ-### | AC reference | Test Case (TC/UT) | BDD Scenario (Feature/Scenario) | Evidence (where) | Notes |
|----------|--------------|-------------------|---------------------------------|------------------|--------|
| REQ-001 | AC-1, AC-3 | UT-AUTH-04 | - | AuthenticationServiceTest, EcoDoarWebSecurityTest | Registo de utilizador implementado via `/register`. |
| REQ-002 | AC-2 | UT-AUTH-05 | - | AuthenticationServiceTest | Rejeição de email duplicado. |
| REQ-003 | Perfil do utilizador | TC-003 | - | User.java, AuthenticationService.java | Gestão básica de perfil. |
| REQ-004 | Login válido | UT-AUTH-01, UT-AUTH-02, WEB-SEC-03 | - | AuthenticationServiceTest, EcoDoarWebSecurityTest | Autenticação com email e password. |
| REQ-005 (NFR) | Logs de tentativas falhadas | UT-AUTH-03 | - | AuthenticationServiceTest | Falhas de login geram registos para auditoria. |
| REQ-006 (NFR / Variant) | Bloqueio após 5 falhas | TC-006 | - | Não implementado | Gap identificado. |
| REQ-010 (NFR / Variant) | GDPR | TC-010 | - | Não implementado | Fora do scope atual. |
| REQ-011 | Criação de anúncios | TC-011 | - | Não implementado | Fora do scope atual. |
| REQ-016 | Validação institucional | UT-VAL-01, UT-VAL-02, UT-VAL-05 | Lab11 Happy Path, Lab13 Happy Path | ValidationServiceTest, ValidationServiceSecurityTest | Requisito principal do projeto. |
| REQ-017 (NFR / Variant) | Histórico de validações | UT-VAL-03 | Lab11 e Lab13 | ValidationServiceTest | Histórico mantido após validação. |
| REQ-018 (NFR / Variant) | Logs de auditoria | UT-VAL-04 | Lab11 e Lab13 | ValidationServiceTest, EcoDoarWebControllerTest | Auditoria de validações e autenticação. |
| REQ-019 (NFR / Variant) | Retenção ≥ 12 meses | TC-019 | - | Não implementado | Gap identificado. |
| REQ-020 (NFR / Variant) | Performance Mobile | TC-020 | - | Não implementado | Gap identificado. |

---

## Testes Automatizados Mapeados

| Test ID | Tipo | Ficheiro | Objetivo | REQ |
|----------|------|----------|----------|------|
| UT-AUTH-01 | Unit | AuthenticationServiceTest.java | Login admin válido | REQ-004 |
| UT-AUTH-02 | Unit | AuthenticationServiceTest.java | Login donor válido | REQ-004 |
| UT-AUTH-03 | Unit | AuthenticationServiceTest.java | Password incorreta | REQ-004, REQ-005 |
| UT-AUTH-04 | Unit | AuthenticationServiceTest.java | Registo de utilizador | REQ-001 |
| UT-AUTH-05 | Unit | AuthenticationServiceTest.java | Email duplicado | REQ-002 |
| UT-VAL-01 | Unit | ValidationServiceTest.java | Validar beneficiário existente | REQ-016 |
| UT-VAL-02 | Unit | ValidationServiceSecurityTest.java | Beneficiário inexistente | REQ-016 |
| UT-VAL-03 | Unit | ValidationServiceTest.java | Histórico de validações | REQ-017 |
| UT-VAL-04 | Unit | ValidationServiceTest.java | Logs de auditoria | REQ-018 |
| UT-VAL-05 | Unit | ValidationServiceSecurityTest.java | ID duplicado | REQ-016 |
| WEB-SEC-01 | Web | EcoDoarWebSecurityTest.java | Visitante não pode criar beneficiário | REQ-004, REQ-016 |
| WEB-SEC-02 | Web | EcoDoarWebSecurityTest.java | Visitante não pode validar beneficiário | REQ-004, REQ-016 |
| WEB-SEC-03 | Web | EcoDoarWebSecurityTest.java | Login admin | REQ-004 |
| WEB-SEC-04 | Web | EcoDoarWebSecurityTest.java | Registo de utilizador | REQ-001 |
| BDD-011-01 | BDD | lab11.feature | Validação de beneficiário válida | REQ-016, REQ-017, REQ-018 |
| BDD-011-02 | BDD | lab11.feature | Beneficiário sem nome | REQ-016, REQ-018 |
| BDD-013-01 | BDD | lab13.feature | Validação bem-sucedida | REQ-016, REQ-017, REQ-018 |
| BDD-013-02 | BDD | lab13.feature | Nome vazio | REQ-016, REQ-018 |
| BDD-013-03 | BDD | lab13.feature | ID duplicado | REQ-016 |
| BDD-013-04 | BDD | lab13.feature | Nome com um caractere | REQ-016 |

---

## Evidence

Comando executado:

```bash
mvn clean test
```

Resultado:

```text
Tests run: 44
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

## Observações de Manutenção

- Os requisitos com melhor cobertura atualmente são REQ-004, REQ-016, REQ-017 e REQ-018.
- O foco principal do projeto está em autenticação e validação de beneficiários.
- REQ-006, REQ-010, REQ-019 e REQ-020 permanecem identificados como gaps para futuras versões.
- Esta matriz deve ser atualizada sempre que novos testes, requisitos ou cenários BDD forem adicionados.
