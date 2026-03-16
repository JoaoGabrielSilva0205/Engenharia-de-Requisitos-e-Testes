# Objectives and Critical Success Factors — Lab 4 (EcoDoar)

Este documento define os objetivos principais do sistema EcoDoar e os respetivos
LCRs/FCS (Fatores Críticos de Sucesso), bem como o mapeamento entre LCRs e requisitos.

---

## Objectives

### OBJ-1 — Facilitar a gestão de utilizadores e doações
Descrição:  
O sistema deve permitir que utilizadores se registem, autentiquem e publiquem itens
para doação de forma simples e organizada.

Variant impact: No

---

### OBJ-2 — Garantir segurança, controlo de acesso e rastreabilidade
Descrição:  
O sistema deve proteger acessos, registar ações críticas e manter histórico
de eventos relevantes para auditoria e segurança.

Variant impact: Yes

---

### OBJ-3 — Assegurar privacidade e bom desempenho em dispositivos móveis
Descrição:  
O sistema deve proteger dados pessoais dos utilizadores e garantir uma boa
experiência de utilização em ambiente mobile.

Variant impact: Yes

---

## LCR / CSF

### LCR-1 — Fluxo eficiente de registo, autenticação e gestão de doações
Relacionado com: OBJ-1

Descrição:  
O sucesso do sistema depende da capacidade de permitir registo, autenticação,
publicação de itens e gestão do estado das doações de forma clara e funcional.

Requisitos relacionados:
- REQ-001
- REQ-004
- REQ-011
- REQ-013
- REQ-014

Variant impact: No

---

### LCR-2 — Segurança operacional e auditoria confiável
Relacionado com: OBJ-2

Descrição:  
O sistema deve controlar acessos, registar eventos importantes e manter logs
e históricos que apoiem segurança, transparência e rastreabilidade.

Requisitos relacionados:
- REQ-005
- REQ-006
- REQ-017
- REQ-018
- REQ-019

Variant impact: Yes

---

### LCR-3 — Privacidade dos dados e desempenho mobile
Relacionado com: OBJ-3

Descrição:  
O sistema deve tratar dados pessoais em conformidade com privacidade e
oferecer desempenho adequado em dispositivos móveis.

Requisitos relacionados:
- REQ-008
- REQ-010
- REQ-015
- REQ-020

Variant impact: Yes

---

## Relationship Summary

- OBJ-1 → LCR-1
- OBJ-2 → LCR-2
- OBJ-3 → LCR-3
