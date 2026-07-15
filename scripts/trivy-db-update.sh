#!/bin/bash

set -e

echo "Updating Vulnerability DB..."

trivy image \
  --download-db-only \
  --cache-dir ~/.cache/trivy

echo "Updating Java DB..."

trivy image \
  --download-java-db-only \
  --cache-dir ~/.cache/trivy

echo "Trivy databases updated successfully."