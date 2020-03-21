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
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var routes = [];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
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

module.exports = "@media (max-width: 800px) {\r\n  .jumbotron {\r\n    padding: 0;\r\n    margin-bottom: 0;\r\n  }\r\n\r\n  .display-4 {\r\n    font-size: 17px;\r\n    font-weight: bolder;\r\n    color: #2C3446;\r\n  }\r\n\r\n  .lead {\r\n    font-size: 14px\r\n  }\r\n\r\n  #bestPriceOffer {\r\n    position: relative;\r\n    float: right;\r\n    margin-top: 10px;\r\n    max-width: 35px;\r\n    max-height: 35px;\r\n    border-radius: 35px;\r\n    display: none;\r\n  }\r\n}\r\n\r\n.logo {\r\n  position: relative;\r\n  max-width: 75px;\r\n  max-height: 75px;\r\n  border-radius: 35px;\r\n}\r\n\r\n#bestPriceOffer{\r\n  font-style: italic;\r\n  font-size: 11px;\r\n  float: right;\r\n  text-align: center;\r\n}\r\n\r\n.best-price {\r\n  color: brown;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRTtJQUNFLFdBQVc7SUFDWCxpQkFBaUI7R0FDbEI7O0VBRUQ7SUFDRSxnQkFBZ0I7SUFDaEIsb0JBQW9CO0lBQ3BCLGVBQWU7R0FDaEI7O0VBRUQ7SUFDRSxlQUFlO0dBQ2hCOztFQUVEO0lBQ0UsbUJBQW1CO0lBQ25CLGFBQWE7SUFDYixpQkFBaUI7SUFDakIsZ0JBQWdCO0lBQ2hCLGlCQUFpQjtJQUNqQixvQkFBb0I7SUFDcEIsY0FBYztHQUNmO0NBQ0Y7O0FBRUQ7RUFDRSxtQkFBbUI7RUFDbkIsZ0JBQWdCO0VBQ2hCLGlCQUFpQjtFQUNqQixvQkFBb0I7Q0FDckI7O0FBRUQ7RUFDRSxtQkFBbUI7RUFDbkIsZ0JBQWdCO0VBQ2hCLGFBQWE7RUFDYixtQkFBbUI7Q0FDcEI7O0FBRUQ7RUFDRSxhQUFhO0NBQ2QiLCJmaWxlIjoic3JjL2FwcC9hcHAuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIkBtZWRpYSAobWF4LXdpZHRoOiA4MDBweCkge1xyXG4gIC5qdW1ib3Ryb24ge1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIG1hcmdpbi1ib3R0b206IDA7XHJcbiAgfVxyXG5cclxuICAuZGlzcGxheS00IHtcclxuICAgIGZvbnQtc2l6ZTogMTdweDtcclxuICAgIGZvbnQtd2VpZ2h0OiBib2xkZXI7XHJcbiAgICBjb2xvcjogIzJDMzQ0NjtcclxuICB9XHJcblxyXG4gIC5sZWFkIHtcclxuICAgIGZvbnQtc2l6ZTogMTRweFxyXG4gIH1cclxuXHJcbiAgI2Jlc3RQcmljZU9mZmVyIHtcclxuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIG1hcmdpbi10b3A6IDEwcHg7XHJcbiAgICBtYXgtd2lkdGg6IDM1cHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAzNXB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogMzVweDtcclxuICAgIGRpc3BsYXk6IG5vbmU7XHJcbiAgfVxyXG59XHJcblxyXG4ubG9nbyB7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIG1heC13aWR0aDogNzVweDtcclxuICBtYXgtaGVpZ2h0OiA3NXB4O1xyXG4gIGJvcmRlci1yYWRpdXM6IDM1cHg7XHJcbn1cclxuXHJcbiNiZXN0UHJpY2VPZmZlcntcclxuICBmb250LXN0eWxlOiBpdGFsaWM7XHJcbiAgZm9udC1zaXplOiAxMXB4O1xyXG4gIGZsb2F0OiByaWdodDtcclxuICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbn1cclxuXHJcbi5iZXN0LXByaWNlIHtcclxuICBjb2xvcjogYnJvd247XHJcbn1cclxuIl19 */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<head>\r\n  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\r\n        integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"\r\n          integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\"\r\n          crossorigin=\"anonymous\"></script>\r\n\r\n  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n          integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n          crossorigin=\"anonymous\"></script>\r\n  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\r\n          integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n          crossorigin=\"anonymous\"></script>\r\n</head>\r\n<div class=\"jumbotron jumbotron-fluid\">\r\n  <div class=\"container\">\r\n    <div id=\"bestPriceOffer\">\r\n      <img src=\"{{boardGame?.urlImage}}\"\r\n           alt=\"{{boardGame?.name}}\"\r\n           onerror=\"this.src='https://vignette.wikia.nocookie.net/lyricwiki/images/d/dd/Unknown.png/revision/latest?cb=20080726074744'\"\r\n           class=\"logo\"><br>\r\n      <span class=\"best-name\">{{boardGame?.name}}</span><br>\r\n      Best price:\r\n      <span class=\"best-price\">{{boardGame?.bestPrice}}</span>\r\n    </div>\r\n    <h1 class=\"display-4\">{{title}}</h1>\r\n    <p class=\"lead\">Search for any boardgame to get best prices. More traders will be added. Enable geekmarket for\r\n      international shipments.</p>\r\n  </div>\r\n</div>\r\n\r\n<app-board-game-list></app-board-game-list>\r\n<router-outlet></router-outlet>\r\n"

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
/* harmony import */ var _board_game_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./board-game.service */ "./src/app/board-game.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = /** @class */ (function () {
    function AppComponent(boardGameService) {
        this.boardGameService = boardGameService;
        this.title = 'Boardgames share market';
    }
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.boardGameService.getOne().subscribe(function (data) {
            _this.boardGame = data;
        });
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [_board_game_service__WEBPACK_IMPORTED_MODULE_1__["BoardGameService"]])
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
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _board_game_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./board-game.service */ "./src/app/board-game.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _board_game_list_board_game_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./board-game-list/board-game-list.component */ "./src/app/board-game-list/board-game-list.component.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _material_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./material-module */ "./src/app/material-module.ts");
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
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _board_game_list_board_game_list_component__WEBPACK_IMPORTED_MODULE_6__["BoardGameListComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__["BrowserAnimationsModule"],
                _material_module__WEBPACK_IMPORTED_MODULE_9__["AllMaterialModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_7__["MatNativeDateModule"]
            ],
            providers: [_board_game_service__WEBPACK_IMPORTED_MODULE_4__["BoardGameService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/board-game-list/board-game-list.component.css":
/*!***************************************************************!*\
  !*** ./src/app/board-game-list/board-game-list.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700);\n/*\t\r\n\tSide Navigation Menu V2, RWD\r\n\t===================\r\n\tLicense:\r\n\thttps://goo.gl/EaUPrt\r\n\t===================\r\n\tAuthor: @PableraShow\r\n\r\n */\n@charset \"UTF-8\";\nbody {\r\n  font-family: 'Open Sans', sans-serif;\r\n  font-weight: 300;\r\n  line-height: 1.42em;\r\n  background-color: #2c9088;\r\n}\nh1 {\r\n  font-size: 3em;\r\n  font-weight: 300;\r\n  line-height: 1em;\r\n  text-align: center;\r\n}\nh2 {\r\n  font-size: 1em;\r\n  font-weight: 300;\r\n  text-align: center;\r\n  display: block;\r\n  line-height: 1em;\r\n  padding-bottom: 2em;\r\n}\nh2 a {\r\n  font-weight: 700;\r\n  text-transform: uppercase;\r\n  text-decoration: none;\r\n}\n.blue {\r\n  color: #185875;\r\n}\n.yellow {\r\n  color: #FFF842;\r\n}\n.container th h1 {\r\n  font-weight: bold;\r\n  font-size: 1em;\r\n  text-align: left;\r\n}\n.container td {\r\n  font-weight: normal;\r\n  font-size: 1em;\r\n  box-shadow: 0 2px 2px -2px #0E1119;\r\n}\n.container {\r\n  text-align: left;\r\n  overflow: hidden;\r\n  margin: 0 auto;\r\n  width: 100%;\r\n  display: table;\r\n  padding: 0 0 8em 0;\r\n}\n.container td, .container th {\r\n  padding-bottom: 2%;\r\n  padding-top: 2%;\r\n  padding-left: 2%;\r\n}\n/* Background-color of the odd rows */\n.container tr:nth-child(odd) {\r\n  background-color: #323C50;\r\n}\n/* Background-color of the even rows */\n.container tr:nth-child(even) {\r\n  background-color: #2C3446;\r\n}\n.container th {\r\n  background-color: #21b8a0;\r\n}\n.container td:first-child {\r\n  color: #277efb;\r\n}\n.container tr:hover {\r\n  background-color: #464A52;\r\n  box-shadow: 0 6px 6px -6px #0E1119;\r\n}\na {\r\n  cursor: hand;\r\n  text-decoration: none;\r\n}\nth {\r\n  font-weight: bold;\r\n  text-transform: uppercase;\r\n}\ntd {\r\n  color: #A7A1AE;\r\n}\ntd a {\r\n  color: #A7A1AE;\r\n}\n.logo {\r\n  max-height: 40px;\r\n}\n.logo-small {\r\n  max-height: 15px;\r\n  position: relative;\r\n  text-align: right;\r\n  right: 10px;\r\n}\n@media (min-width: 800px) {\r\n  .logo-small {\r\n    display: none;\r\n  }\r\n}\n@media (max-width: 800px) {\r\n  .container td:nth-child(4),\r\n  .container th:nth-child(4) {\r\n    display: none;\r\n  }\r\n}\n.bggDetails {\r\n  font-size: 10px;\r\n  font-style: italic;\r\n}\n.bggInfo {\r\n  font-size: 11px;\r\n  color: #323C50;\r\n}\n.bggInfoTotal {\r\n  font-size: 14px;\r\n}\n.bubble {\r\n  right: 10px;\r\n  position: relative;\r\n  text-transform: uppercase;\r\n  top: 10px;\r\n  float:right!important;\r\n  z-index: 9;\r\n}\n.bubble .inside {\r\n  background-color: #951515;\r\n  border-radius: 999px;\r\n  display: table;\r\n  height: 25px;\r\n  position: relative;\r\n  width: 25px;\r\n  -webkit-border-radius: 999px;\r\n}\n.bubble .inside .inside-text {\r\n  color: #fff;\r\n  display: table-cell;\r\n  font-size: 11px;\r\n  font-weight: bold;\r\n  line-height: 14px;\r\n  text-align: center;\r\n  vertical-align: middle;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYm9hcmQtZ2FtZS1saXN0L2JvYXJkLWdhbWUtbGlzdC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFXQSwyRUFBMkU7QUFYM0U7Ozs7Ozs7O0dBUUc7QUFFSCxpQkFBaUI7QUFHakI7RUFDRSxxQ0FBcUM7RUFDckMsaUJBQWlCO0VBQ2pCLG9CQUFvQjtFQUNwQiwwQkFBMEI7Q0FDM0I7QUFFRDtFQUNFLGVBQWU7RUFDZixpQkFBaUI7RUFDakIsaUJBQWlCO0VBQ2pCLG1CQUFtQjtDQUNwQjtBQUVEO0VBQ0UsZUFBZTtFQUNmLGlCQUFpQjtFQUNqQixtQkFBbUI7RUFDbkIsZUFBZTtFQUNmLGlCQUFpQjtFQUNqQixvQkFBb0I7Q0FDckI7QUFFRDtFQUNFLGlCQUFpQjtFQUNqQiwwQkFBMEI7RUFDMUIsc0JBQXNCO0NBQ3ZCO0FBRUQ7RUFDRSxlQUFlO0NBQ2hCO0FBRUQ7RUFDRSxlQUFlO0NBQ2hCO0FBRUQ7RUFDRSxrQkFBa0I7RUFDbEIsZUFBZTtFQUNmLGlCQUFpQjtDQUNsQjtBQUVEO0VBQ0Usb0JBQW9CO0VBQ3BCLGVBQWU7RUFHZixtQ0FBbUM7Q0FDcEM7QUFFRDtFQUNFLGlCQUFpQjtFQUNqQixpQkFBaUI7RUFDakIsZUFBZTtFQUNmLFlBQVk7RUFDWixlQUFlO0VBQ2YsbUJBQW1CO0NBQ3BCO0FBRUQ7RUFDRSxtQkFBbUI7RUFDbkIsZ0JBQWdCO0VBQ2hCLGlCQUFpQjtDQUNsQjtBQUVELHNDQUFzQztBQUN0QztFQUNFLDBCQUEwQjtDQUMzQjtBQUVELHVDQUF1QztBQUN2QztFQUNFLDBCQUEwQjtDQUMzQjtBQUVEO0VBQ0UsMEJBQTBCO0NBQzNCO0FBRUQ7RUFDRSxlQUFlO0NBQ2hCO0FBRUQ7RUFDRSwwQkFBMEI7RUFHMUIsbUNBQW1DO0NBQ3BDO0FBRUQ7RUFDRSxhQUFhO0VBQ2Isc0JBQXNCO0NBQ3ZCO0FBRUQ7RUFDRSxrQkFBa0I7RUFDbEIsMEJBQTBCO0NBQzNCO0FBRUQ7RUFDRSxlQUFlO0NBQ2hCO0FBRUQ7RUFDRSxlQUFlO0NBQ2hCO0FBRUQ7RUFDRSxpQkFBaUI7Q0FDbEI7QUFFRDtFQUNFLGlCQUFpQjtFQUNqQixtQkFBbUI7RUFDbkIsa0JBQWtCO0VBQ2xCLFlBQVk7Q0FDYjtBQUVEO0VBQ0U7SUFDRSxjQUFjO0dBQ2Y7Q0FDRjtBQUVEO0VBQ0U7O0lBRUUsY0FBYztHQUNmO0NBQ0Y7QUFFRDtFQUNFLGdCQUFnQjtFQUNoQixtQkFBbUI7Q0FDcEI7QUFFRDtFQUNFLGdCQUFnQjtFQUNoQixlQUFlO0NBQ2hCO0FBRUQ7RUFDRSxnQkFBZ0I7Q0FDakI7QUFFRDtFQUNFLFlBQVk7RUFDWixtQkFBbUI7RUFDbkIsMEJBQTBCO0VBQzFCLFVBQVU7RUFDVixzQkFBc0I7RUFDdEIsV0FBVztDQUNaO0FBRUQ7RUFDRSwwQkFBMEI7RUFDMUIscUJBQXFCO0VBQ3JCLGVBQWU7RUFDZixhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLFlBQVk7RUFDWiw2QkFBNkI7Q0FDOUI7QUFFRDtFQUNFLFlBQVk7RUFDWixvQkFBb0I7RUFDcEIsZ0JBQWdCO0VBQ2hCLGtCQUFrQjtFQUNsQixrQkFBa0I7RUFDbEIsbUJBQW1CO0VBQ25CLHVCQUF1QjtDQUN4QiIsImZpbGUiOiJzcmMvYXBwL2JvYXJkLWdhbWUtbGlzdC9ib2FyZC1nYW1lLWxpc3QuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi8qXHRcclxuXHRTaWRlIE5hdmlnYXRpb24gTWVudSBWMiwgUldEXHJcblx0PT09PT09PT09PT09PT09PT09PVxyXG5cdExpY2Vuc2U6XHJcblx0aHR0cHM6Ly9nb28uZ2wvRWFVUHJ0XHJcblx0PT09PT09PT09PT09PT09PT09PVxyXG5cdEF1dGhvcjogQFBhYmxlcmFTaG93XHJcblxyXG4gKi9cclxuXHJcbkBjaGFyc2V0IFwiVVRGLThcIjtcclxuQGltcG9ydCB1cmwoaHR0cHM6Ly9mb250cy5nb29nbGVhcGlzLmNvbS9jc3M/ZmFtaWx5PU9wZW4rU2FuczozMDAsNDAwLDcwMCk7XHJcblxyXG5ib2R5IHtcclxuICBmb250LWZhbWlseTogJ09wZW4gU2FucycsIHNhbnMtc2VyaWY7XHJcbiAgZm9udC13ZWlnaHQ6IDMwMDtcclxuICBsaW5lLWhlaWdodDogMS40MmVtO1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICMyYzkwODg7XHJcbn1cclxuXHJcbmgxIHtcclxuICBmb250LXNpemU6IDNlbTtcclxuICBmb250LXdlaWdodDogMzAwO1xyXG4gIGxpbmUtaGVpZ2h0OiAxZW07XHJcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG59XHJcblxyXG5oMiB7XHJcbiAgZm9udC1zaXplOiAxZW07XHJcbiAgZm9udC13ZWlnaHQ6IDMwMDtcclxuICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgZGlzcGxheTogYmxvY2s7XHJcbiAgbGluZS1oZWlnaHQ6IDFlbTtcclxuICBwYWRkaW5nLWJvdHRvbTogMmVtO1xyXG59XHJcblxyXG5oMiBhIHtcclxuICBmb250LXdlaWdodDogNzAwO1xyXG4gIHRleHQtdHJhbnNmb3JtOiB1cHBlcmNhc2U7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG59XHJcblxyXG4uYmx1ZSB7XHJcbiAgY29sb3I6ICMxODU4NzU7XHJcbn1cclxuXHJcbi55ZWxsb3cge1xyXG4gIGNvbG9yOiAjRkZGODQyO1xyXG59XHJcblxyXG4uY29udGFpbmVyIHRoIGgxIHtcclxuICBmb250LXdlaWdodDogYm9sZDtcclxuICBmb250LXNpemU6IDFlbTtcclxuICB0ZXh0LWFsaWduOiBsZWZ0O1xyXG59XHJcblxyXG4uY29udGFpbmVyIHRkIHtcclxuICBmb250LXdlaWdodDogbm9ybWFsO1xyXG4gIGZvbnQtc2l6ZTogMWVtO1xyXG4gIC13ZWJraXQtYm94LXNoYWRvdzogMCAycHggMnB4IC0ycHggIzBFMTExOTtcclxuICAtbW96LWJveC1zaGFkb3c6IDAgMnB4IDJweCAtMnB4ICMwRTExMTk7XHJcbiAgYm94LXNoYWRvdzogMCAycHggMnB4IC0ycHggIzBFMTExOTtcclxufVxyXG5cclxuLmNvbnRhaW5lciB7XHJcbiAgdGV4dC1hbGlnbjogbGVmdDtcclxuICBvdmVyZmxvdzogaGlkZGVuO1xyXG4gIG1hcmdpbjogMCBhdXRvO1xyXG4gIHdpZHRoOiAxMDAlO1xyXG4gIGRpc3BsYXk6IHRhYmxlO1xyXG4gIHBhZGRpbmc6IDAgMCA4ZW0gMDtcclxufVxyXG5cclxuLmNvbnRhaW5lciB0ZCwgLmNvbnRhaW5lciB0aCB7XHJcbiAgcGFkZGluZy1ib3R0b206IDIlO1xyXG4gIHBhZGRpbmctdG9wOiAyJTtcclxuICBwYWRkaW5nLWxlZnQ6IDIlO1xyXG59XHJcblxyXG4vKiBCYWNrZ3JvdW5kLWNvbG9yIG9mIHRoZSBvZGQgcm93cyAqL1xyXG4uY29udGFpbmVyIHRyOm50aC1jaGlsZChvZGQpIHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjMzIzQzUwO1xyXG59XHJcblxyXG4vKiBCYWNrZ3JvdW5kLWNvbG9yIG9mIHRoZSBldmVuIHJvd3MgKi9cclxuLmNvbnRhaW5lciB0cjpudGgtY2hpbGQoZXZlbikge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICMyQzM0NDY7XHJcbn1cclxuXHJcbi5jb250YWluZXIgdGgge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICMyMWI4YTA7XHJcbn1cclxuXHJcbi5jb250YWluZXIgdGQ6Zmlyc3QtY2hpbGQge1xyXG4gIGNvbG9yOiAjMjc3ZWZiO1xyXG59XHJcblxyXG4uY29udGFpbmVyIHRyOmhvdmVyIHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjNDY0QTUyO1xyXG4gIC13ZWJraXQtYm94LXNoYWRvdzogMCA2cHggNnB4IC02cHggIzBFMTExOTtcclxuICAtbW96LWJveC1zaGFkb3c6IDAgNnB4IDZweCAtNnB4ICMwRTExMTk7XHJcbiAgYm94LXNoYWRvdzogMCA2cHggNnB4IC02cHggIzBFMTExOTtcclxufVxyXG5cclxuYSB7XHJcbiAgY3Vyc29yOiBoYW5kO1xyXG4gIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcclxufVxyXG5cclxudGgge1xyXG4gIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG4gIHRleHQtdHJhbnNmb3JtOiB1cHBlcmNhc2U7XHJcbn1cclxuXHJcbnRkIHtcclxuICBjb2xvcjogI0E3QTFBRTtcclxufVxyXG5cclxudGQgYSB7XHJcbiAgY29sb3I6ICNBN0ExQUU7XHJcbn1cclxuXHJcbi5sb2dvIHtcclxuICBtYXgtaGVpZ2h0OiA0MHB4O1xyXG59XHJcblxyXG4ubG9nby1zbWFsbCB7XHJcbiAgbWF4LWhlaWdodDogMTVweDtcclxuICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgdGV4dC1hbGlnbjogcmlnaHQ7XHJcbiAgcmlnaHQ6IDEwcHg7XHJcbn1cclxuXHJcbkBtZWRpYSAobWluLXdpZHRoOiA4MDBweCkge1xyXG4gIC5sb2dvLXNtYWxsIHtcclxuICAgIGRpc3BsYXk6IG5vbmU7XHJcbiAgfVxyXG59XHJcblxyXG5AbWVkaWEgKG1heC13aWR0aDogODAwcHgpIHtcclxuICAuY29udGFpbmVyIHRkOm50aC1jaGlsZCg0KSxcclxuICAuY29udGFpbmVyIHRoOm50aC1jaGlsZCg0KSB7XHJcbiAgICBkaXNwbGF5OiBub25lO1xyXG4gIH1cclxufVxyXG5cclxuLmJnZ0RldGFpbHMge1xyXG4gIGZvbnQtc2l6ZTogMTBweDtcclxuICBmb250LXN0eWxlOiBpdGFsaWM7XHJcbn1cclxuXHJcbi5iZ2dJbmZvIHtcclxuICBmb250LXNpemU6IDExcHg7XHJcbiAgY29sb3I6ICMzMjNDNTA7XHJcbn1cclxuXHJcbi5iZ2dJbmZvVG90YWwge1xyXG4gIGZvbnQtc2l6ZTogMTRweDtcclxufVxyXG5cclxuLmJ1YmJsZSB7XHJcbiAgcmlnaHQ6IDEwcHg7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIHRleHQtdHJhbnNmb3JtOiB1cHBlcmNhc2U7XHJcbiAgdG9wOiAxMHB4O1xyXG4gIGZsb2F0OnJpZ2h0IWltcG9ydGFudDtcclxuICB6LWluZGV4OiA5O1xyXG59XHJcblxyXG4uYnViYmxlIC5pbnNpZGUge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICM5NTE1MTU7XHJcbiAgYm9yZGVyLXJhZGl1czogOTk5cHg7XHJcbiAgZGlzcGxheTogdGFibGU7XHJcbiAgaGVpZ2h0OiAyNXB4O1xyXG4gIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICB3aWR0aDogMjVweDtcclxuICAtd2Via2l0LWJvcmRlci1yYWRpdXM6IDk5OXB4O1xyXG59XHJcblxyXG4uYnViYmxlIC5pbnNpZGUgLmluc2lkZS10ZXh0IHtcclxuICBjb2xvcjogI2ZmZjtcclxuICBkaXNwbGF5OiB0YWJsZS1jZWxsO1xyXG4gIGZvbnQtc2l6ZTogMTFweDtcclxuICBmb250LXdlaWdodDogYm9sZDtcclxuICBsaW5lLWhlaWdodDogMTRweDtcclxuICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcclxufVxyXG4iXX0= */"

/***/ }),

/***/ "./src/app/board-game-list/board-game-list.component.html":
/*!****************************************************************!*\
  !*** ./src/app/board-game-list/board-game-list.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-form-field class=\"mx-auto px-1\">\r\n  <input matInput (keyup)=\"applyFilter($event.target.value)\" (keydown.enter)=\"findBoardGame($event.target.value)\"\r\n         placeholder=\"Filter the {{numberOfGames}} items | Press enter to get latest price | Enable GeekMarket for best trades[europe] | @yourbggusername/[o,w,p]\"\r\n         #gamename\r\n         maxlength=\"50\"\r\n         required>\r\n  <mat-hint align=\"start\">\r\n    <div id=\"bggInfoTotal\" class=\"bggInfo\" *ngIf=\"numberOfBggCollection > 0\">\r\n      Total value for your <b>{{ numberOfBggCollection }}</b> games: <b>~{{ totalBggCollection | number : '1.2-2' }}</b>\r\n      lei.\r\n    </div>\r\n    <span class=\"bggInfo\" *ngIf=\"numberOfBggCollection == 0\"><i>Place your bgg username starting with @ and\r\n      /o[owned], /w[wishlist], /p[plays] (Sample:  @makowey/o) </i></span>\r\n  </mat-hint>\r\n  <mat-hint align=\"end\">{{gamename.value.length}}/50</mat-hint>\r\n</mat-form-field>\r\n\r\n<mat-slide-toggle\r\n  labelPosition=\"before\"\r\n  [checked]=\"stateCtrl.disabled\"\r\n  (change)=\"onChange()\"\r\n  class=\"float-right px-1\">\r\n  <i>GeekMarket</i>\r\n</mat-slide-toggle>\r\n\r\n<div class=\"mat-elevation-z8 mx-auto\" style=\"clear: both\">\r\n  <table mat-table [dataSource]=\"boardGames\" matSort class=\"container\">\r\n\r\n    <!--- Note that these columns can be defined in any order.\r\n          The actual rendered columns are set as a property on the row definition\" -->\r\n\r\n    <!-- Prod Column -->\r\n    <ng-container matColumnDef=\"prod\">\r\n      <th mat-header-cell *matHeaderCellDef> Item</th>\r\n      <td mat-cell *matCellDef=\"let element\">\r\n        <img class=\"avatar\" src=\"{{element.urlImage}}\"\r\n             alt=\"{{element.name}}\"\r\n             onerror=\"this.src='https://vignette.wikia.nocookie.net/lyricwiki/images/d/dd/Unknown.png/revision/latest?cb=20080726074744'\">\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Name Column -->\r\n    <ng-container matColumnDef=\"name\">\r\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Name</th>\r\n      <td mat-cell *matCellDef=\"let element\">\r\n        <a href=\"{{element.store.url}}\" target=\"_blank\">{{element.name}}</a>\r\n        <a href=\"{{element.store.url}}\" target=\"_blank\">\r\n          <br><img src=\"{{element.store.logo}}\" class=\"logo-small float-right\"/>\r\n        </a>\r\n        <span class=\"bggDetails\">{{element.bggDetails}}</span>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Weight Column -->\r\n    <ng-container matColumnDef=\"currentPrice\">\r\n      <th mat-header-cell *matHeaderCellDef mat-sort-header matSortStart=\"asc\">\r\n        <div *ngIf=\"!isPlays()\"> Price(lei)</div>\r\n        <div *ngIf=\"isPlays()\"> Plays</div>\r\n      </th>\r\n      <td mat-cell *matCellDef=\"let element\">\r\n        {{element.currentPrice | number : '1.2-2'}}\r\n        <div class=\"bubble\" *ngIf=\"element.percent >= 25\">\r\n          <div class=\"inside\">\r\n            <div class=\"inside-text\">\r\n              {{element.percent}}%\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Symbol Column -->\r\n    <ng-container matColumnDef=\"store\">\r\n      <th mat-header-cell *matHeaderCellDef>\r\n        <div *ngIf=\"!isPlays()\"> Store</div>\r\n        <div *ngIf=\"isPlays()\"> Max Score</div>\r\n      </th>\r\n      <td mat-cell *matCellDef=\"let element\">\r\n        <a href=\"{{element.store.url}}\" target=\"_blank\">\r\n          <img src=\"{{element.store.logo}}\" class=\"logo\"/>\r\n        </a>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n    <tr mat-row *matRowDef=\"let row; columns: displayedColumns; let i = index\" id=\"row{{i}}\"></tr>\r\n  </table>\r\n\r\n  <mat-card *ngIf=\"isLoading\"\r\n            style=\"display: flex; justify-content: center; align-items: center\">\r\n    <mat-progress-spinner\r\n      color=\"primary\"\r\n      mode=\"indeterminate\">\r\n    </mat-progress-spinner>\r\n  </mat-card>\r\n\r\n  <footer class=\"credit\">\r\n    <a href=\"https://boardgamegeek.com/user/makowey\">@makowey, 2018</a>,\r\n    Available online games: <a href=\"http://boardgames.com.ro:8000/index.html?name=HomeScreener\">Ganz Shon Clever</a>\r\n  </footer>\r\n  <mat-paginator [pageSizeOptions]=\"[15, 30, 50]\" showFirstLastButtons></mat-paginator>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/board-game-list/board-game-list.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/board-game-list/board-game-list.component.ts ***!
  \**************************************************************/
/*! exports provided: BoardGameListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BoardGameListComponent", function() { return BoardGameListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _board_game_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../board-game.service */ "./src/app/board-game.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_add_observable_of__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/add/observable/of */ "./node_modules/rxjs-compat/_esm5/add/observable/of.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var BoardGameListComponent = /** @class */ (function () {
    function BoardGameListComponent(boardGameService) {
        this.boardGameService = boardGameService;
        this.displayedColumns = ['prod', 'name', 'currentPrice', 'store'];
        this.numberOfBggCollection = 0;
        this.totalBggCollection = 0;
        this.stateCtrl = new _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormControl"]();
        this.currentFilter = "#20";
        this.isLoading = true;
        this.isGeekMarket = false;
        this.stateCtrl.disable();
    }
    BoardGameListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.boardGameService.getAll().subscribe(function (data) {
            _this.originalData = data;
            _this.refresh(data);
        }, function () { return _this.isLoading = false; });
        this.boardGameService.count().subscribe(function (data) {
            _this.numberOfGames = data;
        });
    };
    BoardGameListComponent.prototype.ngAfterViewInit = function () {
        var _this = this;
        this.paginator.page
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function () { return _this.boardGameService.search(rxjs__WEBPACK_IMPORTED_MODULE_4__["Observable"].of(_this.boardGames.filter), _this.isGeekMarket); }))
            .subscribe();
    };
    BoardGameListComponent.prototype.applyFilter = function (filterValue) {
        var _this = this;
        this.currentFilter = filterValue;
        this.boardGames.filter = filterValue.trim().toLowerCase();
        if (this.currentFilter.startsWith("#"))
            return this.blackFriday(filterValue);
        if (this.currentFilter.startsWith("^"))
            return this.boardGameService.reloadAll();
        if (this.currentFilter.startsWith("@") &&
            (this.currentFilter.endsWith("/w") ||
                this.currentFilter.endsWith("/o") ||
                this.currentFilter.endsWith("/p"))) {
            this.isLoading = true;
            this.boardGameService.findCollections(this.boardGames.filter)
                .subscribe(function (data) {
                _this.totalBggCollection = _this.getTotal(data);
                if (_this.boardGames.filter.endsWith("\o")) {
                    _this.numberOfBggCollection = data.length;
                }
                else
                    _this.numberOfBggCollection = 0;
                _this.refresh(data);
            }, function () { return _this.isLoading = false; });
            return;
        }
        if (this.currentFilter.startsWith("@"))
            return;
        if (this.currentFilter.startsWith("$"))
            return;
        if (this.boardGames.filter.length > 1) {
            this.isLoading = true;
            this.boardGameService.search(rxjs__WEBPACK_IMPORTED_MODULE_4__["Observable"].of(this.boardGames.filter), this.isGeekMarket)
                .subscribe(function (data) {
                _this.numberOfBggCollection = 0;
                _this.refresh(data);
            }, function () { return _this.isLoading = false; });
        }
    };
    BoardGameListComponent.prototype.findBoardGame = function (filterValue) {
        var _this = this;
        this.currentFilter = filterValue;
        if (this.currentFilter.startsWith("@") ||
            this.currentFilter.startsWith("#"))
            return;
        this.isLoading = true;
        this.boardGames.data = [];
        this.boardGames.filter = filterValue.replace(/ /g, "%20");
        this.boardGameService.findAndUpdateBoardGames(0, this.boardGames.filter)
            .subscribe(function (data) {
            _this.refresh(data);
        }, function () { return _this.isLoading = false; });
    };
    BoardGameListComponent.prototype.blackFriday = function (filterValue) {
        var _this = this;
        this.currentFilter = filterValue.replace("#", "");
        this.isLoading = true;
        this.boardGames.filter = this.currentFilter;
        this.boardGameService.blackFriday(this.boardGames.filter)
            .subscribe(function (data) {
            _this.refresh(data);
        }, function () { return _this.isLoading = false; });
    };
    BoardGameListComponent.prototype.refresh = function (data) {
        this.boardGames = new _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTableDataSource"](data);
        this.boardGames.paginator = this.paginator;
        this.sort.sort(({ id: 'currentPrice', start: 'asc' }));
        this.boardGames.sort = this.sort;
        this.isLoading = false;
    };
    BoardGameListComponent.prototype.enableGeekMarket = function () {
        this.stateCtrl.enable();
        this.isGeekMarket = true;
        this.applyFilter(this.currentFilter);
    };
    BoardGameListComponent.prototype.disableGeekMarket = function () {
        this.stateCtrl.disable();
        this.isGeekMarket = false;
        this.applyFilter(this.currentFilter);
    };
    BoardGameListComponent.prototype.onChange = function () {
        this.stateCtrl.disabled ?
            this.enableGeekMarket() :
            this.disableGeekMarket();
    };
    BoardGameListComponent.prototype.getTotal = function (data) {
        var total = 0;
        data.forEach(function (game) { return total += game.currentPrice; });
        return total;
    };
    BoardGameListComponent.prototype.isPlays = function () {
        return this.currentFilter.endsWith("/p");
    };
    BoardGameListComponent.prototype.isOwned = function () {
        return this.currentFilter.endsWith("/o");
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSort"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSort"])
    ], BoardGameListComponent.prototype, "sort", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatPaginator"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatPaginator"])
    ], BoardGameListComponent.prototype, "paginator", void 0);
    BoardGameListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-board-game-list',
            template: __webpack_require__(/*! ./board-game-list.component.html */ "./src/app/board-game-list/board-game-list.component.html"),
            styles: [__webpack_require__(/*! ./board-game-list.component.css */ "./src/app/board-game-list/board-game-list.component.css")]
        }),
        __metadata("design:paramtypes", [_board_game_service__WEBPACK_IMPORTED_MODULE_1__["BoardGameService"]])
    ], BoardGameListComponent);
    return BoardGameListComponent;
}());



