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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<head>\r\n  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\r\n\r\n  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n</head>\r\n<div class=\"jumbotron jumbotron-fluid\">\r\n  <div class=\"container\">\r\n    <h1 class=\"display-4\">{{title}}</h1>\r\n    <p class=\"lead\">Search for any boardgame to get best prices. More traders will be added. Enable geekmarket for international ships.</p>\r\n  </div>\r\n</div>\r\n\r\n<app-board-game-list></app-board-game-list>\r\n<router-outlet></router-outlet>\r\n"

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
        this.title = 'Boardgames share market';
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

module.exports = "\r\n@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700);\n/*\t\r\n\tSide Navigation Menu V2, RWD\r\n\t===================\r\n\tLicense:\r\n\thttps://goo.gl/EaUPrt\r\n\t===================\r\n\tAuthor: @PableraShow\r\n\r\n */\n@charset \"UTF-8\";\nbody {\r\n  font-family: 'Open Sans', sans-serif;\r\n  font-weight: 300;\r\n  line-height: 1.42em;\r\n  background-color: #2c9088;\r\n}\nh1 {\r\n  font-size:3em;\r\n  font-weight: 300;\r\n  line-height:1em;\r\n  text-align: center;\r\n}\nh2 {\r\n  font-size:1em;\r\n  font-weight: 300;\r\n  text-align: center;\r\n  display: block;\r\n  line-height:1em;\r\n  padding-bottom: 2em;\r\n}\nh2 a {\r\n  font-weight: 700;\r\n  text-transform: uppercase;\r\n  text-decoration: none;\r\n}\n.blue { color: #185875; }\n.yellow { color: #FFF842; }\n.container th h1 {\r\n  font-weight: bold;\r\n  font-size: 1em;\r\n  text-align: left;\r\n}\n.container td {\r\n  font-weight: normal;\r\n  font-size: 1em;\r\n  box-shadow: 0 2px 2px -2px #0E1119;\r\n}\n.container {\r\n  text-align: left;\r\n  overflow: hidden;\r\n  margin: 0 auto;\r\n  width: 100%;\r\n  display: table;\r\n  padding: 0 0 8em 0;\r\n}\n.container td, .container th {\r\n  padding-bottom: 2%;\r\n  padding-top: 2%;\r\n  padding-left:2%;\r\n}\n/* Background-color of the odd rows */\n.container tr:nth-child(odd) {\r\n  background-color: #323C50;\r\n}\n/* Background-color of the even rows */\n.container tr:nth-child(even) {\r\n  background-color: #2C3446;\r\n}\n.container th {\r\n  background-color: #21b8a0;\r\n}\n.container td:first-child { color: #277efb; }\n.container tr:hover {\r\n  background-color: #464A52;\r\n  box-shadow: 0 6px 6px -6px #0E1119;\r\n}\n.container td:hover {\r\n  background-color: #593654;\r\n  color: #403E10;\r\n  font-weight: bold;\r\n\r\n  box-shadow: #7F7C21 -1px 1px, #7F7C21 -2px 2px, #7F7C21 -3px 3px, #7F7C21 -4px 4px, #7F7C21 -5px 5px, #7F7C21 -6px 6px;\r\n  -webkit-transform: translate3d(6px, -6px, 0);\r\n          transform: translate3d(6px, -6px, 0);\r\n\r\n  transition-delay: 0s;\r\n  transition-duration: 0.4s;\r\n  transition-property: all;\r\n  transition-timing-function: line;\r\n}\n@media (max-width: 800px) {\r\n  .container td:nth-child(4),\r\n  .container th:nth-child(4) { display: none; }\r\n}\na {\r\n  cursor: hand;\r\n  text-decoration:none;\r\n}\nth {\r\n  font-weight: bold;\r\n}\ntd {\r\n  color: #A7A1AE;\r\n}\ntd a {\r\n  color: #A7A1AE;\r\n}\n#row0 {\r\n  background-color: #086f2e;\r\n  font-weight: bold;\r\n  color: darkblue;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYm9hcmQtZ2FtZS1saXN0L2JvYXJkLWdhbWUtbGlzdC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFXQSwyRUFBMkU7QUFYM0U7Ozs7Ozs7O0dBUUc7QUFFSCxpQkFBaUI7QUFHakI7RUFDRSxxQ0FBcUM7RUFDckMsaUJBQWlCO0VBQ2pCLG9CQUFvQjtFQUNwQiwwQkFBMEI7Q0FDM0I7QUFFRDtFQUNFLGNBQWM7RUFDZCxpQkFBaUI7RUFDakIsZ0JBQWdCO0VBQ2hCLG1CQUFtQjtDQUNwQjtBQUVEO0VBQ0UsY0FBYztFQUNkLGlCQUFpQjtFQUNqQixtQkFBbUI7RUFDbkIsZUFBZTtFQUNmLGdCQUFnQjtFQUNoQixvQkFBb0I7Q0FDckI7QUFFRDtFQUNFLGlCQUFpQjtFQUNqQiwwQkFBMEI7RUFDMUIsc0JBQXNCO0NBQ3ZCO0FBRUQsUUFBUSxlQUFlLEVBQUU7QUFDekIsVUFBVSxlQUFlLEVBQUU7QUFFM0I7RUFDRSxrQkFBa0I7RUFDbEIsZUFBZTtFQUNmLGlCQUFpQjtDQUNsQjtBQUVEO0VBQ0Usb0JBQW9CO0VBQ3BCLGVBQWU7RUFHZixtQ0FBbUM7Q0FDcEM7QUFFRDtFQUNFLGlCQUFpQjtFQUNqQixpQkFBaUI7RUFDakIsZUFBZTtFQUNmLFlBQVk7RUFDWixlQUFlO0VBQ2YsbUJBQW1CO0NBQ3BCO0FBRUQ7RUFDRSxtQkFBbUI7RUFDbkIsZ0JBQWdCO0VBQ2hCLGdCQUFnQjtDQUNqQjtBQUVELHNDQUFzQztBQUN0QztFQUNFLDBCQUEwQjtDQUMzQjtBQUVELHVDQUF1QztBQUN2QztFQUNFLDBCQUEwQjtDQUMzQjtBQUVEO0VBQ0UsMEJBQTBCO0NBQzNCO0FBRUQsNEJBQTRCLGVBQWUsRUFBRTtBQUU3QztFQUNFLDBCQUEwQjtFQUcxQixtQ0FBbUM7Q0FDcEM7QUFFRDtFQUNFLDBCQUEwQjtFQUMxQixlQUFlO0VBQ2Ysa0JBQWtCOztFQUVsQix1SEFBdUg7RUFDdkgsNkNBQXFDO1VBQXJDLHFDQUFxQzs7RUFFckMscUJBQXFCO0VBQ3JCLDBCQUEwQjtFQUMxQix5QkFBeUI7RUFDekIsaUNBQWlDO0NBQ2xDO0FBRUQ7RUFDRTsrQkFDNkIsY0FBYyxFQUFFO0NBQzlDO0FBRUQ7RUFDRSxhQUFhO0VBQ2IscUJBQXFCO0NBQ3RCO0FBRUQ7RUFDRSxrQkFBa0I7Q0FDbkI7QUFFRDtFQUNFLGVBQWU7Q0FDaEI7QUFFRDtFQUNFLGVBQWU7Q0FDaEI7QUFFRDtFQUNFLDBCQUEwQjtFQUMxQixrQkFBa0I7RUFDbEIsZ0JBQWdCO0NBQ2pCIiwiZmlsZSI6InNyYy9hcHAvYm9hcmQtZ2FtZS1saXN0L2JvYXJkLWdhbWUtbGlzdC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLypcdFxyXG5cdFNpZGUgTmF2aWdhdGlvbiBNZW51IFYyLCBSV0RcclxuXHQ9PT09PT09PT09PT09PT09PT09XHJcblx0TGljZW5zZTpcclxuXHRodHRwczovL2dvby5nbC9FYVVQcnRcclxuXHQ9PT09PT09PT09PT09PT09PT09XHJcblx0QXV0aG9yOiBAUGFibGVyYVNob3dcclxuXHJcbiAqL1xyXG5cclxuQGNoYXJzZXQgXCJVVEYtOFwiO1xyXG5AaW1wb3J0IHVybChodHRwczovL2ZvbnRzLmdvb2dsZWFwaXMuY29tL2Nzcz9mYW1pbHk9T3BlbitTYW5zOjMwMCw0MDAsNzAwKTtcclxuXHJcbmJvZHkge1xyXG4gIGZvbnQtZmFtaWx5OiAnT3BlbiBTYW5zJywgc2Fucy1zZXJpZjtcclxuICBmb250LXdlaWdodDogMzAwO1xyXG4gIGxpbmUtaGVpZ2h0OiAxLjQyZW07XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogIzJjOTA4ODtcclxufVxyXG5cclxuaDEge1xyXG4gIGZvbnQtc2l6ZTozZW07XHJcbiAgZm9udC13ZWlnaHQ6IDMwMDtcclxuICBsaW5lLWhlaWdodDoxZW07XHJcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG59XHJcblxyXG5oMiB7XHJcbiAgZm9udC1zaXplOjFlbTtcclxuICBmb250LXdlaWdodDogMzAwO1xyXG4gIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICBkaXNwbGF5OiBibG9jaztcclxuICBsaW5lLWhlaWdodDoxZW07XHJcbiAgcGFkZGluZy1ib3R0b206IDJlbTtcclxufVxyXG5cclxuaDIgYSB7XHJcbiAgZm9udC13ZWlnaHQ6IDcwMDtcclxuICB0ZXh0LXRyYW5zZm9ybTogdXBwZXJjYXNlO1xyXG4gIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcclxufVxyXG5cclxuLmJsdWUgeyBjb2xvcjogIzE4NTg3NTsgfVxyXG4ueWVsbG93IHsgY29sb3I6ICNGRkY4NDI7IH1cclxuXHJcbi5jb250YWluZXIgdGggaDEge1xyXG4gIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG4gIGZvbnQtc2l6ZTogMWVtO1xyXG4gIHRleHQtYWxpZ246IGxlZnQ7XHJcbn1cclxuXHJcbi5jb250YWluZXIgdGQge1xyXG4gIGZvbnQtd2VpZ2h0OiBub3JtYWw7XHJcbiAgZm9udC1zaXplOiAxZW07XHJcbiAgLXdlYmtpdC1ib3gtc2hhZG93OiAwIDJweCAycHggLTJweCAjMEUxMTE5O1xyXG4gIC1tb3otYm94LXNoYWRvdzogMCAycHggMnB4IC0ycHggIzBFMTExOTtcclxuICBib3gtc2hhZG93OiAwIDJweCAycHggLTJweCAjMEUxMTE5O1xyXG59XHJcblxyXG4uY29udGFpbmVyIHtcclxuICB0ZXh0LWFsaWduOiBsZWZ0O1xyXG4gIG92ZXJmbG93OiBoaWRkZW47XHJcbiAgbWFyZ2luOiAwIGF1dG87XHJcbiAgd2lkdGg6IDEwMCU7XHJcbiAgZGlzcGxheTogdGFibGU7XHJcbiAgcGFkZGluZzogMCAwIDhlbSAwO1xyXG59XHJcblxyXG4uY29udGFpbmVyIHRkLCAuY29udGFpbmVyIHRoIHtcclxuICBwYWRkaW5nLWJvdHRvbTogMiU7XHJcbiAgcGFkZGluZy10b3A6IDIlO1xyXG4gIHBhZGRpbmctbGVmdDoyJTtcclxufVxyXG5cclxuLyogQmFja2dyb3VuZC1jb2xvciBvZiB0aGUgb2RkIHJvd3MgKi9cclxuLmNvbnRhaW5lciB0cjpudGgtY2hpbGQob2RkKSB7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogIzMyM0M1MDtcclxufVxyXG5cclxuLyogQmFja2dyb3VuZC1jb2xvciBvZiB0aGUgZXZlbiByb3dzICovXHJcbi5jb250YWluZXIgdHI6bnRoLWNoaWxkKGV2ZW4pIHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjMkMzNDQ2O1xyXG59XHJcblxyXG4uY29udGFpbmVyIHRoIHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjMjFiOGEwO1xyXG59XHJcblxyXG4uY29udGFpbmVyIHRkOmZpcnN0LWNoaWxkIHsgY29sb3I6ICMyNzdlZmI7IH1cclxuXHJcbi5jb250YWluZXIgdHI6aG92ZXIge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICM0NjRBNTI7XHJcbiAgLXdlYmtpdC1ib3gtc2hhZG93OiAwIDZweCA2cHggLTZweCAjMEUxMTE5O1xyXG4gIC1tb3otYm94LXNoYWRvdzogMCA2cHggNnB4IC02cHggIzBFMTExOTtcclxuICBib3gtc2hhZG93OiAwIDZweCA2cHggLTZweCAjMEUxMTE5O1xyXG59XHJcblxyXG4uY29udGFpbmVyIHRkOmhvdmVyIHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjNTkzNjU0O1xyXG4gIGNvbG9yOiAjNDAzRTEwO1xyXG4gIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG5cclxuICBib3gtc2hhZG93OiAjN0Y3QzIxIC0xcHggMXB4LCAjN0Y3QzIxIC0ycHggMnB4LCAjN0Y3QzIxIC0zcHggM3B4LCAjN0Y3QzIxIC00cHggNHB4LCAjN0Y3QzIxIC01cHggNXB4LCAjN0Y3QzIxIC02cHggNnB4O1xyXG4gIHRyYW5zZm9ybTogdHJhbnNsYXRlM2QoNnB4LCAtNnB4LCAwKTtcclxuXHJcbiAgdHJhbnNpdGlvbi1kZWxheTogMHM7XHJcbiAgdHJhbnNpdGlvbi1kdXJhdGlvbjogMC40cztcclxuICB0cmFuc2l0aW9uLXByb3BlcnR5OiBhbGw7XHJcbiAgdHJhbnNpdGlvbi10aW1pbmctZnVuY3Rpb246IGxpbmU7XHJcbn1cclxuXHJcbkBtZWRpYSAobWF4LXdpZHRoOiA4MDBweCkge1xyXG4gIC5jb250YWluZXIgdGQ6bnRoLWNoaWxkKDQpLFxyXG4gIC5jb250YWluZXIgdGg6bnRoLWNoaWxkKDQpIHsgZGlzcGxheTogbm9uZTsgfVxyXG59XHJcblxyXG5hIHtcclxuICBjdXJzb3I6IGhhbmQ7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOm5vbmU7XHJcbn1cclxuXHJcbnRoIHtcclxuICBmb250LXdlaWdodDogYm9sZDtcclxufVxyXG5cclxudGQge1xyXG4gIGNvbG9yOiAjQTdBMUFFO1xyXG59XHJcblxyXG50ZCBhIHtcclxuICBjb2xvcjogI0E3QTFBRTtcclxufVxyXG5cclxuI3JvdzAge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICMwODZmMmU7XHJcbiAgZm9udC13ZWlnaHQ6IGJvbGQ7XHJcbiAgY29sb3I6IGRhcmtibHVlO1xyXG59XHJcbiJdfQ== */"

