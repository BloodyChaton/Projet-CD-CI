Vagrant.configure("2") do |config|
  # Linux OS CentOS
  config.vm.box = "geerlingguy/centos7";
  config.vm.network "public_network"
  # Web server
  config.vm.define "db-server" do |db|
    db.vm.hostname = "mongodb";
    # static ip address
    db.vm.network :private_network, ip: "192.168.60.4"
    #db.vm.network :forwarded_port, guest: 27017, host: 27017
  end
  # Kube server
  config.vm.define "k8s-server" do |kb|
    kb.vm.hostname = "minikube";
    # static ip address
    kb.vm.network :private_network, ip: "192.168.60.5"
    kb.vm.network :forwarded_port, guest: 80, host: 80
  end
  # Docker server
  config.vm.define "docker" do |dk|
    dk.vm.hostname = "docker";
    # static ip address
    dk.vm.network :private_network, ip: "192.168.60.6"
  end
end