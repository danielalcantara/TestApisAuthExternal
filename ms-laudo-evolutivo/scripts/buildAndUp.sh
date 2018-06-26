#!/bin/bash
set -e

# Build docker image from docker compose
docker-compose build

# Start docker container from docker compose
docker-compose up