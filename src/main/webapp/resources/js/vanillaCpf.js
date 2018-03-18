function cpfPre(){     
    !function(a,b){"function"==typeof define&&define.amd?define(b):a.VMasker=b()}(this,function(){var a="9",b="A",c="S",d=[8,9,16,17,18,36,37,38,39,40,91,92,93],e=function(a){for(var b=0,c=d.length;c>b;b++)if(a==d[b])return!1;return!0},f=function(a){return a=a||{},a={precision:a.hasOwnProperty("precision")?a.precision:2,separator:a.separator||",",delimiter:a.delimiter||".",unit:a.unit&&a.unit.replace(/[\s]/g,"")+" "||"",suffixUnit:a.suffixUnit&&" "+a.suffixUnit.replace(/[\s]/g,"")||"",zeroCents:a.zeroCents,lastOutput:a.lastOutput},a.moneyPrecision=a.zeroCents?0:a.precision,a},g=function(a){this.elements=a};g.prototype.unbindElementToMask=function(){for(var a=0,b=this.elements.length;b>a;a++)this.elements[a].lastOutput="",this.elements[a].onkeyup=!1,this.elements[a].onkeydown=!1,this.elements[a].value.length&&(this.elements[a].value=this.elements[a].value.replace(/\D/g,""))},g.prototype.bindElementToMask=function(a){for(var b=this,c=function(c){c=c||window.event;var d=c.target||c.srcElement;e(c.keyCode)&&setTimeout(function(){b.opts.lastOutput=d.lastOutput,d.value=h[a](d.value,b.opts),d.lastOutput=d.value,d.setSelectionRange&&b.opts.suffixUnit&&d.setSelectionRange(d.value.length,d.value.length-b.opts.suffixUnit.length)},0)},d=0,f=this.elements.length;f>d;d++)this.elements[d].lastOutput="",this.elements[d].onkeyup=c,this.elements[d].value.length&&(this.elements[d].value=h[a](this.elements[d].value,this.opts))},g.prototype.maskMoney=function(a){this.opts=f(a),this.bindElementToMask("toMoney")},g.prototype.maskNumber=function(){this.opts={},this.bindElementToMask("toNumber")},g.prototype.maskPattern=function(a){this.opts={pattern:a},this.bindElementToMask("toPattern")},g.prototype.unMask=function(){this.unbindElementToMask()};var h=function(a){if(!a)throw new Error("VanillaMasker: There is no element to bind.");var b="length"in a?a.length?a:[]:[a];return new g(b)};return h.toMoney=function(a,b){if(b=f(b),b.zeroCents){b.lastOutput=b.lastOutput||"";var c="("+b.separator+"[0]{0,"+b.precision+"})",d=new RegExp(c,"g"),e=a.toString().replace(/[\D]/g,"").length||0,g=b.lastOutput.toString().replace(/[\D]/g,"").length||0;a=a.toString().replace(d,""),g>e&&(a=a.slice(0,a.length-1))}var h=a.toString().replace(/[\D]/g,""),i=new RegExp("^(0|\\"+b.delimiter+")"),j=new RegExp("(\\"+b.separator+")$"),k=h.substr(0,h.length-b.moneyPrecision),l=k.substr(0,k.length%3),m=new Array(b.precision+1).join("0");k=k.substr(k.length%3,k.length);for(var n=0,o=k.length;o>n;n++)n%3===0&&(l+=b.delimiter),l+=k[n];if(l=l.replace(i,""),l=l.length?l:"0",!b.zeroCents){var p=h.length-b.precision,q=h.substr(p,b.precision),r=q.length,s=b.precision>r?b.precision:r;m=(m+q).slice(-s)}var t=b.unit+l+b.separator+m+b.suffixUnit;return t.replace(j,"")},h.toPattern=function(d,e){var f,g="object"==typeof e?e.pattern:e,h=g.replace(/\W/g,""),i=g.split(""),j=d.toString().replace(/\W/g,""),k=j.replace(/\W/g,""),l=0,m=i.length;for(f=0;m>f;f++){if(l>=j.length){if(h.length==k.length)return i.join("");break}i[f]===a&&j[l].match(/[0-9]/)||i[f]===b&&j[l].match(/[a-zA-Z]/)||i[f]===c&&j[l].match(/[0-9a-zA-Z]/)?i[f]=j[l++]:(i[f]===a||i[f]===b||i[f]===c)&&(i=i.slice(0,f))}return i.join("").substr(0,f)},h.toNumber=function(a){return a.toString().replace(/(?!^-)[^0-9]/g,"")},h});
            function inputHandler(masks, max, event) {
              var c = event.target;
              var v = c.value.replace(/\D/g, '');
              var m = c.value.length > max ? 1 : 0;
              VMasker(c).unMask();
              VMasker(c).maskPattern(masks[m]);
              c.value = VMasker.toPattern(v, masks[m]);
            }
            
            function limpaCampo(event) {
                var value = event.target.value;                
                //<![CDATA[
                    if (value.length < 14) {
                        event.target.value = '';
                        this.classList.remove('ui-state-filled');
                    }
                //]]>
            }
                      
            var docMask = ['999.999.999-99'];
            var cpf = document.querySelector('#cpfP');
            
            VMasker(cpf).maskPattern(docMask[0]);
                        
            cpf.addEventListener('input', inputHandler.bind(undefined, docMask, 15), false);
            
            cpf.addEventListener('blur', limpaCampo);
}
function celpad(){     
    !function(a,b){"function"==typeof define&&define.amd?define(b):a.VMasker=b()}(this,function(){var a="9",b="A",c="S",d=[8,9,16,17,18,36,37,38,39,40,91,92,93],e=function(a){for(var b=0,c=d.length;c>b;b++)if(a==d[b])return!1;return!0},f=function(a){return a=a||{},a={precision:a.hasOwnProperty("precision")?a.precision:2,separator:a.separator||",",delimiter:a.delimiter||".",unit:a.unit&&a.unit.replace(/[\s]/g,"")+" "||"",suffixUnit:a.suffixUnit&&" "+a.suffixUnit.replace(/[\s]/g,"")||"",zeroCents:a.zeroCents,lastOutput:a.lastOutput},a.moneyPrecision=a.zeroCents?0:a.precision,a},g=function(a){this.elements=a};g.prototype.unbindElementToMask=function(){for(var a=0,b=this.elements.length;b>a;a++)this.elements[a].lastOutput="",this.elements[a].onkeyup=!1,this.elements[a].onkeydown=!1,this.elements[a].value.length&&(this.elements[a].value=this.elements[a].value.replace(/\D/g,""))},g.prototype.bindElementToMask=function(a){for(var b=this,c=function(c){c=c||window.event;var d=c.target||c.srcElement;e(c.keyCode)&&setTimeout(function(){b.opts.lastOutput=d.lastOutput,d.value=h[a](d.value,b.opts),d.lastOutput=d.value,d.setSelectionRange&&b.opts.suffixUnit&&d.setSelectionRange(d.value.length,d.value.length-b.opts.suffixUnit.length)},0)},d=0,f=this.elements.length;f>d;d++)this.elements[d].lastOutput="",this.elements[d].onkeyup=c,this.elements[d].value.length&&(this.elements[d].value=h[a](this.elements[d].value,this.opts))},g.prototype.maskMoney=function(a){this.opts=f(a),this.bindElementToMask("toMoney")},g.prototype.maskNumber=function(){this.opts={},this.bindElementToMask("toNumber")},g.prototype.maskPattern=function(a){this.opts={pattern:a},this.bindElementToMask("toPattern")},g.prototype.unMask=function(){this.unbindElementToMask()};var h=function(a){if(!a)throw new Error("VanillaMasker: There is no element to bind.");var b="length"in a?a.length?a:[]:[a];return new g(b)};return h.toMoney=function(a,b){if(b=f(b),b.zeroCents){b.lastOutput=b.lastOutput||"";var c="("+b.separator+"[0]{0,"+b.precision+"})",d=new RegExp(c,"g"),e=a.toString().replace(/[\D]/g,"").length||0,g=b.lastOutput.toString().replace(/[\D]/g,"").length||0;a=a.toString().replace(d,""),g>e&&(a=a.slice(0,a.length-1))}var h=a.toString().replace(/[\D]/g,""),i=new RegExp("^(0|\\"+b.delimiter+")"),j=new RegExp("(\\"+b.separator+")$"),k=h.substr(0,h.length-b.moneyPrecision),l=k.substr(0,k.length%3),m=new Array(b.precision+1).join("0");k=k.substr(k.length%3,k.length);for(var n=0,o=k.length;o>n;n++)n%3===0&&(l+=b.delimiter),l+=k[n];if(l=l.replace(i,""),l=l.length?l:"0",!b.zeroCents){var p=h.length-b.precision,q=h.substr(p,b.precision),r=q.length,s=b.precision>r?b.precision:r;m=(m+q).slice(-s)}var t=b.unit+l+b.separator+m+b.suffixUnit;return t.replace(j,"")},h.toPattern=function(d,e){var f,g="object"==typeof e?e.pattern:e,h=g.replace(/\W/g,""),i=g.split(""),j=d.toString().replace(/\W/g,""),k=j.replace(/\W/g,""),l=0,m=i.length;for(f=0;m>f;f++){if(l>=j.length){if(h.length==k.length)return i.join("");break}i[f]===a&&j[l].match(/[0-9]/)||i[f]===b&&j[l].match(/[a-zA-Z]/)||i[f]===c&&j[l].match(/[0-9a-zA-Z]/)?i[f]=j[l++]:(i[f]===a||i[f]===b||i[f]===c)&&(i=i.slice(0,f))}return i.join("").substr(0,f)},h.toNumber=function(a){return a.toString().replace(/(?!^-)[^0-9]/g,"")},h});
            function inputHandler(masks, max, event) {
              var c = event.target;
              var v = c.value.replace(/\D/g, '');
              var m = c.value.length > max ? 1 : 0;
              VMasker(c).unMask();
              VMasker(c).maskPattern(masks[m]);
              c.value = VMasker.toPattern(v, masks[m]);
            }
            
                  
            function limpaCampo2(event) {
                var value = event.target.value;                
                //<![CDATA[
                    if (value.length < 14) {
                        event.target.value = '';                        
                    }
                //]]>
            }
            
            var telMask = ['(99) 9999-9999', '(99) 99999-9999'];
            var tel = document.querySelector('#tele');            

            VMasker(tel).maskPattern(telMask[0]);

            tel.addEventListener('input', inputHandler.bind(undefined, telMask, 14), false);

            tel.addEventListener('blur', limpaCampo2);


}
function celpad2(){     
    !function(a,b){"function"==typeof define&&define.amd?define(b):a.VMasker=b()}(this,function(){var a="9",b="A",c="S",d=[8,9,16,17,18,36,37,38,39,40,91,92,93],e=function(a){for(var b=0,c=d.length;c>b;b++)if(a==d[b])return!1;return!0},f=function(a){return a=a||{},a={precision:a.hasOwnProperty("precision")?a.precision:2,separator:a.separator||",",delimiter:a.delimiter||".",unit:a.unit&&a.unit.replace(/[\s]/g,"")+" "||"",suffixUnit:a.suffixUnit&&" "+a.suffixUnit.replace(/[\s]/g,"")||"",zeroCents:a.zeroCents,lastOutput:a.lastOutput},a.moneyPrecision=a.zeroCents?0:a.precision,a},g=function(a){this.elements=a};g.prototype.unbindElementToMask=function(){for(var a=0,b=this.elements.length;b>a;a++)this.elements[a].lastOutput="",this.elements[a].onkeyup=!1,this.elements[a].onkeydown=!1,this.elements[a].value.length&&(this.elements[a].value=this.elements[a].value.replace(/\D/g,""))},g.prototype.bindElementToMask=function(a){for(var b=this,c=function(c){c=c||window.event;var d=c.target||c.srcElement;e(c.keyCode)&&setTimeout(function(){b.opts.lastOutput=d.lastOutput,d.value=h[a](d.value,b.opts),d.lastOutput=d.value,d.setSelectionRange&&b.opts.suffixUnit&&d.setSelectionRange(d.value.length,d.value.length-b.opts.suffixUnit.length)},0)},d=0,f=this.elements.length;f>d;d++)this.elements[d].lastOutput="",this.elements[d].onkeyup=c,this.elements[d].value.length&&(this.elements[d].value=h[a](this.elements[d].value,this.opts))},g.prototype.maskMoney=function(a){this.opts=f(a),this.bindElementToMask("toMoney")},g.prototype.maskNumber=function(){this.opts={},this.bindElementToMask("toNumber")},g.prototype.maskPattern=function(a){this.opts={pattern:a},this.bindElementToMask("toPattern")},g.prototype.unMask=function(){this.unbindElementToMask()};var h=function(a){if(!a)throw new Error("VanillaMasker: There is no element to bind.");var b="length"in a?a.length?a:[]:[a];return new g(b)};return h.toMoney=function(a,b){if(b=f(b),b.zeroCents){b.lastOutput=b.lastOutput||"";var c="("+b.separator+"[0]{0,"+b.precision+"})",d=new RegExp(c,"g"),e=a.toString().replace(/[\D]/g,"").length||0,g=b.lastOutput.toString().replace(/[\D]/g,"").length||0;a=a.toString().replace(d,""),g>e&&(a=a.slice(0,a.length-1))}var h=a.toString().replace(/[\D]/g,""),i=new RegExp("^(0|\\"+b.delimiter+")"),j=new RegExp("(\\"+b.separator+")$"),k=h.substr(0,h.length-b.moneyPrecision),l=k.substr(0,k.length%3),m=new Array(b.precision+1).join("0");k=k.substr(k.length%3,k.length);for(var n=0,o=k.length;o>n;n++)n%3===0&&(l+=b.delimiter),l+=k[n];if(l=l.replace(i,""),l=l.length?l:"0",!b.zeroCents){var p=h.length-b.precision,q=h.substr(p,b.precision),r=q.length,s=b.precision>r?b.precision:r;m=(m+q).slice(-s)}var t=b.unit+l+b.separator+m+b.suffixUnit;return t.replace(j,"")},h.toPattern=function(d,e){var f,g="object"==typeof e?e.pattern:e,h=g.replace(/\W/g,""),i=g.split(""),j=d.toString().replace(/\W/g,""),k=j.replace(/\W/g,""),l=0,m=i.length;for(f=0;m>f;f++){if(l>=j.length){if(h.length==k.length)return i.join("");break}i[f]===a&&j[l].match(/[0-9]/)||i[f]===b&&j[l].match(/[a-zA-Z]/)||i[f]===c&&j[l].match(/[0-9a-zA-Z]/)?i[f]=j[l++]:(i[f]===a||i[f]===b||i[f]===c)&&(i=i.slice(0,f))}return i.join("").substr(0,f)},h.toNumber=function(a){return a.toString().replace(/(?!^-)[^0-9]/g,"")},h});
            function inputHandler(masks, max, event) {
              var c = event.target;
              var v = c.value.replace(/\D/g, '');
              var m = c.value.length > max ? 1 : 0;
              VMasker(c).unMask();
              VMasker(c).maskPattern(masks[m]);
              c.value = VMasker.toPattern(v, masks[m]);
            }
            
                  
            function limpaCampo2(event) {
                var value = event.target.value;                
                //<![CDATA[
                    if (value.length < 14) {
                        event.target.value = '';                        
                    }
                //]]>
            }
            
            var telMask = ['(99) 9999-9999', '(99) 99999-9999'];
            var tel = document.querySelector('#celular');            

            VMasker(tel).maskPattern(telMask[0]);

            tel.addEventListener('input', inputHandler.bind(undefined, telMask, 14), false);

            tel.addEventListener('blur', limpaCampo2);


}