#!/bin/bash
echo "mvn clean install starting"
mvn clean install -DskipTests
echo "mvn clean install finish"
echo "docker build starting"
docker build -t calculator-case-study:1.0 .
echo "docker build finished"
echo "docker compose process starting"
docker-compose -f docker-compose.yml up -d
echo "docker compose process finished"
