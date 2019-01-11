/*
 * Converte a sigla do Estado para o nome em extenso.
*/
function converteEstado(estado){
	
	var estadoAtual = document.getElementById("formulario:estado");
	
	switch(estado){
		case "AC": estadoAtual.value = ("Acre"); break;
		case "AP": estadoAtual.value = ("Amapá"); break;
		case "AM": estadoAtual.value = ("Amazonas"); break;
		case "BA": estadoAtual.value = ("Bahia"); break;
		case "CE": estadoAtual.value = ("Ceará"); break;
		case "DF": estadoAtual.value = ("Distrito Federal"); break;
		case "ES": estadoAtual.value = ("Espírito Santo"); break;
		case "GO": estadoAtual.value = ("Goiás"); break;
		case "MA": estadoAtual.value = ("Maranhão"); break;
		case "MT": estadoAtual.value = ("Mato Grosso"); break;
		case "MS": estadoAtual.value = ("Mato Grosso do Sul"); break;
		case "MG": estadoAtual.value = ("Minas Gerais"); break;
		case "PA": estadoAtual.value = ("Pará"); break;
		case "PB": estadoAtual.value = ("Paraíba"); break;
		case "PE": estadoAtual.value = ("Pernambuco"); break;
		case "PI": estadoAtual.value = ("Piauí"); break;
		case "RJ": estadoAtual.value = ("Rio de Janeiro"); break;
		case "RN": estadoAtual.value = ("Rio Grande do Norte"); break;
		case "RS": estadoAtual.value = ("Rio Grande do Sul"); break;
		case "RO": estadoAtual.value = ("Rondônia"); break;
		case "RR": estadoAtual.value = ("Roraima"); break;
		case "SC": estadoAtual.value = ("Santa Catarina"); break;
		case "SP": estadoAtual.value = ("São Paulo"); break;
		case "SE": estadoAtual.value = ("Sergipe"); break;
		case "TO": estadoAtual.value = ("Tocantins"); break;
		default: estadoAtual = "Nenhum estado encontrado"; break;
	}
}

// CEP
function clean_form_cep() {
	// Clean value of the inputs
	document.getElementById('formulario:endereco').value = ("");
	document.getElementById('formulario:bairro').value = ("");
	document.getElementById('formulario:cidade').value = ("");
	document.getElementById('formulario:estado').value = ("");
}
function my_callback(content) {
	if (!("erro" in content)) {
		// Update fields with values.
		document.getElementById('formulario:endereco').value = (content.logradouro);
		document.getElementById('formulario:bairro').value = (content.bairro);
		document.getElementById('formulario:cidade').value = (content.localidade);
		
		var estado = (content.uf);
		converteEstado(estado);
		
	} else {
		// CEP not found.
		clean_form_cep();
		alert("CEP não encontrado.");
	}
}

function searchcep(v) {

	// New cep only numbers
	var cep = v.replace(/\D/g, '');

	// Check if cep is empty
	if (cep != "") {

		// Regex for CEP
		var validacep = /^[0-9]{8}$/;

		// Valida o formato do CEP.
		if (validacep.test(cep)) {

			// Fill the fields with "..." while consult webservice
			document.getElementById('formulario:endereco').value = "...";
			document.getElementById('formulario:bairro').value = "...";
			document.getElementById('formulario:cidade').value = "...";
			document.getElementById('formulario:estado').value = "...";

			// Create an element javascript
			var script = document.createElement('script');

			// Sync with callback
			script.src = 'https://viacep.com.br/ws/' + cep
					+ '/json/?callback=my_callback';

			// Inset script into doc and load content
			document.body.appendChild(script);

		} else {
			// cep invalid
			clean_form_cep();
			alert("Formato de CEP inválido.");
		}
	} else {
		// cep without value clean form
		clean_form_cep();
	}
}