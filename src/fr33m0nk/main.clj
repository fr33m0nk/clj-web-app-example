(ns fr33m0nk.main
  (:require
    [fr33m0nk.server :as s]
    [fr33m0nk.router :as r]
    [reitit.ring :as ring])
  (:gen-class))

(def app
  (ring/ring-handler r/router))

(defn -main
  [& args]
  (let [port (or (first args) 8080)]
    (println "Stating HTTP server at port " port)
    (s/start-server app port)
    (.addShutdownHook
      (Runtime/getRuntime)
      (Thread. ^Runnable s/stop-server))))
