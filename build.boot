#!/usr/bin/env boot
(set-env! :dependencies '[[org.clojure/clojure "1.7.0"]
                          [adzerk/bootlaces "0.1.11"]
                          [deraen/boot-cljx "0.3.0"]
                          [adzerk/boot-cljs "0.0-3308-0"]
                          [adzerk/boot-cljs-repl "0.1.10-SNAPSHOT"]
                          [adzerk/boot-reload "0.2.6"]
                          [cljs-hash "0.0.2"]
                          [digest "1.4.4"]]
          :source-paths #{"src"})

;; cider support in boot repl
(require 'boot.repl)
(swap! boot.repl/*default-dependencies* concat '[[cider/cider-nrepl "0.9.0-SNAPSHOT"]])
(swap! boot.repl/*default-middleware* conj 'cider.nrepl/cider-middleware)

(require '[adzerk.bootlaces :refer :all])
(def +version+ "1.0.0")
(bootlaces! +version+)

(task-options! pom {:project     'gravatar
                    :version     +version+
                    :description "Library to generate gravatar links"
                    :url         "https://github.com/alesguzik/gravatar-clj"
                    :scm         {:url "https://github.com/alesguzik/gravatar-clj"}
                    :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer :all]
 '[adzerk.boot-reload    :refer [reload]])
