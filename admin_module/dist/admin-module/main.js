(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/accommodationCategory/accommodationCategory.css":
/*!*****************************************************************!*\
  !*** ./src/app/accommodationCategory/accommodationCategory.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/accommodationCategory/accommodationCategory.html":
/*!******************************************************************!*\
  !*** ./src/app/accommodationCategory/accommodationCategory.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n    <div class=\"w3-panel w3-card-4 w3-padding w3-cyan\">\r\n        <div class=\"w3-xxlarge w3-text-white w3-center w3-myfont \"> Accommodation Category </div>\r\n    </div>\r\n    <app-menu></app-menu>\r\n        <div style=\"margin-left:20%;\">\r\n            <div class=\"w3-row\">\r\n                <a href=\"javascript:void(0)\" onclick=\"openTab(event, 'viewCategory');\">\r\n                    <div class=\"w3-third tablink w3-bottombar w3-hover-light-grey w3-padding\"><span class=\"fa fa-eye w3-text-cyan\"></span>&nbsp;&nbsp;View Accommodation Category</div>\r\n                </a>\r\n                <a href=\"javascript:void(0)\" onclick=\"openTab(event, 'addCategory');\">\r\n                    <div class=\"w3-third tablink w3-bottombar w3-hover-light-grey w3-padding\"><span class=\"fa fa-plus w3-text-cyan\"></span>&nbsp;&nbsp;Add Accommodation Category</div>\r\n                </a>\r\n            </div>\r\n       \r\n        <div id=\"viewCategory\" class=\"w3-container selectionTab\">\r\n            <h2>Current Accommodation Categories</h2>\r\n\r\n        </div>\r\n        <div id=\"addCategory\" class=\"w3-container selectionTab\" style=\"display:none\">\r\n            <h2>Add New Accommodation Category</h2>\r\n            <div class=\"w3-card-4\" style=\"width:50%;padding:5%;\">\r\n                <form class=\"w3-container\">\r\n                    <div class=\"w3-margin\">\r\n                        <label>Serial Id</label>\r\n                        <input class=\"w3-input\" type=\"text\">\r\n                    </div>\r\n                    <div class=\"w3-margin\">\r\n                        <label>Accommodation Category Name</label>\r\n                        <input class=\"w3-input\" type=\"text\">\r\n                    </div>\r\n                    <input type=\"submit\" class=\"w3-margin w3-btn w3-cyan w3-text-white\" value=\"Submit\" />\r\n                </form>\r\n            </div>\r\n        </div>\r\n         </div>\r\n</div>"

/***/ }),

/***/ "./src/app/accommodationCategory/accommodationCategory.ts":
/*!****************************************************************!*\
  !*** ./src/app/accommodationCategory/accommodationCategory.ts ***!
  \****************************************************************/
/*! exports provided: AccommodationCategoryComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AccommodationCategoryComponent", function() { return AccommodationCategoryComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AccommodationCategoryComponent = /** @class */ (function () {
    function AccommodationCategoryComponent() {
    }
    AccommodationCategoryComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-accommodationCategory',
            template: __webpack_require__(/*! ./accommodationCategory.html */ "./src/app/accommodationCategory/accommodationCategory.html"),
            styles: [__webpack_require__(/*! ./accommodationCategory.css */ "./src/app/accommodationCategory/accommodationCategory.css")]
        })
    ], AccommodationCategoryComponent);
    return AccommodationCategoryComponent;
}());



/***/ }),

