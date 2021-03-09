async function displayString() {
    const response = await fetch('/hardString');
    const responseJson = await response.json();
    // This gets a random index, from the function below
    let index = randomIndex();
    const greetingContainer = document.getElementById('message-server');
    greetingContainer.innerText = responseJson[index];
}

function randomIndex(){
    return Math.floor(Math.random() * 5);
}