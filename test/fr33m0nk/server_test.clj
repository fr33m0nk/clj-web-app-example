(ns fr33m0nk.server-test
  (:require
    [clojure.test :refer :all]
    [fr33m0nk.server :as su]
    [org.httpkit.server :as s]))

(deftest start-server-test
  (testing "should start server if not started"
    (with-redefs [s/run-server (fn [_ _] {:server :started})]
      (is (= {:server :started} (su/start-server {} 80)))))
  (testing "should do nothing if server is already started"
    (with-redefs [su/server (atom {:server :started})]
      (is (nil? (su/start-server {} 80))))))

(deftest stop-server-test
  (testing "should stop server if running"
    (with-redefs [s/run-server (fn [_ _] {:server :started})]
      (su/start-server {} 8080)
      (is (nil? (su/stop-server)))))
  (testing "should do nothing if server is already stopped"
    (with-redefs [su/server (atom nil)]
      (is (nil? (su/stop-server))))))
