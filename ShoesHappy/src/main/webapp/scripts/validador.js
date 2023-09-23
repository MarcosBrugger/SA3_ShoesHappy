/**
 * Validar campos obrigatorios
 */

function validar() {
	
	let nome = frmContato.nome.value
	let endereco = frmContato.endereco.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (endereco === "") {
		alert('Preencha o campo Endereço')
		frmContato.endereco.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}