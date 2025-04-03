import { ServicioSede } from "./services/ServicioSede.js";

const servicio = new ServicioSede();

document.addEventListener("DOMContentLoaded", async () => {
  const sedes = await servicio.obtenerSedes();
  console.log("sedes obtenidas:", sedes);

  const tbody = document.getElementById("tablaSede");
  tbody.innerHTML = "";

  sedes.forEach((proyecto) => {
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
