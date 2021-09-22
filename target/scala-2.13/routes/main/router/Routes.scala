// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_0: controllers.HomeController,
  // @LINE:20
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:20
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """nama""", """controllers.HomeController.listNama"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """map""", """controllers.HomeController.returnMap"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """patient""", """controllers.HomeController.getPatient"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """patient/page""", """controllers.HomeController.jmlPagePatient"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """patient/page/""" + "$" + """page<[^/]+>""", """controllers.HomeController.pagePatient(page:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """patient/""" + "$" + """id<[^/]+>""", """controllers.HomeController.getItemPatient(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """patient""", """controllers.HomeController.addPatient"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """patient/update""", """controllers.HomeController.updatePatient"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """patient/delete""", """controllers.HomeController.deletePatient"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_listNama1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("nama")))
  )
  private[this] lazy val controllers_HomeController_listNama1_invoker = createInvoker(
    HomeController_0.listNama,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "listNama",
      Nil,
      "GET",
      this.prefix + """nama""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_returnMap2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("map")))
  )
  private[this] lazy val controllers_HomeController_returnMap2_invoker = createInvoker(
    HomeController_0.returnMap,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "returnMap",
      Nil,
      "GET",
      this.prefix + """map""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_getPatient3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("patient")))
  )
  private[this] lazy val controllers_HomeController_getPatient3_invoker = createInvoker(
    HomeController_0.getPatient,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getPatient",
      Nil,
      "GET",
      this.prefix + """patient""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_jmlPagePatient4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("patient/page")))
  )
  private[this] lazy val controllers_HomeController_jmlPagePatient4_invoker = createInvoker(
    HomeController_0.jmlPagePatient,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "jmlPagePatient",
      Nil,
      "GET",
      this.prefix + """patient/page""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_pagePatient5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("patient/page/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_pagePatient5_invoker = createInvoker(
    HomeController_0.pagePatient(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "pagePatient",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """patient/page/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_getItemPatient6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("patient/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getItemPatient6_invoker = createInvoker(
    HomeController_0.getItemPatient(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getItemPatient",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """patient/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_addPatient7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("patient")))
  )
  private[this] lazy val controllers_HomeController_addPatient7_invoker = createInvoker(
    HomeController_0.addPatient,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addPatient",
      Nil,
      "POST",
      this.prefix + """patient""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_updatePatient8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("patient/update")))
  )
  private[this] lazy val controllers_HomeController_updatePatient8_invoker = createInvoker(
    HomeController_0.updatePatient,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "updatePatient",
      Nil,
      "POST",
      this.prefix + """patient/update""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_deletePatient9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("patient/delete")))
  )
  private[this] lazy val controllers_HomeController_deletePatient9_invoker = createInvoker(
    HomeController_0.deletePatient,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deletePatient",
      Nil,
      "POST",
      this.prefix + """patient/delete""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:8
    case controllers_HomeController_listNama1_route(params@_) =>
      call { 
        controllers_HomeController_listNama1_invoker.call(HomeController_0.listNama)
      }
  
    // @LINE:9
    case controllers_HomeController_returnMap2_route(params@_) =>
      call { 
        controllers_HomeController_returnMap2_invoker.call(HomeController_0.returnMap)
      }
  
    // @LINE:11
    case controllers_HomeController_getPatient3_route(params@_) =>
      call { 
        controllers_HomeController_getPatient3_invoker.call(HomeController_0.getPatient)
      }
  
    // @LINE:12
    case controllers_HomeController_jmlPagePatient4_route(params@_) =>
      call { 
        controllers_HomeController_jmlPagePatient4_invoker.call(HomeController_0.jmlPagePatient)
      }
  
    // @LINE:13
    case controllers_HomeController_pagePatient5_route(params@_) =>
      call(params.fromPath[Int]("page", None)) { (page) =>
        controllers_HomeController_pagePatient5_invoker.call(HomeController_0.pagePatient(page))
      }
  
    // @LINE:14
    case controllers_HomeController_getItemPatient6_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_HomeController_getItemPatient6_invoker.call(HomeController_0.getItemPatient(id))
      }
  
    // @LINE:15
    case controllers_HomeController_addPatient7_route(params@_) =>
      call { 
        controllers_HomeController_addPatient7_invoker.call(HomeController_0.addPatient)
      }
  
    // @LINE:16
    case controllers_HomeController_updatePatient8_route(params@_) =>
      call { 
        controllers_HomeController_updatePatient8_invoker.call(HomeController_0.updatePatient)
      }
  
    // @LINE:17
    case controllers_HomeController_deletePatient9_route(params@_) =>
      call { 
        controllers_HomeController_deletePatient9_invoker.call(HomeController_0.deletePatient)
      }
  
    // @LINE:20
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
