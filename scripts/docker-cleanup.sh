#!/bin/bash

set -e

CONTAINER_NAME=${CONTAINER_NAME:-springboot-container}

echo "Removing existing container..."

docker rm -f "${CONTAINER_NAME}" 2>/dev/null || true

echo "Cleanup completed."