(ns polymer_todo.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.tools.logging :as log]
            [environ.core :refer [env]]
            [ring.util.response :refer [resource-response content-type]]
            [ring.middleware.logger :refer [wrap-with-logger]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.adapter.jetty :refer [run-jetty]]))

(def resource-root "public")

(defn simple-resource [resource-path mime-type]
  (-> (resource-response (str resource-root "/" resource-path))
      (content-type mime-type)))

(defroutes app
  (GET "/" [] (simple-resource "index.html" "text/html"))
  (route/resources "/" {:root resource-root})
  (route/not-found "<h1>Page not found</h1>"))

(def full-app
  (-> app
      wrap-params ; Adds :query-params, :form-params, and :params to each request.
      wrap-with-logger))

(defn -main [& args]
  (log/info (format "Using port %d" (env :port)))
  (run-jetty app {:port (env :port)}))
