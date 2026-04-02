# PSP - Procesos

Completa el código proporcionado. Los test unitarios te ayudarán a completar los detalles que no estén en estas especificaciones.

## Especificaciones:
Escribe un programa ProcesarFrases que cante con una sola vocal el texto introducido utilizando dos procesos auxiliares: ReemplazarVocales y Cantar.
Ejemplos: 
```
	argumento I, frase introducida: "Hola", salida "HIlI"
	argumento u, frase introducida: "¡aeiou!", salida "¡uuuuu!"
```
- Si no recibe argumentos, la vocal de salida será la A mayúscula.
- Si recibe argumentos, la vocal de salida será el primer argumento.
- El proceso de reemplazar vocales substituirá todas las instancias de vocales (en mayúsculas y minúsculas, sin acentos) por el caracter '_'.
- El proceso de cantar, reemplazará todos los '_' por la vocal recibida como parámetro.
- Cantar: si no recibe argumentos, saldrá con el código 2.
- Cantar: si el argumento recibido no es una vocal, saldrá con el código 3.
- Tras el lanzamiento de cada proceso, imprimiremos, por la salida de error, el mensaje "PID " + comandos del processBuilder + ": " + pid del proceso lanzado.
Ej: 
```
PID [java, -cp, ..., psp.prac01.ReemplazarVocales]: 38338
PID [java, -cp, ..., psp.prac01.Cantar, A]: 38339
```
Siendo los ... el classpath completo.

## Requisitos:
- Debes respetar el código proporcionado.
- Debes utilizar java.lang.Process
- Cuida la calidad de tu código.
- Puedes utilizar los métodos auxiliares proporcionados.
- Los ficheros de salida (los .class) deben ir a la carpeta ./build/classes
- Al lanzar los procesos, para que funcionen en el entorno de entrega, es necesario añadirle el classpath
```
new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), ...
```

## Rúbrica:
- ReemplazarVocalesTest: 2 puntos
- CantarTest: 2 puntos
- ProcesarFrasesTest.okVocal*: 2 puntos
- ProcesarFrasesTest.okProcess*: 2 puntos
- ProcesarFrasesTest.ko*: 2 puntos
- Revisión manual: 5 puntos

## Nota:
En la página https://www.geeksforgeeks.org/how-to-clone-a-project-from-github-using-eclipse/ te explican cómo importar el proyecto en tu Eclipse.