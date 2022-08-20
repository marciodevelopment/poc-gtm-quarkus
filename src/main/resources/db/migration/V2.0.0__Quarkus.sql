     create table GTMPEJPessoa_Juridica (
       Cod_Pessoa int not null,
        primary key (Cod_Pessoa)
    );


insert into GTMPEJPessoa_Juridica values (1);
insert into GTMPEJPessoa_Juridica values (2);
insert into GTMPEJPessoa_Juridica values (3);
insert into GTMPEJPessoa_Juridica values (4);
insert into GTMPEJPessoa_Juridica values (5);
insert into GTMPEJPessoa_Juridica values (6);
insert into GTMPEJPessoa_Juridica values (7);
insert into GTMPEJPessoa_Juridica values (8);
insert into GTMPEJPessoa_Juridica values (9);
insert into GTMPEJPessoa_Juridica values (10);
insert into GTMPEJPessoa_Juridica values (11);
insert into GTMPEJPessoa_Juridica values (13);

    
    create table GTMPESPessoa (
       Cod_Pessoa int not null,
        Nme_Pessoa varchar(255),
        Ind_tipo_pessoa varchar(255),
        primary key (Cod_Pessoa)
    );

insert into GTMPESPessoa values (1,'INOVARE', '2');
insert into GTMPESPessoa values (2, 'VITA SONHO', '2');
insert into GTMPESPessoa values (3, 'BELO CENARIO', '2');
insert into GTMPESPessoa values (4, 'CULTURAL STORE', '2');
insert into GTMPESPessoa values (5, 'UNIVERSO MAGICO', '2');
insert into GTMPESPessoa values (6, 'ESTOFARIA SAO PEDRO', '2');
insert into GTMPESPessoa values (7, 'ACOUGUE SAO JOAO', '2');
insert into GTMPESPessoa values (8, 'FARMACIA CURITIBA', '2');
insert into GTMPESPessoa values (9, 'MERCADO DO PAULO', '2');
insert into GTMPESPessoa values (10, 'PADARIA PAO QUENTE', '2');
insert into GTMPESPessoa values (11, 'PET SHOP SAO BERNARDO', '2');
insert into GTMPESPessoa values (12, 'CLUBE DE TIRO PROIBIDO', '2');
insert into GTMPESPessoa values (13, 'ESCOLA PRIMARIA', '1');
