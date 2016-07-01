(ns ecollect.core
  (:require [clj-http.client :as http]
            [clojure.data.json :as json]
            [ecollect.api :as api]))

;; Obsolete credentials (no more valid)
(def config {:endpoint "https://sandbox-api.ecollect.org"
             :creditor {:username "user-s+"
                        :password "asJl1OJvKxPjIKhnynFZ2Bix2tCGvsLb"}
             :oauth-user {:username "user-s+"
                          :password "K5y4xdLp0ht3w1OsPzRwIvL6wLtBP8Rs"}})

(defn exec-post [data]
  (-> (api/login config)
      (api/post-file data)
      :body
      (json/read-json)))

(defn exec-get [id]
  (-> (api/login config)
      (api/get-file id)
      :body
      (json/read-json)))

;; :direct_payment, :claim_invalid,...
(defn exec-cancel [id status]
  (-> (api/login config)
      (api/cancel-file id status)))
