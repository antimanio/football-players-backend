
# Info 
Language: Java 21
BuildTool: Maven
Framework: Quarkus
Type: RestAPI
Database: Postgres
Docker for containerization
Kubernetes for container orchestration
Used WSL2 for development

- Using Minikube to run a local cluster.
- Using images from Docker Hub.
- Created 2 services (postgres & quarkus-api), 1 Configmap and 1 Secret. 


#SwaggerUI:
- localhost:8080/apis

## Docker: 
To build two services (docker-compose.yml) for postgres you can run: `docker compose up`
To build a image and push to DockerHub / Registry: 
- `mvn clean install`
- `docker build -f src/main/docker/Dockerfile.jvm -t football-players .`
- `docker tag football-players username/football-players:1.0`
- `docker push username/football-players:1.0`

## Minikube
- `minikube start --driver=docker` -> Start your cluster.
- `minikube dashboard` -> Get some insights. 
- `minikube stop` -> Halt the cluster

## K8S
To create or update resources in the cluster (MiniKube): 
- `kubectl apply -f postgres-configmap.yaml`
- `kubectl apply -f postgres-credentials.yaml`
- `kubectl apply -f postgres-pv.yaml`
- `kubectl apply -f postgres-pvc.yaml`
- `kubectl apply -f postgres-deployment.yaml`
- `kubectl apply -f quarkus-deployment.yaml`

Remember to give Service account in K8S rights to read configmaps & secrets:
### Create a role: 
kubectl create role configmap-rolle --verb=get --verb=list --resource=configmaps --namespace=default

### Create a rolebinding
kubectl create rolebinding my-rolebinding-configmap --role=configmap-rolle --serviceaccount=default:default

### Useful CLI
- kubectl get configmaps
- kubectl describe configmap "name-of-configmap"
- kubectl get secrets
- kubectl get roles
- kubectl get rolesbindings
- kubectl get deployments
- kubectl get pods
- kubectl get all

### Resource: 
- https://kubernetes.io/
- https://minikube.sigs.k8s.io/docs/start/
