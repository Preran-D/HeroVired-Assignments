let countdownValue = 5;
let countdownInterval;

function startCountdown() {
    document.getElementById('startButton').disabled = true;
    document.getElementById('replayButton').disabled = true;

    countdownInterval = setInterval(() => {
        if (countdownValue > 0) {
            document.getElementById('countdown').innerText = countdownValue;
            countdownValue--;
        } else {
            document.getElementById('countdown').innerText = 'GO!';
            clearInterval(countdownInterval);
            document.getElementById('replayButton').disabled = false;
        }
    }, 1000);
}

function resetCountdown() {
    countdownValue = 5;
    document.getElementById('countdown').innerText = '';
    document.getElementById('replayButton').disabled = true;
    document.getElementById('startButton').disabled = false;
}
