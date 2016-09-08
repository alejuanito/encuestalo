define(['backbone', 'model/LocalModel'], function (Backbone, LocalModel) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/local',
        model: LocalModel
    });
});