/***/ "./src/app/accommodationType/accommodationType.css":
/*!*********************************************************!*\
  !*** ./src/app/accommodationType/accommodationType.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/accommodationType/accommodationType.html":
/*!**********************************************************!*\
  !*** ./src/app/accommodationType/accommodationType.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n    <div class=\"w3-panel w3-card-4 w3-padding w3-cyan\">\r\n        <div class=\"w3-xxlarge w3-text-white w3-center w3-myfont \"> Accommodation Type </div>\r\n    </div>\r\n    <app-menu></app-menu>\r\n        <div style=\"margin-left:20%;\">\r\n            <div class=\"w3-row\">\r\n                <a href=\"javascript:void(0)\" onclick=\"openTab(event, 'viewTypes');\">\r\n                    <div class=\"w3-third tablink w3-bottombar w3-hover-light-grey w3-padding\"><span class=\"fa fa-eye w3-text-cyan\"></span>&nbsp;&nbsp;View Accommodation Type</div>\r\n                </a>\r\n                <a href=\"javascript:void(0)\" onclick=\"openTab(event, 'addTypes');\">\r\n                    <div class=\"w3-third tablink w3-bottombar w3-hover-light-grey w3-padding\"><span class=\"fa fa-plus w3-text-cyan\"></span>&nbsp;&nbsp;Add Accommodation Type</div>\r\n                </a>\r\n            </div>\r\n        \r\n        <div id=\"viewTypes\" class=\"w3-container selectionTab\">\r\n            <h2>Current Accommodation Types</h2>\r\n\r\n        </div>\r\n        <div id=\"addTypes\" class=\"w3-container selectionTab\" style=\"display:none\">\r\n            <h2>Add New Accommodation Type</h2>\r\n            <div class=\"w3-card-4\" style=\"width:50%;padding:5%;\">\r\n                <form class=\"w3-container\" (ngSubmit)=\"save(accommodationType.value)\" #accommodationType=\"ngForm\">\r\n                    <div class=\"w3-margin\">\r\n                        <label>Serial Id</label>\r\n                        <input [(ngModel)]=\"accommodationType.id\" name=\"id\" #id=\"ngModel\" class=\"w3-input\" type=\"text\">\r\n                    </div>\r\n                    <div class=\"w3-margin\">\r\n                        <label>Accommodation Type Name</label>\r\n                        <input [(ngModel)]=\"accommodationType.accommodationTypeName\" name=\"accommodationTypeName\" #accommodationTypeName=\"ngModel\"  class=\"w3-input\" type=\"text\">\r\n                    </div>\r\n                    <input type=\"submit\" class=\"w3-margin w3-btn w3-cyan w3-text-white\" value=\"Submit\" />\r\n                </form>\r\n            </div>\r\n        </div>\r\n        </div>\r\n</div>"

/***/ }),

/***/ "./src/app/accommodationType/accommodationType.ts":
/*!********************************************************!*\
  !*** ./src/app/accommodationType/accommodationType.ts ***!
  \********************************************************/
/*! exports provided: AccommodationTypeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AccommodationTypeComponent", function() { return AccommodationTypeComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AccommodationTypeComponent = /** @class */ (function () {
    function AccommodationTypeComponent() {
    }
    AccommodationTypeComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-accommodationType',
            template: __webpack_require__(/*! ./accommodationType.html */ "./src/app/accommodationType/accommodationType.html"),
            styles: [__webpack_require__(/*! ./accommodationType.css */ "./src/app/accommodationType/accommodationType.css")]
        })
    ], AccommodationTypeComponent);
    return AccommodationTypeComponent;
}());



/***/ }),

/***/ "./src/app/additionalServices/additionalServices.css":
/*!***********************************************************!*\
  !*** ./src/app/additionalServices/additionalServices.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".w3-myfont {\r\n  font-family: \"Comic Sans MS\", cursive, sans-serif;\r\n   font-size: 20px;\r\n   font-weight: bold;\r\n}"

/***/ }),

