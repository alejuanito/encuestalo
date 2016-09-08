 UPDATE ectd_encuesta_respuesta SET DE_RESPUESTA_CORTA = 'MALO' WHERE DE_RESPUESTA_CORTA='MALA';
             UPDATE ectd_encuesta_respuesta SET DE_RESPUESTA_CORTA = 'MUY MALO' WHERE DE_RESPUESTA_CORTA='MUY MALA';
             UPDATE ectd_encuesta_respuesta SET DE_RESPUESTA_CORTA = 'BUENO' WHERE DE_RESPUESTA_CORTA='BUENA';
             UPDATE ectd_encuesta_respuesta SET DE_RESPUESTA_CORTA = 'MUY BUENO' WHERE DE_RESPUESTA_CORTA='MUY BUENA';



             UPDATE ectd_plantilla_encuesta_respuesta SET DE_RESPUESTA = 'MALO' WHERE DE_RESPUESTA='MALA';
             UPDATE ectd_plantilla_encuesta_respuesta SET DE_RESPUESTA = 'MUY MALO' WHERE DE_RESPUESTA='MUY MALA';
             UPDATE ectd_plantilla_encuesta_respuesta SET DE_RESPUESTA = 'BUENO' WHERE DE_RESPUESTA='BUENA';
             UPDATE ectd_plantilla_encuesta_respuesta SET DE_RESPUESTA = 'MUY BUENO' WHERE DE_RESPUESTA='MUY BUENA';