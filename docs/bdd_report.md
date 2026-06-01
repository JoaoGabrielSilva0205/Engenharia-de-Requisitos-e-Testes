# BDD Automation Report — Lab 13

## Tool used

- BDD Framework: Cucumber
- Language: Java
- Build Tool: Maven
- Test Runner: JUnit 5

## How to run

Executar apenas os cenários do Lab 13:

```bash
mvn -Dtest=RunLab13CucumberTest test
```

Executar todos os testes:

```bash
mvn test
```

## Requirements covered

- REQ-016 — Validação institucional de beneficiários
- REQ-017 — Histórico de validações
- REQ-018 — Logs de auditoria

## Scenarios executed

### Happy path — validar beneficiário existente

Objetivo:
Validar um beneficiário existente e registar a validação no histórico e nos logs.

Resultado:
PASS

### Negative path — rejeitar beneficiário com nome vazio

Objetivo:
Garantir que beneficiários com dados inválidos não são validados.

Resultado:
PASS

### Alternative flow — rejeitar id duplicado

Objetivo:
Garantir que não é possível criar dois beneficiários com o mesmo ID.

Resultado:
PASS

### Boundary behavior — validar beneficiário com nome de um caractere

Objetivo:
Validar o comportamento do sistema com o menor nome aceitável.

Resultado:
PASS

## Execution results

- Data: 01/06/2026
- Scenarios executed: 4
- Passed: 4
- Failed: 0
- Skipped: 0

## Evidence

Resultado obtido após execução:

```text
Tests run: 4
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

Feature executada:

```text
bdd/features/lab13.feature
```

## Notes

### What worked well

- Integração entre Maven, JUnit e Cucumber.
- Execução automática dos cenários BDD.
- Cobertura de happy path, negative path, alternative flow e boundary behavior.
- Rastreabilidade entre requisitos e cenários.

### What failed and why

Nenhuma falha identificada na execução final.

### Next steps

- Adicionar cenários para autenticação.
- Adicionar cenários para bloqueio após múltiplas tentativas falhadas.
- Aumentar a cobertura dos requisitos do sistema.
