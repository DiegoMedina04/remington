import { seedProyectoAsesor } from "../api/seed/seedProyectoAsesor.js";

export class ServicioProyectoAsesor {
  constructor() {}

  async obtenerProyectoAsesors() {
    try {
      const asesorProtectos = JSON.parse(
        localStorage.getItem("asesorProtectos")
      );
      if (asesorProtectos) {
        return asesorProtectos;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedProyectoAsesor = await response.json();
      localStorage.setItem(
        "asesorProtectos",
        JSON.stringify(seedProyectoAsesor)
      );
      return seedProyectoAsesor;
    } catch (error) {
      return [];
    }
  }

  async crearProyectoAsesor(proyectoasesor) {
    console.log("Creando ProyectoAsesor (mock):", proyectoasesor);
    return { message: "ProyectoAsesor creado" };
  }

  async actualizarProyectoAsesor(proyectoasesor) {
    console.log("Actualizando ProyectoAsesor (mock):", proyectoasesor);
    return { message: "ProyectoAsesor actualizado" };
  }

  async eliminarProyectoAsesor(id) {
    console.log("Eliminando ProyectoAsesor con id:", id);
    return { message: "ProyectoAsesor eliminado" };
  }
}