/***/ }),

/***/ "./src/app/board-game.service.ts":
/*!***************************************!*\
  !*** ./src/app/board-game.service.ts ***!
  \***************************************/
/*! exports provided: BoardGameService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BoardGameService", function() { return BoardGameService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs_add_operator_map__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/add/operator/map */ "./node_modules/rxjs-compat/_esm5/add/operator/map.js");
/* harmony import */ var rxjs_add_operator_debounceTime__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/add/operator/debounceTime */ "./node_modules/rxjs-compat/_esm5/add/operator/debounceTime.js");
/* harmony import */ var rxjs_add_operator_distinctUntilChanged__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/add/operator/distinctUntilChanged */ "./node_modules/rxjs-compat/_esm5/add/operator/distinctUntilChanged.js");
/* harmony import */ var rxjs_add_operator_switchMap__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/add/operator/switchMap */ "./node_modules/rxjs-compat/_esm5/add/operator/switchMap.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var BoardGameService = /** @class */ (function () {
    function BoardGameService(http) {
        this.http = http;
        this.baseUrl = ""; //http://localhost:8089";
    }
    BoardGameService.prototype.getAll = function () {
        return this.http.get(this.baseUrl + '/all');
    };
    BoardGameService.prototype.reloadAll = function () {
        return this.http.get(this.baseUrl + '/collectAll');
    };
    BoardGameService.prototype.count = function () {
        return this.http.get(this.baseUrl + '/count');
    };
    BoardGameService.prototype.findBoardGames = function (name) {
        if (name === void 0) { name = ''; }
        return this.http.get(this.baseUrl + '/find', {
            params: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]()
                .set('name', name)
        });
    };
    BoardGameService.prototype.blackFriday = function (percent) {
        if (percent === void 0) { percent = '10'; }
        return this.http.get(this.baseUrl + '/blackFriday', {
            params: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]()
                .set('percent', percent)
        });
    };
    BoardGameService.prototype.findCollections = function (username) {
        if (username === void 0) { username = ''; }
        return this.http.get(this.baseUrl + '/findCollections', {
            params: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]()
                .set('username', username)
        });
    };
    BoardGameService.prototype.findAllBoardGames = function (name, value) {
        if (name === void 0) { name = ''; }
        if (value === void 0) { value = false; }
        return this.http.get(this.baseUrl + '/findall', {
            params: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]()
                .set('name', name)
                .set('geekmarket', String(value))
        });
    };
    BoardGameService.prototype.findAndUpdateBoardGames = function (gameId, name) {
        if (name === void 0) { name = ''; }
        return this.http.get(this.baseUrl + '/search', {
            params: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]()
                .set('gameId', gameId.toString())
                .set('name', name)
        });
    };
    BoardGameService.prototype.search = function (term, geekMarket) {
        var _this = this;
        return term
            .debounceTime(1000)
            .distinctUntilChanged()
            .switchMap(function (term) { return _this.findAllBoardGames(term, geekMarket); });
    };
    BoardGameService.prototype.getOne = function () {
        return this.http.get(this.baseUrl + '/getOne');
    };
    BoardGameService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], BoardGameService);
    return BoardGameService;
}());



