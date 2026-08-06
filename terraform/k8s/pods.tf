resource "kubernetes_replication_controller" "app-master" {
  metadata {
    name = "app-master"
  }

  spec {
    replicas = 1

    selector = {
      app  = "WealthManagementonspringboot35"
    }
    template {        
    template {
      container {
        image = "${dbEngine}:latest"
        name  = "db-container"

        port {
          container_port = ${dbPort}
        }

        resources {
          requests {
            cpu    = "100m"
            memory = "100Mi"
          }
        }

        
      container {
        image = "theharbormaster/WealthManagement-on-springboot-35:latest
"
        name  = "app-container"

        port {
          container_port =         }
        resources {
          requests {
            cpu    = "100m"
            memory = "100Mi"
          }
        }

      }

    }
    }
  }
}