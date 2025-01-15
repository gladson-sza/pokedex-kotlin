# 📱 Pokedex App ![Language](https://img.shields.io/badge/language-Kotlin-orange.svg) [![License](https://img.shields.io/badge/license-Mit-blue.svg)](https://github.com/gladson-sza/pokedex-kotlin/blob/master/LICENSE) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

# Preview
  Splash    |                                             Home                                              |       Details        |
:-------------------------:|:---------------------------------------------------------------------------------------------:|:-------------------------:
![](https://github.com/gladson-sza/pokedex-kotlin/blob/master/documents/screen_shot_splash.png)  | ![](https://github.com/gladson-sza/pokedex-kotlin/blob/master/documents/screen_shot_home.png) | ![](https://github.com/gladson-sza/pokedex-kotlin/blob/master/documents/screen_shot_details.png)

# 📦 Resources

* Community details screen [Pokedex](https://www.figma.com/community/file/979132880663340794) by [Ricardo Schiniegoski](https://www.figma.com/@ricardohs)  
* Public API: [PokéAPI](https://pokeapi.co/) 
* JavaDoc: [Doc](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/javadoc/index.md)

# 📄 Docs

* [Documentation](#documentation)
  * [Features](#features)
  * [Flow](#flow)
  * [Architecture](#architecture)
  * [Packages](#packages)
  * [Libs](#libs)
  * [Build](#build)
* [License](#license)

# Documentation
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

# Packages
![](https://github.com/gladson-sza/pokedex-egsys/blob/master/documents/packages.png) 

## Description

**/di** &rarr; Contains [Koin](https://insert-koin.io/) dependency injection modules  
**/data** &rarr; Contains Models, Services, DAOs, Services and others data related classes  
**/exceptions** &rarr; Contains custom exception classes  
**/ui** &rarr; Contains Activities, Fragments, Adapters and ViewModels classes (Works as a controller)  
**/util** &rarr; Contains utility classes and [kotlin extensions](https://kotlinlang.org/docs/extensions.html) for code reuse

# Libs
* [Koin](https://insert-koin.io/) for Dependency Injection
* [Room](https://developer.android.com/training/data-storage/room) for persistency
* [Glide](https://github.com/bumptech/glide) for image loading
* [Retrofit2](https://square.github.io/retrofit/) for HTTP
* [Moshi](https://github.com/square/moshi) for serialization
* [Coroutines](https://developer.android.com/kotlin/coroutines) for Reactivity
* [Navigation](https://developer.android.com/guide/navigation) for navigation between fragments
* [Dokka](https://github.com/Kotlin/dokka) for code documentation

# Build

* [Create](https://developer.android.com/studio/run/managing-avds#createavd) an ADV Device
* [Boot up](https://developer.android.com/studio/run/managing-avds#emulator) your ADV Device


Build your app with gradle
```shell
  git clone https://github.com/gladson-sza/pokedex-kotlin.git
  cd /pokedex-kotlin
  gradlew installDebug
```
Open your device and search for your installed 'Pokedex egSYS' apk

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
