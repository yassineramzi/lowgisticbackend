## Run application

## Using Docker to simplify development (optional)

To use docker run :

    mvnw clean verify jib:dockerBuild

Then run :

    docker-compose -f src/main/docker/app.yml up -d

## Branch management 

For each ticket, create a branch and in the end of the ticket, 
Make a pull request to develop by specifying the other developers for a code review.
