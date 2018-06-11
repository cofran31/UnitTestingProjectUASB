# Proyecto Final - Pruebas Unitarias - Análisis del Sentimiento

[![Build Status](https://travis-ci.org/j3kstrum/CodeCarnage.svg?branch=ekstrum)](https://travis-ci.org/j3kstrum/CodeCarnage) [![Build Status (Windows)](https://img.shields.io/appveyor/ci/platan/idea-gradle-dependencies-formatter/master.svg?label=build%20(Windows))](https://ci.appveyor.com/project/platan/idea-gradle-dependencies-formatter) [![Coverage Status](https://coveralls.io/repos/platan/idea-gradle-dependencies-formatter/badge.svg?branch=master&service=github)](https://coveralls.io/github/platan/idea-gradle-dependencies-formatter?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/1a2524f23e9b49538760cdce6368bf8e)](https://www.codacy.com/app/platan/idea-gradle-dependencies-formatter?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=platan/idea-gradle-dependencies-formatter&amp;utm_campaign=Badge_Grade) [![codebeat badge](https://codebeat.co/badges/669c521f-7ecb-4e0a-a079-fa5c28ca17c7)](https://codebeat.co/projects/github-com-platan-idea-gradle-dependencies-formatter-master)

_**Docente:**_  Ing. Marcelo Ferrufino Murillo


_**Maestrante:**_  Juan Carlos Ortube Lahor

## Tools
- Sistema Operativo: 'Windows 10 Enterprise'
- Lenguaje de Programacion: 'Java'
- Sistema de automatización: 'Gradle'
- Ide: 'Intellij'
- Test framework: 'JUnit'
- testCompile group: 'org.mockito'

<img src="https://github.com/cofran31/UnitTestingProjectUASB/blob/master/images/java.jpg" width="100"><img src="https://github.com/cofran31/UnitTestingProjectUASB/blob/master/images/gradle.png" width="100"><img src="https://github.com/cofran31/UnitTestingProjectUASB/blob/master/images/intellij.png" width="100">
## Features
[Class Analyzer.java]

_**Metodo readFile**_
- Permite leer un archivo .txt con oraciones del sentimiento.
- Setea las oracion de las filas del archivo .txt en un campo de valor entero del sentimiento y un campo texto .
- Valida cuando no exista el archivo devuelve una lista vacia.
- Devuelve una Lista.

_**Metodo AllWords**_
- Encuentra todos las palabras individuales en el campo de texto de cada oración en la lista  y crear objetos Word para cada palabra distinta.
- Hace el seguimiento del número de apariciones de esa palabra en todas las oraciones, y la puntuación acumulativa total de todas las oraciones en las que aparece.
- Convierte las mayusculas a minusculas y evita caracteres especiales.
- Valida cuando no exista el archivo devuelve una mapa vacio.
- Devuelve un conjunto de objetos Word

_**Metodo calculateScores**_
- Itera sobre cada palabra en el conjunto de entrada, usa el método de CalculateScore de Word para obtener el puntaje de sentimiento promedio.
- Colocar el texto de la palabra (como clave) y la puntuación calculada (como valor) en un mapa.
- Valida cuando no exista el archivo devuelve una mapa vacio.
- Devuelve un map con clave (que tomara el promedio) y el valor (el texto).

## Installation

Open Intellij teniendo gradle instalado.  
`File` > `Open` >  `Browse repositories...` > Ok

![Sort dependencies](https://github.com/cofran31/UnitTestingProjectUASB/blob/master/images/open.png)

### Sort dependencies

Para ordenar las dependencias, abra un archivo .gradle y use la acción Ordenar dependencias de Gradle desde el menú Código.

![Sort dependencies](https://github.com/cofran31/UnitTestingProjectUASB/blob/master/images/dependence.png)

## Implementation

Se realizo la implementacion de los metodos de la clase Analyzer.java a traves de un main: 

![Sort dependencies](https://github.com/cofran31/UnitTestingProjectUASB/blob/master/images/main.png)

Resultados: 

![Sort dependencies](https://github.com/cofran31/UnitTestingProjectUASB/blob/master/images/result.png)

## License

This project is licensed under the MIT license.
