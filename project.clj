(defproject polymer-todo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/wcauchois/polymer-todo"
  :source-paths ["src/clj"]
  :main polymer_todo.core
  :aot [polymer_todo.core]
  :env {:port 8000}
  :plugins [[lein-environ "1.0.0"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring.middleware.logger "0.5.0"]
                 [ring "1.3.2"]
                 [org.clojure/tools.logging "0.3.1"]
                 [compojure "1.3.2"]
                 [environ "1.0.0"]])
