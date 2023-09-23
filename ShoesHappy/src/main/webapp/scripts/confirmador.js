/**
 * Confirmar a exclusao de um contato
 */

function confirmar(matricula) {
	let resposta = confirm("Confirma a exclusão deste contato?")
	if (resposta === true) {
		window.location.href = "delete?matricula=" + matricula
	}
}