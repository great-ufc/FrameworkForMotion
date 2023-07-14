//------Generated by the Framework and must be changed-----//
//------Developers should change Constants-----//

package br.ufc.POC1.model.utils

object Constants {
    const val ADMIN_EMAIL       = "adm@email.com"
    //const val BACKEND_IP_PORT   = "http://192.168.153.85:5000" //Server API for Classification Graph
    const val BACKEND_IP_PORT   = "http://ec2-3-86-153-243.compute-1.amazonaws.com:3000" //Server API for Classification Graph
    const val BACKEND_IP_PORT_ADAPTATION_RULES   = "http://ec2-3-86-153-243.compute-1.amazonaws.com:3001/POC1"
    //const val BACKEND_IP_PORT_ADAPTATION_RULES   = "http://192.168.153.85:5001/"
    const val LAST_OPTIMIZE_GRAPH_ADDRESS   = BACKEND_IP_PORT+"/OptimizeGraphRequest/download.xml"
    const val OPTIMIZE_GRAPH_ADDRESS   = BACKEND_IP_PORT+"/OptimizeGraphRequest/acc/60" // 60% IS THE THRESHOLD FOR TRAINED MODELS. CAN BE CHANGE
    const val SAVED_MODELS_ADDRESS   = BACKEND_IP_PORT+"/saved_model/"

    const val WINDOW = 1 //Window Data Time

    const val SHEET_TAB_NAME_PARAMS = "APP_PARAMS"
    const val SHEET_ID              = "1ijmj_UxM5rmqxt6i3qNH5ZwXTYJC471foIi664Z3sj4"
    const val SHEET_URL_MASK        = "https://sheets.googleapis.com/v4/spreadsheets/%s/values/%s?alt=json&key=%s"

    const val APK_DOWNLOAD_URL = "$BACKEND_IP_PORT/<app>>-backend/latest-apk/<app>-%s.apk"

    const val LANGUAGE_PT_BR = "pt_BR"
    const val LANGUAGE_EN_US = "en_US"

    const val ZERO = 0

    const val LIMIT_METERS_GPS_REGISTER = 50.0
    const val INTERVAL_LOCATION_SERVICE = 60000L
    const val MAX_WAIT_LOCATION_SERVICE = 120000L
    const val FASTEST_INTERVAL_LOCATION_SERVICE = 10000L

    const val SIGN_IN = 1

    const val NOTIFICATION_ID                               = 2
    const val NOTIFICATION_MORNING_ID                       = 3
    const val NOTIFICATION_WEARABLE_ID                      = 4

    const val MY_PERMISSIONS_REQUEST_ACTIVITY_RECOGNITION   = 10
    const val GOOGLE_FIT_PERMISSIONS_REQUEST_CODE           = 11
    const val NOTIFICATION_MORNING_REQUEST_CODE             = 12
    const val NOTIFICATION_WEARABLE_REQUEST_CODE            = 13


    const val LOCATION_PERMISSION_REQUEST                   = 20
    const val PHYSICAL_ACTIVITY_PERMISSION_REQUEST          = 21
    const val USAGE_STATUS_PERMISSION_REQUEST               = 22
    const val GOOGLE_FIT_PERMISSION_REQUEST                 = 23

    const val NOTIFICATION_UPDATE_APP_REQUEST_CODE          = 30
    const val NOTIFICATION_UPDATE_APP_ID                    = 31

    const val NOTIFICATION_OPEN_APPS_REQUEST_CODE           = 40

    const val KEY_INTENT_OPEN_APPS          = "<app package path>.<app name>.OPEN_EXTERNALS_APPS"
    const val KEY_INTENT_INSTALL_UPDATES    = "<app package path>.<app name>.INSTALL_UPDATES"
    const val GOOGLE_FIT_PACK               = "com.google.android.apps.fitness"

    const val NOTIFICATION_CHANNEL_ID = "<APP_NAME>_Notification_Channel_ID"

    const val SHARED_PREF_KEY                           = "<app package path>.<app name>.SHARED_PREF_KEY"
    const val SHARED_PREF_KEY_TERMS                     = "<app package path>.<app name>.SHARED_PREF_KEY_TERMS"
    const val SHARED_PREF_KEY_WEARABLE_APP_NOTIFICATION = "<app package path>.<app name>.SHARED_PREF_KEY_WEARABLE_APP_NOTIFICATION"
    const val SHARED_PREF_KEY_GOOGLE_FIT_NOTIFICATION   = "<app package path>.<app name>.SHARED_PREF_KEY_GOOGLE_FIT_NOTIFICATION"
    const val SHARED_PREF_KEY_FIRST_ACCESS              = "<app package path>.<app name>.SHARED_PREF_KEY_FIRST_ACCESS"
}