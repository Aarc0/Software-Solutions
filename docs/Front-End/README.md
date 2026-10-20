# Formulary

<img width="1165" height="328" alt="imagen" src="https://github.com/user-attachments/assets/c41dae04-a963-40c9-bf40-1222a98a4f80" /><img width="1196" height="311" alt="imagen" src="https://github.com/user-attachments/assets/3c1c3689-4acf-4a21-9097-120c104ac227" />
Se ha creado el front end para publicar un inmueble, a este html se accede mediante la clase HomeController que asigna el archivo al /publish de la página.
Se utilizo tailwindcss y el código tiene varias partes, procedo a detallar que hace cada una:

## 1. Header

<img width="786" height="369" alt="imagen" src="https://github.com/user-attachments/assets/3fe14bb4-a3f2-45fc-b204-b747eb8d752a" />


Aquí simplemente se pone que el fondo tenga un degradado y que como mínimo ocupe toda la pantalla, mediante el body class. Se crea un título en grande y centrado que es publique inmueble y luego un subtítulo en gris

## 2. Formulario del inmueble
<img width="1047" height="481" alt="imagen" src="https://github.com/user-attachments/assets/683bbc44-22d4-4397-9412-66b959995eae" />

En el main class se asignan las reglas estéticas que tiene el formulario y sus diferentes campos y crea dos columnas que son la imágen y el formulario.
El form envía los datos al controller que el usuario ha rellenado.
El input hidden ayuda a proteger el formulario frente a peticiones externas mediante un token CSRF.

- ### 2.1 Elegir tipo de casa
    <img width="1568" height="319" alt="imagen" src="https://github.com/user-attachments/assets/4d014562-b96a-4923-90e3-a93b53dcf9f5" />
    Aquí simplemente hago que cuando el usuario clique se despliegue una lista con las diferentes opciones de inmuebles, mediante un select  y con type lo asocio a una etiqueta para que el usuario pueda
    elegir.
- ### 2.2 Rellenar información del imueble
     <img width="1625" height="680" alt="imagen" src="https://github.com/user-attachments/assets/7f25f882-1d18-40d0-bcad-f7e4cce249ba" />
      Aquí se rellenan diferentes campos de los inmuebles como el precio la fianza, etc. Son prácticamente iguales salvo por el id y el for. Se hace esto para que al pasarlo  a la base de datos y al
      controller quede organizado.
      Los apartados constan de un título pequeño que indíca que campo se está rellenando luego la caja donde se rellena. Los valores numéricos tienen un mínimo de 0.
      
- ### 2.3 Descripción
     <img width="1626" height="88" alt="imagen" src="https://github.com/user-attachments/assets/5469d4ed-aff7-45bc-a007-0d15b673809b" />
      Un text area donde se rellena información adicional del inmueble.

- ### 2.4 Comodidades
     <img width="1243" height="850" alt="imagen" src="https://github.com/user-attachments/assets/4ce41251-4791-40b5-a106-481e3d15904d" />
     Casillas para marcar relacionado con comodidades del inmueble se usa fieldset para campos similares y legend para  el título.
     Las casillas son unas checkboxs que se marcan y se alamacenan en la base de datos.
  
- ### 2.5 Normas
    <img width="1099" height="190" alt="imagen" src="https://github.com/user-attachments/assets/b47306c9-830f-4546-9e20-8b1dd75b2cae" />
    Casillas para marcar relacionado con normas del inmueble se usa fieldset para campos similares y legend para  el título.
    Las casillas son unas checkboxs que se marcan y se alamacenan en la base de datos.
  
- ### 2.6 Fotos
  <img width="1729" height="96" alt="imagen" src="https://github.com/user-attachments/assets/76d5bfd5-4972-4fe1-924c-42a951a962ac" />
  Un campo que te permite subir fotos a la información del imueble y que tiene un botón azul para subirlo.
  
- ### 2.7 Botón de publicar inmueble
  <img width="1318" height="100" alt="imagen" src="https://github.com/user-attachments/assets/e8c4291e-0544-49d4-b134-3d45059da150" />

## 3. Imágen
<img width="902" height="97" alt="imagen" src="https://github.com/user-attachments/assets/3336f850-a9cf-473f-b9c4-64a2910161a9" />

Imágen que se encuentra en la columna derecha 

