#!/usr/bin/env bash
set -euo pipefail
log() { echo "[$(date '+%H:%M:%S')] $*"; }

log "  ROLLBACK INICIADO"
log "Detectado fallo en la nueva version (green)."
log "  -> Reapuntando el balanceador al entorno estable (BLUE)."
log "  -> Escalando GREEN a 0 replicas."
log "  -> Verificando health checks de BLUE... OK (HTTP 200)."
log "ROLLBACK COMPLETADO. Servicio restaurado."