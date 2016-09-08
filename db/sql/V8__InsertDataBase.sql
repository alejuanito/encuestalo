update ectm_colaborador set id_local = 1;

insert into ectc_plantilla_encuesta (id_empresa, de_encuesta_largo,
 de_encuesta_corto, co_tipo_encuesta) values (1,'ENCUESTA DE ATENCIÓN','ENCUESTA','ATEN');

insert into ectd_plantilla_encuesta (id_plantilla_encuesta, nu_orden,
 de_pregunta, in_es_rpta_corta, es_plantilla_encuesta_detalle,co_tipo_pregunta)
  values (1,1,'¿ME SIRVIERON RÁPIDAMENTE?',true,'A','CERR');

  insert into ectd_plantilla_encuesta (id_plantilla_encuesta, nu_orden,
 de_pregunta, in_es_rpta_corta, es_plantilla_encuesta_detalle,co_tipo_pregunta)
  values (1,1,'¿COMO CALIFICA LA CALIDAD DE LOS PRODUCTOS?',true,'A','CERR');

  insert into ectd_plantilla_encuesta (id_plantilla_encuesta, nu_orden,
 de_pregunta, in_es_rpta_corta, es_plantilla_encuesta_detalle,co_tipo_pregunta)
  values (1,1,'¿COMO CALIFICA LA ATENCIÓN DEL MOZO?',true,'A','CERR');

  insert into ectd_plantilla_encuesta (id_plantilla_encuesta, nu_orden,
 de_pregunta, in_es_rpta_corta, es_plantilla_encuesta_detalle,co_tipo_pregunta)
  values (1,1,'¿QUÉ ES LO QUE MAS LE GUSTA DE EL PIONBINO?',false,'A','ABIE');
  
    insert into ectd_plantilla_encuesta (id_plantilla_encuesta, nu_orden,
 de_pregunta, in_es_rpta_corta, es_plantilla_encuesta_detalle,co_tipo_pregunta)
  values (1,1,'¿QUÉ ES LO QUE NO LE GUSTÓ HOY?',false,'A','ABIE');
  
    insert into ectd_plantilla_encuesta (id_plantilla_encuesta, nu_orden,
 de_pregunta, in_es_rpta_corta, es_plantilla_encuesta_detalle,co_tipo_pregunta)
  values (1,1,'¿QUÉ ES LO QUE LE GUSTARÍA QUE IMPLEMENTEMOS?',false,'A','ABIE');

insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MUY MALA',1,1,'muymalo.png');

  insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MALA',2,1,'malo.png');

  insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('REGULAR',3,1,'regular.png');

    insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('BUENO',4,1,'bueno.png');

    insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MUY BUENO',5,1,'muybueno.png');

insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MUY MALA',1,2,'muymalo.png');

  insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MALA',2,2,'malo.png');

  insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('REGULAR',3,2,'regular.png');

    insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('BUENO',4,2,'bueno.png');

    insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MUY BUENO',5,2,'muybueno.png');

insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MUY MALA',1,3,'muymalo.png');

  insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MALA',2,3,'malo.png');

  insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('REGULAR',3,3,'regular.png');

    insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('BUENO',4,3,'bueno.png');

    insert into ectd_plantilla_encuesta_respuesta (de_respuesta, nu_orden,
 id_plantilla_encuesta_detalle, no_img)
  values ('MUY BUENO',5,3,'muybueno.png');

