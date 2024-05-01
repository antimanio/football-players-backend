# K8S

Using Minikube to run a cluster locally.

Using images from Docker Hub

Created 2 services (postgres & api), 1 Configmap and 1 Secret. 

Remember to give Service account in K8S rights to read configmaps & secrets:
### Create a role: 
kubectl create role configmap-rolle --verb=get --verb=list --resource=configmaps --namespace=default

### Create a rolebinding
kubectl create rolebinding my-rolebinding-configmap --role=configmap-rolle --serviceaccount=default:default

### Useful CLI
kubectl get configmaps
kubectl get secerts
kubectel get roles
kubectl get rolesbindings
kubectl get deployments
kubectl describe configmap "name-of-configmap"
kubectl get pods
kubectl get all


### Resource: 
https://kubernetes.io/
https://minikube.sigs.k8s.io/docs/start/
