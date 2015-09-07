(ns gravatar
  (:import [java.net URLEncoder])
  (:require #?(:cljs [cljs-hash.md5 :refer [md5]]
               :clj  [digest :refer [md5]])
            [clojure.string :as str]))

(defn params->query [params]
  (->> params
       (filter (fn [[k v]] v))
       (map (fn [[k v]] [(name k) (URLEncoder/encode (str v))]))
       (map #(str/join "=" %))
       (str/join "&")))

(defn gravatar-host [https?]
  (if https?
    "https://secure.gravatar.com/"
    "http://www.gravatar.com/"))

(defn email-hash [email]
  (md5 (str/lower-case email)))

(defn avatar-url
  [email & {:keys [default rating size https] :as options}]
  (let [params (params->query (dissoc options :https))
        params-str (if (empty? params)
                     ""
                     (str "?" params))]
    (str (gravatar-host https)
         "avatar/"
         (email-hash email)
         params-str)))