/***/ "./src/app/additionalServices/additionalServices.html":
/*!************************************************************!*\
  !*** ./src/app/additionalServices/additionalServices.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <div class=\"w3-panel w3-card-4 w3-padding w3-cyan\">\r\n    <div class=\"w3-xxlarge w3-text-white w3-center w3-myfont \"> Additional Services </div>\r\n  </div>\r\n  <app-menu></app-menu>\r\n  <div style=\"margin-left:20%;\">\r\n    <div class=\"w3-row\">\r\n      <a href=\"javascript:void(0)\" onclick=\"openTab(event, 'viewService');\">\r\n        <div class=\"w3-third tablink w3-bottombar w3-hover-light-grey w3-padding\"><span class=\"fa fa-eye w3-text-cyan\"></span>&nbsp;&nbsp;View Services</div>\r\n      </a>\r\n      <a href=\"javascript:void(0)\" onclick=\"openTab(event, 'addService');\">\r\n        <div class=\"w3-third tablink w3-bottombar w3-hover-light-grey w3-padding\"><span class=\"fa fa-plus w3-text-cyan\"></span>&nbsp;&nbsp;Add Services</div>\r\n      </a>\r\n    </div>\r\n    <div id=\"viewService\" class=\"w3-container selectionTab\">\r\n      <h2>Current Additional Services</h2>\r\n<table class=\"table\">\r\n  <thead>\r\n    <tr class=\"w3-text-blue\">\r\n      <th>Service Id</th>\r\n      <th>Service Name</th>\r\n    </tr>\r\n  </thead>\r\n  <tbody>\r\n    <tr *ngFor=\"let row of result\">\r\n      <td>{{ row.id }}</td>\r\n      <td>{{ row.serviceName }}</td>\r\n    </tr>\r\n  </tbody>\r\n</table>\r\n    </div>\r\n\r\n    <div id=\"addService\" class=\"w3-container selectionTab\" style=\"display:none\">\r\n      <h2>Add New Service</h2>\r\n      <div class=\"w3-card-4\" style=\"width:50%;padding:5%;\">\r\n        <form class=\"w3-container\" (ngSubmit)=\"save(additionalServiceForm.value)\" #additionalServiceForm=\"ngForm\">\r\n          <div class=\"w3-margin\">\r\n            <label>Serial Id</label>\r\n            <input [(ngModel)]=\"additionalService.id\" name=\"id\" #id=\"ngModel\" class=\"w3-input\" type=\"text\">\r\n          </div>\r\n          <div class=\"w3-margin\">\r\n            <label>Service Name</label>\r\n            <input [(ngModel)]=\"additionalService.serviceName\" name=\"serviceName\" #serviceName=\"ngModel\" class=\"w3-input\" type=\"text\">\r\n          </div>\r\n          <input type=\"submit\" class=\"w3-margin w3-btn w3-cyan w3-text-white\" value=\"Submit\" />\r\n        </form>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/additionalServices/additionalServices.ts":
/*!**********************************************************!*\
  !*** ./src/app/additionalServices/additionalServices.ts ***!
  \**********************************************************/
/*! exports provided: AdditionalServicesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AdditionalServicesComponent", function() { return AdditionalServicesComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _models_additionalService__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../models/additionalService */ "./src/app/models/additionalService.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AdditionalServicesComponent = /** @class */ (function () {
    function AdditionalServicesComponent(http, router) {
        this.http = http;
        this.router = router;
        this.headers = new _angular_http__WEBPACK_IMPORTED_MODULE_1__["Headers"]();
        this.additionalService = new _models_additionalService__WEBPACK_IMPORTED_MODULE_3__["additionalService"]();
        this.headers.set('Content-Type', 'application/json');
        this.headers.set('Access-Control-Allow-Origin', '*');
        this.options = new _angular_http__WEBPACK_IMPORTED_MODULE_1__["RequestOptions"]({ headers: this.headers });
        this.http.get('http://localhost:8080/admin/viewAllAdditionalServices')
            .subscribe(function (json) {
            console.log(json);
        });
    }
    AdditionalServicesComponent.prototype.save = function (data) {
        this.http.post('http://localhost:8080/admin/addNewAdditionalService', JSON.stringify(data), this.options)
            .subscribe(function (json) {
            console.log(json);
        }, function (err) { console.error(err); });
    };
    AdditionalServicesComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-additionalServices',
            template: __webpack_require__(/*! ./additionalServices.html */ "./src/app/additionalServices/additionalServices.html"),
            styles: [__webpack_require__(/*! ./additionalServices.css */ "./src/app/additionalServices/additionalServices.css")]
        }),
        __metadata("design:paramtypes", [_angular_http__WEBPACK_IMPORTED_MODULE_1__["Http"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], AdditionalServicesComponent);
    return AdditionalServicesComponent;
}());



