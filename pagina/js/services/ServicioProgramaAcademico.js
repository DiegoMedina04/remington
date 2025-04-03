import { seedProgramaAcademico } from "../api/seed/seedProgramaAcademico.js";

export class ServicioProgramaAcademico {
  constructor() {}

  async obtenerProgramaAcademicos() {
    try {
      const programasAcademicos = JSON.parse(
        localStorage.getItem("programasAcademicos")
      );
      if (programasAcademicos) {
        return programasAcademicos;
      }
      // const response = await this.request(`area`, 'GET');
      // const seedProgramaAcademico = await response.json();
      localStorage.setItem(
        "programasAcademicos",
        JSON.stringify(seedProgramaAcademico)
      );
      return seedProgramaAcademico;
    } catch (error) {
      return [];
    }
  }

  async crearProgramaAcademico(programaacademico) {
    console.log("Creando ProgramaAcademico (mock):", programaacademico);
    return { message: "ProgramaAcademico creado" };
  }

  async actualizarProgramaAcademico(programaacademico) {
    console.log("Actualizando ProgramaAcademico (mock):", programaacademico);
    return { message: "ProgramaAcademico actualizado" };
  }

  async eliminarProgramaAcademico(id) {
    console.log("Eliminando ProgramaAcademico con id:", id);
    return { message: "ProgramaAcademico eliminado" };
  }
}
