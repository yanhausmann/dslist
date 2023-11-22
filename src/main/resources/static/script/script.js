function mostrarMenuOculto() {
    var menuOculto = document.getElementById('menuOculto');
    
    var estiloDisplay = window.getComputedStyle(menuOculto).display;

    if (estiloDisplay === 'none') {
        menuOculto.style.display = 'block';
    } else {
        menuOculto.style.display = 'none';
    }
}
//---------------------------------------------------------------------------------
function enviarGame() {
    console.log("Botão clicado!");

    var nome = document.getElementById("nome").value;
    var genre = document.getElementById("genre").value;
    var year = document.getElementById("year").value;
    var score = document.getElementById("score").value;
    var platform = document.getElementById("platform").value;
    var shortDescription = document.getElementById("shortDescription").value;
    var longDescription = document.getElementById("longDescription").value;
    var imgUrl = document.getElementById("imgUrl").value;

    var data = {
        nome: nome,
        genre: genre,
        year: year,
        score: score,
        platform: platform,
        shortDescription: shortDescription,
        longDescription: longDescription,
        imgUrl: imgUrl
    };

    fetch('http://localhost:8080/games/full', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Game salvo com sucesso:', data);

        // Adicione estas linhas para exibir o card com as informações do jogo
        document.getElementById("cap-card").style.display = "block";
        document.querySelector(".containerCard h2").innerText = nome;
        document.querySelector(".containerCard p").innerText = shortDescription;
        document.querySelector(".containerCard img").src = imgUrl;

        // Limpe os campos do formulário
        document.getElementById("nome").value = "";
        document.getElementById("genre").value = "";
        document.getElementById("year").value = "";
        document.getElementById("score").value = "";
        document.getElementById("platform").value = "";
        document.getElementById("shortDescription").value = "";
        document.getElementById("longDescription").value = "";
        document.getElementById("imgUrl").value = "";

        // Exiba a mensagem por 3 segundos
        setTimeout(function() {
            document.getElementById("cap-card").style.display = "none";
        }, 7000);
    })
    .catch(error => {
        console.error('Erro ao salvar game:', error);
    });
}

//---------------------------------------------------------------------------------
 function exibirMensagem(containerCard) {
    var mensagemDiv = document.getElementById("containerCard");

    mensagemDiv.style.display = "block";

    setTimeout(function() {
      mensagemDiv.style.display = "none";
    }, 3000);
}

//---------------------------------------------------------------------------------
// function exibirMensagem(){

//     // document.getElementById("nome").value = "";
//     // document.getElementById("genre").value = "";
//     // document.getElementById("year").value = "";
//     // document.getElementById("platform").value = "";
//     // document.getElementById("shortDescription").value = "";
//     // document.getElementById("longDescription").value = "";
//     // document.getElementById("imgUrl").value = "";

//     var mensagemDiv = document.getElementsByClassName("containerCard");
//     mensagemDiv.innerHTML = containerCard;


//     mensagemDiv.style.display = "block";
//     setTimeout(function() {
//         mensagemDiv.innerHTML = "";
//         mensagemDiv.style.display = "none";
//     }, 3000); // Limpar após 3 segundos (ajuste conforme necessário)

// }