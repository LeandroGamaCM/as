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
    
    var element1 = document.getElementById("cpfLogin");
    var element2 = document.getElementById("senhaLogin");
    
    if(element1.value !== ''){
        element1.classList.add("ui-state-filled");
    }
    if(element2.value !== ''){
        element2.classList.add("ui-state-filled");
    }
}
function removerClass5() {
    var element = document.getElementById("scriptC");
    element.classList.remove("layout");
    
    var element1 = document.getElementById("inputNome");
    var element2 = document.getElementById("inputCPF");
    var element3 = document.getElementById("inputEmail");

    if(element1.value !== ''){
        element1.classList.add("ui-state-filled");
    }
    if(element2.value !== ''){
        element2.classList.add("ui-state-filled");
    }
    if(element3.value !== ''){
        element3.classList.add("ui-state-filled");
    }
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
}
﻿

//formulário de perfil adm
        function validaPerfil() {
            var senha1 = document.getElementById('senha');

            if (senha1.value.length < 6) {
                senha1.focus();
                alert('Informe uma senha com no mínimo 6 caracteres.');
                return false;

            } else {
                return true;
            }
        }

//formulário de perfil aluno
function validaPerfilAluno() {
    var senha = document.getElementById('senha');

    if (senha.value.length < 6) {
        senha.focus();
        alert('Informe uma senha com no mínimo 6 caracteres.');
        return false;

    } else {
        return true;
    }
}

//formulario de recuperacao de senha
function validarRecu() {
    var cpf = document.getElementById('cpfRecuperar');

    if (cpf.value === '') {
        cpf.focus();
        return false;
    } else {
        return true;
    }
}
﻿

//permite apenas letras no campo nome
        function letras(e) {
            var expressao;
            expressao = /[0-9]/;

            if (expressao.test(String.fromCharCode(e.keyCode)))
            {
                return false;
            } else
            {
                return true;
            }
        }
//permite apenas numeros no campo rg
function numeros(e) {
    var expressao;
    expressao = /[a-zA-z;´~^~+*,]/;

    if (expressao.test(String.fromCharCode(e.keyCode)))
    {
        return false;
    } else
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

    } else if (senha.value.length < 6) {
        senha.focus();
        alert('Informe uma senha com no mínimo 6 caracteres.');
        return false;

    } else if (confirmar.value === '') {
        confirmar.focus();
        ;
        return false;

    } else if (senha.value !== confirmar.value) {
        alert('Ops... As senhas não conferem! Reescreva corretamente.');
        confirmar.focus();
        return false;
    } else {
        i = 1;
        if (i == 1) {
            var pre_src = '<div class="rect1"></div>'
                    + '<div class="rect2"></div>'
                    + '<div class="rect3"></div>'
                    + '<div class="rect4"></div>'
                    + '<div class="rect5"></div>';

            var div = document.createElement("div");
            div.setAttribute("class", "preloader");
            document.body.appendChild(div);
            document.body.querySelector(".preloader").innerHTML = pre_src;
        } else {
            document.body.querySelector(".preloader").outerHTML = '';
        }
        return true;

    }
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

    } else if (senha.value.length < 6) {
        senha.focus();
        alert('Informe uma senha com no mínimo 6 caracteres.');
        return false;

    } else if (confirmar.value === '') {
        confirmar.focus();
        ;
        return false;

    } else if (senha.value !== confirmar.value) {
        alert('Ops... As senhas não conferem! Reescreva corretamente.');
        confirmar.focus();
        return false;
    } else {
        alert('Cadastro realizado com sucesso!');
        return true;
    }

}

//valida formulario de inscricao
function onnext() {
    //função chamar o topo da tela
    $('html, body').animate({scrollTop: 0}, 'medium');

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
function onback() {
    //função chamar o topo da tela
    $('html, body').animate({scrollTop: 0}, 'medium');
}
