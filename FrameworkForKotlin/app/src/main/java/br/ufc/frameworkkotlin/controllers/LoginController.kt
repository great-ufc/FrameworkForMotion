//------Generated by the Framework and can be changed-----//
//------Sample of LoginController for Login Activity----//

package br.ufc.frameworkkotlin.controllers

import android.content.Intent
import br.ufc.frameworkkotlin.model.utils.Constants
import br.ufc.frameworkkotlin.model.utils.GoogleApiUtil
import br.ufc.frameworkkotlin.ui.CommonActivities.BaseActivity
import br.ufc.frameworkkotlin.R

class LoginController(private val activity: BaseActivity) {

    private var googleApiClient: GoogleApiUtil = GoogleApiUtil(activity)

    fun signIn() {
        googleApiClient.signIn()
    }

    fun activityResult(requestCode: Int, data: Intent?) {
        if (requestCode == Constants.SIGN_IN && googleApiClient.googleResult(data) == true) {
  //          activity.startActivity(Intent(activity.baseContext, MenuActivity::class.java))
        } else {
            activity.showLongToast(activity.getString(R.string.login_failed), false)
        }
    }

    fun isLogged():Boolean{
        return googleApiClient.isLogged()
    }
}