
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("bootstrap/css/bootstrap.css")),format.raw/*14.108*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.versioned("images/favicon.png")),format.raw/*15.104*/("""">

    </head>
    <body>
        """),format.raw/*20.32*/("""
        """),_display_(/*21.10*/content),format.raw/*21.17*/("""

        """),format.raw/*23.9*/("""<script src=""""),_display_(/*23.23*/routes/*23.29*/.Assets.versioned("bootstrap/js/bootstrap.js")),format.raw/*23.75*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*24.23*/routes/*24.29*/.Assets.versioned("javascripts/jquery.js")),format.raw/*24.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/date.format.js")),format.raw/*25.76*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*26.23*/routes/*26.29*/.Assets.versioned("javascripts/main.js")),format.raw/*26.69*/("""" type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: a9ef53b242ec99a5454c1be5b3d2995934fad683
                  MATRIX: 987->260|1111->291|1138->292|1218->397|1254->406|1289->414|1315->419|1404->481|1419->487|1489->535|1577->596|1592->602|1653->641|1716->766|1753->776|1781->783|1818->793|1859->807|1874->813|1941->859|2025->916|2040->922|2103->964|2187->1021|2202->1027|2270->1074|2354->1131|2369->1137|2430->1177
                  LINES: 26->7|31->8|32->9|35->12|36->13|36->13|36->13|37->14|37->14|37->14|38->15|38->15|38->15|42->20|43->21|43->21|45->23|45->23|45->23|45->23|46->24|46->24|46->24|47->25|47->25|47->25|48->26|48->26|48->26
                  -- GENERATED --
              */
          