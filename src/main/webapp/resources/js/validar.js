//formulário de cadastro de usuários
function validar() {
    var nome = document.getElementById('inputNome');
    var cpf = document.getElementById('inputCPF');
    var senha = document.getElementById('inputSenha');
    var confirmar = document.getElementById('inputCsenha');

    if (nome.value === '') {
        nome.focus();
        return false;
        
    } else if (cpf.value === '') {
        cpf.focus();
        return false;
        
    } else if (senha.value === '') {
        senha.focus();
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

//valida formulário de inscrição
function onnext(){
    //função chamar o topo da tela
    $('html, body').animate({scrollTop:0}, 'medium');
    
    //validar formulário
  if ($(".tab1").hasClass("ui-state-highlight")) {
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
//    return true;
 
    }
}

//botão voltar do wizard
function onback(){
    //função chamar o topo da tela
    $('html, body').animate({scrollTop:0}, 'medium');
}

