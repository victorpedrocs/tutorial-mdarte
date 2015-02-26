
    alter table ESTUDANTE 
        drop constraint FKC_ESTUDANTE_CURSO;

    drop table CURSO cascade;

    drop table ESTUDANTE cascade;

    drop sequence CURSO_SEQ;

    drop sequence ESTUDANTE_SEQ;

    create table CURSO (
        ID BIGINT not null,
        HIBERNATE_VERSION int4 default 0 not null,
        CODIGO CHARACTER VARYING(1024) not null unique,
        NOME CHARACTER VARYING(1024) not null,
        primary key (ID)
    );

    create table ESTUDANTE (
        ID BIGINT not null,
        HIBERNATE_VERSION int4 default 0 not null,
        MATRICULA CHARACTER VARYING(1024) not null unique,
        NOME CHARACTER VARYING(1024) not null,
        CURSO_FK BIGINT not null,
        primary key (ID)
    );

    create index IND_ESTUDANTE_CURSO_FK on ESTUDANTE (CURSO_FK);

    alter table ESTUDANTE 
        add constraint FKC_ESTUDANTE_CURSO 
        foreign key (CURSO_FK) 
        references CURSO;

    create sequence CURSO_SEQ;

    create sequence ESTUDANTE_SEQ;
