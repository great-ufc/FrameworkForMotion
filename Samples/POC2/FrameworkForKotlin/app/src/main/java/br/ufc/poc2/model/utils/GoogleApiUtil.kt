//------Generated by the Framework and must not be changed-----//
//------Google API Util Functions-----//
package br.ufc.poc2.model.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import br.ufc.poc2.ui.CommonActivities.BaseActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task

@SuppressLint("CheckResult")
class GoogleApiUtil (private val activity: BaseActivity) {
    var account: GoogleSignInAccount? = null
    private var client: GoogleSignInClient

    init {
        client = GoogleSignIn.getClient(
            activity.applicationContext,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build()
        )
    }

    fun signIn() {
        activity.startActivityForResult(client.signInIntent, Constants.SIGN_IN)
        val task: Task<GoogleSignInAccount> = client.silentSignIn()

        if (task.isSuccessful) {
            account = task.result
        }
    }

    fun googleResult(data: Intent?): Boolean? {
        if(data != null){
            return Auth.GoogleSignInApi.getSignInResultFromIntent(data)?.isSuccess
        }
        return false
    }

    fun isLogged():Boolean{
        val lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(activity.applicationContext)
        if(lastSignedInAccount != null){
            account = lastSignedInAccount
            return true
        }
        return false
    }

    fun getName(): String {
        return account?.displayName!!
    }

    fun getEmail(): String {
        return account?.email!!
    }

    fun getImage(): Uri? {
        return account?.photoUrl
    }

}