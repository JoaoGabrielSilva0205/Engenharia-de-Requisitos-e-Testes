# EcoDoar — Engenharia de Requisitos e Testes

EcoDoar é um projeto Java/Maven usado na disciplina de Engenharia de Requisitos e Testes para demonstrar requisitos, critérios de aceitação, testes JUnit, cenários BDD com Cucumber e rastreabilidade.

Esta versão acrescenta uma aplicação web simples com Spring Boot e Thymeleaf, preservando a lógica Java existente sempre que possível. O repositório de beneficiários continua a usar o ficheiro `data/beneficiaries.json` e a regra de negócio mantém o `id` como identificador único.

## Funcionalidades principais

- Página inicial com descrição do sistema, requisitos REQ-016, REQ-017 e REQ-018 e explicação de rastreabilidade.
- Página de beneficiários para listar dados de `data/beneficiaries.json` e criar novos beneficiários.
- Bloqueio de criação de beneficiários com `id` duplicado.
- Página de validação por `id` de beneficiário.
- Histórico de validações aprovadas com `beneficiaryId`, `beneficiaryName`, `status` e `timestamp`.
- Logs de auditoria com `timestamp` e `action`.
- Página de testes e qualidade com resumo de JUnit, Cucumber e `lab13.feature`.

## Requisitos implementados em destaque

- **REQ-016 — Validação institucional de beneficiários**: valida beneficiários existentes e rejeita beneficiários inexistentes ou com nome inválido.
- **REQ-017 — Histórico de validações**: guarda registos das validações aprovadas durante a execução da aplicação.
- **REQ-018 — Logs de auditoria**: guarda logs de sucesso e falha das validações executadas.

## Como correr o site

A aplicação web usa Spring Boot 2.7.18, compatível com Java 11.

```bash
mvn spring-boot:run
```

Depois de iniciar, abrir no navegador:

```text
http://localhost:8080
```

Rotas disponíveis:

- `GET /`
- `GET /beneficiaries`
- `POST /beneficiaries`
- `GET /validation`
- `POST /validation`
- `GET /history`
- `GET /logs`
- `GET /tests`

## Como correr os testes

Executar todos os testes JUnit e Cucumber configurados:

```bash
mvn test
```

Executar especificamente a feature BDD do Lab 13:

```bash
mvn -Dtest=RunLab13CucumberTest test
```

## Estrutura principal do projeto

```text
.
├── data/
│   ├── beneficiaries.json
│   └── test-beneficiaries.json
├── docs/
│   ├── requirements_v1.md
│   ├── acceptance_criteria.md
│   ├── test_plan.md
│   ├── unit_test_report.md
│   ├── test_execution.md
│   ├── bdd_report.md
│   └── traceability_req_bdd.md
├── src/
│   ├── Beneficiary.java              # package ecodoar
│   ├── BeneficiaryRepository.java
│   ├── ValidationService.java
│   ├── ValidationRecord.java
│   ├── LogEntry.java
│   ├── EcoDoarApplication.java       # Spring Boot
│   ├── EcoDoarWebController.java
│   ├── main/resources/
│   │   ├── templates/
│   │   │   ├── index.html
│   │   │   ├── beneficiaries.html
│   │   │   ├── validation.html
│   │   │   ├── history.html
│   │   │   ├── logs.html
│   │   │   └── tests.html
│   │   └── static/css/style.css
│   └── test/
│       ├── java/
│       └── resources/bdd/features/
└── pom.xml
```

## Organização técnica

- `EcoDoarApplication` inicia a aplicação Spring Boot e expõe um `ValidationService` configurado para `data/beneficiaries.json`.
- `EcoDoarWebController` concentra as rotas web e delega as regras de negócio para `ValidationService` e `BeneficiaryRepository`.
- As páginas HTML ficam em `src/main/resources/templates` e usam Thymeleaf.
- O design visual fica em `src/main/resources/static/css/style.css`.
- As classes de domínio e serviço originais foram preservadas, com visibilidade pública e pacote `ecodoar` para permitir acesso seguro pelo Spring Boot/Thymeleaf e evitar o uso do pacote Java padrão.

## Rastreabilidade e qualidade

O projeto mantém documentação e relatórios em `docs/`, incluindo requisitos, critérios de aceitação, plano de testes, relatórios de execução e rastreabilidade BDD. A feature `src/test/resources/bdd/features/lab13.feature` demonstra:

- **Happy path** — validar beneficiário existente.
- **Negative path** — rejeitar beneficiário com nome vazio.
- **Alternative flow** — rejeitar id duplicado.
- **Boundary behavior** — validar beneficiário com nome de um caractere.

## Observações de demonstração

- Os beneficiários são persistidos em formato JSON Lines no ficheiro `data/beneficiaries.json`, mantendo o comportamento original do `BeneficiaryRepository`.
- O histórico e os logs ficam em memória durante a execução atual da aplicação, conforme a lógica existente do `ValidationService`.
- O campo `name` pode repetir entre beneficiários; apenas o `id` deve ser único.


## Informação original do grupo

### Tema de projeto usado

EcoDoar.

### Projeto no Trello

[Link para acessar o projeto do Trello](https://trello.com/invite/b/698af9b62d78be81e09be2bf/ATTI30844e510cf7421d1a9442488e11ef04F8B63AAE/exemplo)

### Link para o GitBook

Ainda precisamos criar um gitbook.

### Elementos do grupo

- a22043160 - João Gabriel
- a22045793 - Vinicius Valconcellos Cardoso
- a22207598 - Andre Marques
- a22204542 - Giuseppe Mazzeo
