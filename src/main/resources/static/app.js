var jokeCount;
var jokeId;

function getRandomJoke() {
        // get the total number of jokes from the API
        $.ajax({
                   url: "http://localhost:8080/api/v1/jokes/"
               }).then(function(data) {
                jokeCount = parseInt(data.page.totalElements);
                // get a random jokeId based on the total number of jokes
                var minimumId = 1;
                jokeId = Math.floor(Math.random() * (jokeCount - minimumId + 1 )) + minimumId;

                //get a random joke and update the DOM
                $.ajax({
                           url: "http://localhost:8080/api/v1/jokes/" + jokeId
                       }).then(function(data) {
                    $('.joke-rank').append(data.rank);
                    $('.joke-content').append(data.content);
                });
        });
}

getRandomJoke();
