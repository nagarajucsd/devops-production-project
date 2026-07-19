# 🚀 Production DevOps Pipeline

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green)
![Maven](https://img.shields.io/badge/Maven-3.8+-red)
![Docker](https://img.shields.io/badge/Docker-Containerized-blue)
![Docker Compose](https://img.shields.io/badge/Docker%20Compose-Orchestration-blue)
![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-red)
![SonarQube](https://img.shields.io/badge/SonarQube-Code%20Quality-brightgreen)
![Trivy](https://img.shields.io/badge/Trivy-Security%20Scanning-blueviolet)
![License](https://img.shields.io/badge/License-MIT-green)

---

# 📖 Overview

Production DevOps Pipeline is a production-ready Employee Management REST API built with **Spring Boot** and integrated with a complete DevOps workflow.

The project demonstrates modern software delivery practices including:

- REST API Development
- Automated Unit Testing
- Code Coverage Reporting
- Static Code Analysis
- Security Scanning
- Docker Containerization
- Docker Compose Orchestration
- Jenkins CI/CD Pipeline
- Health Monitoring using Spring Boot Actuator

This project serves as a practical demonstration of how enterprise applications are built, tested, secured, containerized, and deployed.  

---

# 🌟 Project Highlights

- ✅ Production-ready Spring Boot REST API
- ✅ Automated CI/CD with Jenkins
- ✅ Unit Testing with JUnit 5 & Mockito
- ✅ Code Coverage with JaCoCo
- ✅ Static Code Analysis using SonarQube
- ✅ Security Scanning with Trivy
- ✅ Docker Containerization
- ✅ Docker Compose Multi-Container Deployment
- ✅ MySQL Persistent Storage
- ✅ Spring Boot Actuator Health Monitoring
- ✅ Production-style Bash Automation Scripts
- ✅ Recruiter-friendly Project Documentation

---

# 🏗️ Project Architecture

```text
                    Developer
                        │
                        ▼
                GitHub Repository
                        │
                        ▼
                  Jenkins Pipeline
                        │
        ┌───────────────┼────────────────┐
        │               │                │
        ▼               ▼                ▼
    Maven Build     Unit Tests      JaCoCo Report
                        │
                        ▼
                 SonarQube Analysis
                        │
                        ▼
              Trivy Security Scanning
                        │
                        ▼
                Docker Image Build
                        │
                        ▼
               Docker Compose Deploy
                        │
          ┌─────────────┴─────────────┐
          │                           │
          ▼                           ▼
 Spring Boot Container         MySQL Container
          │                           │
          └──────── Docker Network ───┘
                      │
                      ▼
             Persistent Docker Volume
```

---

# ✨ Features

- Employee Management REST API
- CRUD Operations
- Request Validation
- Global Exception Handling
- DTO Pattern
- Spring Data JPA
- MySQL Integration
- Swagger/OpenAPI Documentation
- Spring Boot Actuator
- Health Checks
- Dockerized Application
- Docker Compose Multi-Container Deployment
- Jenkins CI/CD Pipeline
- SonarQube Code Quality Analysis
- Trivy Filesystem Scan
- Trivy Docker Image Scan
- JaCoCo Code Coverage Reports

---

# 🛠️ Technology Stack

| Category | Technologies |
|-----------|-------------|
| Language | Java 17 |
| Framework | Spring Boot 3 |
| Build Tool | Maven |
| Database | MySQL 8 |
| ORM | Spring Data JPA |
| Testing | JUnit 5, Mockito |
| API Documentation | Swagger / OpenAPI |
| Containerization | Docker |
| Container Orchestration | Docker Compose |
| CI/CD | Jenkins |
| Code Quality | SonarQube |
| Security | Trivy |
| Monitoring | Spring Boot Actuator |
| Version Control | Git & GitHub |

---

# 📂 Project Structure

```text
production-devops-pipeline/
│
├── app/
│   └── springboot-app/
│       ├── src/
│       ├── target/
│       └── pom.xml
│
├── docker/
│   └── Dockerfile
│
├── docker-compose/
│   ├── docker-compose.yml
│   └── .env
│
├── scripts/
│   ├── docker-build.sh
│   ├── docker-compose-deploy.sh
│   ├── docker-cleanup.sh
│   ├── health-check.sh
│   ├── trivy-fs-scan.sh
│   └── trivy-image-scan.sh
│
├── reports/
├── docs/screenshots/
├── Jenkinsfile
├── README.md
└── .gitignore
```

---

# 🚀 REST API Endpoints

| Method | Endpoint | Description |
|----------|----------|-------------|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| POST | `/api/employees` | Create employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

---

# ❤️ Health Endpoint

```
GET /actuator/health
```

Response

```json
{
  "status": "UP"
}
```

---

# 📊 CI/CD Pipeline

The Jenkins pipeline performs the following stages automatically:

- Checkout Source Code
- Maven Compile
- Unit Testing
- Publish Test Reports
- JaCoCo Code Coverage
- SonarQube Analysis
- Trivy Filesystem Scan
- Package Application
- Docker Image Build
- Docker Image Verification
- Trivy Image Scan
- Docker Compose Deployment
- Health Check Verification

---

# 🐳 Docker

Build image

```bash
docker build -t production-devops-pipeline:latest -f docker/Dockerfile .
```

Run container

```bash
docker run -d \
-p 8082:8082 \
production-devops-pipeline:latest
```

---

# 🐳 Docker Compose

Start the application

```bash
docker compose --env-file docker-compose/.env \
-f docker-compose/docker-compose.yml up -d
```

Stop services

```bash
docker compose --env-file docker-compose/.env \
-f docker-compose/docker-compose.yml down
```

View running services

```bash
docker compose --env-file docker-compose/.env \
-f docker-compose/docker-compose.yml ps
```

---

# 🧪 Running Tests

```bash
cd app/springboot-app

mvn test
```

---

# 📈 JaCoCo Coverage

Generate report

```bash
mvn test
```

Coverage Report Location

```
target/site/jacoco/index.html
```

---

# 🔍 SonarQube Analysis

Run SonarQube analysis

```bash
mvn sonar:sonar
```

The Jenkins pipeline automatically performs SonarQube analysis and publishes quality metrics.

---

# 🔒 Security Scanning

Filesystem Scan

```bash
./scripts/trivy-fs-scan.sh
```

Docker Image Scan

```bash
./scripts/trivy-image-scan.sh
```

---

# 📷 Project Screenshots

## GitHub Repository

![GitHub Repository](docs/screenshots/01-github-repository.png)

---

## Project Structure

![Project Structure](docs/screenshots/02-project-structure.png)

---

## Swagger UI

![Swagger UI](docs/screenshots/03-swagger-ui.png)

---

## Get Employees API

![Get Employees](docs/screenshots/04-postman-get-employees.png)

---

## Create Employee API

![Create Employee](docs/screenshots/05-postman-create-employees.png)

---

## JUnit Test Results

![JUnit Tests](docs/screenshots/06-junit-tests.png)

---

## JaCoCo Code Coverage

![JaCoCo Report](docs/screenshots/07-jacoco-report.png)

---

## SonarQube Dashboard

![SonarQube Dashboard](docs/screenshots/08-sonarqube-dashboard.png)

---

## SonarQube Project Overview

![SonarQube Overview](docs/screenshots/09-sonarqube-overview.png)

---

## Trivy Filesystem Scan

![Trivy Filesystem Scan](docs/screenshots/10-trivy-filesystem-scan.png)

---

## Docker Images

![Docker Images](docs/screenshots/11-docker-images.png)

---

## Running Docker Containers

![Docker Containers](docs/screenshots/12-docker-containers.png)

---

## Jenkins CI/CD Pipeline

![Jenkins Pipeline](docs/screenshots/13-jenkins-pipeline-success.png)

---

## Health Check Verification

![Health Check](docs/screenshots/14-health-check-success.png)

---

## Spring Boot Actuator

![Actuator Health](docs/screenshots/15-actuator-health.png)

---

## Docker Compose Services

![Docker Compose](docs/screenshots/16-docker-compose-ps.png)

---

# ▶️ Local Setup

Clone repository

```bash
git clone https://github.com/Nagaraju-209/production-devops-pipeline.git

cd production-devops-pipeline
```

Build application

```bash
cd app/springboot-app

mvn clean package
```

Start using Docker Compose

```bash
docker compose \
--env-file docker-compose/.env \
-f docker-compose/docker-compose.yml up -d
```

Application

```
http://localhost:8082
```

Swagger UI

```
http://localhost:8082/swagger-ui/index.html
```

Health Endpoint

```
http://localhost:8082/actuator/health
```

---

# 📌 Future Enhancements

- Kubernetes Deployment
- Helm Charts
- Prometheus Monitoring
- Grafana Dashboards
- Terraform Infrastructure
- GitHub Actions Pipeline
- AWS Deployment
- NGINX Reverse Proxy

---

# 👨‍💻 Author

**Dandu Rama Siva Naga Raju**

- GitHub: https://github.com/Nagaraju-209
- LinkedIn: https://www.linkedin.com/in/dandu-rama-siva-naga-raju/

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

It helps others discover the project and motivates continued improvements.

---

# 📄 License

This project is licensed under the MIT License.