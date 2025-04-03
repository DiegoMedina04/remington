import { seedProyecto } from "../api/seed/seedProyecto.js";

export class ServicioProyecto {
  constructor() {}

  async obtenerProyectos() {
    try {
      const proyectos = JSON.parse(localStorage.getItem("proyectos"));
      if (proyectos) {
        return proyectos;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedProyecto = await response.json();
      localStorage.setItem("proyectos", JSON.stringify(seedProyecto));
      return seedProyecto;
    } catch (error) {
      return [];
    }
  }

  async crearProyecto(proyecto) {
    console.log("Creando Proyecto (mock):", proyecto);
    return { message: "Proyecto creado" };
  }

  async actualizarProyecto(proyecto) {
    console.log("Actualizando Proyecto (mock):", proyecto);
    return { message: "Proyecto actualizado" };
  }

  async eliminarProyecto(id) {
    console.log("Eliminando Proyecto con id:", id);
    return { message: "Proyecto eliminado" };
  }
}
