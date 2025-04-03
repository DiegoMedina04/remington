import { ServicioProyectoAsesor } from "./services/ServicioProyectoAsesor.js";

const servicio = new ServicioProyectoAsesor();

document.addEventListener("DOMContentLoaded", async () => {
  const proyectosAsesores = await servicio.obtenerProyectoAsesors();
  console.log("proyectosAsesores obtenidas:", proyectosAsesores);

  const tbody = document.getElementById("tablaProyectoAsesor");
  tbody.innerHTML = "";

  proyectosAsesores.forEach((proyecto) => {
    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${proyecto.proyecto}</td>
        <td>${proyecto.asesor}</td>
        <td>${proyecto.estado}</td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarproyecto(${proyecto.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarproyecto(${proyecto.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
