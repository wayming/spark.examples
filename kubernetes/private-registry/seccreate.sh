kubectl delete secret regsecret
kubectl create secret docker-registry regsecret --docker-server=172.17.0.1:5000 --docker-username=zhaway01 --docker-password=<password> --docker-email=wayming.z@gmail.com
kubectl get secret regsecret --output=yaml


