# Formulary
Se ha creado el front end para publicar un inmueble, a este html se accede mediante la clase HomeController que asigna el archivo al /publish de la página.
Se utilizo tailwindcss y el código tiene varias partes, procedo a detallar que hace cada una:
1.Header
<body class="min-h-screen bg-linear-to-r from-white to-gray-100">

  <header class="py-10">
    <h1 class="font-serif text-center tracking-wide text-4xl md:text-6xl">
      Publique un inmueble
    </h1>
    <p class="mt-3 text-center text-gray-500">
      Rellene los datos y su anuncio estará listo en minutos
    </p>
  </header>

Aquí simplemente se pone que el fondo tenga un degradado y que como mínimo ocupe toda la pantalla, mediante el body class. Se crea un título en grande y centrado que es publique inmueble y luego un subtítulo en gris

2.Elegir tipo de casa

<main class="mx-auto grid max-w-8xl gap-25 px-40 pb-16 lg:grid-cols-[1fr_1.5fr]">

    <!-- Formulario -->
    <!-- action="/publish y method="post" para enviar el formulario al controller, que esta esperando el post, añadido enctype="multipart/form-data" para poder guardar en BBDD las fotos-->
    <form action="/publish" method="post" 
      class="space-y-5 rounded-2xl bg-white p-8 shadow-lg" enctype="multipart/form-data">

      <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
        
      <div>
        <label for="type" class="mb-1 block text-sm font-medium text-gray-700">Tipo de inmueble</label>
        <select id="type" name="type" class="w-full rounded-lg border border-gray-300 bg-white px-3 py-2 focus:border-blue-500 focus:outline-none focus:ring-2 focus:ring-blue-200">
          <option value="" disabled selected>Selecciona una opción</option>
          <option value="duplex">Dúplex</option>
          <option value="house">Casa</option>
          <option value="flat">Piso</option>
          <option value="local_or_warehouse">Local o nave</option>
          <option value="office">Oficina</option>
          <option value="storage_room">Trastero</option>
          <option value="building">Edificio</option>
          <option value="room">Habitación</option>
          <option value="container">Contenedor</option>
          <option value="hostel">Albuergue</option>
        </select>
      </div>