# Home 
Es lo que el usuario primero ve cuando ingresa en nuestra página, a través del home controller. El home fue creado casi en su totalidad por ia, el promt se hizo de la siguiente manera:
Se le pasó a la ia un esquema de la página con el carrusel sin todavía fotos dentro y se le paso  la issue  #33.
Ahora voy a proceder a explicar que hace el home:

## 1. Header 
<img width="1400" height="287" alt="imagen" src="https://github.com/user-attachments/assets/1207c13b-d6ed-4d45-88d6-c34b3b248b08" />
Se importa la api de google para usar sus fuentes de texto, se importa tailwind. 
El noscript quita la pantalla de carga si javascript está desactivado para que así no tape la página.

## 2. Theme
<img width="905" height="344" alt="imagen" src="https://github.com/user-attachments/assets/c42eadd5-d4db-40ed-9d49-8b581bde9cd3" />
Define animaciones y variables para tailwindcss:
   - ### 2.1 Fuente
     Se deciden las fuentes que hay que utilizar a través de font display para títulos y font sans para el texto general.
     
   - ### 2.2 animate
     
     - #### 2.2.1 marquue es  la regla que va a utilizar el carrusel superior en cuanto a su movimiento.
       
     - #### 2.2.2 Animación del carrusel superior. Dura 40 s, velocidad constante (linear) y se repite sin fin.
       
     - #### 2.2.3 draw es la regla que va a utilizar el carrusel inferior que va a usar en su moviemento.
       
     - #### 2.2.4 word Dibuja las líneas del icono de la casa en el loader. forwards mantiene el estado final cuando termina, en vez de volver al inicio.
       
     - #### 2.2.5 bar Llena la línea de progreso del inicio.
       
     - #### 2.2.6 beat El latido de las estrellas.
       
   - ### 2.3 @KeyFrame: Definen cómo cambia un elemento a lo largo de una animación
     
     - #### 2.3.1 sus funcionalidades son para los mismos que el animate

## 3. body y pantalla de carga
<img width="1672" height="435" alt="imagen" src="https://github.com/user-attachments/assets/e57305e5-755b-4564-95ef-0d56f5da137e" />

   - ### 3.1 En el body se deciden el ascepcto del fondo
     
   - ### 3.2 El loader pone las reglas para toda la pantalla de carga

   - ### 3.3 Puertas
     Las puertas laterales al cargar pantalla, el primer div es de la puerta izquierda y el segundo de la puerta derecha. Tiene  ease-[cubic-bezier(.77,0,.18,1)] para que la animación pase de mas rápido a
     más despacio.
     
   - ### 3.4 Casa
     
     La casa de está dentro de otro div que centra tanto a casa como las letras de de debajo. Dentro del svg dodne se han creado las reglas de color, tamaño y cordeenadas estan los paths que con ellos se
     hace el dibujo como tal.
     
   - ### 3.5 Letras
     Con la i llenamos la barra de carga
     
## 4. Fondos laterales y parallax
<img width="1214" height="183" alt="imagen" src="https://github.com/user-attachments/assets/d8c2a2e6-8cb6-47ea-98d0-3b06dbacb336" />

Crea objetos de decoración del fondo 
El contenedor fixed inset-0 cubre toda la ventana. overflow-hidden recorta lo que sobresalga.
aria-hidden="true" indica a los lectores de pantalla que estos adornos no aportan contenido.
pointer-events-none hace que no intercepten clics; z-0 los coloca en una capa de fondo.
Los dos primeros <div> crean formas estrechas en los laterales, con degradados ámbar y naranja. xl:block las muestra solo en pantallas grandes.
Los tres últimos crean círculos grandes con colores suaves y blur-3xl, que les da un aspecto difuminado. Sus atributos data-parallax pueden ser usados por JavaScript para moverlos a distintas velocidades al desplazarse la página.

## 5. Navegación 
<img width="1228" height="186" alt="imagen" src="https://github.com/user-attachments/assets/e1b67f26-f19a-4a92-9ecf-4329f0aa2d49" />
Aquí se crea la barra horizontal, los botones de inicio de sesión y de publish con su respectiva ruta /login y /publish, también las letras y la casa.

## 6. Hero
<img width="1188" height="265" alt="imagen" src="https://github.com/user-attachments/assets/53f2fb7a-34c4-4794-a129-ee230abfd568" />
Aquí se crea el título de la página principal y sus subtítulos.

- ### 6.1 `<header>`

Agrupa la cabecera de la página. `px-4` añade espacio horizontal; `pt-14` y `pb-6`, espacio arriba y abajo. `text-center` centra el texto.

