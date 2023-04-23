## Pre-requisites

### Create queues (AWS SQS)
* awslocal --endpoint-url=http://localhost:4566 sqs create-queue --queue-name order_process --region eu-west-1
* awslocal --endpoint-url=http://localhost:4566 sqs create-queue --queue-name order_processed --region eu-west-1
* awslocal --endpoint-url=http://localhost:4566 sqs send-message --queue-url http://localhost:4566/000000000000/order_process --message-body "Corpo da mensagem" --region eu-west-1
* awslocal --endpoint-url=http://localhost:4566 sqs receive-message --queue-url http://localhost:4566/000000000000/order_process --region eu-west-1