import { BASE_URL } from "../api/api.js";
import { areasMock } from "../api/seed/seedArea.js";

export class ServicioArea {
  constructor(id, nombre, descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  async request(endpoint, tipoSolicitud, data = null) {
    let options = {
      method: tipoSolicitud,
      headers: {
        "Content-Type": "application/json",
      },
    };
    if (data) {
      options.body = JSON.stringify(data);
    }
    const response = await fetch(`${BASE_URL}/${endpoint}`, options);
    if (!response.ok) {
      throw new Error(`Error: ${response.status} - ${response.statusText}`);
    }
    return response.status !== 204 ? response.json() : null;
  }

  async obtenerAreas() {
    try {
      const areas = JSON.parse(localStorage.getItem("areas"));
      if (areas) {
        return areas;
      }
      // const response = await this.request(`area`, 'GET');
      // const areasMock = await response.json();
      localStorage.setItem("areas", JSON.stringify(areasMock));
      return areasMock;
    } catch (error) {
      return [];
    }
  }

  async obtenerAreaPorId(id) {
    try {
      // const response = await this.request(`area/${id}`, "GET");
      // const data = await response.json();
      // return data;
      const areas = JSON.parse(localStorage.getItem("areas"));
      return areas.find((area) => area.id == id);
    } catch (error) {
      return [];
    }
  }

  async crearArea(area) {
    try {
      const response = await this.request(`area`, "POST", area);
      return response;
    } catch (error) {
      return [];
    }
  }

  async actualizarArea(area) {
    try {
      const response = await this.request(`area`, "PUT", area);
      return response;
    } catch (error) {
      return [];
    }
  }

  async eliminarArea(id) {
    try {
      const response = await this.request(`area/${id}`, "DELETE");
      return response;
    } catch (error) {
      return [];
    }
  }
}