/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _welcome_welcome__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./welcome/welcome */ "./src/app/welcome/welcome.ts");
/* harmony import */ var _home_home__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./home/home */ "./src/app/home/home.ts");
/* harmony import */ var _accommodationType_accommodationType__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./accommodationType/accommodationType */ "./src/app/accommodationType/accommodationType.ts");
/* harmony import */ var _accommodationCategory_accommodationCategory__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./accommodationCategory/accommodationCategory */ "./src/app/accommodationCategory/accommodationCategory.ts");
/* harmony import */ var _ordinaryUsers_ordinaryUsers__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./ordinaryUsers/ordinaryUsers */ "./src/app/ordinaryUsers/ordinaryUsers.ts");
/* harmony import */ var _businessUsers_businessUsers__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./businessUsers/businessUsers */ "./src/app/businessUsers/businessUsers.ts");
/* harmony import */ var _comments_comments__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./comments/comments */ "./src/app/comments/comments.ts");
/* harmony import */ var _additionalServices_additionalServices__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./additionalServices/additionalServices */ "./src/app/additionalServices/additionalServices.ts");
/* harmony import */ var _certificates_certificates__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./certificates/certificates */ "./src/app/certificates/certificates.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var routes = [
    { path: 'admin/welcome', component: _welcome_welcome__WEBPACK_IMPORTED_MODULE_2__["WelcomeComponent"] },
    { path: 'admin/home', component: _home_home__WEBPACK_IMPORTED_MODULE_3__["HomeComponent"] },
    { path: 'admin/accommodationType', component: _accommodationType_accommodationType__WEBPACK_IMPORTED_MODULE_4__["AccommodationTypeComponent"] },
    { path: 'admin/accommodationCategory', component: _accommodationCategory_accommodationCategory__WEBPACK_IMPORTED_MODULE_5__["AccommodationCategoryComponent"] },
    { path: 'admin/ordinaryUsers', component: _ordinaryUsers_ordinaryUsers__WEBPACK_IMPORTED_MODULE_6__["OrdinaryUsersComponent"] },
    { path: 'admin/businessUsers', component: _businessUsers_businessUsers__WEBPACK_IMPORTED_MODULE_7__["BusinessUsersComponent"] },
    { path: 'admin/comments', component: _comments_comments__WEBPACK_IMPORTED_MODULE_8__["CommentsComponent"] },
    { path: 'admin/additionalServices', component: _additionalServices_additionalServices__WEBPACK_IMPORTED_MODULE_9__["AdditionalServicesComponent"] },
    { path: 'admin/certificates', component: _certificates_certificates__WEBPACK_IMPORTED_MODULE_10__["CertificatesComponent"] },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
            declarations: []
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! .//app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _welcome_welcome__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./welcome/welcome */ "./src/app/welcome/welcome.ts");
/* harmony import */ var _home_home__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./home/home */ "./src/app/home/home.ts");
/* harmony import */ var _menu_menu__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./menu/menu */ "./src/app/menu/menu.ts");
/* harmony import */ var _accommodationType_accommodationType__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./accommodationType/accommodationType */ "./src/app/accommodationType/accommodationType.ts");
/* harmony import */ var _accommodationCategory_accommodationCategory__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./accommodationCategory/accommodationCategory */ "./src/app/accommodationCategory/accommodationCategory.ts");
/* harmony import */ var _ordinaryUsers_ordinaryUsers__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./ordinaryUsers/ordinaryUsers */ "./src/app/ordinaryUsers/ordinaryUsers.ts");
/* harmony import */ var _businessUsers_businessUsers__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./businessUsers/businessUsers */ "./src/app/businessUsers/businessUsers.ts");
/* harmony import */ var _comments_comments__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./comments/comments */ "./src/app/comments/comments.ts");
/* harmony import */ var _additionalServices_additionalServices__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./additionalServices/additionalServices */ "./src/app/additionalServices/additionalServices.ts");
/* harmony import */ var _certificates_certificates__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./certificates/certificates */ "./src/app/certificates/certificates.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"],
                _welcome_welcome__WEBPACK_IMPORTED_MODULE_6__["WelcomeComponent"],
                _home_home__WEBPACK_IMPORTED_MODULE_7__["HomeComponent"],
                _menu_menu__WEBPACK_IMPORTED_MODULE_8__["MenuComponent"],
                _accommodationType_accommodationType__WEBPACK_IMPORTED_MODULE_9__["AccommodationTypeComponent"],
                _accommodationCategory_accommodationCategory__WEBPACK_IMPORTED_MODULE_10__["AccommodationCategoryComponent"],
                _ordinaryUsers_ordinaryUsers__WEBPACK_IMPORTED_MODULE_11__["OrdinaryUsersComponent"],
                _businessUsers_businessUsers__WEBPACK_IMPORTED_MODULE_12__["BusinessUsersComponent"],
                _comments_comments__WEBPACK_IMPORTED_MODULE_13__["CommentsComponent"],
                _additionalServices_additionalServices__WEBPACK_IMPORTED_MODULE_14__["AdditionalServicesComponent"],
                _certificates_certificates__WEBPACK_IMPORTED_MODULE_15__["CertificatesComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_3__["HttpModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_3__["JsonpModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_5__["AppRoutingModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/businessUsers/businessUsers.css":
/*!*************************************************!*\
  !*** ./src/app/businessUsers/businessUsers.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/businessUsers/businessUsers.html":
/*!**************************************************!*\
  !*** ./src/app/businessUsers/businessUsers.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/businessUsers/businessUsers.ts":
/*!************************************************!*\
  !*** ./src/app/businessUsers/businessUsers.ts ***!
  \************************************************/
/*! exports provided: BusinessUsersComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BusinessUsersComponent", function() { return BusinessUsersComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var BusinessUsersComponent = /** @class */ (function () {
    function BusinessUsersComponent() {
    }
    BusinessUsersComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-businessUsers',
            template: __webpack_require__(/*! ./businessUsers.html */ "./src/app/businessUsers/businessUsers.html"),
            styles: [__webpack_require__(/*! ./businessUsers.css */ "./src/app/businessUsers/businessUsers.css")]
        })
    ], BusinessUsersComponent);
    return BusinessUsersComponent;
}());



