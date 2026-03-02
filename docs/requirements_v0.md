| Item | Requirement | Type | Stakeholder | Priority | Variant? |
|---:|---|---|---|---|---|
| 1 | O sistema deve permitir que doadores criem e gerenciem anúncios de doação. | FR | Doadores | H | No |
| 2 | O sistema deve permitir que instituições autorizadas validem a elegibilidade dos beneficiários. | FR | Instituições parceiras | H | No |
| 3 | O sistema deve registar todas as ações relevantes dos utilizadores (criar, alterar, eliminar, validar) com data/hora e identificação do utilizador. | NFR | Administrador do sistema | H | Yes |
| 4 | O sistema deve permitir que os utilizadores solicitem a eliminação dos seus dados pessoais, com remoção completa em até 30 dias. | NFR | Beneficiários | H | Yes |
| 5 | O sistema deve mostrar o estado de cada item doado (disponível, reservado, entregue) em tempo real. | FR | Todos os utilizadores | H | No |
| 6 | O sistema deve carregar a interface principal da aplicação mobile em até 3 segundos em condições normais de rede móvel. | NFR | Utilizadores mobile | M | Yes |
| 7 | O sistema deve restringir o acesso às funções de validação apenas a utilizadores com permissões autorizadas. | NFR | Administrador do sistema | H | Yes |
| 8 | O sistema deve armazenar ações realizadas offline e sincronizá-las automaticamente quando houver ligação à internet. | FR | Utilizadores mobile | M | Yes |
| 9 | O sistema deve garantir disponibilidade mínima de 99% durante o horário de suporte (08:00–20:00 em dias úteis). | NFR | Equipa de suporte | M | No |
| 10 | O sistema deve registar tentativas falhadas de login e notificar administradores após 5 falhas consecutivas. | NFR | Responsável de segurança | M | Yes |
| 11 | O sistema deve permitir que administradores gerem relatórios de auditoria por intervalo de datas. | FR | Administrador do sistema | M | Yes |
| 12 | O sistema deve manter consistência dos dados após falhas inesperadas ou interrupções do sistema. | NFR | Equipa de suporte | H | No |



Clarificação de Requisitos Ambíguos: 

1. Original: "O sistema deve carregar rapidamente em dispositivos móveis."
Rewritten: "O sistema deve carregar a interface principal da aplicação mobile em até 3 segundos em condições normais de rede móvel."

2. Original: "Os dados dos utilizadores devem estar protegidos conforme a lei."
Rewritten: "O sistema deve permitir que os utilizadores solicitem a eliminação dos seus dados pessoais, com remoção completa em até 30 dias."

3. Original: "Apenas utilizadores autorizados podem executar ações sensíveis."
Rewritten: "O sistema deve restringir o acesso às funções de validação apenas a utilizadores com permissões autorizadas."

4. Original: "O sistema deve acompanhar a atividade dos utilizadores."
Rewritten: "O sistema deve registar todas as ações relevantes dos utilizadores com data/hora e identificação do utilizador."

5. Original: "O sistema deve estar disponível quase sempre."
Rewritten: "O sistema deve garantir disponibilidade mínima de 99% durante o horário de suporte (08:00–20:00 em dias úteis)."

6. Original: "A aplicação mobile deve funcionar mesmo sem internet."
Rewritten: "O sistema deve armazenar ações realizadas offline e sincronizá-las automaticamente quando houver ligação à internet."
