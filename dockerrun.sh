docker kill sandbox

docker build . -t spark.example

#docker run -d --rm -p 8088:8088 -p 8042:8042 -p 4040:4040 --hostname sandbox --name sandbox sequenceiq/spark:1.6.0 -d
#docker run -d --rm -p 8088:8088 -p 8042:8042 -p 4040:4040 --hostname sandbox --name sandbox spark.example -d
docker run -d --rm -p 8088:8088 -p 8042:8042 -p 4040:4040 --hostname sandbox --name sandbox spark.example tail -f /dev/null

#docker exec sandbox useradd -m -u $(id -u ) -g users -s /bin/bash -d /home/$(whoami) $(whoami)
#docker exec sandbox sh -c 'echo "%users        ALL=(ALL)       NOPASSWD: ALL" > /etc/sudoers.d/sandbox'
