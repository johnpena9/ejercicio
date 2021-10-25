// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function registrarEjercicios(){
let datos ={};


        datos.nombreEjercicio = document.getElementById('txtnombreEjercicio').value;
        datos.tipoMusculo = document.getElementById('txttipoMusulo').value;
        datos.series = document.getElementById('txtseries').value;
        datos.descripcion = document.getElementById('txtdescripcion').value;

      const request = await fetch('api/ejercicios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
        body: JSON.stringify(datos)
      });
      const ejercicios = await request.json();

      let listaHtml ='';

      for(let ejercicio of ejercicios){
      let btnElinimar ='<a onclick=Elinimarejericiio('+ejercicio.id+') href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
             let ejercicioHtml = '<tr><td>'+ejercicio.id+'</td><td>'+ ejercicio.nombreEjercicio +'</td><td>'+ ejercicio.series
             +'</td><td>'+ejercicio.tipoMusculo+'</td><td>'+ejercicio.descripcion
             +'</td><td>'+btnElinimar+'</td></tr>'

             listaHtml += ejercicioHtml;
      }



      console.log(listaHtml);
      document.querySelector('#ejercicios tbody').outerHTML = listaHtml;
}
