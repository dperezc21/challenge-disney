window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
	get();
    const datatablesSimple = document.getElementById('tablaPersonajes');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
    
});


async function get(){
	const response = await fetch('generos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    
  });
  const generos = await response.json();
  console.log(generos);
  let lista = listarGeneros(generos);
	document.querySelector("#tablaPersonajes tbody").innerHTML = lista;
  
  
}


async function eliminarGenero(id){
	if(confirm("¿Esta seguro que quiere eliminar el Genero seleccionado?")){
		const response = await fetch('generos/eliminar/'+id, {
    	method: 'DELETE',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json',
	      //'Authentication':localStorage.token
	    },
	    
	  });
	  location.reload();
	}  
}


function listarGeneros(genero){
	let lista = "";
	for (let i of genero){
		
		let botonEliminar = '<a href="#" onclick="eliminarGenero('+i.id+')">Eliminar</a>';
		let g = '<tr><td>'+i.id
						+'</td><td>'+i.nombre
						+'</td><td>'+i.imagen
						+'</td><td>'+botonEliminar+'</td></tr>';
						
		lista += g;
	}
	return lista;
}


//select = document.getElementById("select");

//botonBuscar = document.getElementById("buscarGenero");

//botonBuscar.addEventListener("click", buscarGeneroPor);




