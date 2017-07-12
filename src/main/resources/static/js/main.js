$(document).ready(function () {
    var station = [];
    var event_type = [];
    // Traigo todas las estaciones
    $.ajax({
        url: "/station",
        type: "GET"
    }).done(function (data) {
        console.log(data);
        station = data;
        $.each(data, function(id,value){
            $("#station_id").append('<option name="station" value="'+value.station+'">'+value.station+'</option>');
        });
    });

    // Traigo todos los tipos de evento
    $.ajax({
        url: "/eventtype",
        type: "GET"
    }).done(function (data) {
        console.log(data);
        event_type = data;
        $.each(data, function(id,value){
            $("#eventtype_id").append('<option name="eventType" value="'+value.description+'">'+value.description+'</option>');
        });
    });

    $("#submit").click(function(){
        var url = "/event";
        $.ajax({
            url: url,
            type: "POST",
            data: $("#subterrorForm").serialize(),
            success: function(data){
                console.log(data);
                debugger;
            },
            error: function (jqXHR, exception) {
                var msg = '';
                if (jqXHR.status === 0) {
                    msg = 'Not connect.\n Verify Network.';
                } else if (jqXHR.status == 404) {
                    msg = 'Requested page not found. [404]';
                } else if (jqXHR.status == 500) {
                    msg = 'Internal Server Error [500].';
                } else if (exception === 'parsererror') {
                    msg = 'Requested JSON parse failed.';
                } else if (exception === 'timeout') {
                    msg = 'Time out error.';
                } else if (exception === 'abort') {
                    msg = 'Ajax request aborted.';
                } else {
                    msg = 'Uncaught Error.\n' + jqXHR.responseText;
                }
                console.log(msg);
                console.log(jqXHR);
                debugger
            }
        });
    });

    $.ajax({
        url: "/event",
        type: "GET"
    }).done(function(response){
        console.log(response);


    });
});