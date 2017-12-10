echo $DOCKER_PASS | docker login 127.0.0.1:5000 -u $DOCKER_USER --password-stdin
docker tag spark.example 127.0.0.1:5000/spark.example.local
docker push 127.0.0.1:5000/spark.example.local
curl http://127.0.0.1:5000/v2/_catalog


