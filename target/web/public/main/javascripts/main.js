
pagePatient()
jmlPagePatient()

function pagePatient(id=1) {
    $("tbody").html('<tr id="duwur"></tr>')
    $.ajax({
        url: "http://0.0.0.0:9000/patient/page/"+id,
        contentType: "application/json",
        dataType: 'json',
        method: 'GET',
        success: function(result) {
            var obj = result.patient;
            obj.forEach((item) => {
                $("#duwur").after('<tr>'
                +'<th scope="row">'+item.patient_id+'</th>'
                +'<td>'+item.city.city_name+'</td>'
                +'<td>'+item.patient_name+'</td>'
                +'<td>'+genderString(item.gender)+'</td>'
                +'<td>'+dateFormat(new Date(item.date_birth), "dd-mm-yyyy") +'</td>'
                +'<td>'+item.address+'</td>'
                    +'<td><button type="button" onclick="getPatient('+item.patient_id+','+item.city_id+',\''+item.patient_name+'\',\''+item.gender+'\','+item.date_birth+',\''+item.address+'\')" data-bs-toggle="modal" data-bs-target="#updateModel" class="btn btn-primary btn-sm">Edit</button>'
                    +'&nbsp;<button type="button" onclick="deleteItem('+item.patient_id+')" class="btn btn-danger btn-sm">Delete</button></td>'
                +'</tr>');
            });
        }
    });
}

function jmlPagePatient(){
    $.ajax({
        url: "http://0.0.0.0:9000/patient/page",
        method: 'GET',
        success: function(result) {

            var jml = result|0;
            for (let i = 1; i <= jml; i++){
                console.log(i)
                $("#pagination").before(
                    '<div class="btn-group" onclick="pagePatient('+i+')" role="group" aria-label="Basic radio toggle button group">'+
                        '<input type="radio" class="btn-check" name="btnradio" autocomplete="off">'+
                        '<label class="btn btn-outline-primary" for="btnradio1">'+i+'</label>'+
                    '</div>'
                )
            }
        }
    });
}

function genderString(gender){
    if (gender == "l"){
        return "Laki-laki";
    } else {
        return "Perempuan";
    }
}

function getPatient(id,city,name,gender,birth,address){
    console.log("getItem");
    document.getElementById("patient-id").value = id;
    document.getElementById("patient-name-edit").value = name;
    document.getElementById("city-id-edit").value = city;
    document.getElementById("gender-edit").value = gender;
    document.getElementById("date-birth-edit").value = dateFormat(birth, "yyyy-mm-dd");
    document.getElementById("address-edit").value = address;
}

function addItem() {

    var city_id = document.getElementById("city-id").value|0;
    var patient_name = document.getElementById("patient-name").value;
    var gender = document.getElementById("gender").value;
    var date_birth = document.getElementById("date-birth").value;
    var address = document.getElementById("address").value;

    var patient = {
        "city_id" : city_id,
        "patient_name" : patient_name,
        "gender" : gender,
        "date_birth" : date_birth,
        "address" : address
    }

    $.ajax({
        url: "/patient",
        method: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(patient),
        complete: function(){
            document.location.reload();
        }
    });
}

function updateItem() {
    var patient_id = document.getElementById("patient-id").value|0;
    var city_id = document.getElementById("city-id-edit").value|0;
    var patient_name = document.getElementById("patient-name-edit").value;
    var gender = document.getElementById("gender-edit").value;
    var date_birth = document.getElementById("date-birth-edit").value;
    var address = document.getElementById("address-edit").value;

    var patient = {
        "patient_id" : patient_id,
        "city_id" : city_id,
        "patient_name" : patient_name,
        "gender" : gender,
        "date_birth" : date_birth,
        "address" : address
    }

    console.log(JSON.stringify(patient))

    $.ajax({
        url: "/patient/update",
        method: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(patient),
        complete: function(){
            document.location.reload();
        }
    });
}

function deleteItem(id) {

    var json = {
        "patient_id": id
    }

    $.ajax({
        url: "/patient/delete",
        method: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(json),
        complete: function(){
            document.location.reload();
        }
    });
}


