document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("formArea");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const data = {
      nombre: document.getElementById("nombre").value,
      estado: document.getElementById("estado").value,
    };

    try {
      const res = await fetch("http://localhost:8080/api/area", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      });

      if (!res.ok) throw new Error("Error al guardar");
      alert("Área guardada correctamente");
      form.reset();
    } catch (error) {
      console.error(error);
      alert("Hubo un error al enviar el formulario.");
    }
  });
});
