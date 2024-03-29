//------Generated by the Framework and can be changed-----//
//------Login Activity Sample with Util Functions-----//

package br.ufc.poc2.ui.CommonActivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import br.ufc.poc2.R
import br.ufc.poc2.controllers.LoginController
import br.ufc.poc2.ui.MainActivity

class LoginActivity : BaseActivity() {

    private lateinit var loginController: LoginController
    private lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginController = LoginController(this)
        btnLogin = findViewById(R.id.btnLogin)

        if(loginController.isLogged())
            startActivity(Intent(this, MainActivity::class.java))

        btnLogin.setOnClickListener {
            loginController.signIn()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginController.activityResult(requestCode, data)
    }
}