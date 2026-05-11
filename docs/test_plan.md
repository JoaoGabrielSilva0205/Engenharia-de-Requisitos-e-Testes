# Test Plan — Lab 10

## 1) Scope

- Slice covered:
  - Registo e autenticação de utilizadores
  - Segurança e auditoria
  - Criação de anúncios
  - Validação institucional de beneficiários
  - Performance mobile

- Out of scope:
  - Interface gráfica avançada
  - Integração com serviços externos reais
  - Automatização completa dos testes
  - Deploy da aplicação

---

## 2) Test strategy (static + dynamic)

### Static testing (reviews)

- What we review:
  - Clareza dos requisitos
  - Qualidade dos critérios de aceitação
  - Cobertura dos casos de teste
  - Clareza dos cenários BDD

- Review checklist:
  - Requisitos sem ambiguidades
  - Critérios de aceitação mensuráveis
  - Test cases com resultados verificáveis
  - Relação correta entre REQ, AC, TC e cenários

### Dynamic testing (planned execution)

| Level | What we test | Examples | Evidence |
|---|---|---|---|
| Unit | Validações simples e regras de negócio | validação de email, bloqueio de login | testes unitários planeados |
| Integration | Comunicação entre componentes | criação de item + registo em log | testes de integração |
| System | Fluxo completo da funcionalidade | registo → login → validação | execução manual |
| Acceptance (BDD) | Comportamento esperado | cenários Given/When/Then | ficheiros `.feature` |

---

## 3) TDD plan (at least 2 candidates)

- Candidate 1 (rule/REQ):
  - REQ-002 — Validação de email

- Candidate 2 (rule/REQ):
  - REQ-006 — Bloqueio após 5 tentativas falhadas

- Why TDD is suitable:
  - Ambos possuem regras claras e mensuráveis
  - Permitem validar lógica antes da implementação completa
  - Facilitam criação de testes automatizados futuros

---

## 4) BDD plan (what behaviors become scenarios)

- Feature(s):
  - Gestão de autenticação e validação

- Scenarios:
  - Login válido
  - Bloqueio após tentativas falhadas
  - Validação institucional de beneficiário

- Links to REQs:
  - REQ-004
  - REQ-005
  - REQ-006
  - REQ-016

---

## 5) Coverage goals

- Happy path:
  - Login válido
  - Registo correto
  - Validação bem-sucedida

- Alternative flows:
  - Item já reservado
  - Cancelamento de operação
  - Documentação incompleta

- Negative/error tests:
  - Email inválido
  - Password incorreta
  - Falha de validação

- Boundary tests:
  - Limite de 5 tentativas falhadas
  - Tempo máximo de resposta mobile
  - Campos vazios

---

## 6) NFR validation approach

- NFR-1:
  - REQ-006 — Bloqueio de conta
  - How we verify:
    - Simulação de 5 tentativas consecutivas

- NFR-2:
  - REQ-019 — Retenção de logs
  - How we verify:
    - Verificação de armazenamento mínimo de 12 meses

- NFR-3:
  - REQ-020 — Performance mobile
  - How we verify:
    - Medição de tempo de resposta com carga simulada

---

## 7) Evidence recording and responsibilities

- Where results are stored (repo paths):
  - docs/test_cases.md
  - docs/traceability_req_ac_tc.md
  - bdd/features/lab9.feature

- Who maintains traceability:
  - Equipa de testes e documentação

- How updates are tracked:
  - Atualizações versionadas no GitHub
