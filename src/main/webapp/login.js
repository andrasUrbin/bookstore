function onLoginAsCustomerClicked(){
    clearMessages();
    showContents(['login-content-customer'])
}

function onLoginAsAdministratorClicked(){
    clearMessages();
    showContents(['login-content'])
}

function onProfileLoad(user) {
    clearMessages();
    showContents(['topnav-admin', 'main-content-admin']);
}

function onCustomerProfileLoad(user) {
    clearMessages();
    showContents(['topnav-customer', 'main-content-customer', 'books-content', 'cart-content']);
}

function onListBooksClicked() {
    const params = new URLSearchParams();
    const user = getAuthorization();

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onBooksResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/books');
    xhr.send();

}

function onLoginResponse() {
    if (this.status === OK) {
        const user = JSON.parse(this.responseText);
        setAuthorization(user);
        onProfileLoad(user);
    } else {
        onOtherResponse(loginContentDivEl, this);
    }
}

function onLoginButtonClicked() {
    const loginFormEl = document.forms['login-form'];

    const emailInputEl = loginFormEl.querySelector('input[name="email"]');
    const passwordInputEl = loginFormEl.querySelector('input[name="password"]');

    const email = emailInputEl.value;
    const password = passwordInputEl.value;

    const params = new URLSearchParams();
    params.append('email', email);
    params.append('password', password);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLoginResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'login');
    xhr.send(params);
}

function onLoginAsCustomerResponse() {
    if (this.status === OK) {
        const user = JSON.parse(this.responseText);
        setAuthorization(user);
        onCustomerProfileLoad(user);
    } else {
        onOtherResponse(loginContentDivEl, this);
    }
}

function onLoginAsCustomerButtonClicked() {
    const loginFormEl = document.forms['login-form-customer'];

    const emailInputEl = loginFormEl.querySelector('input[name="email"]');
    const passwordInputEl = loginFormEl.querySelector('input[name="password"]');

    const email = emailInputEl.value;
    const password = passwordInputEl.value;

    const params = new URLSearchParams();
    params.append('email', email);
    params.append('password', password);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLoginAsCustomerResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'login-customer');
    xhr.send(params);
}
