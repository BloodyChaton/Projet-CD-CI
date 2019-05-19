Vagrant.configure("2") do |config|
  # Linux OS CentOS
  config.vm.box = "geerlingguy/centos7";
  config.vm.network "public_network"
  # Web server
  config.vm.define "db-server" do |db|
    db.vm.hostname = "mongodb";
    # static ip address
    db.vm.network :private_network, ip: "192.168.60.4"
    config.vm.provision "ansible" do |ansible|
      ansible.playbook = "ansible/mongodb.yml"
    end
    #db.vm.network :forwarded_port, guest: 27017, host: 27017
  end
  # # Kube server
  # config.vm.define "k8s-server" do |kb|
  #   kb.vm.hostname = "minikube";
  #   # static ip address
  #   kb.vm.network :private_network, ip: "192.168.60.5"
  #   kb.vm.network :forwarded_port, guest: 80, host: 80
  # end
  # Jenkins server
  config.vm.define "jenkins-server" do |jk|
    jk.vm.hostname = "jenkins";
    # static ip address
    jk.vm.network :private_network, ip: "192.168.60.10"
    #jk.vm.network :forwarded_port, guest: 80, host: 80
    config.vm.provision "ansible" do |ansible|
      ansible.playbook = "ansible/jenkins.yml"
    end
  end
  # Docker server
  config.vm.define "docker-server" do |dc|
    dc.vm.hostname = "minikube";
    # static ip address
    dc.vm.network :private_network, ip: "192.168.60.15"
    #dc.vm.network :forwarded_port, guest: 80, host: 80
  end
    # Nexus server
    config.vm.define "nexus" do |nx|
      nx.vm.hostname = "nexus";
      # static ip address
      nx.vm.network :private_network, ip: "192.168.60.20"
      #nx.vm.network :forwarded_port, guest: 8081, host: 8090
    end
end