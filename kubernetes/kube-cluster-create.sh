kubectl create -f spark-master.yaml
kubectl create -f spark-master-service.yaml
kubectl create -f spark-worker.yaml
kubectl get po
kubectl describe svc spark-master
# Foward local port to Pod Master port
kubectl get po --no-headers | grep master | awk '{print $1}' | xargs -I {} kubectl port-forward {} 8080:8080


