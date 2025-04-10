import { ServicioAsesor } from "./services/ServicioAsesor.js";

const servicio = new ServicioAsesor();

document.addEventListener("DOMContentLoaded", async () => {
  const asesores = await servicio.obtenerAsesors();

  const tbody = document.getElementById("tablaAsesor");
  tbody.innerHTML = "";

  asesores.forEach((asesor) => {
    const row = document.createElement("tr");
    row.setAttribute("data-id", asesor.id);
    row.innerHTML = `
        <td class="d-none">${asesor.id}</td>
        <td>${asesor.identificacion}</td>
        <td>${asesor.nombre}</td>
        <td>${asesor.email}</td>
        <td>
        <button 
            class="btn btn-warning btn-sm btn-editar"
            data-bs-toggle="modal"
            data-bs-target="#modalAsesor"
            data-id="${asesor.id}">
            Editar
          </button>
          <button class="btn btn-danger btn-sm" onclick="eliminarasesor(${asesor.id})">Eliminar</button>
        </td>
      `;
    tbody.appendChild(row);
  });
});

document
  .getElementById("modalAsesor")
  .addEventListener("hidden.bs.modal", () => {
    document.getElementById("formAsesor").reset();
    document.getElementById("idAsesor").value = "";
  });

document.getElementById("formAsesor").addEventListener("submit", async (e) => {
  e.preventDefault();

  const id = document.getElementById("idAsesor").value;
  console.log({ id });

  const identificacion = document.getElementById("identificacion").value;
  const nombre = document.getElementById("nombre").value;
  const email = document.getElementById("email").value;

  const asesor = { id, identificacion, nombre, email };

  if (id) {
    // await servicio.actualizarAsesor(asesor);
    console.log("asesor actualizada: ", asesor);
  } else {
    // await servicio.crearAsesor(asesor);
    console.log("Área creada: ", asesor);
  }

  document.getElementById("formAsesor").reset();
  bootstrap.Modal.getInstance(document.getElementById("formAsesor")).hide();
  // location.reload();
});

document.getElementById("tablaAsesor").addEventListener("click", async (e) => {
  if (e.target.classList.contains("btn-editar")) {
    const id = e.target.dataset.id;
    console.log({ id });
    const asesor = await servicio.obtenerAsesorsPorId(id);

    console.log({ asesor });

    document.getElementById("idAsesor").value = asesor.id;
    document.getElementById("identificacion").value = asesor.identificacion;
    document.getElementById("nombre").value = asesor.nombre;
    document.getElementById("email").value = asesor.email;
  }

  if (e.target.classList.contains("btn-eliminar")) {
    const id = e.target.dataset.id;
    // await servicioasesor.eliminarasesor(id);
    console.log("Área eliminada: ", id);
  }
});
