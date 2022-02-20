# Pokedex App (pt-BR) ![Language](https://img.shields.io/badge/language-Kotlin-orange.svg) [![License](https://img.shields.io/badge/license-Mit-blue.svg)](https://github.com/gladson-sza/pokedex-egsys/blob/master/LICENSE) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
Aplicativo de Pokédex, contendo os dados de todos os pokémons, o app realiza requisições dos dados para  PokéAPI e os salva localmente para que o usuário possa ter acesso offline aos dados.

# Arquitetura
A arquitetura do projeto é dividida em camadas, seguindo o padrão MVVM, com as camadas de Interface, Domínio e Dados.



## Interface
A camada de interface é a responsável por lidar com a apresentação dos dados e interação com o usuário

## Domínio
A camada de domínio é a camada intermediária entre a camada de interface e de dados, sendo esta a responsável por realizar a chamada de dados, lidar com regra de negócio para apresentação e então notificar a camada de interface.

## Dados
A camada de dados é responsável tanto realizar chamadas à API quanto fazer a persistência no banco de dados local, além de conter regras de negócio 


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
