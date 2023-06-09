//------Generated by the Framework and can be changed-----//
//------Login Activity Sample with Util Functions-----//

package br.ufc.POC1.ui.CommonActivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import br.ufc.POC1.R
import br.ufc.POC1.controllers.LoginController
import br.ufc.POC1.ui.MainActivity

class LoginActivity : BaseActivity() {

    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginController = LoginController(this)

        val btnSignIn = findViewById<Button>(R.id.btnLogin)

        if(loginController.isLogged())
            startActivity(Intent(this, MainActivity::class.java))

        btnSignIn.setOnClickListener {
                loginController.signIn()
            }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginController.activityResult(requestCode, data)

    }
}