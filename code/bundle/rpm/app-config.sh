#!/bin/bash

echo "run app-config.sh target = $TARGET"

auto_config $TARGET/chaoexpo.bundle.war-1.0-SNAPSHOT.war
auto_config $TARGET/web-deploy.jar
##auto_config $TARGET/chaoexpo.task-uber.jar
