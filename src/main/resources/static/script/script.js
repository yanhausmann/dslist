function enviarGame() {
    console.log("Botão clicado!");

    var nome = document.getElementById("nome").value;
    var genre = document.getElementById("genre").value;
    var year = document.getElementById("year").value;
    var platform = document.getElementById("platform").value;
    var shortDescription = document.getElementById("shortDescription").value;
    var longDescription = document.getElementById("longDescription").value;
    var imgUrl = document.getElementById("imgUrl").value;

    var data = {
        nome: nome,
        genre: genre,
        year: year,
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
        document.getElementById("nome").value = "";
        document.getElementById("genre").value = "";
        document.getElementById("year").value = "";
        document.getElementById("platform").value = "";
        document.getElementById("shortDescription").value = "";
        document.getElementById("longDescription").value = "";
        document.getElementById("imgUrl").value = "";

        exibirMensagem("Jogo salvo com sucesso!", true);
    })
    .catch(error => {
        console.error('Erro ao salvar game:', error);
    });
}

function exibirMensagem(mensagem, sucesso) {
    var mensagemDiv = document.getElementById("mensagem");

    // Definir a classe da mensagem com base no sucesso
    mensagemDiv.className = sucesso ? "sucesso" : "erro";

    // Definir o conteúdo da mensagem
    mensagemDiv.innerHTML = mensagem;

    // Exibir a div
    mensagemDiv.style.display = "block";

    // Limpar a mensagem após alguns segundos (opcional)
    setTimeout(function() {
        mensagemDiv.innerHTML = "";
        mensagemDiv.style.display = "none";
    }, 3000); // Limpar após 3 segundos (ajuste conforme necessário)
}
