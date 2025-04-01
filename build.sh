#!/bin/bash

set -e

MODULES=("config-service" "eureka-service" "user-service")

print_usage() {
  echo "🔨 Maven multi-module builder"
  echo ""
  echo "Usage:"
  echo "  ./build.sh [module-name]   build selected module only"
  echo "  ./build.sh all             build all modules"
  echo ""
  echo "Available modules: ${MODULES[*]}"
  echo ""
}

build_module() {
  local module="$1"
  echo "🚀 Building module: $module"
  mvn clean install -pl "$module" -am -DskipTests
}

if [[ $# -eq 0 ]]; then
  print_usage
  exit 0
fi

if [[ "$1" == "all" ]]; then
  echo "🔁 Building all modules..."
  mvn clean install -DskipTests
  exit 0
fi

if [[ " ${MODULES[*]} " == *" $1 "* ]]; then
  build_module "$1"
else
  echo "❌ Unknown module: $1"
  print_usage
  exit 1
fi
