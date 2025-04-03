import { seedSede } from "../api/seed/seedSede.js";

export class ServicioSede {
  constructor() {}

  async obtenerSedes() {
    try {
      const sedes = JSON.parse(localStorage.getItem("sedes"));
      if (sedes) {
        return sedes;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedSede = await response.json();
      localStorage.setItem("sedes", JSON.stringify(seedSede));
      return seedSede;
    } catch (error) {
      return [];
    }
  }

  async crearSede(sede) {
    console.log("Creando Sede (mock):", sede);
    return { message: "Sede creado" };
  }

  async actualizarSede(sede) {
    console.log("Actualizando Sede (mock):", sede);
    return { message: "Sede actualizado" };
  }

  async eliminarSede(id) {
    console.log("Eliminando Sede con id:", id);
    return { message: "Sede eliminado" };
  }
}