- ### 6.2 Primer `<p>`

Muestra «Inmobiliaria de confianza». `text-sm` establece un tamaño pequeño, `font-medium` un grosor medio, `tracking-[.25em]` separa las letras, `text-orange-700` aplica el color naranja y `uppercase` transforma el texto en mayúsculas.

- ### 6.3 `<h1>`

Muestra el título principal: «Bienvenido a Nano Inmobiliaria». `mx-auto` lo centra; `mt-4` añade margen superior; `max-w-4xl` limita su ancho. `font-display` usa la fuente decorativa, `text-4xl` define el tamaño inicial, `leading-tight` reduce el espacio entre líneas y `font-extrabold` aplica un grosor fuerte. `sm:text-5xl` y `lg:text-7xl` aumentan el tamaño en pantallas más grandes.

- ### 6.4 Contenedor de eslóganes

`<div id="slogans">` contiene los eslóganes que aparecen debajo del título. `aria-live="off"` evita que los lectores de pantalla anuncien automáticamente sus cambios.

Las clases posicionan los eslóganes unos sobre otros, los centran y configuran su apariencia inicial: desplazados hacia abajo, transparentes y desenfocados. `transition-all duration-700` anima los cambios durante 700 milisegundos.

Cuando un eslogan tiene `data-state="active"`, se mueve a su posición, aparece y pierde el desenfoque. El estado `prev` lo desplaza hacia arriba. En pantallas pequeñas, `sm:*:text-3xl` aumenta el tamaño de los eslóganes. `motion-reduce:*:transition-none` desactiva las transiciones si el usuario prefiere reducir el movimiento.

## 7. Carruseles 

- ### 7.1 `<section>`

Agrupa la galería de inmuebles. `aria-label="Galería de inmuebles"` proporciona un nombre accesible a la sección. `space-y-2` añade espacio entre sus elementos y `py-6` añade espacio vertical alrededor.

- ### 7.2 Primer contenedor de la galería

`overflow-hidden` recorta el contenido que sobresale horizontalmente y `py-5` añade espacio vertical. `mask-image` aplica un degradado en los bordes para que las imágenes se desvanezcan gradualmente. `motion-reduce:overflow-x-auto` permite desplazarse horizontalmente si el usuario prefiere reducir el movimiento.

- ### 7.3 Primera fila

El `<div id="row1">` contiene las imágenes de la primera fila. `flex` las organiza en línea y `w-max` adapta el ancho al contenido. `animate-marquee` aplica el movimiento continuo. Al pasar el cursor, la animación se pausa; con `motion-reduce:animate-none`, se desactiva para quienes prefieren reducir el movimiento.

- ### 7.4 Segunda fila

El segundo contenedor y el `<div id="row2">` funcionan como los de la primera fila. La diferencia es `animate-marquee-rev`, que mueve las imágenes en la dirección contraria.

## 8. Mensajes de confianza 
<img width="1197" height="403" alt="imagen" src="https://github.com/user-attachments/assets/af110d31-2013-4f9d-baf8-150b157dbaa3" />

- ### 8.1 `<section>`

Agrupa las tres tarjetas de información. `mx-auto` centra la sección, `max-w-6xl` limita su ancho y `px-4 py-16` añade espacio interior horizontal y vertical.

-### 8.2 Contenedor de las tarjetas

`grid grid-cols-1` organiza las tarjetas en una columna. `md:grid-cols-3` las distribuye en tres columnas en pantallas medianas o más grandes. `gap-6` deja espacio entre ellas.

Las clases que empiezan con `*:` aplican estilos a cada elemento hijo: bordes redondeados (`rounded-2xl`), fondo blanco semitransparente (`bg-white/70`), espacio interior (`p-7`), sombra (`shadow-sm`), un borde tenue (`ring-1 ring-amber-900/10`) y fondo difuminado (`backdrop-blur`).

- ### 8.3 Tarjetas

Cada `<article class="reveal">` representa una tarjeta. La clase `reveal` permite que JavaScript o CSS aplique un efecto de aparición.

El `<span>` muestra un emoji dentro de un círculo ámbar. `aria-hidden="true"` indica que el emoji es decorativo y se puede omitir al leer la página con tecnologías de asistencia.

El `<h3>` muestra el título de la tarjeta con la fuente decorativa y texto oscuro. El `<p>` presenta debajo una descripción en gris; `mt-2` añade un pequeño margen superior.

