# Requirements Validation — Lab 7

## Participants / roles
- Client/Stakeholders: Equipa A
- DevTeam: Equipa B
- Facilitator: -
- Scribe: -
- Reviewer: -
- Tester: -

## Selected requirements (min. 6)
- REQ-001 (Variant impact: No)
- REQ-004 (Variant impact: No)
- REQ-005 (Variant impact: Yes)
- REQ-006 (Variant impact: Yes)
- REQ-010 (Variant impact: Yes)
- REQ-020 (Variant impact: Yes)

## Variant-driven validation questions (min. 3)
1. Como garantir que os logs de auditoria (REQ-005) não violam privacidade (GDPR)?
2. O bloqueio de conta (REQ-006) pode impactar negativamente a experiência do utilizador?
3. O tempo de resposta (REQ-020) é realista em dispositivos de baixo desempenho?

---

## Validation results

### REQ-001 — Registo de utilizadores
- Status: Needs rewrite
- Issues found:
  - “dados pessoais básicos” é vago
- Proposed fix:
  - Especificar: nome, email, password
- Expected evidence:
  - Teste de criação de conta
  - Demo funcional

---

### REQ-004 — Autenticação
- Status: Valid
- Issues found:
  - Não especifica requisitos de segurança mínimos
- Proposed fix:
  - Adicionar regras de password (mínimo 8 caracteres)
- Expected evidence:
  - Testes de login
  - Testes de validação

---

### REQ-005 — Logs de tentativas falhadas
- Status: Needs rewrite
- Issues found:
  - Não define quais dados são registados
- Proposed fix:
  - Registar: timestamp, IP, email
- Expected evidence:
  - Verificação de logs
  - Teste de auditoria

---

### REQ-006 — Bloqueio de conta
- Status: Valid
- Issues found:
  - Não define tempo de bloqueio
- Proposed fix:
  - Bloqueio por 15 minutos após 5 tentativas
- Expected evidence:
  - Teste automatizado de bloqueio

---

### REQ-010 — Eliminação GDPR
- Status: Needs rewrite
- Issues found:
  - Não define claramente o prazo no requisito
- Proposed fix:
  - Garantir eliminação em até 30 dias
- Expected evidence:
  - Verificação de base de dados
  - Auditoria

---

### REQ-020 — Performance mobile
- Status: Valid
- Issues found:
  - “carga normal” não está definida
- Proposed fix:
  - Definir: até 1000 utilizadores simultâneos
- Expected evidence:
  - Testes de performance
  - Métricas de tempo de resposta
