# Requirements Validation — Lab 7

## Participants / roles

* Client/Stakeholders: Equipa A
* DevTeam: Equipa B
* Facilitator: -
* Scribe: -
* Reviewer: -
* Tester: -

---

## Selected requirements (min. 6)

* REQ-001 (Variant impact: No)
* REQ-004 (Variant impact: No)
* REQ-005 (Variant impact: Yes)
* REQ-006 (Variant impact: Yes)
* REQ-011 (Variant impact: No)
* REQ-020 (Variant impact: Yes)

---

## Variant-driven validation questions (min. 3)

1. Como garantir que os logs de auditoria (REQ-005) não violam privacidade (GDPR)?
2. O bloqueio de conta (REQ-006) pode impactar negativamente a experiência do utilizador?
3. O tempo de resposta (REQ-020) é realista em dispositivos móveis com baixo desempenho?

---

## Validation results (one block per requirement)

### REQ-001 — Registo de utilizadores

* Status: Needs rewrite
* Issues found:

  * “dados pessoais básicos” é ambíguo
* Proposed fix (rewrite/split/clarify):

  * Especificar claramente os dados: nome, email e password
* Expected evidence (how to verify):

  * Teste funcional de registo
  * Execução com dados válidos e inválidos
  * Demo do fluxo completo

---

### REQ-004 — Autenticação de utilizadores

* Status: Valid
* Issues found:

  * Não define requisitos mínimos de segurança
* Proposed fix (rewrite/split/clarify):

  * Adicionar regra de password (mínimo 8 caracteres)
* Expected evidence (how to verify):

  * Testes de login com credenciais válidas e inválidas
  * Testes de validação de password

---

### REQ-005 — Registo de tentativas falhadas (auditoria)

* Status: Needs rewrite
* Issues found:

  * Não define que informação deve ser registada
* Proposed fix (rewrite/split/clarify):

  * Registar timestamp, endereço IP e email
* Expected evidence (how to verify):

  * Verificação de logs gerados
  * Teste de auditoria
  * Revisão manual dos registos

---

### REQ-006 — Bloqueio de conta após tentativas falhadas

* Status: Needs rewrite
* Issues found:

  * Não define duração do bloqueio
* Proposed fix (rewrite/split/clarify):

  * Bloquear conta por 15 minutos após 5 tentativas consecutivas
* Expected evidence (how to verify):

  * Teste automatizado de tentativas de login
  * Verificação do bloqueio e desbloqueio

---

### REQ-011 — Criar anúncio de item

* Status: Needs rewrite
* Issues found:

  * Não define campos obrigatórios do item
* Proposed fix (rewrite/split/clarify):

  * Definir campos obrigatórios: título, descrição e categoria
* Expected evidence (how to verify):

  * Execução do UC-01 (Criar anúncio de item)
  * Teste funcional do fluxo completo
  * Verificação de registo em log (REQ-018)

---

### REQ-020 — Performance mobile

* Status: Needs rewrite
* Issues found:

  * “carga normal” não está definida
* Proposed fix (rewrite/split/clarify):

  * Definir carga normal como até 1000 utilizadores simultâneos
* Expected evidence (how to verify):

  * Testes de performance com carga simulada
  * Medição do tempo de resposta (≤ 3 segundos em 95% dos casos)
  * Relatório de desempenho

---
