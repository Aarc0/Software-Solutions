# Formulary
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

## 10
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


