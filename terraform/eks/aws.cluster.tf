# AWS Cluster
data "aws_eks_cluster" "WealthManagementonSpringboot35-cluster" {
  name = "WealthManagementonSpringboot35-cluster"
}

output "endpoint" {
  value = "${data.aws_eks_cluster.WealthManagementonSpringboot35-cluster.endpoint}"
}

output "kubeconfig-certificate-authority-data" {
  value = "${data.aws_eks_cluster.WealthManagementonSpringboot35-cluster.certificate_authority.0.data}"
}

# Output for K8S
