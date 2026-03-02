Contexto da Entrevista:

Suposições:

- A versão mobile manterá as funcionalidades essenciais da versão web.
- A validação institucional continuará obrigatória para beneficiários.
- O sistema continuará a operar com múltiplos perfis de utilizador com permissões distintas.
- A conformidade com GDPR aplica-se integralmente à versão mobile.
- O suporte AMS será responsável pela continuidade operacional após implementação.

Questões em Aberto:

- Qual o período exato de retenção legal dos dados pessoais?
- Que métricas específicas definem desempenho aceitável em mobile?
- Qual o nível mínimo aceitável de disponibilidade do sistema (SLA)?
- Como será implementado o plano formal de Disaster Recovery?
- Que integrações externas exigem monitorização automática contínua?
- Quem aprova formalmente políticas de auditoria e acesso?

Perguntas e Respostas:

1. Que tipos de utilizadores precisam de acesso ao sistema?
Resposta: Doadores, beneficiários, administradores, instituições parceiras e equipa de suporte técnico.

2. [Variante] É necessário manter registo completo das ações realizadas pelos utilizadores (trilha de auditoria)?
Resposta: Sim. Todas as alterações relevantes devem ser registadas, incluindo criação de registos, validações, alterações de estado e acessos administrativos.

3. [Variante] Existem requisitos específicos de retenção de dados pessoais para conformidade com o GDPR?
Resposta: Sim. Dados pessoais devem poder ser eliminados mediante pedido e não devem ser mantidos além do período necessário para a finalidade da plataforma.

4. [Variante] Existem metas de desempenho para a aplicação mobile?
Resposta: Sim. O carregamento das principais funcionalidades deve ocorrer em poucos segundos, mesmo em redes móveis instáveis.

5. O sistema depende de integrações externas críticas?
Resposta: Sim. Integração com sistemas institucionais para validação de beneficiários e envio de notificações.

6. [Evidência] Que provas demonstram que os processos atuais de validação de beneficiários são fiáveis?
Resposta: Registos administrativos mantidos pela instituição parceira e relatórios periódicos de validação manual.

7. [Evidência] Quão recente deve ser a informação sobre o estado dos bens doados?
Resposta: Deve refletir o estado quase em tempo real, com atualizações visíveis imediatamente após alterações.

8. [Evidência] Quem é o responsável pela manutenção e verificação dos registos de auditoria?
Resposta: A equipa administrativa da instituição parceira, com supervisão técnica da equipa de suporte L3.

9. Existem requisitos de disponibilidade mínima do sistema?
Resposta: O sistema deve estar disponível durante toda a janela de serviço e suportar picos de utilização em campanhas sazonais.

10. O que acontece se o sistema falhar durante o processo de entrega de um bem?
Resposta: O estado da transação deve ser preservado e recuperável, evitando perda de informação ou inconsistência.

11. Existem restrições sobre quem pode validar beneficiários?
Resposta: Apenas entidades autorizadas com permissões específicas podem validar ou alterar o estado de elegibilidade.

12. O sistema precisa suportar utilização offline em dispositivos móveis?
Resposta: Idealmente sim, pelo menos para consulta de dados recentes e registo temporário de ações a sincronizar depois.
