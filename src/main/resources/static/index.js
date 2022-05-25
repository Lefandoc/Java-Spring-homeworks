angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:9082/app/api/v1';

    $scope.loadProducts = function (min, max, title) {
        // $http.get(contextPath + '/products')
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                min: min,
                max: max,
                title: title
            }
        }).then(function (response) {
            console.log(response.data);
            $scope.productList = response.data;
        });
    };

    $scope.changeCount = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_count',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.delete = function (productId) {
        $http({
            url: contextPath + '/products/delete',
            method: 'GET',
            params: {
                id: productId
            }
        }).then(function (response) {
            $scope.loadProducts($scope.min, $scope.max, $scope.title)
        });
    };

    $scope.fill = function () {
        $http({
            url: contextPath + '/products/fill_products',
            method: 'GET'
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.addProduct = function () {
        console.log($scope.newProduct);
        if (typeof $scope.newProduct.id instanceof "bigint") {
            console.log($scope.newProduct.id)
            console.log('pipipi')
        }
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts($scope.min, $scope.max, $scope.title)
            });
    }

    $scope.sortProducts = function (min, max) {
        $http({
            url: contextPath + '/products/get_btw',
            method: 'GET',
            params: {
                min: min,
                max: max
            }
        }).then(function (response) {
            $scope.loadProducts(min, max);
            console.log(response.data);
            // $scope.productList = response.data;
        });
    };

    $scope.loadProducts();

});