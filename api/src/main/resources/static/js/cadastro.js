const form = document.getElementById("formulario");
const modal = document.getElementById("modal");
const modalMessage = document.getElementById("modal-message");
const closeButton = document.querySelector(".close");

function closeModal() {
  modal.style.display = "none";
}

function efetuarCadastro() {
  const nome = document.getElementById("nome").value;
  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;
  const confirmacaoSenha = document.getElementById("confirmacao-senha").value;

  if (senha === confirmacaoSenha) {
    const data = {
      nome: nome,
      email: email,
      senha: senha,
    };
    fetch("/efetua-cadastro", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    }).then(response => {
      if(response.ok){
      }else{
        modalMessage.textContent = "Ocorreu um erro ao processar o cadastro.";
        modal.style.display = "block";
      }
      return response.json();
    }).then((data) => {
      console.log(data);
      const token = data.token;
      const nome = data.nome;
      const email = data.email;

      if (token != null && nome != "undefined" && email != "undefined") {
        localStorage.setItem("token", token);
        localStorage.setItem("nome", nome);
        localStorage.setItem("email", email);
      window.location.href = '/cadastrado';
    }
    });
  }
  else{
    modalMessage.textContent = "Senhas não conferem!";
    modal.style.display = "block";
  }
}

function goToHome(){
  window.location.href = '/';
}

form.addEventListener("submit", function (event) {
  event.preventDefault();
  efetuarCadastro();
});

closeButton.addEventListener("click", closeModal);
window.addEventListener("click", function (event) {
  if (event.target === modal) {
    closeModal();
  }
});