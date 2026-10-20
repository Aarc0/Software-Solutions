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
  Un campo que te permite subir fotos a la información del imueble y que tiene un botón azul para subirlo
- ### 2.7 Botón de publicar inmueble
  <img width="1318" height="100" alt="imagen" src="https://github.com/user-attachments/assets/e8c4291e-0544-49d4-b134-3d45059da150" />

## 3. Imágen
<img width="902" height="97" alt="imagen" src="https://github.com/user-attachments/assets/3336f850-a9cf-473f-b9c4-64a2910161a9" />

Imágen que se encuentra en la columna derecha 

# Home 
Es lo que el usuario primero ve cuando ingresa en nuestra página. El home fue creado casi en su totalidad por ia, el promt se hizo de la siguiente manera:
Se le pasó a la ia un esquema de la página con el carrusel sin todavía fotos dentro y se le paso  la issue  #33.
Ahora voy a proceder a explicar que hace el home:

## 1. Header 
<img width="1400" height="287" alt="imagen" src="https://github.com/user-attachments/assets/1207c13b-d6ed-4d45-88d6-c34b3b248b08" />
Se importa la api de google para usar sus fuentes de texto, se importa tailwind. 
El noscript quita la pantalla de carga si javascript está desactivado para que así no tape la página.
## 2. Theme
<img width="905" height="344" alt="imagen" src="https://github.com/user-attachments/assets/c42eadd5-d4db-40ed-9d49-8b581bde9cd3" />
Define animaciones y variables para tailwindcss: Las fuentes, los animates son las reglas de animación del carrusel y por útlimo los @keyframe




