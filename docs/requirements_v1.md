# Requirements v1 — Lab 3 (AMS)

## Lista de requisitos com IDs estáveis

### REQ-001
**Descrição:** O sistema deve permitir o registo e validação de sessões de admissão de novos serviços ou componentes.  
**Tipo:** FR  
**Stakeholder:** Equipa AMS  
**Prioridade:** Alta  
**Área:** Sessão de Admissão e Validação  

---

### REQ-002
**Descrição:** O sistema deve registar a origem, data e responsável por cada evidência recolhida durante a admissão.  
**Tipo:** FR  
**Stakeholder:** Equipa AMS  
**Prioridade:** Alta  
**Área:** Evidências e Rastreabilidade  

---

### REQ-003
**Descrição:** O sistema deve identificar e registar automaticamente informações críticas em falta durante a admissão.  
**Tipo:** FR  
**Stakeholder:** Equipa AMS  
**Prioridade:** Alta  
**Área:** Informações Críticas Ausentes  

---

### REQ-004
**Descrição:** O sistema deve implementar controlo de acessos baseado em papéis (RBAC).  
**Tipo:** NFR  
**Stakeholder:** Administrador do sistema  
**Prioridade:** Alta  
**Área:** Gestão de Utilizadores e Permissões  

---

### REQ-005
**Descrição:** O sistema deve registar todas as ações relevantes em logs de auditoria.  
**Tipo:** NFR  
**Stakeholder:** Auditoria / Segurança  
**Prioridade:** Alta  
**Área:** Auditoria e Registo  

---

### REQ-006
**Descrição:** O sistema deve permitir exportação de relatórios de admissão e estado do serviço.  
**Tipo:** FR  
**Stakeholder:** Gestão / Administração  
**Prioridade:** Média  
**Área:** Exportação e Relatórios  

---

### REQ-007
**Descrição:** O sistema deve carregar a interface mobile em até 3 segundos sob condições normais de rede.  
**Tipo:** NFR (mensurável)  
**Stakeholder:** Utilizadores mobile  
**Prioridade:** Alta  
**Área:** Desempenho Mobile  

---

### REQ-008
**Descrição:** O sistema deve permitir eliminação ou anonimização de dados pessoais em até 30 dias após solicitação.  
**Tipo:** NFR (mensurável)  
**Stakeholder:** Utilizadores / Compliance GDPR  
**Prioridade:** Alta  
**Área:** Privacidade e Conformidade  

---

### REQ-009
**Descrição:** O sistema deve garantir disponibilidade mensal mínima de 99%.  
**Tipo:** NFR (mensurável)  
**Stakeholder:** Operações / Suporte AMS  
**Prioridade:** Alta  
**Área:** Disponibilidade do Sistema  

---

### REQ-010
**Descrição:** O sistema deve armazenar logs de auditoria por pelo menos 12 meses.  
**Tipo:** NFR  
**Stakeholder:** Auditoria / Compliance  
**Prioridade:** Média  
**Área:** Auditoria e Registo  

---

### REQ-011
**Descrição:** O sistema deve garantir que apenas utilizadores autorizados acedam a dados sensíveis.  
**Tipo:** NFR  
**Stakeholder:** Segurança da Informação  
**Prioridade:** Alta  
**Área:** Gestão de Utilizadores e Permissões  

---

### REQ-012
**Descrição:** O sistema deve sincronizar automaticamente dados registados offline quando houver ligação à internet.  
**Tipo:** NFR  
**Stakeholder:** Utilizadores mobile  
**Prioridade:** Média  
**Área:** Desempenho e Operação Mobile  

---

## Detalhamento dos 6 requisitos principais

### REQ-001 — Sessão de admissão validada

**Objetivo:** Garantir que todas as informações necessárias sejam recolhidas e verificadas antes da operação.

**Critérios de aceitação:**
- Não é possível concluir a admissão com campos obrigatórios vazios.
- Deve existir registo da data e responsável pela validação.
- O estado deve ficar armazenado como validado ou pendente.

**Impacto da variante:** Não

---

### REQ-002 — Registo de evidências rastreáveis

**Objetivo:** Garantir rastreabilidade e confiança das informações utilizadas na transição AMS.

**Critérios de aceitação:**
- Toda evidência deve ter autor identificado.
- Deve existir data de recolha.
- Deve ser possível consultar histórico completo.

**Impacto da variante:** Sim

---

### REQ-004 — Controlo de acessos RBAC

**Objetivo:** Garantir acesso controlado e seguro às funcionalidades.

**Critérios de aceitação:**
- Utilizadores sem permissão não podem aceder a funções restritas.
- Alterações de permissões devem ser registadas.
- Perfis devem ser configuráveis por administradores.

**Impacto da variante:** Sim

---

### REQ-005 — Auditoria de ações

**Objetivo:** Permitir rastreabilidade e controlo de eventos.

**Critérios de aceitação:**
- Cada ação deve incluir utilizador, data e tipo de operação.
- Registos não podem ser alterados manualmente.
- Logs devem poder ser consultados por administradores.

**Impacto da variante:** Sim

---

### REQ-007 — Desempenho mobile

**Objetivo:** Garantir boa experiência em dispositivos móveis.

**Critérios de aceitação:**
- Interface principal ≤ 3 segundos.
- Testes em rede móvel padrão.
- 95% das execuções dentro do limite.

**Impacto da variante:** Sim

---

### REQ-008 — Eliminação de dados pessoais (GDPR)

**Objetivo:** Cumprir regulamentações de proteção de dados.

**Critérios de aceitação:**
- Pedido registado.
- Dados removidos ou anonimizados.
- Confirmação registada.

**Impacto da variante:** Sim

---

## Requisitos Não Funcionais (NFR)

### NFR mensuráveis

**NFR-01 — Desempenho Mobile**  
Interface ≤ 3 segundos para 95% dos acessos sob rede móvel padrão.  
Medição: testes automatizados.

**NFR-02 — Disponibilidade**  
Tempo de atividade mensal ≥ 99%.  
Medição: monitorização contínua.

**NFR-03 — Retenção de auditoria**  
Logs armazenados ≥ 12 meses.  
Medição: verificação periódica.

---

### NFR adicionais

- Conformidade com GDPR.
- Controlo de acesso baseado em perfis.
- Sincronização automática offline.
