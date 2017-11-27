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
            var thead = table.append($('<thead></thead>'));
            var th, tr, td;
            for (i = 0; i < size; i++) {
                tr = $('<tr></tr>');
                th = $('<th></th>');
                th.text(i + 1);
                tr.append(th);
                td = $('<td></td>');
                // add property: artworkUrl60   (url to display)
                // add property: trackViewUrl  (link to spp store)
                td.html(
                    '<a href="' + result.itunes[i].trackViewUrl + '">' +
                    '<img src="' + result.itunes[i].artworkUrl60 + '" /> ' +
                    result.itunes[i].trackName + "</a> - " + result.itunes[i].description
                );
                tr.append(td);
                thead.append(tr);
            }
            storeResults.html(table);
        }
    });
});
