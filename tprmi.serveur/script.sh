#!/bin/bash


java -Djava.security.policy=java.policy /home/cheikh/workspace/tprmi.serveur/target/classes/tprmi/serveur/*.class

rmiregistry&
