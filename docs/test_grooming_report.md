# Test Grooming Report — Lab 14

## Objetivo

Este documento regista as atividades de manutenção ("test grooming") realizadas sobre os ativos de teste do projeto EcoDoar.

O objetivo foi melhorar a legibilidade, rastreabilidade, reutilização e estabilidade dos testes automatizados e cenários BDD.

---

# Grooming Actions Performed

## 1. Consolidação da rastreabilidade

### File(s)

- docs/traceability_master.md

### Why

A informação encontrava-se distribuída entre requisitos, critérios de aceitação, testes unitários e cenários BDD.

Foi criada uma matriz consolidada para servir como fonte única de verdade.

---

## 2. Correção dos cenários BDD do Lab11

### File(s)

- bdd/features/lab11.feature

### Why

Foi identificado um problema de ordem incorreta dos passos.

Antes:

```gherkin
Given a validação do beneficiário é executada
When que existe um beneficiário...
```

Depois:

```gherkin
Given existe um beneficiário...
When a validação é executada
```

Isto tornou o cenário consistente com o comportamento real do sistema.

---

## 3. Refatoração dos Step Definitions

### File(s)

- src/test/java/BeneficiaryLab13Steps.java

### Why

Foram removidas dependências desnecessárias entre cenários.

Melhorias:

- reutilização de métodos comuns;
- inicialização consistente do repositório;
- isolamento entre cenários;
- redução de efeitos colaterais.

---

## 4. Isolamento dos dados de teste

### File(s)

- BeneficiaryLab13Steps.java
- ValidationServiceSecurityTest.java

### Why

Os testes utilizavam o mesmo ficheiro JSON da aplicação.

Foi introduzido um ficheiro específico para testes:

```text
data/cucumber-test-beneficiaries.json
```

Isto reduz interferências entre execução da aplicação e execução dos testes.

---

## 5. Melhoria da nomenclatura dos testes

### File(s)

- AuthenticationServiceTest.java
- ValidationServiceSecurityTest.java
- EcoDoarWebSecurityTest.java

### Why

Foram adotados nomes mais descritivos e alinhados com os requisitos.

Exemplos:

```text
shouldValidateExistingBeneficiaryWithValidName
```

```text
shouldRejectDuplicateBeneficiaryId
```

```text
visitorCannotValidateBeneficiary
```

Isto facilita manutenção futura e compreensão dos resultados.

---

## 6. Remoção de dependências frágeis

### File(s)

- BeneficiaryLab13Steps.java

### Why

Os cenários dependiam de IDs específicos e estado anterior do sistema.

Foi reforçada a inicialização dos dados antes de cada cenário.

---

## Traceability Updates

### What changed in traceability_master

Foi criada uma matriz única ligando:

```text
REQ
→ AC
→ Teste Unitário
→ Teste Web
→ Cenário BDD
→ Evidência
```

---

### Key gaps resolved

Foram identificados e documentados:

- REQ-006
- REQ-010
- REQ-019
- REQ-020

como requisitos ainda não implementados ou parcialmente cobertos.

---

# Test Execution Evidence

## Date

Junho 2026

---

## Commands Used

```bash
mvn clean test
```

```bash
mvn -Dtest=RunLab13CucumberTest test
```

---

## Unit Tests

Executados: 38

Passados: 38

Falhados: 0

---

## BDD Scenarios

Executados: 6

Passados: 6

Falhados: 0

---

## Resultado Global

```text
Tests run: 44
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

# Lessons Learned

## Main Source of Brittleness

A principal fonte de fragilidade foi a utilização de dados persistentes partilhados através de ficheiros JSON.

Isto provocava:

- dependências entre cenários;
- resultados inconsistentes;
- falhas difíceis de reproduzir.

---

## Biggest Improvement

A melhoria com maior impacto foi o isolamento dos testes através da limpeza e reinicialização controlada dos repositórios de teste.

Benefícios:

- cenários independentes;
- resultados reproduzíveis;
- maior confiança na execução automatizada.

---

## Future Improvements

1. Implementar bloqueio após 5 tentativas falhadas (REQ-006).

2. Adicionar testes de performance para REQ-020.

3. Implementar testes para retenção de logs (REQ-019).

4. Automatizar execução através de GitHub Actions.

5. Introduzir mocks para eliminar dependência de ficheiros físicos.

---

# Conclusion

O processo de grooming melhorou significativamente a qualidade dos testes do projeto EcoDoar.

Os ativos de teste encontram-se agora:

- mais legíveis;
- mais reutilizáveis;
- melhor documentados;
- alinhados com os requisitos atuais;
- preparados para evolução futura.
