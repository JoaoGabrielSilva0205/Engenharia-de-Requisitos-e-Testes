# Test Cases — Lab 9

## TC-001 — Registo de novo utilizador com dados válidos

- Type: Funcional
- Priority: H
- Related requirements: REQ-001, REQ-002
- Preconditions:
  - Utilizador não autenticado
- Test data:
  - Nome: João Silva
  - Email: joao@email.com
  - Password: Teste123
- Steps:
  1. Aceder ao formulário de registo
  2. Inserir nome, email e password válidos
  3. Submeter formulário
- Expected results:
  - Sistema cria conta com sucesso
  - Sistema envia confirmação de registo
  - Dados ficam armazenados no sistema

---

## TC-002 — Registo com email inválido

- Type: System
- Priority: H
- Related requirements: REQ-002
- Preconditions:
  - Utilizador não autenticado
- Test data:
  - Email inválido: joaoemail.com
- Steps:
  1. Aceder ao formulário de registo
  2. Inserir email inválido
  3. Submeter formulário
- Expected results:
  - Sistema rejeita o email
  - Sistema apresenta mensagem de erro
  - Conta não é criada

---

## TC-003 — Login com credenciais válidas

- Type: Acceptance
- Priority: H
- Related requirements: REQ-004
- Preconditions:
  - Utilizador registado no sistema
- Test data:
  - Email válido
  - Password válida
- Steps:
  1. Aceder ao ecrã de login
  2. Inserir email e password corretos
  3. Selecionar "Entrar"
- Expected results:
  - Sistema autentica utilizador
  - Utilizador acede ao sistema

---

## TC-004 — Bloqueio após 5 tentativas falhadas

- Type: System
- Priority: H
- Related requirements: REQ-005, REQ-006
- Preconditions:
  - Conta existente
- Test data:
  - Password incorreta
- Steps:
  1. Inserir password incorreta 5 vezes consecutivas
  2. Tentar novo login
- Expected results:
  - Sistema regista todas as tentativas falhadas
  - Conta fica bloqueada por 15 minutos
  - Sistema informa bloqueio temporário

---

## TC-005 — Criar anúncio de item com imagem

- Type: Integration
- Priority: H
- Related requirements: REQ-011, REQ-013, REQ-018
- Preconditions:
  - Doador autenticado
- Test data:
  - Descrição do item
  - Imagem válida
- Steps:
  1. Aceder à funcionalidade "Criar anúncio"
  2. Inserir dados do item
  3. Fazer upload da imagem
  4. Submeter formulário
- Expected results:
  - Sistema cria anúncio
  - Estado do item fica "disponível"
  - Sistema regista ação em log

---

## TC-006 — Solicitar item já reservado

- Type: System
- Priority: M
- Related requirements: REQ-014
- Preconditions:
  - Beneficiário autenticado
  - Item reservado
- Test data:
  - Item com estado "reservado"
- Steps:
  1. Aceder ao item reservado
  2. Selecionar "Solicitar"
- Expected results:
  - Sistema rejeita pedido
  - Sistema informa indisponibilidade do item

---

## TC-007 — Validação institucional de beneficiário

- Type: Acceptance
- Priority: H
- Related requirements: REQ-016, REQ-017, REQ-018
- Preconditions:
  - Instituição autenticada
  - Beneficiário pendente
- Test data:
  - Documentos válidos
- Steps:
  1. Aceder à lista de beneficiários
  2. Selecionar beneficiário pendente
  3. Validar documentos
  4. Confirmar validação
- Expected results:
  - Beneficiário fica validado
  - Sistema guarda histórico de validação
  - Sistema regista ação em log

---

## TC-008 — Verificar retenção de logs por 12 meses

- Type: System
- Priority: M
- Related requirements: REQ-019
- Preconditions:
  - Logs armazenados no sistema
- Test data:
  - Logs com diferentes datas
- Steps:
  1. Consultar logs do sistema
  2. Verificar logs com menos de 12 meses
  3. Verificar logs com mais de 12 meses
- Expected results:
  - Logs com menos de 12 meses permanecem disponíveis
  - Logs expirados seguem política do sistema

---

## TC-009 — Teste de performance mobile

- Type: System
- Priority: H
- Related requirements: REQ-020
- Preconditions:
  - Sistema operacional
- Test data:
  - Simulação de carga normal
- Steps:
  1. Aceder à aplicação mobile
  2. Executar operações comuns
  3. Medir tempo de resposta
- Expected results:
  - 95% das operações respondem em até 3 segundos
