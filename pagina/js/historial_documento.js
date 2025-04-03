import { ServicioHistorialDocumento } from "./services/ServicioHistorialDocumentos.js";

const servicio = new ServicioHistorialDocumento();

document.addEventListener("DOMContentLoaded", async () => {
  const hisotrialDocumentos = await servicio.obtenerHistorialDocumentos();
  console.log("hisotrialDocumentos obtenidas:", hisotrialDocumentos);

  const tbody = document.getElementById("tablaHistorialDocumento");
  tbody.innerHTML = "";

  hisotrialDocumentos.forEach((historial) => {
    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${historial.nombre}</td>
        <td>${historial.estado}</td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarhistorial(${historial.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarhistorial(${historial.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
