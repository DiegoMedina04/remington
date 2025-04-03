import { convocatoriasMock } from "../api/seed/seedConvocatoria.js";

export class ServicioConvocatoria {
  constructor() {}

  async obtenerConvocatorias() {
    try {
      const convocatorias = JSON.parse(localStorage.getItem("convocatorias"));
      if (convocatorias) {
        return convocatorias;
      }
      // const response = await this.request(`area`, 'GET');
      // const convocatoriasMock = await response.json();
      localStorage.setItem("convocatorias", JSON.stringify(convocatoriasMock));
      console.log(convocatoriasMock);
      return convocatoriasMock;
    } catch (error) {
      return [];
    }
  }

  async crearConvocatoria(convocatoria) {
    console.log("Creando Convocatoria (mock):", convocatoria);
    return { message: "Convocatoria creado" };
  }

  async actualizarConvocatoria(convocatoria) {
    console.log("Actualizando Convocatoria (mock):", convocatoria);
    return { message: "Convocatoria actualizado" };
  }

  async eliminarConvocatoria(id) {
    console.log("Eliminando Convocatoria con id:", id);
    return { message: "Convocatoria eliminado" };
  }
}
