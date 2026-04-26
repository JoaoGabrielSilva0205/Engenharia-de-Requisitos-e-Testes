# Generated Scope — Lab 8

## Selected slice

* Slice: B
* Short description:
  Validação de beneficiários com captura de metadados e registo de auditoria, incluindo armazenamento de histórico e logs.

---

## Actors / roles

* Primary actor: Instituição
* Secondary actor: Sistema

---

## Use Cases implemented

* UC-VAL-01 — Validar beneficiário
* UC-VAL-02 — Consultar histórico de validações

---

## Requirements implemented (max 10)

* REQ-016 — Validação institucional de beneficiários
* REQ-017 — Histórico de validações
* REQ-018 — Registo de logs de auditoria

---

## Variant constraints implemented (min. 2)

* Todas as validações devem gerar logs com timestamp (auditoria)
* O sistema deve manter histórico completo das validações realizadas

---

## Out of scope (explicit)

* Sistema de autenticação
* Interface web ou mobile
* Base de dados persistente
* Gestão completa de utilizadores
* Outras funcionalidades fora da validação de beneficiários

