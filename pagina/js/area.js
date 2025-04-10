import { ServicioArea } from "./services/ServicioArea.js";

const servicioArea = new ServicioArea();
document.addEventListener("DOMContentLoaded", async () => {
  const areas = await servicioArea.obtenerAreas();

  const tbody = document.getElementById("tablaArea");
  tbody.innerHTML = "";

  areas.forEach((area) => {
    const row = document.createElement("tr");
    row.setAttribute("data-id", area.id);
    const estado = area.estado ? "Activo" : "Inactivo";
    const backgroundState = area.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td class="d-none">${area.id}</td>
        <td >${area.nombre}</td>
        <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button 
            class="btn btn-warning btn-sm btn-editar"
            data-bs-toggle="modal"
            data-bs-target="#modalArea"
            data-id="${area.id}">
            Editar
          </button>
          <button class="btn btn-danger btn-sm btn-eliminar" data-id="${area.id}">
            Eliminar
          </button>
        </td>
      `;
    tbody.appendChild(row);
  });
});
document.getElementById("modalArea").addEventListener("hidden.bs.modal", () => {
  document.getElementById("formArea").reset();
  document.getElementById("idArea").value = "";
});

document.getElementById("formArea").addEventListener("submit", async (e) => {
  e.preventDefault();

  const id = document.getElementById("idArea").value;
  const nombre = document.getElementById("nombre").value;
  const estado = document.getElementById("estado").value;

  const area = { id, nombre, estado };

  if (id) {
    // await servicioArea.actualizarArea(area);
    console.log("Área actualizada: ", area);
  } else {
    // await servicioArea.crearArea(area);
    console.log("Área creada: ", area);
  }

  document.getElementById("formArea").reset();
  bootstrap.Modal.getInstance(document.getElementById("modalArea")).hide();
  // location.reload();
});

document.getElementById("tablaArea").addEventListener("click", async (e) => {
  if (e.target.classList.contains("btn-editar")) {
    const id = e.target.dataset.id;
    const area = await servicioArea.obtenerAreaPorId(id);
    console.log({ area });

    document.getElementById("idArea").value = area.id;
    document.getElementById("nombre").value = area.nombre;
    document.getElementById("estado").value = area.estado
      ? "ACTIVO"
      : "INACTIVO";
  }

  if (e.target.classList.contains("btn-eliminar")) {
    const id = e.target.dataset.id;
    // await servicioArea.eliminarArea(id);
    console.log("Área eliminada: ", id);
  }
});
