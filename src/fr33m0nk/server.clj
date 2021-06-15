(ns fr33m0nk.server
  (:require
    [org.httpkit.server :as s]))

(defonce ^:private server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn start-server [app port]
  (when (nil? @server)
    (reset! server (s/run-server app {:port (Integer/parseInt port)}))))

