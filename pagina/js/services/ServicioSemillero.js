import { seedSemillero } from "../api/seed/seedSemillero.js";

export class ServicioSemillero {
  constructor() {}

  async obtenerSemilleros() {
    try {
      const semilleros = JSON.parse(localStorage.getItem("semilleros"));
      if (semilleros) {
        return semilleros;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedSemillero = await response.json();
      localStorage.setItem("semilleros", JSON.stringify(seedSemillero));
      return seedSemillero;
    } catch (error) {
      return [];
    }
  }

  async crearSemillero(semillero) {
    console.log("Creando Semillero (mock):", semillero);
    return { message: "Semillero creado" };
  }

  async actualizarSemillero(semillero) {
    console.log("Actualizando Semillero (mock):", semillero);
    return { message: "Semillero actualizado" };
  }

  async eliminarSemillero(id) {
    console.log("Eliminando Semillero con id:", id);
    return { message: "Semillero eliminado" };
  }
}
