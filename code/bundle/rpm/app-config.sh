#!/bin/bash

echo "run app-config.sh target = $TARGET"

echo "start config web-deploy ..."
auto_config $TARGET/web-deploy.jar

echo "start config war ..."
auto_config $TARGET/chaoexpo.bundle.war-1.0-SNAPSHOT.war

##echo "start config task-uber ..."
##auto_config $TARGET/chaoexpo.task-uber.jar
