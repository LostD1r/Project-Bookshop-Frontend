function changeColorLogin(){
    document.getElementById('auth-method-button-login').style.background = 'none';
    document.getElementById('auth-method-button-login').style.color = 'white';
    document.getElementById('auth-method-button-login').style.border = '1px solid #615e5e';
    document.getElementById('auth-method-button-registry').style.background = 'white';
    document.getElementById('auth-method-button-registry').style.color = 'black';
    document.getElementById('auth-method-button-registry').style.border = 'none';
    document.getElementById('login-input-registry').type = 'text';
    document.getElementById('email-input-registry').type = 'email';
    document.getElementById('password-input-registry').type = 'password';
    document.getElementById('password-reinput-registry').type = 'password';
    document.getElementById('login-input-login').type = 'hidden';
    document.getElementById('password-input-login').type = 'hidden';
    document.getElementById('submit-form-login').style.visibility = 'hidden';
    document.getElementById('submit-form-registry').style.visibility = 'visible';
    document.getElementById('submit-form-login').style.transition = 'none';
    document.getElementById('submit-form-registry').style.transition = '0.4s';
    window.history.pushState('login-page', 'Title', '/registration');
}

function changeColorRegistry(){
    document.getElementById('auth-method-button-registry').style.background = 'none';
    document.getElementById('auth-method-button-registry').style.color = 'white';
    document.getElementById('auth-method-button-registry').style.border = '1px solid #615e5e';
    document.getElementById('auth-method-button-login').style.background = 'white';
    document.getElementById('auth-method-button-login').style.color = 'black';
    document.getElementById('auth-method-button-login').style.border = 'none';
    document.getElementById('login-input-registry').type = 'hidden';
    document.getElementById('email-input-registry').type = 'hidden';
    document.getElementById('password-input-registry').type = 'hidden';
    document.getElementById('password-reinput-registry').type = 'hidden';
    document.getElementById('login-input-login').type = 'text';
    document.getElementById('password-input-login').type = 'password';
    document.getElementById('submit-form-login').style.visibility = 'visible';
    document.getElementById('submit-form-registry').style.visibility = 'hidden';
    document.getElementById('submit-form-login').style.transition = '0.4s';
    document.getElementById('submit-form-registry').style.transition = 'none';
    window.history.pushState('login-page', 'Title', '/login-page');
}