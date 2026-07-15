#!/bin/bash

set -e

IMAGE_NAME=${IMAGE_NAME:-production-devops-pipeline}
BUILD_NUMBER=${BUILD_NUMBER:-latest}
CONTAINER_NAME=${CONTAINER_NAME:-springboot-container}
APP_PORT=${APP_PORT:-8082}
NETWORK_NAME=${NETWORK_NAME:-devops-network}

echo "Starting container..."

docker run -d \
  --name "${CONTAINER_NAME}" \
  --network "${NETWORK_NAME}" \
  -p "${APP_PORT}:${APP_PORT}" \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-db:3306/employee_db \
  -e SPRING_DATASOURCE_USERNAME=devops \
  -e SPRING_DATASOURCE_PASSWORD=devops123 \
  "${IMAGE_NAME}:${BUILD_NUMBER}"

echo "Container started successfully."