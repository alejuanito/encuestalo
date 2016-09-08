define(['marionette'], function (Marionette) {
    return Marionette.AppRouter.extend({
        appRoutes: {
            'usuarios/': 'showUsuarioList',
            'usuarios/edit/:id': 'showEditUserForm',
            'usuarios/new/': 'showNewUserForm',
            'usuarios/password/:id': 'showChangeUserPasswordForm',
            
            
            'roles/': 'showRolList',
            'roles/new/': 'showNewRolForm',
            'roles/edit/:id': 'showEditRolForm'
        }
    });
});