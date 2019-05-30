var stompClient = null;

function connectWebSocket() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/api/projet/instalMod', function (greeting) {
            showGreeting(greeting.body);
        });
    });
}

function disconnectWebSocket() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
    alert("Disconnected success");
}

function showGreeting(message) {
    $("#log-container div").append(message);
    // Scroll the bar to the bottom
    $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
}
