docker kill sandbox

docker build . -t spark.example

docker run -d --rm -p 8088:8088 -p 8042:8042 -p 4040:4040 --hostname sandbox --name sandbox spark.example tail -f /dev/null

docker exec -u sparkuser sandbox sh -c "sudo service smbd restart"
