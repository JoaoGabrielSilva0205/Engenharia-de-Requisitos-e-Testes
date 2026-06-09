# EcoDoar — Engenharia de Requisitos e Testes

EcoDoar é um projeto desenvolvido no âmbito da unidade curricular de Engenharia de Requisitos e Testes. O sistema demonstra a aplicação prática de requisitos funcionais e não funcionais, critérios de aceitação, rastreabilidade, testes unitários com JUnit e testes BDD com Cucumber.

A solução foi implementada em Java utilizando Maven e inclui uma aplicação web baseada em Spring Boot e Thymeleaf para demonstração das funcionalidades principais do sistema.

---

# Objetivo do Projeto

O EcoDoar tem como objetivo apoiar a gestão e validação institucional de beneficiários, garantindo controlo de acesso, histórico de validações e registo de auditoria das operações realizadas.

---

# Funcionalidades Principais

- Registo de beneficiários
- Validação institucional de beneficiários
- Histórico de validações
- Logs de auditoria
- Login e autenticação de utilizadores
- Registo de novos utilizadores
- Controlo de acesso baseado em sessão
- Interface web para demonstração académica

---

# Requisitos Implementados em Destaque

## REQ-016 — Validação Institucional de Beneficiários

- Valida beneficiários existentes
- Rejeita beneficiários inexistentes
- Rejeita beneficiários com nome inválido

## REQ-017 — Histórico de Validações

- Regista validações aprovadas
- Guarda identificador, nome e timestamp

## REQ-018 — Logs de Auditoria

- Regista eventos de validação
- Regista autenticação e logout
- Regista criação de beneficiários
- Regista tentativas inválidas ou bloqueadas

---

# Casos de Uso Implementados

| Use Case | Estado |
|-----------|---------|
| UC02 Register Beneficiary | Implementado |
| UC03 Validate Beneficiary | Implementado |
| UC04 Authenticate User | Implementado |
| UC05 Edit Profile | Implementado (versão simplificada) |
| UC12 Secure Visualization | Implementado |
| UC13 Audit Log | Implementado |

---

# Tecnologias Utilizadas

- Java 11
- Maven
- Spring Boot 2.7.18
- Thymeleaf
- JUnit 5
- Cucumber

---

# Como Executar a Aplicação

Executar:

```bash
mvn spring-boot:run
```

Após iniciar, abrir:

```text
http://localhost:8080
```

---

# Rotas Disponíveis

- GET /
- GET /beneficiaries
- POST /beneficiaries
- GET /validation
- POST /validation
- GET /history
- GET /logs
- GET /tests
- GET /login
- POST /login
- GET /register
- POST /register
- GET /logout
- GET /profile

---

# Login e Controlo de Acesso

A autenticação é realizada através de sessão HTTP para fins académicos.

## Credenciais de Demonstração

| Papel | Email | Password |
|---------|---------|---------|
| Administrador Cruz Vermelha | admin@ecodoar.pt | admin123 |
| Doador Demo | donor@ecodoar.pt | donor123 |

Também é possível criar novos utilizadores através de:

```text
/register
```

### Roles Disponíveis

- DONOR
- BENEFICIARY

### Ações Públicas

Visitantes podem consultar:

- Página inicial
- Beneficiários
- Validação
- Histórico
- Logs
- Testes
- Login
- Registo

### Ações Protegidas

Apenas utilizadores autenticados podem:

- Criar beneficiários
- Validar beneficiários
- Consultar perfil
- Terminar sessão

---

# Como Executar os Testes

Executar todos os testes:

```bash
mvn clean test
```

Executar apenas os cenários BDD:

```bash
mvn -Dtest=RunLab13CucumberTest test
```

---

# Documentação

Toda a documentação do projeto encontra-se na pasta `docs/`.

## Requisitos e Análise

- requirements_v1.md
- acceptance_criteria.md

## Testes

- test_plan.md
- test_cases.md
- test_execution.md
- unit_test_report.md

## BDD e Rastreabilidade

- bdd_report.md
- traceability_req_bdd.md
- traceability_master.md

## Lab 14 — Quality & Testing Maintenance

- gap_analysis_lab14.md
- test_retrocompatibility.md
- test_grooming_report.md

---

# Qualidade e Testes

## Testes Unitários

- ValidationServiceTest
- ValidationServiceSecurityTest
- AuthenticationServiceTest

## Testes de Integração / BDD

- lab11.feature
- lab13.feature
- BeneficiaryLab13Steps
- RunLab13CucumberTest

### Cobertura BDD

- Happy Path
- Negative Path
- Alternative Flow
- Boundary Conditions

---

# Observações

- Os beneficiários são armazenados em `data/beneficiaries.json`.
- O identificador (`id`) é único.
- O histórico e os logs são mantidos em memória durante a execução da aplicação.
- O projeto foi desenvolvido com foco na validação institucional de beneficiários, autenticação de utilizadores e auditoria de operações.

---

# Projeto no Trello

[Link para acessar o projeto do Trello](https://trello.com/invite/b/698af9b62d78be81e09be2bf/ATTI30844e510cf7421d1a9442488e11ef04F8B63AAE/exemplo)

---

# Elementos do Grupo

- a22043160 — João Gabriel
- a22045793 — Vinicius Valconcellos Cardoso
- a22207598 — Andre Marques
- a22204542 — Giuseppe Mazzeo
