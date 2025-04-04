import { ServicioSemillero } from "./services/ServicioSemillero.js";

const servicio = new ServicioSemillero();

document.addEventListener("DOMContentLoaded", async () => {
  const semilleros = await servicio.obtenerSemilleros();
  console.log("semilleros obtenidas:", semilleros);

  const tbody = document.getElementById("tablaSemillero");
  tbody.innerHTML = "";

  semilleros.forEach((semillero) => {
    const row = document.createElement("tr");
    const estado = semillero.estado ? "Activo" : "Inactivo";
    const backgroundState = semillero.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${semillero.nombre}</td>
        <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarsemillero(${semillero.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarsemillero(${semillero.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
