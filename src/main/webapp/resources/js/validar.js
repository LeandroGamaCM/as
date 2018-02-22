//script para ativar o site quando o javascript estiver ativado
function removerClass1() {
   var element = document.getElementById("scriptT");
   element.classList.remove("layout");
}
function removerClass2() {
   var element = document.getElementById("scriptD");
   element.classList.remove("layout");
}
function removerClass3() {
   var element = document.getElementById("scriptR");
   element.classList.remove("layout");
}
function removerClass4() {
   var element = document.getElementById("scriptE");
   element.classList.remove("layout");
}
function removerClass5() {
   var element = document.getElementById("scriptC");
   element.classList.remove("layout");
}

//formulario de login
function validarLogin() {
    var cpf = document.getElementById('cpfLogin');
    var senha = document.getElementById('senhaLogin');

    if (cpf.value === '') {
        cpf.focus();
        return false;

    } else if (senha.value === '') {
        senha.focus();
        return false;
    } else {
        return true;
    }
}﻿

//formulario de recuperacao de senha
function validarRecu() {
    var cpf = document.getElementById('cpfRecuperar');

    if (cpf.value === '') {
        cpf.focus();
        return false;
    } else{
        return true;
    }
}﻿

//permite apenas letras no campo nome
function letras(e){
    var expressao;
    expressao = /[0-9]/;

    if(expressao.test(String.fromCharCode(e.keyCode)))
    {
        return false;
    }
    else
    {
        return true;
    }
}
//permite apenas numeros no campo rg
function numeros(e){
    var expressao;
    expressao = /[a-z]/;

    if(expressao.test(String.fromCharCode(e.keyCode)))
    {
        return false;
    }
    else
    {
        return true;
    }
}

//formulario de cadastro de usuarios
function validar() {
    var nome = document.getElementById('inputNome');
    var cpf = document.getElementById('inputCPF');
    var email = document.getElementById('inputEmail');
    var senha = document.getElementById('inputSenha');
    var confirmar = document.getElementById('inputCsenha');

    if (nome.value === '') {
        nome.focus();
        return false;
        
    } else if (cpf.value === '') {
        cpf.focus();
        return false;
        
    } else if (email.value === '') {
        email.focus();
        return false;
        
    } else if (senha.value === '') {
        senha.focus();
        return false;   
        
    } else if (senha.value.length < 6){
        senha.focus();
        alert('Informe uma senha com no mínimo 6 caracteres.');
        return false;
        
    } else if (confirmar.value === '') {
        confirmar.focus();;
        return false;    
        
    } else if (senha.value !== confirmar.value) {
        alert('Ops... As senhas não conferem! Reescreva corretamente.');
        confirmar.focus();
        return false;
    }
    else{        
        return true;
        nome.value = "";
        cpf.value = "";
        email.value = "";
        senha.value = "";
        confirmar.value = "";
    }
    
}

//formulário confirma login
function validarConfirma(){
    var cod = document.getElementById('codConfirmacao');
    cod.value = "";
}

//formulario de cadastro de administradores
function validarAdm() {
    var nome = document.getElementById('nomeAdm');
    var cpf = document.getElementById('cpfAdm');
    var email = document.getElementById('emailAdm');
    var senha = document.getElementById('senhaAdm');
    var confirmar = document.getElementById('confirmaAdm');

    if (nome.value === '') {
        nome.focus();
        return false;
        
    } else if (cpf.value === '') {
        cpf.focus();
        return false;
        
    } else if (email.value === '') {
        email.focus();
        return false;
        
    } else if (senha.value === '') {
        senha.focus();
        return false;    
        
    } else if (senha.value.length < 6){
        senha.focus();
        alert('Informe uma senha com no mínimo 6 caracteres.');
        return false;
        
    } else if (confirmar.value === '') {
        confirmar.focus();;
        return false;    
        
    } else if (senha.value !== confirmar.value) {
        alert('Ops... As senhas não conferem! Reescreva corretamente.');
        confirmar.focus();
        return false;
    }
    else{
        alert('Cadastro realizado com sucesso!');
        return true;
    }
    
}

//valida formulario de inscricao
function onnext(){
    //função chamar o topo da tela
    $('html, body').animate({scrollTop:0}, 'medium');
    
    //validar formulário
//  if ($(".tab1").hasClass("ui-state-highlight")) {
//      var nome = document.getElementById('nome');
//      var cpf = document.getElementById('cpf');
//      
//      if(nome.value === ''){
//        alert('Por favor, preencha o campo Nome!');
//        nome.focus;
//        return false;
//    }
//    else if(cpf.value === ''){
//        alert('Por favor, preencha o campo CPF!');
//        cpf.focus;
//        return false;
//    }
//    else{       
//        return true;
//    }
// 
//    }
}

//botao voltar do wizard
function onback(){
    //função chamar o topo da tela
    $('html, body').animate({scrollTop:0}, 'medium');
}
