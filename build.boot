#!/usr/bin/env boot
(set-env! :dependencies '[[org.clojure/clojure "1.7.0"]
                          [adzerk/bootlaces "0.1.11"]
                          [adzerk/boot-cljs "1.7.48-3"]
                          [cljs-hash "0.0.2"]
                          [digest "1.4.4"]]
          :source-paths #{"src"})

(require '[adzerk.bootlaces :refer :all])
(def +version+ "1.1.0")
(bootlaces! +version+)

(task-options! pom {:project     'gravatar
                    :version     +version+
                    :description "Library to generate gravatar links"
                    :url         "https://github.com/alesguzik/gravatar-clj"
                    :scm         {:url "https://github.com/alesguzik/gravatar-clj"}
                    :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(require
 '[adzerk.boot-cljs      :refer [cljs]])
