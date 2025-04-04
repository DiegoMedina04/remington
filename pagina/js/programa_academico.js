import { ServicioProgramaAcademico } from "./services/ServicioProgramaAcademico.js";

const servicio = new ServicioProgramaAcademico();

document.addEventListener("DOMContentLoaded", async () => {
  const programasAcademicos = await servicio.obtenerProgramaAcademicos();
  console.log("programasAcademicos obtenidas:", programasAcademicos);

  const tbody = document.getElementById("tablaProgramaAcademico");
  tbody.innerHTML = "";

  programasAcademicos.forEach((historial) => {
    const row = document.createElement("tr");
    const estado = historial.estado ? "Activo" : "Inactivo";
    const backgroundState = historial.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${historial.nombre}</td>
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
