import { ServicioArea } from "./services/ServicioArea.js";

const servicioArea = new ServicioArea();

// ✅ Cargar áreas y llenar tabla
document.addEventListener("DOMContentLoaded", async () => {
  const areas = await servicioArea.obtenerAreas();
  console.log("Áreas obtenidas:", areas);

  const tbody = document.getElementById("tablaArea");
  tbody.innerHTML = "";

  areas.forEach((area) => {
    const row = document.createElement("tr");
    const estado = area.estado ? "Activo" : "Inactivo";
    const backgroundState = area.estado ? "bg-success" : "bg-danger";
    const textColor = "text-white";
    row.innerHTML = `
        <td>${area.nombre}</td>
        <td>
          <span class="badge ${backgroundState} ${textColor}">${estado}</span>
        </td>
        <td>
          <button class="btn btn-warning btn-sm" onclick="editarArea(${area.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarArea(${area.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});

document.getElementById("formArea").addEventListener("submit", async (e) => {
  e.preventDefault();

  const id = document.getElementById("idArea").value;
  const nombre = document.getElementById("nombre").value;
  const estado = document.getElementById("estado").value;

  const area = { id, nombre, estado };

  try {
    if (id) {
      await servicioArea.actualizarArea(area);
      console.log("Área actualizada:", area);
    } else {
      await servicioArea.crearArea(area);
      console.log("Área creada:", area);
    }

    document.getElementById("formArea").reset();
    bootstrap.Modal.getInstance(document.getElementById("modalArea")).hide();
    location.reload();
  } catch (error) {
    console.error("Error al guardar:", error);
  }
});
