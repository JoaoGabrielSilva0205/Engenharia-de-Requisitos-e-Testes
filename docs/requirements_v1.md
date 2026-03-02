# Requirements v1 — Lab 3 (EcoDoar)

---

## Lista de requisitos com IDs estáveis

### REQ-001
Descrição: O sistema deve permitir o registo de novos utilizadores com dados pessoais básicos.  
Tipo: FR  
Stakeholder: Utilizadores  
Prioridade: Alta  
Área funcional: Gestão de Utilizadores  

---

### REQ-002
Descrição: O sistema deve validar o endereço de email durante o registo de utilizador.  
Tipo: FR  
Stakeholder: Utilizadores  
Prioridade: Alta  
Área funcional: Gestão de Utilizadores  

---

### REQ-003
Descrição: O sistema deve armazenar e gerir dados do perfil do utilizador.  
Tipo: FR  
Stakeholder: Utilizadores  
Prioridade: Média  
Área funcional: Gestão de Utilizadores  

---

### REQ-004
Descrição: O sistema deve autenticar utilizadores com email e password.  
Tipo: FR  
Stakeholder: Utilizadores  
Prioridade: Alta  
Área funcional: Autenticação  

---

### REQ-005
Descrição: O sistema deve registar tentativas falhadas de login.  
Tipo: NFR  
Stakeholder: Segurança  
Prioridade: Média  
Área funcional: Segurança  
Impacto da variante: Sim (auditoria)

---

### REQ-006
Descrição: O sistema deve bloquear contas após 5 tentativas consecutivas de login falhadas.  
Tipo: NFR  
Stakeholder: Segurança  
Prioridade: Média  
Área funcional: Segurança  
Impacto da variante: Sim

---

### REQ-007
Descrição: O sistema deve permitir envio de email de recuperação de palavra-passe.  
Tipo: FR  
Stakeholder: Utilizadores  
Prioridade: Alta  
Área funcional: Autenticação  

---

### REQ-008
Descrição: O sistema deve permitir redefinição segura de palavra-passe.  
Tipo: NFR  
Stakeholder: Segurança  
Prioridade: Alta  
Área funcional: Segurança  
Impacto da variante: Sim

---

### REQ-009
Descrição: O sistema deve permitir edição dos dados do perfil do utilizador.  
Tipo: FR  
Stakeholder: Utilizadores  
Prioridade: Média  
Área funcional: Gestão de Utilizadores  

---

### REQ-010
Descrição: O sistema deve permitir eliminação de conta e dados pessoais conforme GDPR.  
Tipo: NFR (mensurável)  
Stakeholder: Utilizadores / Compliance  
Prioridade: Alta  
Área funcional: Privacidade  
Impacto da variante: Sim

---

### REQ-011
Descrição: O sistema deve permitir criação de anúncios de itens com descrição e imagens.  
Tipo: FR  
Stakeholder: Doadores  
Prioridade: Alta  
Área funcional: Gestão de Doações  

---

### REQ-012
Descrição: O sistema deve permitir edição de itens publicados.  
Tipo: FR  
Stakeholder: Doadores  
Prioridade: Média  
Área funcional: Gestão de Doações  

---

### REQ-013
Descrição: O sistema deve permitir alteração do estado de itens (disponível, reservado, entregue).  
Tipo: FR  
Stakeholder: Sistema / Doadores  
Prioridade: Alta  
Área funcional: Gestão de Doações  

---

### REQ-014
Descrição: O sistema deve associar automaticamente pedidos de beneficiários a itens disponíveis.  
Tipo: FR  
Stakeholder: Beneficiários  
Prioridade: Alta  
Área funcional: Correspondência  

---

### REQ-015
Descrição: O sistema deve notificar utilizadores sobre correspondências de doação.  
Tipo: FR  
Stakeholder: Utilizadores  
Prioridade: Média  
Área funcional: Notificações  

---

### REQ-016
Descrição: O sistema deve permitir validação institucional de beneficiários.  
Tipo: FR  
Stakeholder: Instituições  
Prioridade: Alta  
Área funcional: Validação de Beneficiários  

---

### REQ-017
Descrição: O sistema deve manter histórico de validações de beneficiários.  
Tipo: NFR  
Stakeholder: Auditoria  
Prioridade: Alta  
Área funcional: Auditoria  
Impacto da variante: Sim

---

### REQ-018
Descrição: O sistema deve registar todas as ações críticas do sistema em logs de auditoria.  
Tipo: NFR  
Stakeholder: Administrador  
Prioridade: Alta  
Área funcional: Auditoria  
Impacto da variante: Sim

---

### REQ-019
Descrição: O sistema deve armazenar logs por no mínimo 12 meses.  
Tipo: NFR (mensurável)  
Stakeholder: Auditoria  
Prioridade: Média  
Área funcional: Auditoria  
Impacto da variante: Sim

---

### REQ-020
Descrição: A interface mobile deve carregar em até 3 segundos para 95% das operações sob carga normal.  
Tipo: NFR (mensurável)  
Stakeholder: Utilizadores mobile  
Prioridade: Alta  
Área funcional: Desempenho Mobile  
Impacto da variante: Sim

---

## Requisitos Não Funcionais Mensuráveis

NFR-01 — Performance Mobile  
≤ 3 segundos em 95% das operações sob carga normal.

NFR-02 — Retenção de Logs  
≥ 12 meses de armazenamento.

NFR-03 — Eliminação GDPR  
Dados removidos em até 30 dias após solicitação.

---

## Relação com Trello

Cada REQ-### corresponde diretamente a um item de backlog no Trello,
mantendo rastreabilidade completa entre especificação formal e planeamento de desenvolvimento.