/***/ }),

/***/ "./src/app/certificates/certificates.css":
/*!***********************************************!*\
  !*** ./src/app/certificates/certificates.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/certificates/certificates.html":
/*!************************************************!*\
  !*** ./src/app/certificates/certificates.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/certificates/certificates.ts":
/*!**********************************************!*\
  !*** ./src/app/certificates/certificates.ts ***!
  \**********************************************/
/*! exports provided: CertificatesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CertificatesComponent", function() { return CertificatesComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var CertificatesComponent = /** @class */ (function () {
    function CertificatesComponent() {
    }
    CertificatesComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-certificates',
            template: __webpack_require__(/*! ./certificates.html */ "./src/app/certificates/certificates.html"),
            styles: [__webpack_require__(/*! ./certificates.css */ "./src/app/certificates/certificates.css")]
        })
    ], CertificatesComponent);
    return CertificatesComponent;
}());



/***/ }),

/***/ "./src/app/comments/comments.css":
/*!***************************************!*\
  !*** ./src/app/comments/comments.css ***!
  \***************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/comments/comments.html":
/*!****************************************!*\
  !*** ./src/app/comments/comments.html ***!
  \****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n    <div class=\"w3-panel w3-card-4 w3-padding w3-cyan\">\r\n        <div class=\"w3-xxlarge w3-text-white w3-center w3-myfont \"> Comments </div>\r\n    </div>\r\n    <app-menu></app-menu>\r\n    <div style=\"margin-left:20%;\">\r\n        <div class=\"w3-row\">\r\n            <div class=\"w3-third tablink w3-bottombar w3-hover-light-grey w3-padding\"><span class=\"fa fa-eye w3-text-cyan\"></span>&nbsp;&nbsp;Manage Comments</div>\r\n        </div>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/comments/comments.ts":
/*!**************************************!*\
  !*** ./src/app/comments/comments.ts ***!
  \**************************************/
/*! exports provided: CommentsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentsComponent", function() { return CommentsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var CommentsComponent = /** @class */ (function () {
    function CommentsComponent() {
    }
    CommentsComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-comments',
            template: __webpack_require__(/*! ./comments.html */ "./src/app/comments/comments.html"),
            styles: [__webpack_require__(/*! ./comments.css */ "./src/app/comments/comments.css")]
        })
    ], CommentsComponent);
    return CommentsComponent;
}());



/***/ }),

/***/ "./src/app/home/home.css":
/*!*******************************!*\
  !*** ./src/app/home/home.css ***!
  \*******************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".w3-myfont {\r\n  font-family: \"Comic Sans MS\", cursive, sans-serif;\r\n   font-size: 20px;\r\n   font-weight: bold;\r\n}\r\n\r\n"

/***/ }),

