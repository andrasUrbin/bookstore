function onRegistrationClicked(){
    clearMessages();
    showContents(['reg-content'])
}

function onRegistrationResponse() {
    if (this.status === OK) {
        showContents(['login-content-customer'])
    } else {
        onOtherResponse(registrationContentDivEl, this);
    }
}

function onRegistrationButtonClicked(){
    const regFormEl = document.forms['reg-form'];

    const emailInputEl = regFormEl.querySelector('input[name="email"]');
    const passwordInputEl = regFormEl.querySelector('input[name="password"]');
    const fullNameInputEl = regFormEl.querySelector('input[name="fullname"]');
    const addressInputEl = regFormEl.querySelector('input[name="address"]');


        const email = emailInputEl.value;
        const password = passwordInputEl.value;
        const fullName = fullNameInputEl.value;
        const address = addressInputEl.value;

        const params = new URLSearchParams();
        params.append('email', email);
        params.append('password', password);
        params.append('fullname', fullName);
        params.append('address', address);

        const xhr = new XMLHttpRequest();
        xhr.addEventListener('load', onLoginResponse);
        xhr.addEventListener('error', onNetworkError);
        xhr.open('POST', 'registration');
        xhr.send(params);
}
