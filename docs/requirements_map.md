# Requirements Map — Lab 3 

---

## EPIC-1 — Sessão de Admissão e Validação

REQ-001 — Sessão de admissão validada  
REQ-003 — Identificação de informação crítica em falta  

---

## EPIC-2 — Evidências e Rastreabilidade

REQ-002 — Registo de evidências rastreáveis  
REQ-005 — Auditoria de ações  
REQ-010 — Retenção de logs  

---

## EPIC-3 — Gestão de Utilizadores e Permissões

REQ-004 — Controlo de acessos RBAC  
REQ-011 — Proteção de dados sensíveis  

---

## EPIC-4 — Exportação e Relatórios

REQ-006 — Exportação de relatórios  

---

## EPIC-5 — Desempenho e Operação Mobile

REQ-007 — Desempenho mobile  
REQ-012 — Sincronização offline  

---

## EPIC-6 — Privacidade e Conformidade

REQ-008 — Eliminação de dados pessoais  
REQ-009 — Disponibilidade do sistema  

---

## Resumo da Cobertura de Variante

**Número da variante:** Variante Mobile + Auditoria + GDPR

### Requisitos influenciados pela variante

REQ-002 — Evidências rastreáveis  
REQ-004 — RBAC  
REQ-005 — Auditoria de ações  
REQ-007 — Performance mobile  
REQ-008 — Eliminação GDPR  

### Requisitos não funcionais influenciados pela variante

REQ-004  
REQ-005  
REQ-007  
REQ-008  

---

## Mapeamento Estrutural AMS → Organização Trello

A estrutura AMS utilizada neste documento representa a organização
orientada à transição e descoberta (Admissão e Discovery).

A implementação operacional no Trello está organizada por módulos funcionais:

- Gestão de Utilizadores → corresponde a EPIC-3 (Gestão de Utilizadores e Permissões)
- Auditoria e Segurança → corresponde a EPIC-2 + EPIC-6
- Mobile e Desempenho → corresponde a EPIC-5
- Exportação e Relatórios → corresponde a EPIC-4
- Validação de Beneficiários → relacionado com EPIC-1

Este mapeamento garante rastreabilidade entre modelo conceptual AMS
e organização prática do desenvolvimento.
