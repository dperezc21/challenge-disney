


async function guardarPersonaje(){
	let datos = {}
	datos.id =document.getElementById('inputId').value;
	datos.nombre = document.getElementById('inputNombre').value;
	datos.edad = document.getElementById('inputEdad').value;
	datos.peso = document.getElementById('inputPeso').value;
	datos.historia = document.getElementById('inputHistoria').value;
	//datos.imagen= document.getElementById("inputImagen").value;
	
	const request = await fetch('characters/guardar', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      //'Content-Type": "multipart/form-data'
    },
    body: JSON.stringify(datos)
  });
  alert("Registro Guardado Exitosamente");
  
  //let inputs = '<h3>Subir fotografia de personaje</h3> <div class="col-md-6"><div class="form-floating mb-3 mb-md-0"><input class="form-control" name="imagen" id="inputImagen" type="file" /></div></div></div><div class="mt-4 mb-0"><div class="d-grid"><a class="btn btn-primary btn-block" onclick="guardarImagen()" href="#">Guardar Registro</a></div></div>';
  
  //document.querySelector("#formulario div").innerHTML =  inputs;
  //alert("Personaje Guardado");
  //const personaje = await request.json();
  
}


async function guardarImagen(id){
	
	const request = await fetch('characters/guardar/imagen/'+09982, {
    method: 'GET',
    headers: {
		'Content-Type': 'multipart/form-data',
      'Accept': 'application/json',
      //'Content-Type': 'application/json'
    },
    //body: JSON.stringify(datos)
  });
  alert("Personaje Guardado");
  const personaje = await request.json();
  
}
