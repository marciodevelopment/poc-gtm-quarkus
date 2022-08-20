create table GTMAGNAgencia (
         Cod_Pessoa int not null,
        Cod_Banco int,
        Cod_Agencia int,
        Ind_Sit_Agencia_Retorno_X varchar(255),                 
       Flg_Agencia_Centralizadora bit,
        primary key (Cod_Pessoa)
    );
    
    alter table GTMAGNAgencia 
       add constraint FKibjjo9t20fr6w8a2w7rp2t8gm 
       foreign key (Cod_Pessoa) 
       references GTMPESPessoa;


    
    alter table GTMAGNAgencia 
       add constraint FKsnv72s4m2uokcon26tyy3oqh7 
       foreign key (Cod_Banco) 
       references GtmBanBanco;