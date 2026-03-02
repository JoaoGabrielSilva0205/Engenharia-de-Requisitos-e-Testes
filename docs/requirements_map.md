# Requirements Map — Lab 3 

---

## EPIC-1 — Gestão de Utilizadores

REQ-001 — Registo de utilizador  
REQ-002 — Validação de email no registo  
REQ-003 — Gestão de dados do perfil  
REQ-004 — Autenticação com email e password  
REQ-005 — Registo de tentativas falhadas de login  
REQ-006 — Bloqueio de conta após falhas consecutivas  
REQ-007 — Envio de email de recuperação de password  
REQ-008 — Redefinição segura de password  
REQ-009 — Edição de perfil  
REQ-010 — Eliminação de conta e dados pessoais (GDPR)  

---

## EPIC-2 — Gestão de Doações

REQ-011 — Criação de anúncio de item  
REQ-012 — Edição de item publicado  
REQ-013 — Alteração de estado de item  
REQ-014 — Correspondência automática entre pedidos e itens  
REQ-015 — Notificações de correspondência  

---

## EPIC-3 — Validação de Beneficiários

REQ-016 — Validação institucional de beneficiários  
REQ-017 — Histórico de validações  

---

## EPIC-4 — Auditoria e Segurança

REQ-018 — Registo de ações críticas  
REQ-019 — Retenção de logs  

---

## EPIC-5 — Mobile e Desempenho

REQ-020 — Performance da interface mobile  

---

## Resumo da Cobertura de Variante

Variante considerada: Mobile + Auditoria + GDPR

### Requisitos influenciados pela variante

REQ-005 — Registo de tentativas de login (auditoria)  
REQ-006 — Bloqueio de conta  
REQ-008 — Redefinição segura de password  
REQ-010 — Eliminação de dados pessoais (GDPR)  
REQ-017 — Histórico de validações  
REQ-018 — Auditoria de ações  
REQ-019 — Retenção de logs  
REQ-020 — Performance mobile  

---

## Rastreabilidade com Trello

- EPIC (Trello) → EPIC (este mapa)
- FEATURE (Trello) → grupo funcional dentro do EPIC
- Backlog item (Trello) → requisito REQ-###