/***/ }),

/***/ "./src/app/board-game-list/board-game-list.component.html":
/*!****************************************************************!*\
  !*** ./src/app/board-game-list/board-game-list.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--<form class=\"example-form\">-->\r\n<!--<mat-form-field class=\"example-full-width\">-->\r\n<!--<input matInput placeholder=\"BoardGame\" aria-label=\"BoardGame\" [matAutocomplete]=\"auto\" [formControl]=\"stateCtrl\">-->\r\n<!--<mat-autocomplete #auto=\"matAutocomplete\">-->\r\n<!--<mat-option *ngFor=\"let boardGame of boardGames | async\" [value]=\"boardGame.name\">-->\r\n<!--<img class=\"example-option-img\" aria-hidden [src]=\"boardGame.urlImage\" height=\"25\">-->\r\n<!--<span>{{boardGame.name}}</span> |-->\r\n<!--<small>boardgamegeek: {{boardGame.store.url}}</small>-->\r\n<!--</mat-option>-->\r\n<!--</mat-autocomplete>-->\r\n<!--</mat-form-field>-->\r\n<!--<br>-->\r\n<!--</form>-->\r\n\r\n<mat-form-field class=\"mx-auto px-1\">\r\n  <input matInput (keyup)=\"applyFilter($event.target.value)\" (keydown.enter)=\"findBoardGame($event.target.value)\"\r\n         placeholder=\"Filter the {{numberOfGames}} items | Press enter to get latest price | Enable GeekMarket for best trades[europe]\">\r\n</mat-form-field>\r\n\r\n<mat-slide-toggle\r\n  labelPosition=\"before\"\r\n  [checked]=\"stateCtrl.disabled\"\r\n  (change)=\"onChange()\"\r\n  class=\"float-right px-1\">\r\n  <i>GeekMarket</i>\r\n</mat-slide-toggle>\r\n\r\n<div class=\"mat-elevation-z8 mx-auto\">\r\n  <table mat-table [dataSource]=\"boardGames\" matSort class=\"container\">\r\n\r\n    <!--- Note that these columns can be defined in any order.\r\n          The actual rendered columns are set as a property on the row definition\" -->\r\n\r\n    <!-- Prod Column -->\r\n    <ng-container matColumnDef=\"prod\">\r\n      <th mat-header-cell *matHeaderCellDef> Item</th>\r\n      <td mat-cell *matCellDef=\"let element\">\r\n        <img class=\"avatar\" src=\"{{element.urlImage}}\" alt=\"{{element.name}}\">\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Name Column -->\r\n    <ng-container matColumnDef=\"name\">\r\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Name</th>\r\n      <td mat-cell *matCellDef=\"let element\"><a href=\"{{element.store.url}}\" target=\"_blank\">{{element.name}}</a></td>\r\n    </ng-container>\r\n\r\n    <!-- Weight Column -->\r\n    <ng-container matColumnDef=\"currentPrice\">\r\n      <th mat-header-cell *matHeaderCellDef mat-sort-header matSortStart=\"asc\"> Price(lei)</th>\r\n      <td mat-cell *matCellDef=\"let element\">{{element.currentPrice | number : '1.2-2'}}</td>\r\n    </ng-container>\r\n\r\n    <!-- Symbol Column -->\r\n    <ng-container matColumnDef=\"store\">\r\n      <th mat-header-cell *matHeaderCellDef> Store</th>\r\n      <td mat-cell *matCellDef=\"let element\">\r\n        <a href=\"{{element.store.url}}\" target=\"_blank\">{{element.store.name}}</a>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n    <tr mat-row *matRowDef=\"let row; columns: displayedColumns; let i = index\" id=\"row{{i}}\"></tr>\r\n  </table>\r\n  <footer class=\"credit\">\r\n    <a href=\"https://boardgamegeek.com/user/makowey\">@makowey, 2018</a>\r\n  </footer>\r\n  <mat-paginator [pageSizeOptions]=\"[15, 30, 50]\" showFirstLastButtons></mat-paginator>\r\n</div>\r\n"

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
        this.stateCtrl = new _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormControl"]();
        this.currentFilter = "catan";
        this.isGeekMarket = false;
        this.stateCtrl.disable();
    }
    BoardGameListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.boardGameService.getAll().subscribe(function (data) {
            _this.originalData = data;
            _this.refresh(data);
        });
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
        if (this.boardGames.filter.length > 1) {
            this.boardGameService.search(rxjs__WEBPACK_IMPORTED_MODULE_4__["Observable"].of(this.boardGames.filter), this.isGeekMarket)
                .subscribe(function (data) {
                _this.refresh(data);
            });
        }
    };
    BoardGameListComponent.prototype.findBoardGame = function (filterValue) {
        var _this = this;
        this.currentFilter = filterValue;
        this.boardGames.filter = filterValue.replace(/ /g, "%20");
        this.boardGameService.findAndUpdateBoardGames(0, this.boardGames.filter)
            .subscribe(function (data) {
            _this.refresh(data);
        });
    };
    BoardGameListComponent.prototype.refresh = function (data) {
        this.boardGames = new _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTableDataSource"](data);
        this.boardGames.paginator = this.paginator;
        this.sort.sort(({ id: 'currentPrice', start: 'asc' }));
        this.boardGames.sort = this.sort;
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
        this.baseUrl = ""; //localhost:8083";
    }
    BoardGameService.prototype.getAll = function () {
        return this.http.get(this.baseUrl + '/all');
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

module.exports = __webpack_require__(/*! D:\oath\cheapest-boardgame\web-client\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map