import { facultadesMock } from "../api/seed/seedFacultad.js";

export class ServicioFacultad {
  constructor() {}

  async obtenerFacultads() {
    try {
      const facultades = JSON.parse(localStorage.getItem("facultades"));
      if (facultades) {
        return facultades;
      }
      // const response = await this.request(`area`, 'GET');
      // const facultadesMock = await response.json();
      localStorage.setItem("facultades", JSON.stringify(facultadesMock));
      return facultadesMock;
    } catch (error) {
      return [];
    }
  }

  async crearFacultad(facultad) {
    console.log("Creando Facultad (mock):", facultad);
    return { message: "Facultad creado" };
  }

  async actualizarFacultad(facultad) {
    console.log("Actualizando Facultad (mock):", facultad);
    return { message: "Facultad actualizado" };
  }

  async eliminarFacultad(id) {
    console.log("Eliminando Facultad con id:", id);
    return { message: "Facultad eliminado" };
  }
}
