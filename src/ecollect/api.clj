(ns ecollect.api
  (:require [clj-http.client :as http]
            [clojure.data.json :as json]))

(def charge-type #{:interest
                   :reminder_fee
                   :bank_charges
                   :processing_fee
                   :data_preparation
                   :expenses})

(def cancel-status #{:direct_payment
                     :claim_invalid})

(defn login
  "Login and return the session authorization data map, containing the accesspoint URL,
   the Bearer access token, as well as the Basic-Auth credentials."
  [config]
  (let [response (http/post (str (:endpoint config) "/token")
                            {:basic-auth [(get-in config [:creditor :username])
                                          (get-in config [:creditor :password])]
                             :form-params {:username (get-in config [:oauth-user :username])
                                           :password (get-in config [:oauth-user :password])
                                           :grant_type "password"}
                             :accept :json
                             :insecure? true
                             :throw-entire-message? true})]
    (-> (get config :creditor)
        (assoc :endpoint (:endpoint config))
        (assoc :access-token  (:access_token (json/read-json (:body response)))))))

(defn post-file [auth data-map]
  (http/post (str (:endpoint auth) "/postfile")
             {:basic-auth [(:username auth) (:password auth)]
              :headers {:authorization (str "Bearer " (:access-token auth))}
              :form-params data-map
              :accept :json
              :insecure? true
              :throw-entire-message? true}))

(defn get-file [auth file-id]
  (http/post (str (:endpoint auth) "/getfile")
             {:basic-auth [(:username auth) (:password auth)]
              :headers {:authorization (str "Bearer " (:access-token auth))}
              :accept :json
              :form-params {:file_id file-id}
              :insecure? true
              :throw-entire-message? true}))

(defn cancel-file [auth file-id cancel-status]
  (http/post (str (:endpoint auth) "/cancelfile")
             {:basic-auth [(:username auth) (:password auth)]
              :headers {:authorization (str "Bearer " (:access-token auth))}
              :accept :json
              :form-params {:ecollect_id file-id
                            :cancel_status (name cancel-status)
                            :cancel_comment "a simple test"}
              :insecure? true
              :throw-entire-message? true}))

