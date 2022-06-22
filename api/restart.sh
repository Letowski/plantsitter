#!/bin/bash
screen -S plantsitter -X quit
screen -dmS plantsitter java -jar build/libs/plantsitter-0.0.1-SNAPSHOT.jar
