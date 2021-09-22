// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def returnMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.returnMap",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "map"})
        }
      """
    )
  
    // @LINE:17
    def deletePatient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deletePatient",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "patient/delete"})
        }
      """
    )
  
    // @LINE:12
    def jmlPagePatient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.jmlPagePatient",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "patient/page"})
        }
      """
    )
  
    // @LINE:11
    def getPatient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getPatient",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "patient"})
        }
      """
    )
  
    // @LINE:14
    def getItemPatient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getItemPatient",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "patient/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:8
    def listNama: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.listNama",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nama"})
        }
      """
    )
  
    // @LINE:15
    def addPatient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addPatient",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "patient"})
        }
      """
    )
  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:16
    def updatePatient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.updatePatient",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "patient/update"})
        }
      """
    )
  
    // @LINE:13
    def pagePatient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.pagePatient",
      """
        function(page0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "patient/page/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("page", page0))})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
