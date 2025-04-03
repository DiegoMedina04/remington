import { ServicioFacultad } from "./services/ServicioFacultad.js";

const servicio = new ServicioFacultad();

document.addEventListener("DOMContentLoaded", async () => {
  const facultades = await servicio.obtenerFacultads();

  const tbody = document.getElementById("tablaFacultad");
  tbody.innerHTML = "";

  facultades.forEach((facultad) => {
    const estado = facultad.estado ? "Activo" : "Inactivo";
    const backgroundState = facultad.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${facultad.nombre}</td>
        <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarfacultad(${facultad.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarfacultad(${facultad.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
