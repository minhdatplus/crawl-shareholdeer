#!/bin/sh
echo "********************************************************"
echo "Starting share-holder-servic "
echo "********************************************************"
java -jar -Dspring.profiles.active=dev share-holder-servic.jar
