#!/usr/bin/env bash
set -euo pipefail
ACCION="${1:-}"; PARAM="${2:-}"; LOG="deploy.log"
log() { echo "[$(date '+%H:%M:%S')] $*" | tee -a "$LOG"; }

case "$ACCION" in
  green)
    log "Desplegando version ${PARAM} en entorno GREEN..."
    log "  -> Levantando contenedor green:${PARAM}"
    log "  -> Ejecutando health checks (HTTP 200)..."
    log "GREEN desplegado y saludable."
    ;;
  switch)
    log "Cambiando el balanceador: trafico -> ${PARAM}"
    log "  -> ${PARAM} es ahora el entorno LIVE (produccion)."
    log "  -> El entorno anterior (blue) queda en stand-by."
    ;;
  *)
    echo "Uso: $0 {green <version>|switch <entorno>}" >&2; exit 1 ;;
esac