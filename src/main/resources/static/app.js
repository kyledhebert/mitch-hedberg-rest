var jokeCount;
var jokeId;

function getRandomJoke() {
    // get the total number of jokes from the API
    $.ajax({
               url: "http://localhost:8080/api/v1/jokes/"
           }).then(function (data) {
        jokeCount = parseInt(data.page.totalElements);
        // get a random jokeId based on the total number of jokes
        var minimumId = 1;
        jokeId = Math.floor(Math.random() * (jokeCount - minimumId + 1 )) + minimumId;

        //get a random joke and update the DOM
        $.ajax({
                   url: "http://localhost:8080/api/v1/jokes/" + jokeId
               }).then(function (data) {
            $('.joke-rank').append("Rank " + data.rank);
            $('.joke-content').append(data.content);
        });
    });
}

// gets a list of jokes based on a search term
$(document).ready(function () {
    var searchTerm;
    // get search term on Enter key press
    $('#search-term').keydown(function (e) {
        var key = e.which;
        if (key == 13) { // 13 = Enter
            searchTerm = $('#search-term').val();
            var url = 'http://localhost:8080/api/v1/jokes/search/containsWord?word=' + searchTerm;
            $.getJSON(url, function (data) {
                var html = "";
                $.each(data._embedded, function (i, item) {
                    if ($.isEmptyObject(item)) {
                        html += "<p>No jokes matched your term. Please search again.</p>"
                    }
                    $.each(item, function (j, joke) {
                        html += "<div class='card-panel'>";
                        html += "<p class='flow-text'>" + joke.content + "</p>";
                        html += "<p class='flow-text'>Rank " + joke.rank + "</p>";
                        html += "</div>";
                    })
                });

                $('.joke').empty();
                $('.joke-button').empty();
                $('#jokes').html(html);
            })
        }
    });
});

// get the top five jokes
function getTopFiveJokes() {
    var url = 'http://localhost:8080/api/v1/jokes/search/getTopFive'
    $.getJSON(url, function (data) {
        var html = "";
        $.each(data._embedded, function (i, item) {
            $.each(item, function (j, joke) {
                html += "<div class='card-panel'>";
                html += "<p class='flow-text'>" + joke.content + "</p>";
                html += "<p class ='flow-text'>Rank " + joke.rank + "</p>";
                html += "</div>";
            })
        });

        $('.joke').empty();
        $('.joke-button').empty();
        $('#jokes').html(html);


    })
};

$(document).ready(function () {
    $('#new-joke-button').click(function () {
        $('.joke-rank').empty();
        $('.joke-content').empty();
        getRandomJoke();
    });
    $('#top-five').click(function () {
        $('#search-term').val("");
        getTopFiveJokes();
    })
});

getRandomJoke();

