
    alter table ESTUDANTE 
        drop constraint FKC_ESTUDANTE_CURSO;

    drop table CURSO cascade;

    drop table ESTUDANTE cascade;

    drop sequence CURSO_SEQ;

    drop sequence ESTUDANTE_SEQ;
