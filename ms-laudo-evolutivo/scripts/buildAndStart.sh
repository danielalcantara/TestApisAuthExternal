#!/bin/bash
set -e

# Build do projeto
mvn clean install

# Iniciando o mircoservice
java -jar target/ms-laudo-evolutivo.jar