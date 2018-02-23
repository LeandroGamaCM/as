var submenu = function () {
    var sub_menu = document.querySelector("#animado");
    
    this.acionar = function () {
        sub_menu.classList.toggle('submenu');
        return false;
    };
};

var submenu2 = function () {
    var sub_menu2 = document.querySelector("#respAnimado");
    var sub_menu3 = document.querySelector("#respAnimado2");
    
    this.acionar = function () {
        sub_menu2.classList.toggle('topbar-menu-active');
        sub_menu2.classList.toggle('fadeInDown');
        sub_menu3.classList.toggle('active-topmenuitem');
        return false;
    };
};
