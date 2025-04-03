import { ServicioSemillero } from "./services/ServicioSemillero.js";

const servicio = new ServicioSemillero();

document.addEventListener("DOMContentLoaded", async () => {
  const semilleros = await servicio.obtenerSemilleros();
  console.log("semilleros obtenidas:", semilleros);

  const tbody = document.getElementById("tablaSemillero");
  tbody.innerHTML = "";

  semilleros.forEach((proyecto) => {
    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${proyecto.nombre}</td>
        <td>${proyecto.estado}</td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarproyecto(${proyecto.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarproyecto(${proyecto.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
