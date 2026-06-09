# Test Retrocompatibility — Lab 14

## Objetivo

Este documento analisa a robustez dos testes do projeto EcoDoar perante alterações futuras no sistema.

O objetivo é identificar elementos frágeis que possam provocar falhas desnecessárias quando o software evoluir e definir ações de melhoria para aumentar a manutenção dos testes.

---

# Que alterações podem quebrar os testes atuais?

## Alterações de requisitos

Os testes BDD dependem diretamente da redação dos requisitos e dos critérios de aceitação.

Exemplos:

- alteração das regras de validação de beneficiários;
- alteração das regras de autenticação;
- alteração dos critérios de auditoria.

Impacto:

- cenários BDD deixam de refletir o comportamento esperado;
- necessidade de atualizar Steps e cenários.

---

## Alterações da interface web

Os testes Web MVC dependem das rotas atuais.

Exemplos:

- alteração de `/login`;
- alteração de `/register`;
- alteração de `/validation`.

Impacto:

- falha dos testes de integração web;
- necessidade de atualizar URLs e formulários.

---

## Refactoring interno

Os testes unitários utilizam diretamente serviços como:

- AuthenticationService
- ValidationService
- BeneficiaryRepository

Impacto:

- mudança de assinaturas de métodos;
- mudança de nomes de métodos;
- alteração de responsabilidades entre classes.

---

## Dependências e ambiente

O projeto depende de:

- Maven
- Spring Boot
- JUnit 5
- Cucumber
- Gson

Impacto:

- atualização de versões pode alterar comportamento;
- incompatibilidades podem impedir execução dos testes.

---

## Dados de teste

Os testes utilizam ficheiros JSON para armazenamento temporário.

Exemplos:

- data/beneficiaries.json
- data/cucumber-test-beneficiaries.json

Impacto:

- ficheiros partilhados podem introduzir dependências entre testes;
- dados antigos podem causar resultados inconsistentes.

---

# Fragile Points + Improvement Actions

## 1. Dados hardcoded nos testes

### Fragilidade

Vários testes utilizam IDs fixos:

```text
1
2
100
200
```

Uma alteração futura pode provocar colisões ou dependências inesperadas.

### Ação de melhoria

Criar um gerador automático de IDs de teste ou utilizar fixtures independentes.

---

## 2. Dependência de ficheiros JSON

### Fragilidade

Os testes utilizam armazenamento persistente baseado em ficheiros.

Uma execução interrompida pode deixar dados residuais.

### Ação de melhoria

Utilizar ficheiros temporários ou mocks durante os testes.

---

## 3. Dependência de frases exatas no Cucumber

### Fragilidade

Os cenários BDD dependem da correspondência exata entre:

- Given
- When
- Then

Uma pequena alteração textual pode quebrar os testes.

### Ação de melhoria

Padronizar Steps reutilizáveis e reduzir duplicação de expressões.

---

## 4. Dependência de URLs da aplicação

### Fragilidade

Os testes Web MVC verificam rotas específicas.

Exemplos:

```text
/login
/register
/validation
```

Alterações futuras na navegação podem causar falhas.

### Ação de melhoria

Centralizar constantes de rotas ou criar camada de abstração para testes.

---

## 5. Dependência da estrutura interna dos serviços

### Fragilidade

Os testes verificam diretamente:

- histórico;
- logs;
- resultados de validação.

Mudanças internas podem exigir alterações frequentes.

### Ação de melhoria

Focar os testes em comportamento observável e não em implementação interna.

---

# Avaliação de Retrocompatibilidade

## Cobertura atual

A cobertura atual é considerada boa para:

- autenticação;
- segurança;
- validação de beneficiários;
- histórico;
- auditoria.

---

## Risco de quebra

| Área | Risco |
|--------|--------|
| BDD | Médio |
| Testes Unitários | Baixo |
| Testes Web | Médio |
| Persistência JSON | Médio |
| Dependências Maven | Baixo |

---

## Recomendações Futuras

1. Introduzir fixtures de teste independentes.

2. Reduzir utilização de IDs fixos.

3. Criar uma camada de abstração para armazenamento de teste.

4. Reutilizar mais Step Definitions.

5. Automatizar execução dos testes em GitHub Actions.

---

# Conclusão

A maioria dos testes atuais é robusta relativamente às funcionalidades principais do projeto.

Os pontos mais frágeis estão relacionados com:

- dependência de ficheiros JSON;
- utilização de dados hardcoded;
- dependência textual dos cenários Cucumber.

As ações de melhoria identificadas permitem aumentar a estabilidade dos testes e reduzir custos de manutenção em futuras versões do EcoDoar.