## 9. Reseñas 

- ### 9.1 `<section>`

Agrupa la sección de opiniones. `mx-auto` la centra, `max-w-6xl` limita su ancho, `px-4` añade espacio a los lados y `pb-16` deja espacio debajo.

- ### 9.2 Título `<h2>`

Muestra «Lo que dicen nuestros huéspedes». `reveal` permite aplicar un efecto de aparición; `mb-10` añade espacio debajo; `text-center` centra el título. `font-display`, `text-3xl` y `font-semibold` definen la fuente, el tamaño y el grosor. En pantallas pequeñas o mayores, `sm:text-4xl` aumenta el tamaño.

- ### 9.3 Cuadrícula de opiniones

El `<div>` organiza las opiniones en una columna y, desde el tamaño mediano, en tres (`grid-cols-1`, `md:grid-cols-3`). `gap-6` deja espacio entre ellas. Las clases `*:` aplican a cada elemento hijo bordes redondeados, fondo blanco semitransparente, espacio interior, sombra y un borde tenue.

- ### 9.4 Opiniones

Cada `<figure>` representa una opinión y usa `reveal` para el efecto de aparición.

El `<div data-stars="5">` o `<div data-stars="4">` indica cuántas estrellas mostrar. JavaScript puede leer ese valor y generar las estrellas.

`<blockquote>` contiene el comentario. `<figcaption>` identifica a quien lo escribió y añade información sobre su estancia o compra. Las clases dan formato al texto y separan los elementos con márgenes.

## 10 Recuadro inferior de publciar inmueble

<img width="1218" height="179" alt="imagen" src="https://github.com/user-attachments/assets/a1746d19-70ce-4fd3-87d4-9c6b49c3839e" />

- ### 10.1 `<section>`

Agrupa el bloque que invita a publicar un inmueble. `mx-auto` centra la sección, `max-w-4xl` limita su ancho, `px-4` añade espacio a los lados y `pb-16` deja espacio debajo.

- ### 10.2 Contenedor de la invitación

El `<div>` contiene el título, el texto y el enlace. `reveal` permite aplicar un efecto de aparición. `rounded-3xl` redondea las esquinas, `bg-orange-900` aplica el fondo naranja oscuro, `px-6 py-14` añade espacio interior, `text-center` centra el contenido y `shadow-xl` añade una sombra pronunciada.

- ### 10.3 Título `<h2>`

Invita a dar a conocer un inmueble. `mx-auto max-w-2xl` limita el ancho y centra el título. `font-display`, `text-3xl` y `font-semibold` definen la fuente, el tamaño y el grosor; `text-amber-100` establece el color. En pantallas pequeñas o mayores, `sm:text-4xl` aumenta el tamaño.

- ### 10.4 Texto descriptivo

El `<p>` explica que se puede publicar el inmueble para que lo vean posibles interesados. `mt-4` añade espacio sobre el texto; `mx-auto max-w-xl` limita su ancho y lo centra. `text-lg` establece el tamaño y `text-amber-200/90` aplica un tono ámbar semitransparente.

- ### 10.5 Enlace para publicar

El `<a href="/publish">` lleva a la página de publicación. Sus clases lo muestran como un botón redondeado, con fondo ámbar y texto oscuro. `mt-8` añade espacio arriba; `transition` suaviza los cambios de estilo y `hover:bg-amber-200` aclara el fondo al pasar el cursor.

## 11 JavaScript Pantalla de carga
<img width="1215" height="483" alt="imagen" src="https://github.com/user-attachments/assets/e32f1f8e-c015-408b-ba7f-419a864c59fa" />

- ### 11.1 Función para buscar elementos

`const $ = (id) => document.getElementById(id);` crea una función abreviada para buscar un elemento HTML por su `id`. Por ejemplo, `$('loader')` equivale a `document.getElementById('loader')`.

- ### 11.2 Preferencia de movimiento

`matchMedia('(prefers-reduced-motion: reduce)').matches` comprueba si el usuario ha indicado en su dispositivo que prefiere reducir las animaciones. La variable `reduced` guarda el resultado: `true` si las quiere reducir y `false` en caso contrario.

- ### 11.3 Elementos de la pantalla de carga

`const loader = $('loader');` busca el contenedor de la pantalla de carga.

`const phrase = $('phrase');` busca el elemento donde se insertará la frase de bienvenida.

