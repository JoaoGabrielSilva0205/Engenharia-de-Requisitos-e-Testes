≥ 8 entradas REM completas (valores preenchidos, com base nos campos do arquivo REM_v2.xlsx)
# REM v1 — Lab 4 (EcoDoar)

Este documento apresenta a REM v1 do sistema EcoDoar com base nos requisitos
definidos até ao momento. Cada entrada inclui identificação, descrição,
objetivo, critérios de aceitação, método de validação e alinhamento com
objetivos e LCRs.

---

## REM Entry 1

### ID
REQ-001 — Registo de utilizador

**Stakeholder / Requisitante:** Utilizadores

**Descrição:**  
O sistema deve permitir o registo de novos utilizadores com dados pessoais básicos.

**Objetivo:**  
Permitir que novos utilizadores acedam ao sistema e iniciem interação com a plataforma.

**Tipo:** FR  
**Prioridade:** Alta

**Ligação a Objetivo + LCR:**  
OBJ-1 → LCR-1

**Pré-condições:**  
- O utilizador ainda não possui conta registada.
- O formulário de registo encontra-se disponível.

**Pós-condições:**  
- A conta do utilizador é criada no sistema.
- Os dados básicos ficam armazenados.

**Critérios de aceitação:**  
- O sistema deve permitir introdução de nome, email e password.
- O sistema deve rejeitar registos com campos obrigatórios vazios.
- O sistema deve criar a conta quando os dados forem válidos.

**Método de validação:**  
Teste funcional de registo com dados válidos e inválidos.

**Variant impact:** No

---

## REM Entry 2

### ID
REQ-004 — Autenticar utilizador com email e password

**Stakeholder / Requisitante:** Utilizadores

**Descrição:**  
O sistema deve autenticar utilizadores com email e password.

**Objetivo:**  
Garantir acesso seguro à conta do utilizador.

**Tipo:** FR  
**Prioridade:** Alta

**Ligação a Objetivo + LCR:**  
OBJ-1 → LCR-1

**Pré-condições:**  
- O utilizador já possui conta registada.
- O utilizador tem credenciais válidas.

**Pós-condições:**  
- O utilizador entra na plataforma com sessão iniciada.
- O sistema associa a sessão à conta autenticada.

**Critérios de aceitação:**  
- O sistema deve permitir login com email e password válidos.
- O sistema deve rejeitar credenciais incorretas.
- O sistema deve permitir acesso apenas após autenticação bem-sucedida.

**Método de validação:**  
Teste funcional de autenticação com diferentes combinações de credenciais.

**Variant impact:** No

---

## REM Entry 3

### ID
REQ-011 — Criar anúncio de item com descrição e imagens

**Stakeholder / Requisitante:** Doadores

**Descrição:**  
O sistema deve permitir criação de anúncios de itens com descrição e imagens.

**Objetivo:**  
Permitir que doadores disponibilizem bens para reutilização na plataforma.

**Tipo:** FR  
**Prioridade:** Alta

**Ligação a Objetivo + LCR:**  
OBJ-1 → LCR-1

**Pré-condições:**  
- O utilizador está autenticado.
- O utilizador acede à área de publicação de item.

**Pós-condições:**  
- O item fica registado no sistema.
- O anúncio fica disponível para consulta.

**Critérios de aceitação:**  
- O sistema deve permitir introduzir descrição do item.
- O sistema deve permitir anexar imagens.
- O item deve ser guardado com estado inicial válido.

**Método de validação:**  
Teste funcional de criação de item com e sem campos obrigatórios.

**Variant impact:** No

---

## REM Entry 4

### ID
REQ-014 — Associar automaticamente pedidos a itens disponíveis

**Stakeholder / Requisitante:** Beneficiários

**Descrição:**  
O sistema deve associar automaticamente pedidos de beneficiários a itens disponíveis.

**Objetivo:**  
Reduzir tempo de correspondência entre necessidade e oferta.

