#!/usr/bin/env bash
APP_NAME="batch-liberar-saldo"
APP_DIR="/opt/vp/app"
INSTALLATION_DIR="$APP_DIR/$APP_NAME"
CURRENT_DEPLOY="$INSTALLATION_DIR/current"

mkdir -p $CURRENT_DEPLOY

if [ -f $CURRENT_DEPLOY/$APP_NAME.jar ]; then
	rm $CURRENT_DEPLOY/$APP_NAME.jar
fi
