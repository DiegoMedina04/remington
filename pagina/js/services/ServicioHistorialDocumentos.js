import { seedHistorialDocumento } from "../api/seed/seedHistorialDocumento.js";

export class ServicioHistorialDocumento {
  constructor() {}

  async obtenerHistorialDocumentos() {
    try {
      const historialdocumento = JSON.parse(
        localStorage.getItem("historialDocumentos")
      );
      if (historialdocumento) {
        return historialdocumento;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedHistorialDocumento = await response.json();
      localStorage.setItem(
        "historialDocumentos",
        JSON.stringify(seedHistorialDocumento)
      );
      return seedHistorialDocumento;
    } catch (error) {
      return [];
    }
  }

  async crearHistorialDocumento(historialdocumento) {
    console.log("Creando HistorialDocumento (mock):", historialdocumento);
    return { message: "HistorialDocumento creado" };
  }

  async actualizarHistorialDocumento(historialdocumento) {
    console.log("Actualizando HistorialDocumento (mock):", historialdocumento);
    return { message: "HistorialDocumento actualizado" };
  }

  async eliminarHistorialDocumento(id) {
    console.log("Eliminando HistorialDocumento con id:", id);
    return { message: "HistorialDocumento eliminado" };
  }
}
