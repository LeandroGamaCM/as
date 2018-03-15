function pre(i){
 
   if(i == 1)  {
      var pre_src = '<div class="rect1"></div>'
      +'<div class="rect2"></div>'
      +'<div class="rect3"></div>'
      +'<div class="rect4"></div>'
      +'<div class="rect5"></div>';
      
      var div = document.createElement("div");
      div.setAttribute("class","preloader");
      document.body.appendChild(div);
      document.body.querySelector(".preloader").innerHTML = pre_src;
   }else{
      document.body.querySelector(".preloader").outerHTML = '';
   }
}

