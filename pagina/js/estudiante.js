import { ServicioEstudiante } from "./services/ServicioEstudiante.js";

const servicio = new ServicioEstudiante();

document.addEventListener("DOMContentLoaded", async () => {
  const estudiantes = await servicio.obtenerEstudiantes();
  console.log("estudiantes obtenidas:", estudiantes);

  const tbody = document.getElementById("tablaEstudiante");
  tbody.innerHTML = "";

  estudiantes.forEach((estudiante) => {
    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${estudiante.identificacion}</td>
        <td>${estudiante.nombre}</td>
        <td>${estudiante.email}</td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarestudiante(${estudiante.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarestudiante(${estudiante.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
