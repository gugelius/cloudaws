1. docker run --rm -it -p 4566:4566 -p 4571:4571 localstack/localstack 
2. Check existing buckets, should return S3-buckets or empty list: aws --endpoint-url=http://localhost:4566 s3 ls
3. Create a bucket: aws --endpoint-url=http://localhost:4566 s3 mb s3://my-bucket
4. Load test file: 
   echo "name,value" > data.csv
   echo "example,42" >> data.csv
   aws --endpoint-url=http://localhost:4566 s3 cp data.csv s3://my-bucket/
5. Check test file: aws --endpoint-url=http://localhost:4566 s3 ls s3://my-bucket
6. Run the application
7. Additional (for auth): 
   aws configure set aws_access_key_id test
   aws configure set aws_secret_access_key test
   aws configure set default.region us-east-1

 
    
