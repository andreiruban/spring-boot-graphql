# blakit-platform


To build Docker image

    ./gradlew build docker --info  
   
To push Docker image 

    docker push andreiruban/blakit-platform:latest
    
To run Docker image

    docker run -p 8080:8080 -t andreiruban/blakit-platform:latest
