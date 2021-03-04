async function displayString() {
    const response = await fetch('/hardString');
    const responseString = await response.text();

    const greetingContainer = document.getElementById('message-server');
    greetingContainer.innerText = responseString;

}