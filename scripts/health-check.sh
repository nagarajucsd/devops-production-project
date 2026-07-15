#!/bin/bash

set -e

APP_PORT=${APP_PORT:-8082}
CONTAINER_NAME=${CONTAINER_NAME:-springboot-container}

echo "====================================="
echo "Running Health Check"
echo "====================================="

echo "Waiting for application to start..."

for i in {1..20}
do
    echo "Attempt $i/20..."

    if curl -fs http://localhost:${APP_PORT}/actuator/health > /tmp/health.json 2>/dev/null
    then
        if grep -q '"status":"UP"' /tmp/health.json
        then
            echo ""
            echo "Application is healthy."
            cat /tmp/health.json
            exit 0
        fi
    fi

    sleep 5
done

echo ""
echo "Health check failed."

echo ""
echo "Container Status:"
docker ps -a --filter "name=${CONTAINER_NAME}"

echo ""
echo "Container Logs:"
docker logs --tail 50 "${CONTAINER_NAME}" || true

exit 1