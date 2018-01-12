//formulário de cadastro de usuários
function validar() {
    var nome = document.getElementById('inputNome');
    var cpf = document.getElementById('inputCPF');
    var senha = document.getElementById('inputSenha');
    var confirmar = document.getElementById('inputCsenha');

    if (nome.value === '' || cpf.value === '' || senha.value === '' || confirmar.value === '') {
        alert('Por favor, preencha todos os campos!');
        return false;
    } else if (senha.value !== confirmar.value) {
        alert('Ops! As senhas não conferem.');
        confirmar.focus();
        return false;
    }

    return true;
}

//valida formulário de inscrição
function onnext(){
//    var nome = document.getElementById('nome');
//    var cpf = document.getElementById('cpf');
//    
//    if(nome.value === ''){
//        alert('Por favor, preencha o campo Nome!');
//        nome.focus;
//        return false;
//    }
//    else if(cpf.value === ''){
//        alert('Por favor, preencha o campo CPF!');
//        cpf.focus;
//        return false;
//    }
//    
//    return true;
    
    //função chamar o topo da tela
    $('html, body').animate({scrollTop:0}, 'medium');
}
function onback(){
    $('html, body').animate({scrollTop:0}, 'medium');
}