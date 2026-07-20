# Automatización de Pruebas — Examen Final

Repositorio con Git (GitFlow), Maven, pipeline de CI y deployment pipeline
con Blue-Green y rollback.

## Estrategia de pruebas
- Unitarias (JUnit, *Test.java) → mvn test
- Integración (JUnit, *IT.java) → mvn verify
- Aceptación (Selenium) → mvn verify -Dacceptance=true

## Estrategia de ramas
GitFlow: main (estable), develop (integración), feature/* (trabajo).

## Cómo ejecutar
mvn clean verify

## Despliegue y rollback
bash infra/deploy-bluegreen.sh green build-1
bash infra/deploy-bluegreen.sh switch green
bash infra/rollback.sh

## Justificación
Se eligió GitFlow por separar trabajo estable de integración, y Blue-Green
por su switch instantáneo y rollback trivial.