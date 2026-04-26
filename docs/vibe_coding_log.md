# Vibe Coding Log — Lab 8

## Tool used

* Codex / ChatGPT
* Environment/stack: Java (console application)

---

## Iteration 1

**Prompt (summary or paste):**

* Geração de protótipo base para validação de beneficiários com histórico e logs

**Generated output (what appeared):**

* Estrutura inicial em Java com classes para beneficiário
* Armazenamento em memória (listas)
* Fluxo básico de validação

**Kept (accepted):**

* Estrutura simples baseada em classes
* Armazenamento em listas
* Fluxo principal de validação

**Rejected (feature drift / out of scope):**

* Funcionalidade extra de autenticação (removida)
* Complexidade desnecessária na estrutura

**Manual verification:**

* Happy path:

  * Inserção de beneficiário válida → registado com sucesso
* Alternative flow:

  * Nome vazio → rejeitado pelo sistema
* Exception/error path:

  * Input inválido tratado com mensagem de erro

**Changes made after generation (manual edits):**

* Simplificação de classes
* Ajuste de mensagens no console

---

## Iteration 2

**Prompt (summary or paste):**

* Adição de validação de input, cenários de erro e logs de auditoria

**Generated output:**

* Validação de campos (nome obrigatório)
* Sistema de logs com timestamp
* Histórico de validações acessível

**Kept:**

* Validação de input
* Estrutura de logs
* Histórico de validações

**Rejected:**

* Sugestões de persistência em ficheiro (fora do escopo)
* Complexidade adicional não necessária

**Manual verification:**

* Happy path:

  * Validação correta → guardada no histórico + log criado
* Alternative flow:

  * Beneficiário inválido → rejeitado
* Exception/error path:

  * Dados inconsistentes → mensagem de erro exibida

**Changes made after generation:**

* Ajuste da estrutura dos logs
* Melhoria das mensagens ao utilizador

---

## Iteration 3

**Prompt (summary or paste):**

* Limpeza do código e criação de menu simples

**Generated output:**

* Aplicação executável com método main
* Menu com opções:

  * Validar beneficiário
  * Ver histórico
  * Ver logs

**Kept:**

* Menu simples
* Organização do código
* Funcionalidades essenciais

**Rejected:**

* Funcionalidades extra não solicitadas
* Complexidade adicional no menu

**Manual verification:**

* Happy path:

  * Validação → sucesso e registo
* Alternative flow:

  * Input inválido → rejeitado corretamente
* Exception/error path:

  * Operação inválida → tratada pelo sistema

**Changes made after generation:**

* Pequenos ajustes na interface do menu
* Organização do código para melhor leitura

---

## Notes (lessons learned)

* Requisitos pouco específicos geraram ambiguidades iniciais
* Foi necessário reforçar restrições de auditoria nos prompts
* A definição clara do escopo evitou funcionalidade extra
* A ligação entre REQ e implementação facilitou o controlo do sistema

