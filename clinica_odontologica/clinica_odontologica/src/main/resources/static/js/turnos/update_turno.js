window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            id: document.querySelector('#turno_id').value,
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value,
            paciente: {
                id: document.querySelector('#paciente_id').value
            },
            odontologo: {
                id: document.querySelector('#odontologo_id').value
            }
        };

        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
            location.reload();

    })
 })

    function findBy(id) {
        const url = '/turnos'+"/"+id;
        const settings = {
            method: 'GET'
        }
        fetch(url,settings)
        .then(response => response.json())
        .then(data => {
        console.log(data)
            let turno = data;
            document.querySelector('#turno_id').value = turno.id;
            document.querySelector('#fecha').value = "";
            document.querySelector('#hora').value = "";
            document.querySelector('#paciente_id').value = "";
            document.querySelector('#odontologo_id').value = "";

            document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }