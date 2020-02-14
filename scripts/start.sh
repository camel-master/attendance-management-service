#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

REPOSITORY=/home/ec2-user/app/step3
PROJECT_NAME=attendance-management-service

echo "> Copy the build files"
echo "> cp $REPOSITORY/zip/*.jar $REPOSITORY/"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> Deploy changed application"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> Add executable permission to $JAR_NAME"

chmod +x $JAR_NAME

echo "> Execute the $JAR_NAME"

IDLE_PROFILE=$(find_idle_profile)

echo "> $JAR_NAME is run through profile=$IDLE_PROFILE"
nohup java -jar \
  -Dspring.config.location=classpath://application.properties,classpath://application-$IDLE_PROFILE.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
  -Dspring.profiles.active=$IDLE_PROFILE \
  $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &

