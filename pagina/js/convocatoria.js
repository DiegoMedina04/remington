import { ServicioConvocatoria } from "./services/ServicioConvocatoria.js";

const servicio = new ServicioConvocatoria();

document.addEventListener("DOMContentLoaded", async () => {
  const convocatorias = await servicio.obtenerConvocatorias();

  const tbody = document.getElementById("tablaConvocatoria");
  tbody.innerHTML = "";

  convocatorias.forEach((convocatoria) => {

    const row = document.createElement("tr");
    const estado = convocatoria.estado ? "Activo" : "Inactivo";
    const backgroundState = convocatoria.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${convocatoria.nombre}</td>
        <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarconvocatoria(${convocatoria.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarconvocatoria(${convocatoria.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