/***/ "./src/app/home/home.html":
/*!********************************!*\
  !*** ./src/app/home/home.html ***!
  \********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n    <div class=\"w3-panel w3-card-4 w3-padding w3-cyan\">\r\n        <div class=\"w3-xxlarge w3-text-white w3-center w3-myfont \"> Admin Options </div>\r\n    </div>\r\n    <app-menu></app-menu>\r\n\r\n    <div class=\"w3-display-middle w3-margin\">\r\n        <h2 class=\"w3-margin\">Avaliable Functions</h2>\r\n        <ul class=\"list-group\">\r\n            <li class=\"list-group-item w3-myfont\">Manage Accommodation Types(Add/View)</li>\r\n            <li class=\"list-group-item w3-myfont\">Manage Your Accommodation Categories(Add/View)</li>\r\n            <li class=\"list-group-item w3-myfont\">Publish Comments(Reject/Approve/View)</li>\r\n            <li class=\"list-group-item w3-myfont\">Business Users(Add/Block/Activate/Remove/View)</li>\r\n            <li class=\"list-group-item w3-myfont\">Ordinary Users(Add/Block/Activate/Remove/View)</li>\r\n            <li class=\"list-group-item w3-myfont\">Additional Services(View/Add)</li>\r\n            <li class=\"list-group-item w3-myfont\">Certificates(Issue/Revoke/Remove/View)</li>\r\n        </ul>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/home/home.ts":
/*!******************************!*\
  !*** ./src/app/home/home.ts ***!
  \******************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var HomeComponent = /** @class */ (function () {
    function HomeComponent() {
    }
    HomeComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.html */ "./src/app/home/home.html"),
            styles: [__webpack_require__(/*! ./home.css */ "./src/app/home/home.css")]
        })
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/menu/menu.css":
/*!*******************************!*\
  !*** ./src/app/menu/menu.css ***!
  \*******************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".w3-myfont {\r\n  font-family: \"Comic Sans MS\", cursive, sans-serif;\r\n   font-size: 30px;\r\n   font-weight: bold;\r\n}\r\n.w3-menufont {\r\n  font-family: \"Comic Sans MS\", cursive, sans-serif;\r\n   font-size: 20px;\r\n   font-weight: bold;\r\n   color: white !important;\r\n}"

/***/ }),

/***/ "./src/app/menu/menu.html":
/*!********************************!*\
  !*** ./src/app/menu/menu.html ***!
  \********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <div class=\"w3-sidebar w3-bar-block w3-cyan w3-card-4\" style=\"width:18%;\">\r\n    <a href=\"./admin/home\" class=\"w3-bar-item w3-button w3-cyan w3-menufont\">Home</a>\r\n    <a href=\"./admin/accommodationType\" class=\"w3-bar-item w3-button w3-cyan w3-menufont\">Accomodation Type</a>\r\n    <a href=\"./admin/accommodationCategory\" class=\"w3-bar-item w3-button w3-cyan  w3-menufont\">Accomodation Category</a>\r\n    <a href=\"./admin/comments\" class=\"w3-bar-item w3-button w3-cyan  w3-menufont\">Publish Comment</a>\r\n    <a href=\"./admin/ordinaryUsers\" class=\"w3-bar-item w3-button w3-cyan  w3-menufont\">Business Users</a>\r\n    <a href=\"./admin/businessUsers\" class=\"w3-bar-item w3-button w3-cyan  w3-menufont\">Ordinary Users</a>\r\n    <a href=\"./admin/additionalServices\" class=\"w3-bar-item w3-button w3-cyan  w3-menufont\">Additional Services</a>\r\n    <a href=\"./admin/certificates\" class=\"w3-bar-item w3-button w3-cyan  w3-menufont\">Certificates</a>\r\n    <a href=\"#\" class=\"w3-bar-item w3-button w3-cyan  w3-menufont\">Log Out</a>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/menu/menu.ts":
/*!******************************!*\
  !*** ./src/app/menu/menu.ts ***!
  \******************************/
/*! exports provided: MenuComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MenuComponent", function() { return MenuComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var MenuComponent = /** @class */ (function () {
    function MenuComponent() {
    }
    MenuComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-menu',
            template: __webpack_require__(/*! ./menu.html */ "./src/app/menu/menu.html"),
            styles: [__webpack_require__(/*! ./menu.css */ "./src/app/menu/menu.css")]
        })
    ], MenuComponent);
    return MenuComponent;
}());