- ### 11.4 Frase de bienvenida

`'Detrás de cada puerta hay una historia esperando.'.split(' ')` divide la frase en palabras y crea un arreglo con ellas. Por ejemplo, `Detrás` es el primer elemento y `puerta` es otro.

- ### 11.5 Recorrido de las palabras

`words.forEach((w, i) => { ... })` ejecuta el bloque una vez por cada palabra. En cada repetición, `w` contiene la palabra actual e `i` su posición en el arreglo, empezando desde cero.

- ### 11.6 Creación de cada palabra

`document.createElement('span')` crea un elemento `<span>` nuevo para envolver la palabra actual.

- ### 11.7 Clases y animación

` s.className = ...` asigna clases al `<span>`. Estas hacen que la palabra aparezca como un elemento en línea, inicialmente desplazado, transparente y desenfocado, y le aplican la animación `animate-word`.

`[animation-delay:calc(var(--w)*150ms_+_600ms)]` calcula un retraso distinto para cada palabra. Así aparecen escalonadamente, con 150 milisegundos adicionales entre palabras, después de una espera inicial de 600 milisegundos.

`motion-reduce:...` adapta el aspecto si el usuario prefiere reducir el movimiento: coloca la palabra en su posición, la hace visible, quita el desenfoque y desactiva la animación.

- ### 11.Resaltado de las últimas palabras

`(i >= words.length - 2 ? ... : '')` comprueba si la palabra actual está entre las dos últimas. Si lo está, añade las clases `hl`, `font-display`, `text-amber-300` e `italic` para resaltarla. Para las demás palabras, añade una cadena vacía.

- ### 11.9 Retraso individual

` s.style.setProperty('--w', i);` define la variable CSS `--w` con la posición de la palabra. La clase de retraso usa ese valor para calcular cuándo comienza su animación.

- ### 11.10 Texto de cada elemento

` s.textContent = w;` coloca la palabra actual dentro del `<span>` como texto.

- ### 11.11 Inserción en la página

`phrase.append(s, ' ');` añade el `<span>` al elemento `phrase` y, a continuación, agrega un espacio. Esto mantiene separadas las palabras al mostrarlas.

- ### 11.12 Estado de apertura

`let opened = false;` crea una variable que indica si la pantalla de carga ya se ha abierto. Al principio es `false`.

- ### 11.13 Función para abrir las puertas

`const openDoors = () => { ... }` define la función que inicia la apertura de la pantalla de carga.

- `if (opened) return;` evita que la función se ejecute de nuevo si las puertas ya se abrieron.
- `opened = true;` registra que la apertura ha comenzado.
- `loader.classList.add('open');` añade la clase `open` al contenedor. Los estilos asociados a esa clase animan las puertas y ocultan el contenido de bienvenida.
- `setTimeout(() => loader.remove(), 1600);` espera 1600 milisegundos y después elimina el `loader` de la página.

- ### 11.14 Comprobación de carga de la página

`const loaded = new Promise(...)` crea una promesa que se resuelve cuando la página termina de cargar.

`document.readyState === 'complete'` comprueba si ya terminó la carga. Si es así, se resuelve la promesa inmediatamente con `r()`. Si todavía no terminó, `addEventListener('load', r)` espera al evento `load` y la resuelve cuando ocurra.

- ### 11.15 Tiempo mínimo de la pantalla

`const minTime = new Promise((r) => setTimeout(r, 3800));` crea una promesa que se resuelve tras 3800 milisegundos. Esto mantiene visible la pantalla de carga durante un tiempo mínimo.

- ### 11.16 Apertura automática

`Promise.all([loaded, minTime]).then(openDoors);` espera a que se resuelvan las dos promesas: la carga de la página y el tiempo mínimo. Cuando ambas se cumplen, ejecuta `openDoors`.

- ### 11.17 Apertura al hacer clic

`loader.addEventListener('click', openDoors);` permite abrir las puertas al hacer clic en cualquier parte de la pantalla de carga. La variable `opened` impide que se inicie más de una vez.

## 12. Carruseles javascript

<img width="1190" height="397" alt="imagen" src="https://github.com/user-attachments/assets/f54b5c1c-ea22-4cd2-9aa9-6d384d733f85" />

### 12.1 Lista de imágenes

`const imgs = [...]` crea una lista con los nombres de los seis archivos de imagen que se mostrarán en los carruseles.

### 12.2 Función para construir una fila

