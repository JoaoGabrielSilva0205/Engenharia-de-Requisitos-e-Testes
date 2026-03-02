# Requirements v1 — Lab 3 (AMS)

## Lista de requisitos com IDs estáveis

REQ-001 — O sistema deve permitir o registo e validação de sessões de admissão de novos serviços ou componentes.

REQ-002 — O sistema deve registar a origem, data e responsável por cada evidência recolhida durante a admissão.

REQ-003 — O sistema deve identificar e registar automaticamente informações críticas em falta durante a admissão.

REQ-004 — O sistema deve implementar controlo de acessos baseado em papéis (RBAC).

REQ-005 — O sistema deve registar todas as ações relevantes em logs de auditoria.

REQ-006 — O sistema deve permitir exportação de relatórios de admissão e estado do serviço.

REQ-007 — O sistema deve carregar a interface mobile em até 3 segundos sob condições normais de rede. (NFR — mensurável)

REQ-008 — O sistema deve permitir eliminação ou anonimização de dados pessoais em até 30 dias após solicitação. (NFR — mensurável)

REQ-009 — O sistema deve garantir disponibilidade mensal mínima de 99%. (NFR — mensurável)

REQ-010 — O sistema deve armazenar logs de auditoria por pelo menos 12 meses. (NFR)

REQ-011 — O sistema deve garantir que apenas utilizadores autorizados acedam a dados sensíveis. (NFR)

REQ-012 — O sistema deve sincronizar automaticamente dados registados offline quando houver ligação à internet.


---

## Detalhamento dos 6 requisitos principais

### REQ-001 — Sessão de admissão validada
**Descrição:** O sistema deve permitir registar e validar sessões completas de admissão antes da transição para suporte AMS.  
**Objetivo:** Garantir que todas as informações necessárias sejam recolhidas e verificadas antes da operação.  
**Critérios de aceitação:**
- Não é possível concluir a admissão com campos obrigatórios vazios.
- Deve existir registo da data e responsável pela validação.
- O estado da admissão deve ficar armazenado como validado ou pendente.  
**Impacto da variante:** Não


---

### REQ-002 — Registo de evidências rastreáveis
**Descrição:** O sistema deve armazenar origem, responsável e data de cada evidência associada à admissão.  
**Objetivo:** Garantir rastreabilidade e confiança das informações utilizadas na transição AMS.  
**Critérios de aceitação:**
- Toda evidência deve ter autor identificado.
- Deve existir data de recolha.
- Deve ser possível consultar histórico completo.  
**Impacto da variante:** Sim


---

### REQ-004 — Controlo de acessos RBAC
**Descrição:** O sistema deve permitir atribuição de permissões por perfil de utilizador.  
**Objetivo:** Garantir acesso controlado e seguro às funcionalidades do sistema.  
**Critérios de aceitação:**
- Utilizadores sem permissão não podem aceder a funções restritas.
- Alterações de permissões devem ser registadas.
- Perfis devem ser configuráveis por administradores.  
**Impacto da variante:** Sim


---

### REQ-005 — Auditoria de ações
**Descrição:** O sistema deve registar todas as ações relevantes realizadas pelos utilizadores.  
**Objetivo:** Permitir rastreabilidade, controlo e análise de eventos do sistema.  
**Critérios de aceitação:**
- Cada ação deve incluir utilizador, data e tipo de operação.
- Registos não podem ser alterados manualmente.
- Logs devem poder ser consultados por administradores.  
**Impacto da variante:** Sim


---

### REQ-007 — Desempenho da aplicação mobile
**Descrição:** A interface principal deve carregar em até 3 segundos sob condições normais de rede móvel.  
**Objetivo:** Garantir boa experiência do utilizador em dispositivos móveis.  
**Critérios de aceitação:**
- Tempo medido desde abertura até interface pronta.
- Testes realizados em rede móvel padrão.
- 95% das execuções devem cumprir o limite.  
**Impacto da variante:** Sim


---

### REQ-008 — Eliminação de dados pessoais (GDPR)
**Descrição:** O sistema deve eliminar ou anonimizar dados pessoais até 30 dias após solicitação.  
**Objetivo:** Cumprir regulamentações de proteção de dados.  
**Critérios de aceitação:**
- Pedido de eliminação registado.
- Dados removidos ou anonimizados.
- Confirmação registada no sistema.  
**Impacto da variante:** Sim


---

## Requisitos Não Funcionais (NFR)

### NFR mensuráveis

NFR-01 — Desempenho mobile  
Interface principal ≤ 3 segundos para 95% dos acessos sob rede móvel padrão.  
Medição: testes automatizados de desempenho.

NFR-02 — Disponibilidade  
Tempo de atividade mensal ≥ 99%.  
Medição: monitorização contínua do sistema.

NFR-03 — Retenção de auditoria  
Logs armazenados por ≥ 12 meses.  
Medição: verificação periódica da base de logs.


### NFR adicionais

NFR-04 — Conformidade com GDPR para eliminação de dados.

NFR-05 — Controlo de acesso seguro baseado em perfis.

NFR-06 — Sincronização automática de dados offline.
