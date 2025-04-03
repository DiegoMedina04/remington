import { ServicioAsesor } from "./services/ServicioAsesor.js";

const servicio = new ServicioAsesor();

document.addEventListener("DOMContentLoaded", async () => {
  const asesores = await servicio.obtenerAsesors();

  const tbody = document.getElementById("tablaAsesor");
  tbody.innerHTML = "";

  asesores.forEach((asesor) => {
    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${asesor.identificacion}</td>
        <td>${asesor.nombre}</td>
        <td>${asesor.email}</td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarasesor(${asesor.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarasesor(${asesor.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
