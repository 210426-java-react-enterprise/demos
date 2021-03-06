(function() {
    document.getElementById('login-form-button').addEventListener('click', login);
    window.history.pushState('login', 'Login', '/login.html');
})();

function login() {
    let providedUsername = document.getElementById('login-form-field-username').value;
    let providedPassword = document.getElementById('login-form-field-password').value;
    
    if (providedUsername && providedPassword) {

        let credentials = {
            username: providedUsername,
            password: providedPassword
        };

        let credentialsJSON = JSON.stringify(credentials);

        // AJAX = Asynchronous JavaScript And XML (even though it supports JSON)
        // Based around an object called: XMLHttpRequest (XHR)
        let xhr = new XMLHttpRequest();
        xhr.open('POST', `${API_ROOT}/auth`);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(credentialsJSON);

        // The XHR object has a value/field called a "ready state"
        // There are 5 ready states in total, learn more here: https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {

                let authenticatedUser = JSON.parse(xhr.responseText);
                loggedInUser = authenticatedUser;
                render('dashboard');

            } else if (xhr.status != 200) {
                printErrorToPage('Invalid credentials provided!');
            }
        }

    } else {
        printErrorToPage('You need to provide a username and a password!');
    }

}

function printErrorToPage(errorMsg) {
    
    let errorEl = document.getElementById('error-msg');

    if (!errorEl) {
        errorEl = document.createElement('p');
        errorEl.id = 'error-msg';
        errorEl.style.color = 'red';
        document.getElementById('login-form').append(errorEl);
    }

    errorEl.innerText = errorMsg;
    
}