/***/ }),

/***/ "./src/app/material-module.ts":
/*!************************************!*\
  !*** ./src/app/material-module.ts ***!
  \************************************/
/*! exports provided: AllMaterialModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AllMaterialModule", function() { return AllMaterialModule; });
/* harmony import */ var _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/cdk/drag-drop */ "./node_modules/@angular/cdk/esm5/drag-drop.es5.js");
/* harmony import */ var _angular_cdk_table__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/cdk/table */ "./node_modules/@angular/cdk/esm5/table.es5.js");
/* harmony import */ var _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/cdk/tree */ "./node_modules/@angular/cdk/esm5/tree.es5.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var AllMaterialModule = /** @class */ (function () {
    function AllMaterialModule() {
    }
    AllMaterialModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"])({
            exports: [
                _angular_cdk_table__WEBPACK_IMPORTED_MODULE_1__["CdkTableModule"],
                _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_2__["CdkTreeModule"],
                _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_0__["DragDropModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatAutocompleteModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatBadgeModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatBottomSheetModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatButtonModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatButtonToggleModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatCardModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatCheckboxModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatChipsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatStepperModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatDatepickerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatDividerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatExpansionModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatGridListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatMenuModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatNativeDateModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatPaginatorModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatProgressBarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatProgressSpinnerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatRadioModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatRippleModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSelectModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSidenavModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSliderModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSlideToggleModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSnackBarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSortModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTableModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTabsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTooltipModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatTreeModule"],
            ]
        })
    ], AllMaterialModule);
    return AllMaterialModule;
}());

/**  Copyright 2018 Google Inc. All Rights Reserved.
 Use of this source code is governed by an MIT-style license that
 can be found in the LICENSE file at http://angular.io/license */


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
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
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
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! D:\Stuff\chilipir\web-client\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map