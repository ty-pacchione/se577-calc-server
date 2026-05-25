# Calculator Logging Server

Server-side project for SE577 individual assignment 3. The companion client-side project can be found at [ty-pacchione/se577-calc-client](https://github.com/ty-pacchione/se577-calc-client).

## Execute

To run the application, execute `./run.sh` from the root directory (will only work on MacOS). A message will be printed to the console when the server is started. Then, start the client-side application in a separate thread to perform calculations. Another message will indicate whether the client was successfully accepted. Each completed calculation is printed to the console, and once the program is closed, all calculations are saved to `log.txt`.