`function buildRow(el, list, w, h)` define una función que genera una fila de imágenes.

- `el` es el elemento HTML donde se insertará la fila.
- `list` es la lista de imágenes que se mostrarán.
- `w` y `h` contienen las clases CSS para el ancho y el alto de cada imagen.

### 12.3 Función para crear un grupo

`const group = (dup) => { ... }` define una función que crea un grupo de imágenes. El parámetro `dup` indica si el grupo es una copia del primero.

### 12.4 Contenedor del grupo

`document.createElement('div')` crea un `<div>` para contener las imágenes.

`g.className = ...` aplica estilos para colocar las imágenes en fila, evitar que se encojan y dejar espacio entre ellas. Si `dup` es verdadero, añade `motion-reduce:hidden` para ocultar la copia cuando el usuario prefiere reducir el movimiento.

### 12.5 Accesibilidad de la copia

`if (dup) g.setAttribute('aria-hidden', 'true');` marca la copia como oculta para lectores de pantalla. Así se evita que anuncien dos veces las mismas imágenes.

### 12.6 Creación de las imágenes

`list.map((src, i) => ...)` recorre la lista y genera el HTML de cada imagen. `src` contiene el nombre del archivo y `i` su posición.

Las clases del contenedor de cada imagen controlan su tamaño, posición, bordes redondeados y efectos al pasar el cursor: se agranda ligeramente, gira y queda por encima de las imágenes vecinas.

El contenedor interior recorta el contenido que sobresale, aplica una sombra y añade efectos decorativos de brillo y degradado al pasar el cursor.

### 12.7 Elemento `<img>`

`<img src="${src}">` carga la imagen correspondiente.

`alt="${dup ? '' : 'Inmueble ' + (i + 1)}"` asigna una descripción a las imágenes originales, como «Inmueble 1». A las copias les asigna un texto alternativo vacío porque son decorativas.

`loading="lazy"` permite aplazar la carga de las imágenes hasta que se acerquen a la zona visible. `draggable="false"` evita que se puedan arrastrar.

### 12.8 Unión del HTML generado

`.join('')` une el HTML de todas las imágenes en una sola cadena, sin separadores entre ellas. `g.innerHTML = ...` inserta esa cadena dentro del grupo.

`return g;` devuelve el grupo ya creado.

### 12.9 Inserción de los grupos

`el.append(group(false), group(true));` añade al elemento de destino el grupo original y una copia. La copia permite que el carrusel parezca continuo durante el desplazamiento.

### 12.10 Creación de las dos filas

`buildRow($('row1'), imgs, 'w-56 sm:w-80', 'h-40 sm:h-56');` crea la primera fila con la lista original y sus tamaños.

`buildRow($('row2'), [...imgs].reverse(), 'w-44 sm:w-60', 'h-32 sm:h-44');` crea la segunda fila con una copia invertida de la lista. `[...imgs]` copia el arreglo para no modificar el original y `reverse()` invierte el orden de las imágenes.

## 13. Slogans javaScript

<img width="1086" height="180" alt="imagen" src="https://github.com/user-attachments/assets/6a3ce922-1216-4f9b-9df7-8b2c206f150a" />

- ### 13.1 Selección de los eslóganes

`document.querySelectorAll('[data-slogan]')` busca todos los elementos HTML que tienen el atributo `data-slogan`.

`[...document.querySelectorAll(...)]` convierte el resultado en un arreglo, que se guarda en `slogans`.

- ### 13.2 Índice del eslogan actual

`let cur = 0;` crea una variable que guarda la posición del eslogan que se está mostrando. Empieza en `0`, que corresponde al primer elemento del arreglo.

- ### 13.3 Función para actualizar los estados

`const setSlogans = () => ...` define una función que recorre todos los eslóganes y actualiza su estado.

`forEach((el, i) => { ... })` recorre el arreglo: `el` es el elemento actual e `i` su posición.

La asignación `el.dataset.state = ...` establece el atributo `data-state` de cada elemento:

- `active` para el eslogan cuya posición coincide con `cur`.
- `prev` para el eslogan anterior al actual.
- `next` para los demás.

El operador `% slogans.length` hace que el cálculo vuelva al final del arreglo cuando llega al principio, manteniendo la secuencia circular.

- ### 13.4 Mostrar el estado inicial

`setSlogans();` llama a la función una vez para asignar los estados iniciales y mostrar el primer eslogan como activo.

- ### 13.5 Rotación automática

