var resp = function () {
    var menuLateral = document.querySelector("#menu-lateral");
    var menuLateral2 = document.querySelector("#menu-lateral2");
    var menuLateral3 = document.querySelector("#menu-lateral3");
    var rodape = document.querySelector("#common");

    this.acionar = function () {
        menuLateral.classList.toggle('toggleMenu');
        menuLateral2.classList.toggle('toggleMenu2');
        menuLateral3.classList.toggle('toggleMenu3');
        rodape.classList.toggle('novoRodape');
        return false;
    };
};

var resp2 = function () {
    var menuLateral = document.querySelector("#menu-lateral");
    var menuLateral2 = document.querySelector("#btn-menu2");
    
    this.acionar = function () {
        menuLateral.classList.toggle('toggleMenu1');
        menuLateral2.classList.toggle('btn-menu2');
        return false;
    };
};


