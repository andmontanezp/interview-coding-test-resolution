# Step by step to test the solution
### Required commands
- `./gradlew clean jar`, this command will build a new .jar file inside `build/libs/` directory
- `docker build -t comparaonline .`, this command will build a new image with the tag `comparaonline`
- `docker run -it comparaonline:latest`, will start a container based on the last image, will display an output similar to `products_after_30_days.txt`