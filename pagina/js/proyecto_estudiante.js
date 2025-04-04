import { ServicioProyectoEstudiante } from "./services/ServicioProyectoEstudiante.js";

const servicio = new ServicioProyectoEstudiante();

document.addEventListener("DOMContentLoaded", async () => {
  const proyectosEstudiantes = await servicio.obtenerProyectoEstudiantes();
  console.log("proyectosEstudiantes obtenidas:", proyectosEstudiantes);

  const tbody = document.getElementById("tablaProyectoEstudiante");
  tbody.innerHTML = "";

  proyectosEstudiantes.forEach((proyecto) => {
    const row = document.createElement("tr");
    const estado = proyecto.estado ? "Activo" : "Inactivo";
    const backgroundState = proyecto.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${proyecto.proyecto}</td>
        <td>${proyecto.estudiante}</td>
        <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarproyecto(${proyecto.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarproyecto(${proyecto.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
