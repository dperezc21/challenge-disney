
async function guardarUsuario(){
	let datos = {}
	datos.nombre =document.getElementById('inputNombre').value;
	datos.apellido = document.getElementById('inputApellido').value;
	datos.correo = document.getElementById('inputEmail').value;
	datos.password = document.getElementById('inputPassword').value;
	passwordConfirm = document.getElementById('inputPasswordConfirm').value;
	
	if(datos.password != passwordConfirm){
		alert("las contraseñas no coinsiden");
		return;
	}
	const request = await fetch('auth/register', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("¡usuario creado exitosamente!")
 window.location.href = "loginUsuario.html";
  //const personaje = await request.json();
  
}
