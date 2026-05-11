# AC & DoD Updates — Lab 10

## Acceptance Criteria improvements (min. 3)

### Item 1 (variant-driven)

- Requirement: REQ-005

- Before:
  - O sistema regista cada tentativa falhada

- After:
  - O sistema deve registar timestamp, IP e identificador do utilizador em cada tentativa falhada

- Why changed:
  - Melhorar rastreabilidade e auditoria
  - Tornar o critério mais verificável

---

### Item 2

- Requirement: REQ-006

- Before:
  - A conta é bloqueada por 15 minutos

- After:
  - Após 5 tentativas falhadas consecutivas, a conta deve permanecer bloqueada exatamente por 15 minutos

- Why changed:
  - Tornar o comportamento mensurável
  - Evitar ambiguidades

---

### Item 3

- Requirement: REQ-020

- Before:
  - 95% das operações devem responder em ≤ 3 segundos

- After:
  - 95% das operações mobile devem responder em até 3 segundos utilizando carga simulada de utilizadores simultâneos

- Why changed:
  - Melhor definição do contexto de teste
  - Facilitar validação de performance

---

## DoD updates (min. 2)

### 1. Proposed DoD change

- Before:
  - Existem testes (unitários ou integração)

- After:
  - Existem testes unitários, integração e pelo menos um cenário BDD associado

- Why:
  - Melhor cobertura funcional
  - Integração entre testes e critérios de aceitação

---

### 2. Proposed DoD change

- Before:
  - Critérios de aceitação definidos

- After:
  - Critérios de aceitação devem ser mensuráveis e verificáveis através de testes

- Why:
  - Reduzir ambiguidades
  - Melhorar validação dos requisitos
