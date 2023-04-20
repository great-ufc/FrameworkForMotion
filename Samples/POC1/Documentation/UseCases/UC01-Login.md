| Info| Value|
| :--- | :--- |
| ID | UC01 |
| Title | Login |
| Requirement | FR01 |
| Mockup | [here](./Mockups/Login.png) |
| Precondition | None |
| Actors | User |
| Basic Flow | 1. User click in Login Button (AF01) <br> 2. Open Email List <br> 3. User Choice a email <br> 4. System use Google Email to identify User Credentials and collect Google Profile Data (EF01) <br> 5. System redirect User to Main App Screen  |
| Alterantive Flow | AF01 - If the user has already logged in on this device before, it is not necessary to log in again and when opening the app, the main screen is redirected |
| Exception | EF01 - If user credentials are not valid, redirect user to login screen |
| Role | None |
