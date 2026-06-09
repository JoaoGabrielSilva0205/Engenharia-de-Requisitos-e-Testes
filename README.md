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
- Login simples por sessão HTTP para demonstração académica de Account management and security.
- Registo simples de novos utilizadores em memória, com roles `DONOR` ou `BENEFICIARY`.
- Controlo de acesso: visitantes podem consultar páginas públicas, mas apenas utilizadores autenticados podem criar ou validar beneficiários.

## Requisitos implementados em destaque

- **REQ-016 — Validação institucional de beneficiários**: valida beneficiários existentes e rejeita beneficiários inexistentes ou com nome inválido.
- **REQ-017 — Histórico de validações**: guarda registos das validações aprovadas durante a execução da aplicação.
- **REQ-018 — Logs de auditoria**: guarda logs de sucesso e falha das validações executadas, autenticação, logout, criação de beneficiários e tentativas bloqueadas.

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
- `GET /login`
- `POST /login`
- `GET /register`
- `POST /register`
- `GET /logout`
- `GET /profile`

## Login e controlo de acesso

A autenticação é simples, em memória e por sessão HTTP, adequada para demonstração académica. Não há base de dados de utilizadores.

Credenciais de demonstração:

| Papel | Email | Password | Role |
| --- | --- | --- | --- |
| Administrador Cruz Vermelha | `admin@ecodoar.pt` | `admin123` | `RED_CROSS_ADMIN` |
| Doador demo | `donor@ecodoar.pt` | `donor123` | `DONOR` |

Também é possível criar novos utilizadores em `/register`. O registo é mantido em memória durante a execução da aplicação e não valida automaticamente um beneficiário.

Roles disponíveis para novos registos:

- `DONOR`
- `BENEFICIARY`

Visitantes não autenticados podem ver:

- `/`
- `/beneficiaries`
- `/validation`
- `/history`
- `/logs`
- `/tests`
- `/login`
- `/register`

Visitantes não autenticados não podem executar ações protegidas:

- `POST /beneficiaries`
- `POST /validation`

Quando um visitante tenta executar uma ação protegida, é redirecionado para `/login` com a mensagem `É necessário iniciar sessão para realizar esta ação.`.

Utilizadores autenticados podem:

- criar beneficiários;
- validar beneficiários;
- aceder ao perfil em `/profile`;
- terminar sessão em `/logout`.

Para testar manualmente:

1. Abrir `http://localhost:8080/register`, criar um utilizador com role `DONOR` ou `BENEFICIARY` e confirmar que volta para `/login` com mensagem de sucesso.
2. Entrar em `http://localhost:8080/login` com `admin@ecodoar.pt` / `admin123`, `donor@ecodoar.pt` / `donor123` ou com a conta criada.
3. Abrir `http://localhost:8080/beneficiaries` sem login e confirmar que a lista aparece, mas o formulário mostra `Inicie sessão para criar beneficiários.`.
4. Abrir `http://localhost:8080/validation` sem login e confirmar que o formulário de validação não aparece.
5. Com sessão iniciada, voltar a `/beneficiaries` e criar um beneficiário com `id` novo.
6. Voltar a `/validation`, validar esse `id` e confirmar a mensagem de sucesso.
7. Consultar `/logs` para ver registo, login, criação, validação e logout registados.

## Como correr os testes

Executar todos os testes JUnit e Cucumber configurados:

```bash
mvn clean test
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
│   ├── User.java
│   ├── AuthenticationService.java
│   ├── EcoDoarApplication.java       # Spring Boot
│   ├── EcoDoarWebController.java
│   ├── main/resources/
│   │   ├── templates/
│   │   │   ├── index.html
│   │   │   ├── beneficiaries.html
│   │   │   ├── validation.html
│   │   │   ├── history.html
│   │   │   ├── logs.html
│   │   │   ├── tests.html
│   │   │   ├── login.html
│   │   │   ├── register.html
│   │   │   └── profile.html
│   │   └── static/css/style.css
│   └── test/
│       ├── java/
│       └── resources/bdd/features/
└── pom.xml
```

## Organização técnica

- `EcoDoarApplication` inicia a aplicação Spring Boot e expõe um `ValidationService` configurado para `data/beneficiaries.json`.
- `EcoDoarWebController` concentra as rotas web, gere sessão HTTP para login/logout e delega regras de negócio para `ValidationService`, `AuthenticationService` e `BeneficiaryRepository`.
- As páginas HTML ficam em `src/main/resources/templates` e usam Thymeleaf.
- O design visual fica em `src/main/resources/static/css/style.css`.
- As classes de domínio e serviço originais foram preservadas, com visibilidade pública e pacote `ecodoar` para permitir acesso seguro pelo Spring Boot/Thymeleaf e evitar o uso do pacote Java padrão.
- `AuthenticationService` contém os utilizadores de demonstração, valida credenciais em memória e permite registar novos utilizadores durante a execução.

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

### Elementos do grupo

- a22043160 - João Gabriel
- a22045793 - Vinicius Valconcellos Cardoso
- a22207598 - Andre Marques
- a22204542 - Giuseppe Mazzeo
