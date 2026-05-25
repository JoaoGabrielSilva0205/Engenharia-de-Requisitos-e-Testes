# Test Execution — Lab 12

## Stack
- Language: Java
- Test framework: JUnit
- Build tool: Maven
- Version requirements:
  - Java 17
  - Maven 3.x

## Setup
1. Abrir o projeto localmente.
2. Confirmar que o ficheiro `pom.xml` existe na raiz do projeto.
3. Confirmar que os testes estão em `src/test/java/`.

## Run all unit tests
- Command:
  - `mvn test`

## Run a single test file
- Command:
  - `mvn -Dtest=ValidationServiceTest test`

## Run a single test
- Command:
  - `mvn -Dtest=ValidationServiceTest#shouldValidateBeneficiaryWithValidName test`

## Notes
- Known limitations:
  - Os testes validam apenas a lógica de validação de beneficiários, histórico e logs.
  - Não há testes de interface gráfica.
- Troubleshooting tips:
  - Se o JUnit não for reconhecido, verificar se o `pom.xml` está correto.
  - Se o Maven não estiver instalado, instalar Maven ou executar os testes através de uma IDE Java.
