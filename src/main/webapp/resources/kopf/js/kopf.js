var kopf = angular.module('kopf', ['ngRoute', 'ntt.TreeDnD', 'ngAnimate',
    'ui.bootstrap']);

kopf.config(function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.when('/cluster', {
        templateUrl: '/eser/resources/kopf/html/partials/cluster_overview.html',
        controller: 'ClusterOverviewController'
    }).when('/nodes', {
        templateUrl: '/eser/resources/kopf/html/partials/nodes/nodes.html',
        controller: 'NodesController'
    }).when('/rest', {
        templateUrl: '/eser/resources/kopf/html/partials/rest_client.html',
        controller: 'RestController'
    }).when('/query', {
        templateUrl: '/eser/resources/kopf/html/partials/query.html',
        controller: 'QueryController'
    }).when('/stats', {
        templateUrl: '/eser/resources/kopf/html/partials/stats.html',
        controller: 'StatsController'
    }).when('/newStats', {
        templateUrl: '/eser/resources/kopf/html/partials/new_stat.html',
        controller: 'NewStatsController'
    }).when('/slowlog', {
        templateUrl: '/eser/resources/kopf/html/partials/slowlog.html',
        controller: 'SlowLogController'
    }).when('/slowlogquery', {
        templateUrl: '/eser/resources/kopf/html/partials/slowlogquery.html',
        controller: 'SlowLogQueryController'
    }).when('/updateMapping', {
        templateUrl: '/eser/resources/kopf/html/partials/update_index_mapping.html',
        controller: 'UpdateMappingController'
    }).when('/createIndex', {
        templateUrl: '/eser/resources/kopf/html/partials/create_index.html',
        controller: 'CreateIndexController'
    }).when('/createType', {
        templateUrl: '/eser/resources/kopf/html/partials/create_type.html',
        controller: 'CreateTypeController'
    }).when('/importIndex', {
        templateUrl: '/eser/resources/kopf/html/partials/index_import.html',
        controller: 'ImportIndexController'
    }).when('/settingIndex', {
        templateUrl: '/eser/resources/kopf/html/partials/index_setting.html',
        controller: 'SettingIndexController'
    }).when('/indexManager', {
    templateUrl: '/eser/resources/kopf/html/partials/index_manager.html',
    controller: 'ManagerIndexController'
    }).when('/indexManagerNew', {
        templateUrl: '/eser/resources/kopf/html/partials/index_manager_new.html',
        controller: 'IndexManageController'
    }).when('/exportIndex', {
        templateUrl: '/eser/resources/kopf/html/partials/index_export.html',
        controller: 'ExportIndexController'
    }).when('/indexTemplate', {
    templateUrl: '/eser/resources/kopf/html/partials/index_templates.html',
        controller: 'IndexTemplatesController'
    }).when('/reindex', {
        templateUrl: '/eser/resources/kopf/html/partials/reindex.html',
        controller: 'ReIndexController'
    }).when('/analysis', {
        templateUrl: '/eser/resources/kopf/html/partials/analysis.html',
        controller: 'AnalysisController'
    }).when('/clientlogquery', {
        templateUrl: '/eser/resources/kopf/html/partials/clientlogquery.html',
        controller: 'ClientLogController'
    }).when('/aliasManager', {
        templateUrl: '/eser/resources/kopf/html/partials/alias_manager.html',
        controller: 'AliasController'
    }).otherwise({redirectTo: '/cluster'});
});

