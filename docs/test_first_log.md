# Test-First Log — Lab 11

## Selected scope (max 3 requirements)

- REQ-016 — Validação institucional de beneficiários
  - AC used:
    - Beneficiário com nome válido deve ser validado
    - Beneficiário sem nome deve ser rejeitado

- REQ-017 — Histórico de validações
  - AC used:
    - Cada validação válida deve ser guardada no histórico

- REQ-018 — Logs de auditoria
  - AC used:
    - Cada ação crítica deve gerar um log de auditoria

## Tests written first (list)

- T-01: valida beneficiário com nome válido (REQ-016)
- T-02: rejeita beneficiário com nome vazio (REQ-016)
- T-03: rejeita beneficiário com nome nulo (REQ-016)
- T-04: guarda validação no histórico (REQ-017)
- T-05: cria log de auditoria após validação (REQ-018)
- T-06: aceita nome com apenas um caractere como teste limite (REQ-016)

## Results

- Initial run: os testes foram definidos antes dos ajustes finais na implementação.
- After implementation: espera-se que os 6 testes passem após adicionar retornos booleanos e métodos de consulta.

## Implementation notes (minimal code to pass)

- Classes usadas:
  - ValidationService
  - ValidationRecord
  - LogEntry

- Regras implementadas:
  - Nome nulo ou vazio é inválido
  - Nome válido gera validação com estado VALID
  - Validação válida é guardada no histórico
  - Cada tentativa de validação gera log

## BDD scenarios

- Feature: bdd/features/lab11.feature
- Scenario 1: Happy path — validar beneficiário com nome válido
- Scenario 2: Negative path — rejeitar beneficiário sem nome

## AI usage

- Tool: ChatGPT
- Prompt summary: apoio na criação dos testes JUnit, cenário BDD e organização do Lab 11.
- What was accepted:
  - Estrutura dos testes
  - Ajustes mínimos para tornar ValidationService testável
  - Conteúdo do ficheiro lab11.feature
- What was rejected (feature drift):
  - Implementação de login, registo e autenticação, porque ficou fora do escopo escolhido
  - Criação obrigatória de steps Cucumber, porque o enunciado apenas exige o ficheiro feature
- Why:
  - O laboratório limita o escopo a no máximo 3 requisitos
  - O objetivo é testar uma parte pequena e coerente do sistema

## Lessons learned

- O código precisa expor resultados verificáveis para ser testável.
- Retornar boolean e criar métodos getHistory/getLogs tornou os testes mais claros.
- O teste de nome vazio ajudou a clarificar a regra de validação.
- Num próximo passo, seria possível executar os cenários Cucumber com steps próprios.
