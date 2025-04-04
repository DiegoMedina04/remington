import { ServicioProyecto } from "./services/ServicioProyecto.js";

const servicio = new ServicioProyecto();

document.addEventListener("DOMContentLoaded", async () => {
  const proyectos = await servicio.obtenerProyectos();
  console.log("proyectos obtenidas:", proyectos);

  const tbody = document.getElementById("tablaProyecto");
  tbody.innerHTML = "";

  proyectos.forEach((proyecto) => {
    const row = document.createElement("tr");
    const estado = proyecto.estado ? "Activo" : "Inactivo";
    const backgroundState = proyecto.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${proyecto.nombre}</td>
        <td>${proyecto.version}</td>
        <td>${proyecto.fechaInscripcion}</td>
        <td>${proyecto.numeroIntegrantes}</td>
        <td>${proyecto.convocatoria}</td>
        <td>${proyecto.semillero}</td>
        <td>${proyecto.faseProyecto}</td>
        <td>${proyecto.sede}</td>
        <td>${proyecto.programaAcademico}</td>
        <td>${proyecto.facultad}</td>
        <td>${proyecto.area}</td>
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
