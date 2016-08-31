var jokeCount;

function getJokeCount() {
        $.ajax({
                   url: "http://localhost:8080/api/v1/jokes/"
               }).then(function(data) {
                jokeCount = parseInt(data.page.totalElements);
            console.log("Joke count is", jokeCount);
        });
};


// returns a random number including the min and max
function getRandomNumber() {
    min = 1;
    //TODO Need to use count from API instead of hardcoded max
    max = 21;
    return Math.floor(Math.random() * (max - min + 1) ) + min;
};

function getRandomJoke() {
    var jokeId = getRandomNumber();
    $.ajax({
             url: "http://localhost:8080/api/v1/jokes/" + jokeId
           }).then(function(data) {
        $('.joke-rank').append(data.rank);
        $('.joke-content').append(data.content);
    });
}

getRandomJoke();
