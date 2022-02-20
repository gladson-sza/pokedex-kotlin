# 📱 Pokedex App ![Language](https://img.shields.io/badge/language-Kotlin-orange.svg) [![License](https://img.shields.io/badge/license-Mit-blue.svg)](https://github.com/gladson-sza/pokedex-egsys/blob/master/LICENSE) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

# Preview
  Splash    |         Home      |       Details        |
:-------------------------:|:-------------------------:|:-------------------------:
![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/screen_shot_splash.png)  |  ![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/screen_shot_home.png) | ![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/screen_shot_details.png)

# Resources

* Community details screen [Pokedex](https://www.figma.com/community/file/979132880663340794) by [Ricardo Schiniegoski](https://www.figma.com/@ricardohs)  
* Public API: [PokéAPI](https://pokeapi.co/) 
* JavaDoc: [Doc](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/javadoc/index.md)

# 📄 Docs

* [Documentation (en)](#%F0%9F%93%84-documentation)
  * [Features](#features)
  * [Flow](#flow)
  * [Architecture](#architecture)
  * [Packages](#%F0%9F%93%A6-packages)
  * [Libs](#%F0%9F%93%97-libs)
  * [Build](#%E2%9A%99-build)
* [Documentação (pt-BR)](#%F0%9F%93%84-documenta%C3%A7%C3%A3o-pt-br)
  * [Funcionalidades](#funcionalidades)
  * [Arquitetura](#architecture)
  * [Divisão de Pacotes](#%F0%9F%93%A6-divis%C3%A3o-de-pacotes)
  * [Bibliotecas](#%F0%9F%93%97-bibliotecas)
  * [Compilação](#%E2%9A%99-compila%C3%A7%C3%A3o)
* [License](#license)

# 📄 Documentation
Pokédex application, containing the data of all pokémons, the app makes data requests to the PokéAPI and saves them locally so that the user can have offline access to the data.

# Features
* All official pokédex entries
* Search by name
* Pokémon details
* Offline persistence

# Flow

* ## Splash
On this screen, the logo with a button is displayed. When clicking on the button, a check is made to see if the data is already persisted, if there is no saved data, a request is initiated to obtain the data of all pokémons and save them locally.

If there is saved data, or it was possible to obtain and save data from the API, the user is redirected to the Home screen.

* ## Home
In this screen, the saved data of the pokémons will be loaded in a list, by default, the list will be ordered by the pokédex number. The list is composed of cards, with the colors of the pokémon, its name, photo and type, when clicking on the card the user will be directed to the details screen of that pokémon.

Just above the screen, the user can search for a pokémon by its name.

You can filter the list by Pokédex number, alphabetically or sort order.

Also on this screen is a button that will open the details screen for a random pokemon

* ## Details
This screen displays the pokémon's details, with data such as its name, photo, types, weight, height, possible abilities, pokédex description and its base status. The screen will adapt to the color of the Pokémon's primary type.

In the upper left corner, there is a button to go back to home.

In the right and left corners, it is possible to navigate between the pokémons, the left button will take to the predecessor pokémon by the pokédex number, the right button will lead to the successor pokémon by the pokédex number. If you are on the first pokémon on the list, the left button will not appear, if you are on the last pokémon on the list, the right button will not appear.

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

# 📗 Libs
* [Koin](https://insert-koin.io/) for Dependency Injection
* [Room](https://developer.android.com/training/data-storage/room) for persistency
* [Glide](https://github.com/bumptech/glide) for image loading
* [Retrofit2](https://square.github.io/retrofit/) for HTTP
* [Moshi](https://github.com/square/moshi) for serialization
* [Coroutines](https://developer.android.com/kotlin/coroutines) for Reactivity
* [Navigation](https://developer.android.com/guide/navigation) for navigation between fragments
* [Dokka](https://github.com/Kotlin/dokka) for code documentation

# ⚙ Build

* [Create](https://developer.android.com/studio/run/managing-avds#createavd) an ADV Device
* [Boot up](https://developer.android.com/studio/run/managing-avds#emulator) your ADV Device


Build your app with gradle
```shell
  git clone https://github.com/gladson-sza/pokedex-egsys.git
  cd /pokedex-egsys
  gradlew installDebug
```
Open your device and search for your installed 'Pokedex egSYS' apk


# 📄 Documentação (pt-BR)

Aplicativo de Pokédex, contendo os dados de todos os pokémons, o app realiza requisições dos dados para  PokéAPI e os salva localmente para que o usuário possa ter acesso offline aos dados.

# Funcionalidades
* Todas as entradas oficiais da pokédex
* Busca por nome
* Detalhes dos pokémon
* Persistência local

# Fluxo

* ## Splash
Nesta tela, é apresentada a logo com um botão.  Ao clicar no botão, é feita uma verificação para saber se os dados já estão persistidos, se não houverem dados salvos é iniciada uma requisição para obter os dados de todos os pokémons e salvá-los localmente.

Caso haja dados salvos, ou foi possível obter e salvar os dados da API, o usuário é redirecionado para a tela de Home.

* ## Home
Nesta tela serão carregados em uma lista os dados salvos dos pokémons, por padrão, a lista virá ordenada pelo número da pokédex. A lista é composta por cards, com as cores do pokémon, o seu nome, foto e tipo, ao clicar no card o usuário será direcionaod para tela de detalhes daquele pokémon.

Logo acima na tela, o usuário pode pesquisar um pokémon pelo seu nome.

É possível filtrar a lista pelo número da pokédex, em ordem alfabética ou ordem de tipos.

Ainda nesta tela, há um botão que abrirá a tela de detalhes para um pokémon aleatório

* ## Details
Nesta tela é exibido os detalhes do pokémon, com dados como o seu nome, foto, tipos, peso, altura, possíveis abilidades, descrição da pokédex e seu status base. A tela se adaptará a cor do tipo primário do pokémon.

No canto superior esquerdo, há um botão para voltar para a home.

Nos cantos direito e esquerdo, é possível navegar entre os pokémons, o botão da esquerda levará para o pokémon antecessor pelo número da pokédex, o botão da direita levará para o pokémon sucessor pelo número da pokédex. Caso esteja no primeiro pokémon da lista, o botão da esquerda não irá aparecer, caso esteja no útlimo pokémon da lista, o botão da direita não irá aparecer.


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

# 📗 Bibliotecas
* [Koin](https://insert-koin.io/) para injeção de dependência
* [Room](https://developer.android.com/training/data-storage/room) para persistência
* [Glide](https://github.com/bumptech/glide) para imagens
* [Retrofit2](https://square.github.io/retrofit/) para HTTP
* [Moshi](https://github.com/square/moshi) para Serialização
* [Coroutines](https://developer.android.com/kotlin/coroutines?hl=pt-br) para Reatividade
* [Navigation](https://developer.android.com/guide/navigation) para navegação entre fragments
* [Dokka](https://github.com/Kotlin/dokka) para documentação do código

# ⚙ Compilação

* [Crie](https://developer.android.com/studio/run/managing-avds#createavd) um dispositivo virtual
* [Inicie](https://developer.android.com/studio/run/managing-avds#emulator) seu dispositivo virtual


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
