#!/bin/bash

set -e

echo "====================================="
echo "| Running Trivy Docker Image Scan   |"
echo "====================================="

mkdir -p reports

trivy image \
--timeout 15m \
--format table \
-o reports/trivy-image-report.txt \
production-devops-pipeline:latest

echo "Docker image scan completed."