$( "#search-form" ).submit(function(event){
    event.preventDefault();
});

var storeResults = $( "#store-results" );
$( "#search" ).on( "click", function(event) {
    storeResults.html($('<table>').addClass('table'));
    $.ajax({
        url: "/api/compare",
        data: {
            country: $( "#country" ).val(),
            term: $( "#term" ).val()
        },
        success: function( result ) {
            //$( "#weather-temp" ).html( "<strong>" + result + "</strong> degrees" );
            var size = result.itunes.length;
            var i = 0;
            var appResult;
            var table = $('<table>').addClass('table');
            var tr, td;
            for (i = 0; i < size; i++) {
                tr = $('<tr>');
                td = $('<td>');
                td.text(i + 1);
                tr.append(td);

                td = $('<td style="font-size: x-small;">');
                // add property: artworkUrl60   (url to display)
                // add property: trackViewUrl  (link to spp store)
                td.html(
                    '<a href="' + result.itunes[i].trackViewUrl + '">' +
                    '<img src="' + result.itunes[i].artworkUrl60 + '" /> ' +
                    result.itunes[i].trackName + "</a><br/>" + result.itunes[i].description
                );
                tr.append(td);
                table.append(tr);
            }
            storeResults.html(table);
        }
    });
});
