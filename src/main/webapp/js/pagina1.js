
window.onload = main;
function main(){
    document.getElementById('posGrafico').addEventListener('click',clickGrafico);
    document.getElementById('posTabela').addEventListener('click',clickTabela);
    opcoes();
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
function opcoes(){
    var url = "http://localhost:8080/TrabalhoPA/controller?tratador=com.henrique.trabalhopa.pagehandlers.Tratadorpg1&action=load";
    var ajaxRequest = new XMLHttpRequest();
    var campo = document.getElementById("selectVariaveisDashboard");
    ajaxRequest.open("GET", url);
    ajaxRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajaxRequest.onreadystatechange = function() {
        if(ajaxRequest.readyState===4 && ajaxRequest.status===200){
            var respostaJSON = JSON.parse(ajaxRequest.response);
            for(i=0;i<respostaJSON.length;i++){
                var opt = document.createElement("option");
                var nome = document.createTextNode(respostaJSON[i].nome);
                opt.appendChild(nome);
                opt.value = respostaJSON[i].nome;
                campo.appendChild(opt);
            }
                
        }
    };
    ajaxRequest.send();
}
function lerReler(){
    var data = document.getElementById("datafinal");
    var periodo = document.getElementById("selectPeriodo");
    var variaveis = document.getElementById("selectVariaveisDashboard");
    var url = "http://localhost:8080/TrabalhoPA/controller?action=search&dataFinal=" + data.value + "&selectPeriodo=" + periodo.value + "&selectVariaveis=" + variaveis.value;
    var ajaxRequest = new XMLHttpRequest();
    var campo = document.getElementById("resultado");

    ajaxRequest.open("GET", url);
    ajaxRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajaxRequest.onreadystatechange = function() {
        if(ajaxRequest.readyState===4 && ajaxRequest.status===200){
            var respostaJSON = JSON.parse(ajaxRequest.response);
            for(i=0;i<respostaJSON.length;i++){
                var tr = campo.insertRow();
                var serialNo = document.createTextNode(respostaJSON[i].serialNo);
                var medidor = document.createTextNode(respostaJSON[i].medidor);
                var temperatura = document.createTextNode(respostaJSON[i].temperatura);
                var umidade = document.createTextNode(respostaJSON[i].umidade);
                var dataHora = document.createTextNode(respostaJSON[i].dataHora);
                var serial = document.createTextNode(respostaJSON[i].serial);
                for(j=0;j<6;j++){
                    var td = tr.insertCell();
                    if (j===0){
                        td.appendChild(serialNo);
                    }
                    else if(j===1){
                        td.appendChild(medidor);
                    }
                    else if(j===2){
                        td.appendChild(temperatura);
                    }
                    else if(j===3){
                        td.appendChild(umidade);
                    }
                    else if(j===4){
                        td.appendChild(dataHora);
                    }
                    else if(j===5){
                        td.appendChild(serial);
                    }
                }
            }            
        }
    };
    ajaxRequest.send();
}



