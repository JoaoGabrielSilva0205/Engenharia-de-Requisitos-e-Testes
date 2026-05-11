# Traceability — Use Cases ↔ Requirements (Lab 6)

## Mapping (UC → REQ)

| Use Case | Linked Requirements (REQ-###) | Notes |
|---|---|---|
| UC-01 Criar anúncio de item | REQ-011, REQ-013, REQ-018 | Criação de item, estado e auditoria |
| UC-02 Editar anúncio de item | REQ-012, REQ-013 | Edição e atualização de estado |
| UC-03 Alterar estado do item | REQ-013, REQ-018 | Mudança de estado com registo |
| UC-04 Solicitar item disponível | REQ-014, REQ-015 | Pedido e início da correspondência |
| UC-05 Associar pedido a item | REQ-014, REQ-015, REQ-018 | Associação automática + notificação + auditoria |
| UC-06 Notificar utilizadores | REQ-015, REQ-018 | Notificações e registo de eventos |

---

## Gaps / Observations (optional)

- Use case without requirements:
  - Nenhum

- Requirement without use cases:
  - REQ-001 a REQ-010 não estão cobertos nesta fatia

- Missing requirement candidates revealed by modeling:
  - Requisito ausente: validação de conteúdo dos anúncios
  - Requisito ausente: gestão de prioridade em múltiplos pedidos

---

# Traceability — Requirements ↔ Test Cases (Lab 9)

## Selected requirements (8)

- REQ-001
- REQ-002
- REQ-004
- REQ-005
- REQ-006
- REQ-011
- REQ-016
- REQ-020

## Mapping (REQ → TC)

| Requirement (REQ-###) | Test Cases (TC-###) | Notes |
|---|---|---|
| REQ-001 | TC-001 | Registo de utilizador |
| REQ-002 | TC-001, TC-002 | Validação de email |
| REQ-004 | TC-003 | Login válido |
| REQ-005 | TC-004 | Registo de tentativas falhadas |
| REQ-006 | TC-004 | Bloqueio temporário |
| REQ-011 | TC-005 | Criação de anúncios |
| REQ-016 | TC-007 | Validação institucional |
| REQ-020 | TC-009 | Performance mobile |
