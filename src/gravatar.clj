(ns gravatar
  (:require [digest]
            [clojure.string :as str]))

(defn params->query [params]
  (->> params
       (filter (fn [[k v]] v))
       (map (fn [[k v]] [(name k) v]))
       (map #(str/join "=" %))
       (str/join "&")))

(defn gravatar-host [https?]
  (if https?
    "https://secure.gravatar.com/"
    "http://www.gravatar.com/"))

(defn email-hash [email]
  (digest/md5 (str/lower-case email)))

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
