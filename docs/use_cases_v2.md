# Use Cases v2 — Lab 6

## UC-01 — Criar anúncio de item
- Primary actor: Doador
- Supporting actors: —
- Goal: Permitir ao doador publicar um item disponível
- Preconditions: Utilizador autenticado
- Trigger: Doador seleciona "Criar anúncio"
- Postconditions (success): Item criado e disponível
- Postconditions (failure/cancel): Nenhum item é criado
- Related requirements: REQ-011, REQ-013, REQ-018

### Main flow (happy path)
1. Doador acede à funcionalidade de criação
2. Sistema apresenta formulário
3. Doador preenche dados do item
4. Doador submete
5. Sistema valida dados
6. Sistema regista o item como disponível
7. Sistema regista ação em log

### Alternative flows (min. 2)
A1. Dados incompletos → sistema solicita correção
<br>
A2. Doador cancela → sistema descarta operação
<br>
A3. Imagem opcional não fornecida → sistema aceita sem imagem

### Exceptions / errors (min. 2)
E1. Falha ao guardar dados → sistema informa erro
<br>
E2. Falha no upload de imagem → sistema permite repetir
<br>
E3. Erro de validação → sistema bloqueia criação

---

## UC-04 — Solicitar item disponível
- Primary actor: Beneficiário
- Supporting actors: —
- Goal: Solicitar um item disponível
- Preconditions: Utilizador autenticado; item disponível
- Trigger: Beneficiário clica em "Solicitar"
- Postconditions (success): Pedido registado
- Postconditions (failure/cancel): Pedido não registado
- Related requirements: REQ-014, REQ-015

### Main flow (happy path)
1. Beneficiário visualiza item
2. Sistema apresenta detalhes
3. Beneficiário solicita item
4. Sistema regista pedido
5. Sistema inicia processo de associação

### Alternative flows (min. 2)
A1. Item já reservado → sistema informa indisponibilidade
<br>
A2. Beneficiário cancela → sistema não regista pedido
<br>
A3. Múltiplos pedidos → sistema coloca em fila

### Exceptions / errors (min. 2)
E1. Falha no sistema → pedido não registado
<br>
E2. Dados inconsistentes → operação rejeitada
<br>
E3. Falha de comunicação → tentativa posterior

---

## Variant-driven notes (required)
- Segurança/Auditoria:
  - Registo de ações no UC-01 (REQ-018)
  - Tratamento de falhas e validações reforçadas
