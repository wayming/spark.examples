echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
docker tag spark.example $DOCKER_USER/spark.example
docker push $DOCKER_USER/spark.example

