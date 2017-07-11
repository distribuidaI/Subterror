$(document).ready(function () {
    // Traigo todas las estaciones
    $.ajax({
        url: "/station",
        type: "GET"
    }).done(function (data) {
        console.log(data);
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
            error: function (error) {
                console.log(error);
                debugger;
            }
        });
    })
});