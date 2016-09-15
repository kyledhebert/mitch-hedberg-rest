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
                console.log(data);
                $.each(data._embedded, function (i, item) {
                    if ($.isEmptyObject(item)) {
                        html += "<p>No jokes matched your term. Please search again.</p>"
                    }
                    $.each(item, function (j, joke) {
                        html += "<div class='card-panel'>";
                        html += "<p>" + joke.content + "</p>";
                        html += "<p>Rank " + joke.rank + "</p>";
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

$(document).ready(function () {
    $('#new-joke-button').click(function () {
        $('.joke-rank').empty();
        $('.joke-content').empty();
        getRandomJoke();
    });
});

getRandomJoke();

