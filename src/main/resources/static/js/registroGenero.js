
async function agregar(){
	
	let datos = {}
	datos.id =document.getElementById('inputId').value;
	datos.nombre = document.getElementById('inputNombre').value;
	datos.imagen = document.getElementById('inputImagen').value;
	
	const request = await fetch('generos/guardar', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  //const peliculasSeries = await request.json();
  alert("Genero guardado");
  //console.log(peliculasSeries);
  
}