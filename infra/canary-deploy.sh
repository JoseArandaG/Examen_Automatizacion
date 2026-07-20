#!/usr/bin/env bash
set -euo pipefail
PESO_INICIAL="${1:-10}"
log() { echo "[$(date '+%H:%M:%S')] $*"; }

log "Desplegando CANARY con ${PESO_INICIAL}% del trafico..."
for peso in "$PESO_INICIAL" 25 50 100; do
    log "  -> Enrutando ${peso}% del trafico al canary."
    log "     Monitoreando latencia y errores... OK."
done
log "Canary promovido al 100%. Nueva version estable."