`setInterval(..., 3500)` ejecuta una función cada 3500 milisegundos, es decir, cada 3,5 segundos.

Dentro de ella, `cur = (cur + 1) % slogans.length` avanza al siguiente eslogan y vuelve al primero al llegar al final. Después, `setSlogans()` actualiza los estados para que se muestre el nuevo eslogan.

## 14. Estrellas 

<img width="1195" height="187" alt="imagen" src="https://github.com/user-attachments/assets/fb8aca73-5b7c-42af-96d7-e5c6dfa04886" />

- ### 14.1 Búsqueda de los elementos con estrellas

`document.querySelectorAll('[data-stars]')` busca todos los elementos que tienen el atributo `data-stars`. Cada uno representa una valoración.

`forEach((el) => { ... })` recorre esos elementos. En cada repetición, `el` representa una valoración.

- ### 14.2 Número de estrellas

`const n = +el.dataset.stars;` lee el valor de `data-stars` y lo convierte en número con el operador `+`. Por ejemplo, `data-stars="4"` se convierte en el número `4`.

- ### 14.3 Accesibilidad de la valoración

`el.setAttribute('role', 'img');` indica a las tecnologías de asistencia que el conjunto de estrellas debe tratarse como una imagen.

`el.setAttribute('aria-label', \`${n} de 5 estrellas\`);` proporciona una descripción accesible, como «4 de 5 estrellas».

- ### 14.4 Creación de las cinco estrellas

`for (let i = 0; i < 5; i++)` repite el bloque cinco veces, creando una estrella en cada iteración. `i` empieza en `0` y llega hasta `4`.

- ### 14.5 Dibujo y color de cada estrella

`el.insertAdjacentHTML('beforeend', ...)` añade al final del elemento una estrella SVG.

El atributo `viewBox="0 0 24 24"` define el área de dibujo del SVG. `aria-hidden="true"` oculta cada estrella individual a los lectores de pantalla, ya que la valoración completa ya tiene una descripción accesible.

`style="--i:${i}"` guarda la posición de la estrella en la variable CSS `--i`. Se usa para aplicar un retraso distinto a cada animación.

- ### 14.6 Estrellas valoradas y no valoradas

`i < n` comprueba si la posición de la estrella está dentro de la valoración:

- Si la condición se cumple, la estrella aparece en ámbar (`text-amber-500`) y recibe la animación `animate-beat`. El retraso calculado con `--i` escalona la animación.
- Si no se cumple, aparece en gris (`text-stone-300`).

`motion-reduce:animate-none` desactiva la animación si el usuario ha configurado su dispositivo para reducir el movimiento.

- ### 14.7 Forma de la estrella

`<path d="..."/>` contiene las coordenadas SVG que dibujan la forma de la estrella. Cada una de las cinco repeticiones inserta una estrella con esa forma.

## 15 Parallax y sombra javascript


<img width="1165" height="328" alt="imagen" src="https://github.com/user-attachments/assets/0a8926ac-43ce-4982-baba-612f1f72947e" />

- ### 15.1 Elemento de navegación

`const nav = $('nav');` busca el elemento de navegación que tiene `id="nav"`. Más adelante se le añade o quita una sombra según la posición del desplazamiento.

- ### 15.2 Elementos con efecto parallax

`document.querySelectorAll('[data-parallax]')` busca los elementos que tienen el atributo `data-parallax`.

`[...document.querySelectorAll(...)]` convierte el resultado en un arreglo, que se guarda en `par`.

- ### 15.3 Elementos laterales

`document.querySelectorAll('[data-side]')` busca los elementos decorativos que tienen el atributo `data-side`. El resultado se convierte en un arreglo y se guarda en `side`.

- ### 15.4 Control de actualizaciones

`let ticking = false;` crea una variable que indica si ya hay una actualización pendiente. Sirve para evitar que se acumulen muchas llamadas mientras el usuario se desplaza.

- ### 15.5 Función de actualización

`const update = () => { ... }` define la función que actualiza los estilos según la posición de desplazamiento de la página.

`const y = scrollY;` guarda en `y` cuánto se ha desplazado verticalmente la página.

- ### 15.6 Sombra de la navegación

`nav.classList.toggle('shadow-md', y > 10);` añade la clase `shadow-md` cuando el desplazamiento supera los 10 píxeles y la quita cuando vuelve a ser de 10 píxeles o menos.

