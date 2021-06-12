const loginButton = document.getElementById('login-form-button'); // select elements from the DOM
const appRoot = document.getElementById('app-root');
const usernameInputField = document.getElementById('login-form-field-username');
const passwordInputField = document.getElementById('login-form-field-password');
const appStyleLink = document.getElementById('app-style');


loginButton.addEventListener('click', login); // add functionality to elements

function login() {
    let usernameValue = usernameInputField.value;
    let passwordValue = passwordInputField.value;
    console.log(`Logging in with credentials: ${usernameValue} ${passwordValue}`); // template literals (interpolation)
    

    // doing this to simulate us talking to some API...
    setTimeout(() => {
        console.log('My fake login is done!');

        // print the username to the page
    
        // Create a paragraph tag and set its inner text to our provided username
        let pTag = document.createElement('p');
        pTag.innerText = 'Logged in: ' + usernameValue;

        // Attach the dynamically created paragraph element to the div we have referenced
        appRoot.append(pTag);

        renderDashboard();

    }, 3000); // timeout value is in milliseconds
    
}

loginButton.addEventListener('mouseover', () => {
    console.log('User is hovering over the login button');
});

usernameInputField.addEventListener('keyup', () => {
    if (usernameInputField.value.length > 3) {
        console.log(usernameInputField.value);
    }
});

function renderDashboard() {
    let dashboardTemplate = `
    <div id="dashboard">
        <h1>Dashboard works!</h1>
    </div>
    `;

    appRoot.innerHTML = dashboardTemplate;

    // if you wanted to change the styling on this new view, simply target an existing 
    // stylesheet link (found in the head) and change the css file it points to
    // OR
    // simply add a new link to the head (if you wanted to keep the original styles and
    // add some new ones)
    appStyleLink.href = "other-style.css";
}