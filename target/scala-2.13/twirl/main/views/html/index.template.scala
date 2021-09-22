
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
"""),format.raw/*4.1*/("""<div class="container">

  <!--  Tombol Modal-->
  <div class="center-button">

    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="getbootstrap">Add Data</button>

  </div>

  <!--  Tabel Data-->
  <table class="table table-striped table-hover">
    <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">City</th>
        <th scope="col">Name</th>
        <th scope="col">Gender</th>
        <th scope="col">Birth</th>
        <th scope="col">Address</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    <tbody>
      <tr id="duwur">
      </tr>
    </tbody>
  </table>

  <!--  Modal Form-->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" >Pasien Baru</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3">
              <label class="col-form-label">Nama Pasien</label>
              <input type="text" class="form-control" id="patient-name" required>
            </div>
            <div class="mb-3">
              <label class="col-form-label">City ID</label>
              <input type="text" class="form-control" id="city-id" required>
            </div>
            <div class="mb-3">
              <label class="col-form-label">Pilih Gender</label>
              <select class="form-select" aria-label="Default select example" id="gender" required>
                <option value="1">l</option>
                <option value="2">p</option>
              </select>
            </div>
            <div class="mb-3">
              <label class="col-form-label">Tanggal Lahir</label>
              <input type="date" class="form-control" id="date-birth" required>
            </div>
            <div class="mb-3">
              <label class="col-form-label">Alamat</label>
              <input type="text" class="form-control" id="address" required>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Batalkan</button>
          <button type="button" onclick="addItem()" class="btn btn-primary">Tambah Data</button>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="updateModel" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" >Pasien Update</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3">
              <label class="col-form-label">ID Pasien</label>
              <input type="text" class="form-control" disabled id="patient-id">
            </div>
            <div class="mb-3">
              <label class="col-form-label">Nama Pasien</label>
              <input type="text" class="form-control" id="patient-name-edit" required>
            </div>
            <div class="mb-3">
              <label class="col-form-label">City ID</label>
              <input type="text" class="form-control" id="city-id-edit" required>
            </div>
            <div class="mb-3">
              <label class="col-form-label">Pilih Gender</label>
              <select class="form-select" aria-label="Default select example" id="gender-edit" required>
                <option value="l">Laki-laki</option>
                <option value="p">Perempuan</option>
              </select>
            </div>
            <div class="mb-3">
              <label class="col-form-label">Tanggal Lahir</label>
              <input type="date" class="form-control" id="date-birth-edit" required>
            </div>
            <div class="mb-3">
              <label class="col-form-label">Alamat</label>
              <input type="text" class="form-control" id="address-edit" required>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Batalkan</button>
          <button type="button" id="update-btn" onclick="updateItem()" class="btn btn-primary">Update Data</button>
        </div>
      </div>
    </div>
  </div>

  <div class="w-100 text-center">
    <div id="pagination"></div>

  </div>


</div>



""")))}),format.raw/*130.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: e79caca31d9af9c038c548bdad803d0055acfdb7
                  MATRIX: 722->1|818->4|845->6|876->29|915->31|942->32|5700->4759
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|154->130
                  -- GENERATED --
              */
          