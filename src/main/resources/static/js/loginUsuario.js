

async function login(){
	
	datos={}
	datos["correo"] = document.getElementById("inputEmail").value;
	datos["password"] = document.getElementById("inputPassword").value;
	
	const request = await fetch('auth/login',{
		method: 'POST',
    	headers: {
		      'Accept': 'application/json',
		      'Content-Type': 'application/json'
    	},
    body: JSON.stringify(datos)
	});
	
	const response = await request.text();
	if (response != ""){
		localStorage.token = response;
		//localStorage.email = datos.correo;
		location.href = "gestionPersonaje.html";
	}else{
		alert("El correo o contraseña son incorrectos");
	}
	
	
}