#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=attendance-management-service

echo "> Copy all of build files"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> Check current running web application's PID"

CURRENT_PID=$(pgrep -fl attendance-management-service | grep jar | awk '{print $1}')

echo "Current running web application's PID: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "> Don't stop web application, because no running web application."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "Deploy the latest application."

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> Add permission to run on $JAR_NAME"

chmod +x $JAR_NAME

echo "> Run $JAR_NAME"

nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
    -Dspring.profiles.active=real \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &