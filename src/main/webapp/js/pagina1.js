

window.onload = main;
function main(){
    document.getElementById('posGrafico').addEventListener('click',clickGrafico);
    document.getElementById('posTabela').addEventListener('click',clickTabela);
}

function clickGrafico(){
    document.getElementById('posGrafico').style.setProperty('background-color','#0044ff');
    document.getElementById('posTabela').style.setProperty('background-color','white');
    document.getElementById('labelGrafico').style.setProperty('color','#0044ff');
    document.getElementById('labelTabela').style.setProperty('color','lightgray');
}
function clickTabela(){
    document.getElementById('posGrafico').style.setProperty('background-color','white');
    document.getElementById('posTabela').style.setProperty('background-color','#0044ff');
    document.getElementById('labelGrafico').style.setProperty('color','lightgray');
    document.getElementById('labelTabela').style.setProperty('color','#0044ff');
}

//===== Esta função faz o mesmo que um botão "submit" no form com id="form1"
function lerReler(){
    document.getElementById('form1').submit();
}


