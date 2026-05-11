# Use Cases — Lab 5
## UC-01 — Criar anúncio de item
- Primary actor: Doador
- Supporting actors: —
- Goal: Permitir ao doador publicar um item disponível para doação
- Preconditions: Utilizador autenticado no sistema
- Trigger: Doador seleciona a opção "Criar anúncio"
- Postconditions (success): Item criado e disponível para outros utilizadores
- Postconditions (failure/cancel): Nenhum item é criado
- Related requirements: REQ-011, REQ-013

### Main flow (happy path)
1. Doador acede à funcionalidade de criação de anúncio
2. Sistema apresenta formulário de criação
3. Doador preenche os dados do item (descrição, imagens, estado)
4. Doador submete o formulário
5. Sistema valida os dados
6. Sistema cria o anúncio com estado "disponível"

### Alternative flows
A1. Dados incompletos → sistema solicita preenchimento dos campos obrigatórios
<br>
A2. Doador cancela operação → sistema descarta os dados inseridos

### Exceptions / errors
E1. Erro ao guardar dados → sistema informa falha e solicita nova tentativa
<br>
E2. Falha no upload de imagem → sistema pede nova imagem ou permite continuar sem imagem

---

## UC-04 — Solicitar item disponível
- Primary actor: Beneficiário
- Supporting actors: —
- Goal: Permitir ao beneficiário solicitar um item disponível
- Preconditions: Utilizador autenticado e item disponível
- Trigger: Beneficiário seleciona um item e clica em "Solicitar"
- Postconditions (success): Pedido registado no sistema
- Postconditions (failure/cancel): Nenhum pedido é registado
- Related requirements: REQ-014, REQ-015

### Main flow (happy path)
1. Beneficiário navega na lista de itens disponíveis
2. Sistema apresenta os detalhes do item
3. Beneficiário seleciona a opção "Solicitar item"
4. Sistema regista o pedido
5. Sistema associa o pedido ao item
6. Sistema altera o estado para "reservado"

### Alternative flows
A1. CRIAR UM ALTERNATIVE 
<br>
A2. Beneficiário cancela pedido → sistema não regista a solicitação

### Exceptions / errors
E1. Falha na comunicação com o sistema → pedido não é registado
<br>
E2. Dados inconsistentes → sistema rejeita operação

---

## UC-05 — Associar pedido a item
- Primary actor: Sistema
- Supporting actors: Doador, Beneficiário
- Goal: Associar automaticamente pedidos a itens disponíveis
- Preconditions: Existem pedidos e itens disponíveis
- Trigger: Novo pedido registado no sistema
- Postconditions (success): Pedido associado ao item e estado atualizado
- Postconditions (failure/cancel): Pedido permanece sem associação
- Related requirements: REQ-014, REQ-015

### Main flow (happy path)
1. Sistema identifica novo pedido de item
2. Sistema verifica itens disponíveis correspondentes
3. Sistema associa o pedido ao item
4. Sistema atualiza estado do item (ex: reservado)
5. Sistema envia notificação aos utilizadores

### Alternative flows
A1. Nenhum item disponível → pedido fica em espera
<br>
A2. Vários pedidos para o mesmo item → sistema aplica regra de prioridade

### Exceptions / errors
E1. Falha na associação → sistema mantém pedido pendente
<br>
E2. Erro no envio de notificação → sistema regista falha e tenta novamente
