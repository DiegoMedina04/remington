import { asesorMock } from "../api/seed/seedAsesor.js";

export class ServicioAsesor {
  async obtenerAsesors() {
    try {
      const asesores = JSON.parse(localStorage.getItem("asesores"));
      if (asesores) {
        return asesores;
      }
      // const response = await this.request(`area`, 'GET');
      // const asesoresMock = await response.json();
      localStorage.setItem("asesores", JSON.stringify(asesorMock));
      return asesorMock;
    } catch (error) {
      return [];
    }
  }
  async obtenerAsesorsPorId(id) {
    try {
      const asesores = JSON.parse(localStorage.getItem("asesores"));
      return asesores.find((asesor) => asesor.id == id);
    } catch (error) {
      return [];
    }
  }

  async crearAsesor(asesor) {
    console.log("Creando Asesor (mock):", asesor);
    return { message: "Asesor creado" };
  }

  async actualizarAsesor(asesor) {
    console.log("Actualizando Asesor (mock):", asesor);
    return { message: "Asesor actualizado" };
  }

  async eliminarAsesor(id) {
    console.log("Eliminando Asesor con id:", id);
    return { message: "Asesor eliminado" };
  }
}