/***/ }),

/***/ "./src/app/models/additionalService.ts":
/*!*********************************************!*\
  !*** ./src/app/models/additionalService.ts ***!
  \*********************************************/
/*! exports provided: additionalService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "additionalService", function() { return additionalService; });
var additionalService = /** @class */ (function () {
    function additionalService() {
        this.id = '';
        this.serviceName = '';
    }
    additionalService.prototype.fromJSON = function (json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    };
    return additionalService;
}());



/***/ }),

/***/ "./src/app/ordinaryUsers/ordinaryUsers.css":
/*!*************************************************!*\
  !*** ./src/app/ordinaryUsers/ordinaryUsers.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/ordinaryUsers/ordinaryUsers.html":
/*!**************************************************!*\
  !*** ./src/app/ordinaryUsers/ordinaryUsers.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/ordinaryUsers/ordinaryUsers.ts":
/*!************************************************!*\
  !*** ./src/app/ordinaryUsers/ordinaryUsers.ts ***!
  \************************************************/
/*! exports provided: OrdinaryUsersComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrdinaryUsersComponent", function() { return OrdinaryUsersComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var OrdinaryUsersComponent = /** @class */ (function () {
    function OrdinaryUsersComponent() {
    }
    OrdinaryUsersComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-ordinaryUsers',
            template: __webpack_require__(/*! ./ordinaryUsers.html */ "./src/app/ordinaryUsers/ordinaryUsers.html"),
            styles: [__webpack_require__(/*! ./ordinaryUsers.css */ "./src/app/ordinaryUsers/ordinaryUsers.css")]
        })
    ], OrdinaryUsersComponent);
    return OrdinaryUsersComponent;
}());



/***/ }),

/***/ "./src/app/welcome/welcome.css":
/*!*************************************!*\
  !*** ./src/app/welcome/welcome.css ***!
  \*************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/welcome/welcome.html":
/*!**************************************!*\
  !*** ./src/app/welcome/welcome.html ***!
  \**************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <div class=\"w3-container w3-white w3-text-cyan w3-border w3-round-xlarge w3-margin w3-border-cyan\">\r\n    <h1 class=\"w3-center\">\r\n      Welcome To {{ title }}\r\n    </h1>\r\n  </div>\r\n  <div class=\"w3-card-4 w3-margin-top w3-display-middle\" style=\"width:50%;\">\r\n    <header class=\"w3-container w3-cyan w3-text-white\">\r\n      <h3>Log In</h3>\r\n    </header>\r\n    <form class=\"w3-container  w3-margin\">\r\n      <div class=\"w3-row w3-section \">\r\n        <div class=\"w3-col  w3-margin\" style=\"width:50px\"><i class=\"w3-xxlarge fa fa-user w3-text-cyan\"></i></div>\r\n        <div class=\"w3-rest  w3-margin\">\r\n          <input class=\"w3-input \" name=\"first\" type=\"text\" placeholder=\"Username\">\r\n        </div>\r\n\r\n        <div class=\"w3-col  w3-margin\" style=\"width:50px\"><i class=\"w3-xxlarge fa fa-pencil w3-text-cyan\"></i></div>\r\n        <div class=\"w3-rest  w3-margin\">\r\n          <input class=\"w3-input \" name=\"first\" type=\"password\" placeholder=\"Password\">\r\n        </div>\r\n      </div>\r\n    </form>\r\n    <footer class=\"w3-container w3-cyan\">\r\n      <button class=\"w3-button w3-white w3-padding w3-section\">Submit</button>\r\n    </footer>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/welcome/welcome.ts":
/*!************************************!*\
  !*** ./src/app/welcome/welcome.ts ***!
  \************************************/
/*! exports provided: WelcomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WelcomeComponent", function() { return WelcomeComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var WelcomeComponent = /** @class */ (function () {
    function WelcomeComponent() {
    }
    WelcomeComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-welcome',
            template: __webpack_require__(/*! ./welcome.html */ "./src/app/welcome/welcome.html"),
            styles: [__webpack_require__(/*! ./welcome.css */ "./src/app/welcome/welcome.css")]
        })
    ], WelcomeComponent);
    return WelcomeComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Users\Ronit\Desktop\student_modules\admin-module\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map