import { ServicioFaseProyecto } from "./services/ServicioFaseProyecto.js";

const servicio = new ServicioFaseProyecto();

document.addEventListener("DOMContentLoaded", async () => {
  const faseProyectos = await servicio.obtenerFaseProyectos();
  console.log("faseProyectos obtenidas:", faseProyectos);

  const tbody = document.getElementById("tablaFaseProyecto");
  tbody.innerHTML = "";

  faseProyectos.forEach((faseProyecto) => {
    const row = document.createElement("tr");
    const estado = faseProyecto.estado ? "Activo" : "Inactivo";
    const backgroundState = faseProyecto.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${faseProyecto.nombre}</td>
       <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarfaseProyecto(${faseProyecto.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarfaseProyecto(${faseProyecto.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
