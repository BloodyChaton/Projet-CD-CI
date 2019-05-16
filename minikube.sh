wget https://download.virtualbox.org/virtualbox/6.0.8/VirtualBox-6.0-6.0.8_130520_el7-1.x86_64.rpm
sudo yum localinstall VirtualBox-6.0-6.0.8_130520_el7-1.x86_64.rpm
curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.9.0/bin/linux/amd64/kubectl
sudo chmod +x ./kubectl
sudo mv ./kubectl /usr/local/bin/kubectl
curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.24.1/minikube-linux-amd64 && chmod +x minikube && sudo mv minikube /usr/local/bin/
minikube version
export CHANGE_MINIKUBE_NONE_USER=true
su
minikube start -vm-driver=none