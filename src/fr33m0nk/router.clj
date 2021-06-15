(ns fr33m0nk.router
  (:require
    [reitit.ring :as r]
    [malli.util :as mu]
    [muuntaja.core :as m]
    [reitit.coercion.malli :as malli]
    [reitit.ring.middleware.muuntaja :as muuntaja]
    [reitit.ring.middleware.parameters :as parameters]
    [reitit.ring.middleware.exception :as exception]
    [reitit.ring.coercion :as coercion]))

(def router
  (r/router
    ["/api"
     ["/v1"
      ["/ping" {:summary   "tests liveliness of the server"
                :responses {200 {:body [:map [:status string?]]}}
                :handler   (fn [_]
                             {:status 200 :body {:status "PONG"}})}]]]
    {:data {:coercion   (malli/create
                          {:error-keys       #{:value :humanized}
                           :compile          mu/closed-schema
                           :strip-extra-keys false})
            :muuntaja   m/instance
            :middleware [parameters/parameters-middleware
                         muuntaja/format-negotiate-middleware
                         muuntaja/format-response-middleware
                         exception/exception-middleware
                         coercion/coerce-response-middleware
                         coercion/coerce-request-middleware]}}))