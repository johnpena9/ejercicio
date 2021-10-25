// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarEjercicios();
  $('#ejercicios').DataTable();
});

async function cargarEjercicios(){

      const request = await fetch('api/ejercicios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
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
async function Elinimarejericiio(id){
if(!confirm('desea eliminar el ejercicio')){
return
}
 const request = await fetch('api/ejercicios'+id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
     location.reload();
}