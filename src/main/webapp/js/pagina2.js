/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = main;

function main(){
    tabelaMedidores();
}

function tabelaMedidores(){
    var url = "http://localhost:8080/TrabalhoPA/controller?tratador=com.henrique.trabalhopa.pagehandlers.Tratadorpg2";
    var ajaxRequest = new XMLHttpRequest();
    var campo = document.getElementById("tabelamedidores");
    ajaxRequest.open("GET", url);
    ajaxRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajaxRequest.onreadystatechange = function() {
        if(ajaxRequest.readyState===4 && ajaxRequest.status===200){
            var respostaJSON = JSON.parse(ajaxRequest.response);
            for(i=0;i<respostaJSON.length;i++){
                var nome = document.createTextNode(respostaJSON[i].nome);
                var tabela = document.createTextNode(respostaJSON[i].tabela);
                var tr = campo.insertRow();
                for(j=0;j<3;j++){
                    var td = tr.insertCell();
                    if(j===0){
                        td.appendChild(nome);
                    }
                    else if(j===1){
                        td.appendChild(tabela);
                    }
                    else if(j===2){
                        var button = document.createElement("button");
                        button.innerHTML = "Editar";
//                        button.addEventListerner("click", function(){alert("funciona");} )
                        td.appendChild(button);
                    }
                }
            }
        }
    };
    ajaxRequest.send();
}

function editar(){
    
}

function criarNovo(){
    var form = document.createElement("FORM");
    form.setAttribute("method","post");
    var nome = document.createElement("INPUT");
    nome.setAttribute("type", "text");
    nome.setAttribute("name", "nome");
    nome.setAttribute("value", "Nome");
    nome.innerHTML = "Nome";
    var tabela = document.createElement("INPUT");
    tabela.setAttribute("type", "text");
    tabela.setAttribute("name", "tabela");
    tabela.setAttribute("value", "Tabela");
    tabela.innerHTML = "Tabela";
    var button = document.createElement("BUTTON");
    button.addEventListener("click", enviar);
    button.setAttribute("value", "Enviar");
    button.innerHTML = "Enviar";
    
    form.appendChild(nome);
    form.appendChild(tabela);
    form.appendChild(button);
    
    document.getElementById("novo").appendChild(form);
}
var enviar = function (){
    // Preparacao do pedido
    var sendData = {
        "nome" : document.getElementsByName('nome')[0].value,
        "tabela" : document.getElementsByName('tabela')[0].value,
    };

    fazerPedidoAJAX(
            sendData,
            function(x){popularCamposComRespostaJSON(x);}  // callback
    );
    
};
function popularCamposComRespostaJSON(objJSONresp){
    document.getElementsByName('nome')[0].value = objJSONresp.nome;
    document.getElementsByName('tabela')[0].value = objJSONresp.tabela;
};
function fazerPedidoAJAX(objetoJSON,funcPopularPagina){
    
    var stringJSON = JSON.stringify(objetoJSON);
    var url = "http://localhost:8080/TrabalhoPA/controller?tratador=com.henrique.trabalhopa.pagehandlers.Tratadorpg2";
    var objPedidoAJAX = new XMLHttpRequest();
    
    objPedidoAJAX.open("POST", url);
    objPedidoAJAX.setRequestHeader("Content-Type","application/json;charset=UTF-8");
    // Prepara recebimento da resposta: tipo da resposta JSON!
    objPedidoAJAX.responseType = 'json';
    
    objPedidoAJAX.onreadystatechange =
        function() {
            if(objPedidoAJAX.readyState===4 && objPedidoAJAX.status===200){
                // A resposta 'response' já é avaliada para json!
                // Ao contraro da resposta responseText.
                var respJSON = objPedidoAJAX.response;
		console.log("readyState final="+objPedidoAJAX.readyState+
			    "\nstatus final="+objPedidoAJAX.status);
                funcPopularPagina(respJSON);
            }else{
		console.log("objPedidoAJAX.readyState="+objPedidoAJAX.readyState+
			    "\nobjPedidoAJAX.status="+objPedidoAJAX.status);
	    };
        };
        
    // Envio do pedido
    objPedidoAJAX.send(stringJSON);
};
