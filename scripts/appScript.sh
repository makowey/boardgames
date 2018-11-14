#!/bin/bash
echo "Rebuild Boardgames application from master..."
cd /home/gamer/boardgames/ && git pull -f origin master && mvn clean package -DskipTests=true -Djava.version=10 && cp ./target/cheapest-bgg.jar ../

echo "Redirecting 80 to 8080..."
iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080
echo "Redirected to 8080"

echo "Restarting the service application..."
/etc/init.d/boardgames restart
echo "----- Done -----"
