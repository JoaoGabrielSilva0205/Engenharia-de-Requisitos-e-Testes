# Acceptance Criteria — Lab 7

## REQ-001 — Registo de utilizadores
- AC-1: O sistema deve permitir inserir nome, email e password
- AC-2: O sistema rejeita emails inválidos
- AC-3: O utilizador recebe confirmação de registo

---

## REQ-004 — Autenticação (Given/When/Then)
- Given que o utilizador está registado
- When introduz email e password corretos
- Then deve conseguir aceder ao sistema

---

## REQ-005 — Logs de tentativas falhadas
- AC-1: O sistema regista cada tentativa falhada
- AC-2: Cada registo inclui timestamp e IP
- AC-3: Os logs são acessíveis para auditoria (variante)

---

## REQ-006 — Bloqueio de conta (Given/When/Then)
- Given que o utilizador falha login 5 vezes
- When tenta novamente
- Then a conta é bloqueada por 15 minutos

---

## REQ-010 — Eliminação GDPR
- AC-1: O utilizador pode solicitar eliminação de dados
- AC-2: Os dados são removidos em até 30 dias
- AC-3: O sistema mantém apenas dados obrigatórios por lei (variante)

---

## REQ-020 — Performance mobile
- AC-1: 95% das operações devem responder em ≤ 3 segundos
- AC-2: Testes devem ser realizados com carga simulada
- AC-3: Deve funcionar em dispositivos móveis comuns (variante)
