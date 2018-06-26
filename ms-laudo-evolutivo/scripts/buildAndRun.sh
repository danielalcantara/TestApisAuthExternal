#!/bin/bash
set -e
NETWORK=network-ms-dasa
VERSION=1.0.0
MS_NAME=ms-laudo-evolutivo
M2_HOME=/root/.m2
PORT=8181:8181

# Build da imagem docker do microservice
docker build -t $MS_NAME:$VERSION .

# Criando rede bridge para o microservice
docker network create -d bridge $NETWORK || true

# Iniciando o container a partir da imagem criada anteriormente
docker run -v ~/.m2:$M2_HOME -p $PORT --network $NETWORK $MS_NAME:$VERSION