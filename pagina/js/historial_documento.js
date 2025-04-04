import { ServicioHistorialDocumento } from "./services/ServicioHistorialDocumentos.js";

const servicio = new ServicioHistorialDocumento();

document.addEventListener("DOMContentLoaded", async () => {
  const hisotrialDocumentos = await servicio.obtenerHistorialDocumentos();
  console.log("hisotrialDocumentos obtenidas:", hisotrialDocumentos);

  const tbody = document.getElementById("tablaHistorialDocumento");
  tbody.innerHTML = "";

  hisotrialDocumentos.forEach((historial) => {
    const row = document.createElement("tr");
    const estado = historial.estado ? "Activo" : "Inactivo";
    const backgroundState = historial.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${historial.version}</td>
        <td>${historial.proyecto}</td>
       <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarhistorial(${historial.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarhistorial(${historial.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
