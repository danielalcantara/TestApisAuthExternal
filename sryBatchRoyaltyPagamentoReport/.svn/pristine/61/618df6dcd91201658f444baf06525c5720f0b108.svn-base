create table RY020T_CTO_RTY_EML
(
  NI_CTO_RTY           NUMBER(10) not null,
  DT_FIM_VIG_CTO       DATE,
  DT_ENV_EML           DATE
  );

comment on table RY020T_CTO_RTY_EML
  is 'Entidade que controla o envio de e-mail pelo BATCH sryBatchAvisarContratosAVencer para impedir que um mesmo e-mail 
  seja enviado mais de uma vez';
  
  
alter table RY020T_CTO_RTY_EML
  add constraint RY020I primary key (NI_CTO_RTY, DT_FIM_VIG_CTO);