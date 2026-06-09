# Registo de Prompts Utilizados no Desenvolvimento do Projeto EcoDoar

## Objetivo

Este documento regista os principais prompts utilizados durante o desenvolvimento técnico do projeto EcoDoar.

Foram incluídos apenas prompts relacionados com:

- Testes unitários (JUnit)
- Testes BDD (Cucumber)
- Persistência de beneficiários
- Login e autenticação
- Segurança
- Aplicação Web Spring Boot
- Validação institucional de beneficiários

Documentação académica e relatórios não foram considerados, uma vez que não alteram diretamente o comportamento do sistema.

---

# Fase 1 — Testes Unitários

## Prompt 1 — Testes para Validação de Beneficiários

```text
Preciso criar testes unitários em Java usando JUnit para validar a funcionalidade principal do sistema.

O foco deve ser a validação institucional de beneficiários, histórico de validações e logs de auditoria.

Os testes devem estar alinhados com REQ-016, REQ-017 e REQ-018.
```

### Resultado

- Criação de `ValidationServiceTest`
- Cobertura de REQ-016
- Cobertura de REQ-017
- Cobertura de REQ-018

---

## Prompt 2 — Testes Negativos e Boundary Tests

```text
Ajude-me a adicionar testes negativos e boundary tests para ValidationService.

O sistema deve aceitar nomes válidos e rejeitar nomes vazios ou nulos.

Utilizar assertTrue, assertFalse e assertEquals.
```

### Resultado

- Teste para nome válido
- Teste para nome vazio
- Teste para nome nulo
- Teste de limite com nome de um caractere

---

## Prompt 3 — Tornar ValidationService Testável

```text
A ValidationService imprime resultados no terminal.

Preciso torná-la testável através de retornos booleanos e métodos de acesso ao histórico e logs.
```

### Resultado

- Introdução de retornos booleanos
- Introdução de `getHistory()`
- Introdução de `getLogs()`

---

# Fase 2 — Persistência e Beneficiários

## Prompt 4 — Repositório JSON

```text
A validação deve ser feita sobre beneficiários reais.

Criar um BeneficiaryRepository com persistência JSON e suporte para procura por ID.
```

### Resultado

- Criação de `BeneficiaryRepository`
- Persistência em JSON
- Procura por beneficiário através do ID

---

## Prompt 5 — IDs Duplicados

```text
Impedir que dois beneficiários tenham o mesmo ID.

O repositório deve rejeitar duplicações e os testes devem validar esse comportamento.
```

### Resultado

- Validação de unicidade de ID
- Rejeição de IDs duplicados
- Novos testes de segurança

---

# Fase 3 — BDD e Cucumber

## Prompt 6 — Criação dos Cenários BDD

```text
Criar um ficheiro Gherkin para validar beneficiários utilizando Given / When / Then.

Os cenários devem cobrir sucesso, falha e auditoria.
```

### Resultado

- Criação de `lab11.feature`
- Happy Path
- Negative Path

---

## Prompt 7 — Integração dos Steps com o Projeto

```text
Adaptar os Step Definitions para usar as classes reais do projeto.

Não inventar métodos inexistentes.
```

### Resultado

- Integração com ValidationService
- Integração com BeneficiaryRepository
- Execução real dos cenários

---

## Prompt 8 — Correção de Conflitos no Cucumber

```text
Corrigir conflitos entre Lab11 e Lab13 e eliminar Step Definitions duplicados.
```

### Resultado

- Compatibilidade entre Lab11 e Lab13
- Remoção de ambiguidades
- Execução correta dos testes BDD

---

# Fase 4 — Aplicação Web

## Prompt 9 — Transformação para Aplicação Web

```text
Transformar o projeto EcoDoar numa aplicação web usando Spring Boot e Thymeleaf.

Reutilizar toda a lógica existente de beneficiários, validação, histórico e auditoria.
```

### Resultado

- Criação de `EcoDoarApplication`
- Criação de `EcoDoarWebController`
- Templates Thymeleaf
- CSS responsivo

---

## Prompt 10 — Interface de Validação

```text
Criar uma página de validação de beneficiários ligada à ValidationService.
```

### Resultado

- Validação via browser
- Integração com a lógica existente
- Histórico e logs acessíveis pela interface

---

# Fase 5 — Segurança e Login

## Prompt 11 — Sistema de Login

```text
Adicionar autenticação ao EcoDoar.

Visitantes podem consultar informação, mas apenas utilizadores autenticados podem criar ou validar beneficiários.
```

### Resultado

- Login
- Logout
- Sessão HTTP
- Proteção das funcionalidades críticas

---

## Prompt 12 — Registo de Utilizadores

```text
Adicionar registo de novos utilizadores.

Manter utilizadores demo e permitir criação dinâmica de contas.
```

### Resultado

- Página `/register`
- Registo de utilizadores
- Validação de email duplicado

---

## Prompt 13 — Correção do Login

```text
O login existe mas os utilizadores de demonstração não conseguem autenticar-se.

Corrigir AuthenticationService, normalização de emails e validação de passwords.
```

### Resultado

- Correção do login
- Utilizadores demo funcionais
- Registo de novos utilizadores funcional

---

# Fase 6 — Segurança e Cobertura de Testes

## Prompt 14 — Testes de Segurança Web

```text
Quero melhorar os testes do projeto focando login e validação de beneficiário.

Adicionar testes para utilizadores autenticados e visitantes.
```

### Resultado

- Criação de `EcoDoarWebSecurityTest`
- Proteção das rotas críticas
- Validação de permissões

---

## Prompt 15 — Testes Avançados de ValidationService

```text
Adicionar testes para:

- beneficiário inexistente;
- beneficiário com nome vazio;
- id duplicado;
- histórico;
- logs.
```

### Resultado

- Criação de `ValidationServiceSecurityTest`
- Maior cobertura de REQ-016
- Maior cobertura de REQ-017
- Maior cobertura de REQ-018

---

# Commits Principais Relacionados

## Add Spring Boot web interface for EcoDoar

### Conteúdo

- Aplicação Spring Boot
- Thymeleaf
- Templates HTML
- CSS
- Integração com ValidationService

---

## Add login and protected actions to EcoDoar web app

### Conteúdo

- Login
- Logout
- Sessão HTTP
- Proteção de funcionalidades críticas

---

## Fix login and add user registration

### Conteúdo

- Correção da autenticação
- Registo de utilizadores
- Email único
- Utilizadores demo

---

## Fix Lab11 and Lab13 cucumber scenarios

### Conteúdo

- Correção dos cenários BDD
- Compatibilidade entre laboratórios
- Correção dos Step Definitions

---

## Improve beneficiary validation and security tests

### Conteúdo

- Novos testes unitários
- Novos testes de segurança
- Cobertura de login
- Cobertura de validação de beneficiários

---

# Resultado Final

O projeto evoluiu de uma aplicação Java executada em consola para uma aplicação web Spring Boot com:

- Autenticação
- Registo de utilizadores
- Validação institucional de beneficiários
- Histórico de validações
- Logs de auditoria
- Testes Unitários (JUnit)
- Testes Web
- Testes BDD (Cucumber)

O foco principal do desenvolvimento foi garantir a qualidade das funcionalidades de autenticação e validação de beneficiários, mantendo alinhamento com os requisitos REQ-016, REQ-017 e REQ-018.
