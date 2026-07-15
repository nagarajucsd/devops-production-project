#!/bin/bash
set -e

IMAGE_NAME=${IMAGE_NAME:-production-devops-pipeline}
IMAGE_TAG=${IMAGE_TAG:-latest}

mkdir -p reports

echo "Image : ${IMAGE_NAME}:${IMAGE_TAG}"

docker image inspect "${IMAGE_NAME}:${IMAGE_TAG}" >/dev/null

trivy image \
  --cache-dir ~/.cache/trivy \
  --skip-db-update \
  --skip-java-db-update \
  --skip-version-check \
  --scanners vuln \
  --timeout 45m \
  --format table \
  --output reports/trivy-image-report.txt \
  "${IMAGE_NAME}:${IMAGE_TAG}"

echo "Image scan completed."