- ### 15.7 Movimiento de los elementos parallax

`if (!reduced)` comprueba que el usuario no haya indicado que prefiere reducir el movimiento. Solo en ese caso se aplican los desplazamientos animados.

`par.forEach(...)` recorre los elementos con `data-parallax`. A cada uno le aplica una transformación vertical calculada con la posición de desplazamiento (`y`) y el valor de su atributo `data-parallax`. El signo negativo hace que se mueva hacia arriba al desplazarse hacia abajo.

`translate3d(0, ..., 0)` desplaza el elemento verticalmente sin cambiar su posición horizontal. Puede ayudar al navegador a representar el movimiento de forma fluida.

- ### 15.8 Movimiento de los elementos laterales

`side.forEach(...)` recorre los elementos laterales y los desplaza verticalmente según el desplazamiento de la página. `y * 0.2` hace que se muevan al 20 % de la distancia recorrida.

- ### 15.9 Final de la actualización

`ticking = false;` indica que la actualización terminó y que ya se puede programar otra.

- ### 15.10 Reacción al desplazamiento

`addEventListener('scroll', ...)` registra una función que se ejecuta cuando el usuario desplaza la página.

`if (!ticking)` comprueba que no haya ya una actualización pendiente. Si no la hay, establece `ticking = true` y programa `update` para el siguiente cuadro de animación con `requestAnimationFrame(update)`.

`{ passive: true }` indica que el evento no va a cancelar el desplazamiento, lo que permite al navegador gestionarlo mejor.

- ### 15.11 Actualización inicial

`update();` ejecuta la función una vez al cargar este código para aplicar los estilos que correspondan a la posición inicial de la página.

## 16. Reveal JavaScript

- ### 16.1 Clases para la aparición

`const REVEAL = '...'` guarda en una cadena las clases CSS que se aplicarán a los elementos con `reveal`.

- `opacity-0` los hace inicialmente transparentes.
- `translate-y-[70px]` los desplaza 70 píxeles hacia abajo.
- `transition-all duration-700` anima los cambios durante 700 milisegundos.
- `[&.visible]:opacity-100` y `[&.visible]:translate-y-0` hacen que, al tener la clase `visible`, aparezcan y vuelvan a su posición.
- `motion-reduce:...` evita el desplazamiento y la transición si el usuario prefiere reducir el movimiento.

- ### 16.2 Observador de visibilidad

`new IntersectionObserver(...)` crea un observador que detecta cuándo los elementos entran en la zona visible de la página.

El parámetro `entries` contiene los elementos observados y sus estados de visibilidad. `entries.forEach((e) => ...)` procesa cada uno.

`e.isIntersecting` indica si el elemento está dentro del área visible. Cuando lo está, `e.target.classList.add('visible')` añade la clase que activa su aparición. Después, `io.unobserve(e.target)` deja de observarlo, porque ya se mostró.

`{ threshold: 0.15 }` establece que el efecto se active cuando al menos el 15 % del elemento sea visible.

- ### 16.3 Búsqueda de elementos

`document.querySelectorAll('.reveal')` busca todos los elementos que tienen la clase `reveal`.

`forEach((el) => { ... })` aplica la configuración a cada uno.

- ### 16.4 Aplicación de las clases

`REVEAL.split(' ')` divide la cadena de clases en un arreglo. `el.classList.add(...REVEAL.split(' '))` añade esas clases al elemento actual.

- ### 16.5 Retraso escalonado

`[...el.parentNode.children].indexOf(el)` encuentra la posición del elemento entre los hijos de su contenedor.

`el.style.transitionDelay = ...` establece el retraso de la transición según esa posición. Al multiplicarla por `120`, cada elemento espera 120 milisegundos más que el anterior.

- ### 16.6 Inicio de la observación

`io.observe(el);` registra el elemento para que el observador detecte cuándo entra en la zona visible y active su animación.

# Login 

Cuenta con dos campos a rellenar, Usuario y contraseña. Usuario tiene la id usuarioemail y contraseña con id contrasena, ambos son enviados al controler mediante un form con un post.
Abajo un hipervínuclo para ir a registrarse si el usario no ha creado una cuenta.

# Register

Cuenta con dos campos a rellenar, Usuario y contraseña. Usuario tiene la id usuarioemail, contraseña con id contrasena, email con id email  y repetir contraseña con contrasena también, todos  son enviados al controler mediante un form con un post.
Abajo un hipervínuclo para ir al login.

