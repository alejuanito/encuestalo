define(['app', 'backbone', 
    'collection/LocalCollection',
    'view/ReporteSatisfaccionListView', 'controller/IndexController'], function (app, Backbone, 
LocalCollection,    
ReporteSatisfaccionListView, IndexController) {
	return {
		showReporteSatisfaccionList : function() {
			var view, me;
			me = this;
                        var localCollection = new LocalCollection;
                        localCollection.fetch({
                            success: function () {
                                
                           				
                                
                                view = new ReporteSatisfaccionListView({
                                    model: new Backbone.Model,
                                    localCollection: localCollection
                                    
                                });
                                app.rootView.showChildView('main', view);
                                view.on('goto:inicio', function() {
                                        IndexController.index();
                                        Backbone.history.navigate('')
                                });    
                        
                                
                                                    
                        }});
			
		}
	}
});
