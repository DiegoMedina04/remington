import { ServicioSede } from "./services/ServicioSede.js";

const servicio = new ServicioSede();

document.addEventListener("DOMContentLoaded", async () => {
  const sedes = await servicio.obtenerSedes();
  console.log("sedes obtenidas:", sedes);

  const tbody = document.getElementById("tablaSede");
  tbody.innerHTML = "";

  sedes.forEach((sede) => {
    const row = document.createElement("tr");
    const estado = sede.estado ? "Activo" : "Inactivo";
    const backgroundState = sede.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${sede.nombre}</td>
        <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarsede(${sede.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarsede(${sede.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
