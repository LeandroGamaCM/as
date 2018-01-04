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
        alert('Ops! A senha não confere.');
        confirmar.focus();
        return false;
    }

    alert("Ok! Seu formulário esta válido! (:");
    return true;
}

function valida(){
    var nome = document.getElementById('nome');
    
    if(nome.value === ''){
        alert('Deu erro');
        return false;
    }
    return true;
}