**Tipo:** FR  
**Prioridade:** Alta

**Ligação a Objetivo + LCR:**  
OBJ-1 → LCR-1

**Pré-condições:**  
- Existem pedidos registados no sistema.
- Existem itens disponíveis compatíveis.

**Pós-condições:**  
- A correspondência é registada.
- O sistema atualiza o estado da relação entre pedido e item.

**Critérios de aceitação:**  
- O sistema deve identificar itens compatíveis com pedidos.
- O sistema deve associar automaticamente quando houver correspondência válida.
- O sistema deve registar a correspondência criada.

**Método de validação:**  
Teste funcional com cenários de correspondência válida e ausência de correspondência.

**Variant impact:** No

---

## REM Entry 5

### ID
REQ-005 — Registar tentativas falhadas de login

**Stakeholder / Requisitante:** Segurança

**Descrição:**  
O sistema deve registar tentativas falhadas de login.

**Objetivo:**  
Permitir deteção de tentativas de acesso indevido e apoio à auditoria de segurança.

**Tipo:** NFR  
**Prioridade:** Média

**Ligação a Objetivo + LCR:**  
OBJ-2 → LCR-2

**Critérios de aceitação:**  
- Cada tentativa falhada deve ficar registada.
- O registo deve incluir data e hora.
- O registo deve permitir auditoria posterior.

**Método de validação:**  
Teste de segurança e inspeção de logs gerados após falhas de autenticação.

**Variant impact:** Yes

---

## REM Entry 6

### ID
REQ-018 — Registar todas as ações críticas do sistema

**Stakeholder / Requisitante:** Administrador

**Descrição:**  
O sistema deve registar todas as ações críticas do sistema em logs de auditoria.

**Objetivo:**  
Garantir rastreabilidade e controlo sobre operações sensíveis realizadas na plataforma.

**Tipo:** NFR  
**Prioridade:** Alta

**Ligação a Objetivo + LCR:**  
OBJ-2 → LCR-2

**Critérios de aceitação:**  
- O sistema deve registar ações críticas de utilizadores e administradores.
- Cada registo deve conter identificação do evento.
- Os logs devem poder ser consultados posteriormente.

**Método de validação:**  
Teste de auditoria com execução de ações críticas e verificação de registos.

**Variant impact:** Yes

---

## REM Entry 7

### ID
REQ-010 — Eliminação de conta e dados pessoais (GDPR)

**Stakeholder / Requisitante:** Utilizadores / Compliance

**Descrição:**  
O sistema deve permitir eliminação de conta e dados pessoais conforme GDPR.

**Objetivo:**  
Garantir conformidade com privacidade e proteção de dados pessoais.

**Tipo:** NFR  
**Prioridade:** Alta

**Ligação a Objetivo + LCR:**  
OBJ-3 → LCR-3

**Critérios de aceitação:**  
- O utilizador deve poder solicitar eliminação dos dados.
- O sistema deve remover ou anonimizar os dados pessoais.
- O processo deve ser concluído dentro do prazo definido.

**Método de validação:**  
Teste de conformidade e verificação de remoção/anonymização de dados.

**Variant impact:** Yes

---

## REM Entry 8

### ID
REQ-020 — Performance da interface mobile

**Stakeholder / Requisitante:** Utilizadores mobile

**Descrição:**  
A interface mobile deve carregar em até 3 segundos para 95% das operações sob carga normal.

**Objetivo:**  
Garantir boa experiência de utilização em ambiente mobile.

**Tipo:** NFR  
**Prioridade:** Alta

**Ligação a Objetivo + LCR:**  
OBJ-3 → LCR-3

**Critérios de aceitação:**  
- O carregamento da interface principal deve ocorrer em até 3 segundos.
- O limite deve ser cumprido em 95% das operações.
- O desempenho deve ser medido sob carga normal.

**Método de validação:**  
Teste de desempenho com medição de tempo de resposta em ambiente mobile.

**Variant impact:** Yes
