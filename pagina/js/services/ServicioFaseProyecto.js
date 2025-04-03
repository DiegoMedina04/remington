import { seedFaseProyecto } from "../api/seed/seedFaseProyecto.js";

export class ServicioFaseProyecto {
  constructor() {}

  async obtenerFaseProyectos() {
    try {
      const faseProyecto = JSON.parse(localStorage.getItem("fasesproyecto"));
      if (faseProyecto) {
        return faseProyecto;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedFaseProyecto = await response.json();
      localStorage.setItem("fasesproyecto", JSON.stringify(seedFaseProyecto));
      return seedFaseProyecto;
    } catch (error) {
      return [];
    }
  }

  async crearFaseProyecto(faseproyecto) {
    console.log("Creando FaseProyecto (mock):", faseproyecto);
    return { message: "FaseProyecto creado" };
  }

  async actualizarFaseProyecto(faseproyecto) {
    console.log("Actualizando FaseProyecto (mock):", faseproyecto);
    return { message: "FaseProyecto actualizado" };
  }

  async eliminarFaseProyecto(id) {
    console.log("Eliminando FaseProyecto con id:", id);
    return { message: "FaseProyecto eliminado" };
  }
}
