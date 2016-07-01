(ns ecollect.examples)

;;
;; Example exchange documents
;;

(def file-simple {:file_currency "CHF"
                  :claim_gross_amount "100.50"
                  :claim_due_date "2014-07-14"
                  :subject_matter_of_claim "Subscription fee"
                  :contractual_item "Year subscription"
                  :contract_date "2014-05-10"
                  :debtor_individual_firstname "John"
                  :debtor_individual_secondname "Doe"
                  :debtor_individual_gender "m"
                  :debtor_address [{:address_country "CH"
                                    :address_state "Zurich"
                                    :address_zip "8000"
                                    :address_city "Zurich"
                                    :address_line1 "Second floor"}]})

(def file-greenwoods {:subject_matter_of_claim "Bestellung bei xxx"
                      :contractual_item "Einkauf im Online-Shop xxx"
                      :contract_date "2014-01-09"
                      :date_of_delivery ""
                      :claim_due_date "2014-01-23"
                      :file_currency "EUR"
                      :claim_gross_amount "80.80"
                      :claim_vat_included "12.90"
                      :file_notes "test-test"
                      :debtor_individual_title ""
                      :debtor_individual_firstname "Marxxx"
                      :debtor_individual_secondname "Kitxxx"
                      :debtor_individual_gender "f"
                      :debtor_individual_birthname ""
                      :debtor_individual_date_of_birth "1966-01-02"
                      :debtor_individual_place_of_birth ""
                      :debtor_individual_email "marxxxx@web.de"
                      :additional_charges [:add_charge_net_amount "6.72"
                                           :add_charge_vat_included "1.28"
                                           :add_charge_due_date ""
                                           :currency_id "1"
                                           :add_charge_label "reminder_fee"
                                           :add_charge_type_id "reminder_fee"]
                      :file_metadata [:key "Rechnungsnummer"
                                      :value "1251"]
                      :debtor_metadata []
                      :debtor_address [:address_country "DE"
                                       :address_state "Zurich"
                                       :address_zip "8000"
                                       :address_city "Zurich"
                                       :address_line1 "Ochsenxxx"
                                       :address_line2 ""
                                       :email_address "marxxxx@web.de"]
                      :contact_details [:contact_type "email"
                                        :contact_label "Email. #1"
                                        :contact_country "DE"
                                        :contact_record "marxxxx@web.de"]})

(def file-answer-greenwoods {:status "success"
                             :status_message ""
                            :file_id "ca_rdZ8C4iWYxxx"
                            :file_update_date "2014-06-10"
                            :file_status ""
                            :file_status_date ""
                            :file file-greenwoods})

(def file-dev {:file_currency "EUR"
               :claim_gross_amount "11.11"
               :claim_vat_included "0.11"
               :claim_due_date "2014-01-01"
               :subject_matter_of_claim "Einkauf xxx"
               :contractual_item "artikel_xxx"
               :contract_date "2013-12-24"
               :date_of_delivery "2013-12-25"
               :additional_charges [:add_charge_gross_amount "5"
                                    :add_charge_vat_included "0.50"
                                    :add_charge_due_date "2013-12-24"
                                    :add_charge_type "reminder_fee"
                                    :add_charge_label "Bearbeitungsgebühr"]
               :debtor_country "DE"
               :debtor_individual_firstname "Max"
               :debtor_individual_secondname "Mustermann"
               :debtor_individual_gender "m"
               :debtor_address [:address_line1 "Musterstr. 10"
                                :address_city "Mustercity"
                                :address_zip "27832"
                                :address_country "de"]
               :contact_details [:contact_type "email"
                                 :contact_label "Private Email"
                                 :contact_coutry "DE"
                                 :contact_record "test@test.de"]
               :debtor_metadata [:key "Kundennummer"
                                 :value "1234897"]
               :file_metadata [:key "Rechnungsnummer"
                               :value "3456789"]})
