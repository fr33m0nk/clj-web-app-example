# fr33m0nk.clj-web-app-example

A simple Clojure web application to serve as a scaffold.

## Endpoints exposed are:

* `GET:/api/v1/ping`
  ```shell
  curl --location --request GET 'http://localhsot:8080/api/v1/ping'
  ```

## Installation

* Install Clojure CLI using instructions at Clojure's official website

## Usage

### Run using Docker

    $ docker build -t clj-web-app . && docker run -p 8080:8080 -it --rm --name clj-web-app-example clj-web-app

### Run the project directly, via `:exec-fn`:

    $ clojure -M:run-m
    Stating HTTP server at port 8080

### Run the project, overriding the name to be greeted:

    $ clojure -M:run-m 8085
    Stating HTTP server at port 8085

### Run the project's tests:

    $ clojure -X:test:runner

### Build an uberjar:

    $ clojure -X:uberjar

### Run that uberjar and start server on default port `8080`:

    $ java -jar fr33m0nk.clj-web-app-example.jar

### Run that uberjar and start server on port `8085`:

    $ java -jar fr33m0nk.clj-web-app-example.jar 8085

## License

Copyright © 2021 Prashant Sinha

Distributed under the Eclipse Public License version 1.0.
