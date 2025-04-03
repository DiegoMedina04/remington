import { seedEstudiantes } from "../api/seed/seedEstudiante.js";

export class ServicioEstudiante {
  constructor() {}

  async obtenerEstudiantes() {
    try {
      const estudiantes = JSON.parse(localStorage.getItem("estudiantes"));
      if (estudiantes) {
        return estudiantes;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedEstudiantes = await response.json();
      localStorage.setItem("estudiantes", JSON.stringify(seedEstudiantes));
      return seedEstudiantes;
    } catch (error) {
      return [];
    }
  }

  async crearEstudiante(estudiante) {
    console.log("Creando Estudiante (mock):", estudiante);
    return { message: "Estudiante creado" };
  }

  async actualizarEstudiante(estudiante) {
    console.log("Actualizando Estudiante (mock):", estudiante);
    return { message: "Estudiante actualizado" };
  }

  async eliminarEstudiante(id) {
    console.log("Eliminando Estudiante con id:", id);
    return { message: "Estudiante eliminado" };
  }
}
