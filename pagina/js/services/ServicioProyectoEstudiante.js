import { seedProyectoEstudiante } from "../api/seed/seedProyectoEstudiante.js";

export class ServicioProyectoEstudiante {
  constructor() {}

  async obtenerProyectoEstudiantes() {
    try {
      const proyectosEstudiantes = JSON.parse(
        localStorage.getItem("proyectosEstudiantes")
      );
      if (proyectosEstudiantes) {
        return proyectosEstudiantes;
      }
      // const response = await this.request(`area`, 'GET');
      // const convocatoriasMock = await response.json();
      localStorage.setItem(
        "proyectosEstudiantes",
        JSON.stringify(seedProyectoEstudiante)
      );
      return seedProyectoEstudiante;
    } catch (error) {
      return [];
    }
  }

  async crearProyectoEstudiante(proyectoestudiante) {
    console.log("Creando ProyectoEstudiante (mock):", proyectoestudiante);
    return { message: "ProyectoEstudiante creado" };
  }

  async actualizarProyectoEstudiante(proyectoestudiante) {
    console.log("Actualizando ProyectoEstudiante (mock):", proyectoestudiante);
    return { message: "ProyectoEstudiante actualizado" };
  }

  async eliminarProyectoEstudiante(id) {
    console.log("Eliminando ProyectoEstudiante con id:", id);
    return { message: "ProyectoEstudiante eliminado" };
  }
}
