eval $(minikube docker-env)

docker build -t spark-2.2.1-bin-hadoop2.6 --build-arg spark_ver=2.2.1 . 
#echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
#docker tag spark-2.2.1-bin-hadoop2.6 $DOCKER_USER/spark-2.2.1-bin-hadoop2.6
#docker push $DOCKER_USER/spark-2.2.1-bin-hadoop2.6
