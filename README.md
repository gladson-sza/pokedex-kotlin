# 📱 Pokedex App ![Language](https://img.shields.io/badge/language-Kotlin-orange.svg) [![License](https://img.shields.io/badge/license-Mit-blue.svg)](https://github.com/gladson-sza/pokedex-egsys/blob/master/LICENSE) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

# Preview
  Splash    |         Home      |       Details        |
:-------------------------:|:-------------------------:|:-------------------------:
![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/screen_shot_splash.png)  |  ![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/screen_shot_home.png) | ![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/screen_shot_details.png)

# 💻Usage

* [Documentation (en)](#documentation)
  * [Features](#features)
  * [Architecture](#architecture)
  * [Packages](#ackages)
  * [Build](#build)
* [Documentação (pt-BR)](#documenta%C3%A7%C3%A3o-pt-br)
  * [Funcionalidades](#funcionalidades)
  * [Arquitetura](#architecture)
  * [Divisão de Pacotes](#divis%C3%A3o-de-pacotes)
  * [Compilação](#compila%C3%A7%C3%A3o)

# 📄 Documentation
Pokédex application, containing the data of all pokémons, the app makes data requests to the PokéAPI and saves them locally so that the user can have offline access to the data.

# Features
* All official pokédex entries
* Search by name
* Pokémon details
* Offline persistence

# Architecture
The project architecture is divided into layers, following the MVVM pattern, with UI, Domain and Data layers. [More architecture details](https://developer.android.com/jetpack/guide)

![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/layer_diagram.png) 

## UI Layer
The UI Layer is responsible for handling data presentation and user interaction.

## Domain Layer
The domain layer is the intermediary layer between the interface and data layer, which is responsible for performing the data call, dealing with business logic and then notifying the interface layer. Works as a controller.

## Data Layer
The data layer is responsible for both making API calls and persisting in the local database, in addition to containing business logic.

![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/data_diagram.png)

# 📦 Packages
![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/packages.png) 

## Description

**/di** &rarr; Contains [Koin](https://insert-koin.io/) dependency injection modules  
**/data** &rarr; Contains custom exception classes  
**/ui** &rarr; Contains Activities, Fragments, Adapters and ViewModels classes (Works as a controller)  
**/exceptions** &rarr; Contém classes de excessões customizadas  
**/ui** &rarr; Contains Activities, Fragments, Adapters and ViewModels classes (Works as a controller)  
**/util** &rarr; Contains utility classes and [kotlin extensions](https://kotlinlang.org/docs/extensions.html) for code reuse

# Build

* [Create](https://developer.android.com/studio/run/managing-avds#createavd) an ADV Device
* [Boot up]((https://developer.android.com/studio/run/managing-avds#emulator)) your ADV Device


Build your app with gradle
```shell
  git clone https://github.com/gladson-sza/pokedex-egsys.git
  cd /pokedex-egsys
  gradlew installDebug
```
Open your device and search for your installed 'Pokedex egSYS' apk


# 📄 Documentação (pt-BR)

Aplicativo de Pokédex, contendo os dados de todos os pokémons, o app realiza requisições dos dados para  PokéAPI e os salva localmente para que o usuário possa ter acesso offline aos dados.

# Features
* Todas as entradas oficiais da pokédex
* Busca por nome
* Detalhes dos pokémon
* Persistência local

# Arquitetura
A arquitetura do projeto é dividida em camadas, seguindo o padrão MVVM, com as camadas de Interface, Domínio e Dados. [Mais detalhes de arquitetura](https://developer.android.com/jetpack/guide)

![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/layer_diagram.png) 

## Interface
A camada de interface é a responsável por lidar com a apresentação dos dados e interação com o usuário

## Domínio
A camada de domínio é a camada intermediária entre a camada de interface e de dados, sendo esta a responsável por realizar a chamada de dados, lidar com regras de negócio e então notificar a camada de interface. Equivalente ao controller.

## Dados
A camada de dados é responsável tanto realizar chamadas à API quanto fazer a persistência no banco de dados local, além de conter regras de negócio

![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/data_diagram.png)

# 📦 Divisão de Pacotes
![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/packages.png) 

## Descrição

**/di** &rarr; Contém os módulos de injeção de dependência do [Koin](https://insert-koin.io/)  
**/data** &rarr; Contém classes relacioandas à camada de dados como Models, DAOs, Services, DataSources e Repository  
**/exceptions** &rarr; Contém classes de excessões customizadas  
**/ui** &rarr; Contém classes de Activities, Fragments, Adapters e ViewModels (Funciona como controller)  
**/util** &rarr; Contém classes utilitárias e [kotlin extensions](https://kotlinlang.org/docs/extensions.html) para reaproveitamento de código

# Compilação

* [Crie](https://developer.android.com/studio/run/managing-avds#createavd) um dispositivo virtual
* [Inicie]((https://developer.android.com/studio/run/managing-avds#emulator)) seu dispositivo virtual


Compile o apk utilizando o gradle
```shell
  git clone https://github.com/gladson-sza/pokedex-egsys.git
  cd /pokedex-egsys
  gradlew installDebug
```
Abra seu dispositivo virutal e procure pelo aplicativo instalado 'Pokedex egSYS'

# License

    MIT License

    Copyright (c) 2022 Gladson

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
