# Gap Analysis — Lab 14

## Objetivo

Este documento identifica lacunas de rastreabilidade entre requisitos, critérios de aceitação, testes automatizados e cenários BDD do projeto EcoDoar.

A análise foi realizada após a consolidação da matriz de rastreabilidade presente em `traceability_master.md`.

---

# REQs com cobertura inexistente ou parcial

## REQ-006 — Bloqueio de conta após 5 tentativas falhadas

### Estado atual

O sistema possui autenticação e testes de login, mas não implementa a regra de bloqueio após 5 tentativas consecutivas falhadas.

### Cobertura atual

- Testes de login válido
- Testes de login inválido

### Lacuna

Não existe teste que valide:

- contagem de tentativas falhadas
- bloqueio da conta
- desbloqueio após 15 minutos

### Ação

**Out-of-scope nesta versão.**

Será implementado numa futura iteração de segurança.

---

## REQ-010 — Eliminação GDPR

### Estado atual

Não existe funcionalidade para eliminação de conta nem anonimização de dados.

### Lacuna

Nenhum teste automatizado cobre:

- pedido de eliminação
- prazo de 30 dias
- retenção legal mínima

### Ação

**Out-of-scope nesta versão.**

Requisito identificado para evolução futura.

---

## REQ-011 — Criação de anúncios

### Estado atual

Não implementado.

### Lacuna

Não existem:

- testes unitários
- testes de integração
- cenários BDD

### Ação

**Out-of-scope.**

---

## REQ-013 — Alteração de estado dos itens

### Estado atual

Não implementado.

### Lacuna

Sem cobertura de testes.

### Ação

**Out-of-scope.**

---

## REQ-014 — Correspondência automática

### Estado atual

Não implementado.

### Lacuna

Sem cobertura de testes.

### Ação

**Out-of-scope.**

---

## REQ-015 — Notificações

### Estado atual

Não implementado.

### Lacuna

Sem cobertura de testes.

### Ação

**Out-of-scope.**

---

## REQ-019 — Retenção de logs por 12 meses

### Estado atual

O sistema gera logs de auditoria.

### Lacuna

Não existe validação automatizada de retenção temporal.

### Ação

Adicionar futuramente:

- teste unitário de retenção
- política de limpeza de logs

---

## REQ-020 — Performance mobile

### Estado atual

O site funciona em browser.

### Lacuna

Não existem testes de:

- tempo de resposta
- carga
- desempenho mobile

### Ação

Adicionar testes de performance numa futura versão.

---

# Testes ou Cenários sem ligação explícita a REQ

Durante a revisão não foram encontrados testes automatizados sem ligação a requisitos.

Todos os testes atuais foram associados a pelo menos um requisito funcional ou não funcional.

Resultado:

- Nenhum teste removido.
- Nenhum cenário BDD removido.

---

# Critérios de Aceitação sem cobertura completa

## REQ-006

### AC

> Given que o utilizador falha login 5 vezes  
> When tenta novamente  
> Then a conta é bloqueada por 15 minutos

### Cobertura

Não existe implementação.

### Ação

Marcado como fora do âmbito da versão atual.

---

## REQ-010

### AC

- Eliminação de dados
- Prazo máximo de 30 dias
- Retenção legal mínima

### Cobertura

Não implementado.

### Ação

Marcado como fora do âmbito da versão atual.

---

## REQ-020

### AC

- 95% das operações ≤ 3 segundos
- Testes com carga simulada
- Dispositivos móveis comuns

### Cobertura

Não existem testes de performance.

### Ação

Adicionar futuramente testes de carga.

---

# Ações concluídas neste Lab

1. Consolidação da rastreabilidade entre REQ, AC, testes unitários e cenários BDD.

2. Verificação da cobertura dos requisitos principais do projeto.

3. Identificação dos requisitos fora do âmbito da versão atual.

4. Validação da existência de ligação entre testes automatizados e requisitos.

5. Atualização da documentação de qualidade e manutenção dos testes.

6. Confirmação da cobertura completa dos requisitos principais:

   - REQ-004 (Autenticação)
   - REQ-016 (Validação de Beneficiários)
   - REQ-017 (Histórico)
   - REQ-018 (Auditoria)

---

# Conclusão

O projeto apresenta boa cobertura para o seu foco atual:

- autenticação de utilizadores;
- proteção de funcionalidades críticas;
- validação institucional de beneficiários;
- histórico de validações;
- logs de auditoria.

As principais lacunas identificadas pertencem a funcionalidades que ainda não fazem parte do protótipo implementado e foram explicitamente classificadas como fora do âmbito desta versão.
