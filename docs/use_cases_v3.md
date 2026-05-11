## UC-16 — Validar beneficiário institucionalmente

- **Primary actor:** Instituição  
- **Supporting actors:** Beneficiário, Sistema  
- **Goal:** Permitir que uma instituição valide a identidade e elegibilidade de um beneficiário  
- **Preconditions:** Beneficiário registado no sistema; instituição autenticada com permissões de validação  
- **Trigger:** Instituição seleciona "Validar beneficiário"  
- **Postconditions (success):** Beneficiário validado e autorizado a solicitar doações  
- **Postconditions (failure/cancel):** Beneficiário permanece não validado  
- **Related requirements:** REQ-016, REQ-017, REQ-018  

### Main flow (happy path)

1. Instituição acede à lista de beneficiários pendentes  
2. Sistema apresenta os dados do beneficiário  
3. Instituição analisa os documentos submetidos  
4. Instituição confirma a validação  
5. Sistema altera o estado do beneficiário para "validado"  
6. Sistema regista a validação no histórico  
7. Sistema regista ação em log de auditoria  

### Alternative flows (min. 2)

**A1.** Documentação incompleta → sistema solicita documentos adicionais  

**A2.** Instituição rejeita validação → sistema mantém estado "não validado"  

**A3.** Instituição cancela operação → sistema não altera os dados  

### Exceptions / errors (min. 2)

**E1.** Falha ao guardar validação → sistema informa erro  

**E2.** Erro na verificação de documentos → sistema bloqueia validação temporariamente  

**E3.** Falha no registo de auditoria → sistema alerta administrador  


---

## UC-17 — Consultar histórico de validações

- **Primary actor:** Auditor  
- **Supporting actors:** Sistema, Instituição  
- **Goal:** Permitir consulta do histórico de validações de beneficiários  
- **Preconditions:** Auditor autenticado com permissões de acesso  
- **Trigger:** Auditor seleciona "Consultar histórico de validações"  
- **Postconditions (success):** Histórico apresentado corretamente  
- **Postconditions (failure/cancel):** Nenhum dado é apresentado  
- **Related requirements:** REQ-017, REQ-018, REQ-019  

### Main flow (happy path)

1. Auditor acede à funcionalidade de histórico  
2. Sistema apresenta filtros de pesquisa  
3. Auditor define critérios de pesquisa  
4. Sistema consulta o histórico de validações  
5. Sistema apresenta lista de validações realizadas  
6. Auditor visualiza detalhes de uma validação  
7. Sistema regista acesso em log de auditoria  

### Alternative flows (min. 2)

**A1.** Nenhum resultado encontrado → sistema informa ausência de registos  

**A2.** Filtros inválidos → sistema solicita correção  

**A3.** Auditor cancela consulta → sistema encerra pesquisa  

### Exceptions / errors (min. 2)

**E1.** Falha na consulta da base de dados → sistema informa indisponibilidade  

**E2.** Dados do histórico corrompidos → sistema impede visualização parcial  

**E3.** Falha no carregamento dos logs → sistema tenta nova consulta  


---

## UC-18 — Registar ações críticas em logs de auditoria

- **Primary actor:** Sistema  
- **Supporting actors:** Administrador  
- **Goal:** Registar automaticamente ações críticas do sistema para auditoria  
- **Preconditions:** Sistema operacional e ações críticas executadas por utilizadores autenticados  
- **Trigger:** Execução de uma ação crítica no sistema  
- **Postconditions (success):** Ação registada corretamente em log  
- **Postconditions (failure/cancel):** Ação executada sem registo completo  
- **Related requirements:** REQ-018, REQ-019  

### Main flow (happy path)

1. Utilizador executa ação crítica  
2. Sistema identifica a ação realizada  
3. Sistema recolhe dados relevantes da operação  
4. Sistema cria registo de auditoria  
5. Sistema armazena log na base de dados  
6. Sistema mantém o registo por no mínimo 12 meses  

### Alternative flows (min. 2)

**A1.** Ação não crítica → sistema não cria log detalhado  

**A2.** Registo duplicado identificado → sistema evita duplicação  

**A3.** Armazenamento secundário disponível → sistema cria cópia de segurança  

### Exceptions / errors (min. 2)

**E1.** Falha ao armazenar log → sistema tenta nova gravação  

**E2.** Base de dados indisponível → sistema guarda log temporariamente  

**E3.** Espaço insuficiente → sistema alerta administrador  
