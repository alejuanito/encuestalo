define(['router/AdminBaseRouter'], function(AdminBaseRouter) {
    return AdminBaseRouter.extend({
        appRoutes: {
//        	'': 'showWelcome',
        	'': 'showConfiguracionAtencion',
        	'configuracion-atencion': 'showConfiguracionAtencion',
         //   'atencion-encuesta': 'showAtencionEncuesta',
            'pregunta-encuesta': 'showPreguntaEncuesta',
            'datos-encuestado': 'showDatosEncuestado',
//            'controlperiodos/facturacion': 'showFacturacionView',
//            'controlperiodos/planilla': 'showPlanillaView',
//            'controlperiodos/newperiodo':'showNewPeriodo',
//            'controlperiodos/edit': 'showEditPeriodo',
           
        }
    });
});