// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def returnMap: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "map")
    }
  
    // @LINE:17
    def deletePatient: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "patient/delete")
    }
  
    // @LINE:12
    def jmlPagePatient: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "patient/page")
    }
  
    // @LINE:11
    def getPatient: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "patient")
    }
  
    // @LINE:14
    def getItemPatient(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "patient/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:8
    def listNama: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "nama")
    }
  
    // @LINE:15
    def addPatient: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "patient")
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:16
    def updatePatient: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "patient/update")
    }
  
    // @LINE:13
    def pagePatient(page:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "patient/page/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("page", page)))
    }
  
  }

  // @LINE:20
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
