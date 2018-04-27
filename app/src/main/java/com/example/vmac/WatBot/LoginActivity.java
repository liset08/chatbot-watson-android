package com.example.vmac.WatBot;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = LoginActivity.class.getSimpleName();


    //Codigo para invocar inicio de sesion
    private static final int GOOGLE_SIGNIN_REQUEST = 1000;
    private SignInButton signInButton;
    private FirebaseAuth firebaseAuth;
    private TextView title;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    public static final int SING_IN_COD = 777;
    public static final int SING_IN_COD_FACEBOOK = 1000;


    //clientes interctuanc¡do con el google api
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        title = (TextView) findViewById(R.id.title);



        Typeface face=Typeface.createFromAsset(getAssets(),"Juicy Fruity.ttf");
        title.setTypeface(face);
        initGoogleSignIn();
    }

    private void initGoogleSignIn() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))   //obtengamos un token
                .requestEmail()  //correo del usuario autenticado
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton = (SignInButton) findViewById(R.id.sign_in_button);   //le damos una accion
        signInButton.setOnClickListener(new View.OnClickListener() {                 //cuando presionemos el boton se ejecutara este metodo onclick

            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);  //abrira el inicio de sesion para la cuenta google
                startActivityForResult(intent, SING_IN_COD);    //esperando un resultado


            }


        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user= firebaseAuth.getCurrentUser();    ///con este metodo preguntaremos si hay un usuario y nos mandaria a main activity
                if (user != null){
                    goMainScreem();
                }


            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {   // a ese metodo llegan los resultados
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TEST", "" + resultCode);
        Log.d("TEST", "" + data);
        if (requestCode == SING_IN_COD) {   //utilizamos el codigo
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data); // mediante esto podemos obtener un objeto resulatado
            handleSignResult(result);                //para mnejar el resultado comodamente  se le enviaremos a otro metodo creamos el metodo handleSignInresult

        }

    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount signInAccount) {

        AuthCredential credential= GoogleAuthProvider.getCredential(signInAccount.getIdToken(),null);   //credencial para autenticarnos con firebase
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),R.string.no_task_furebase, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void handleSignResult(GoogleSignInResult result) {

        if (result.isSuccess()) {        //se comprueba si la operacion a sido exitosa

            firebaseAuthWithGoogle(result.getSignInAccount()); //metodo para abrir la activity principal

        } else {
            Toast.makeText(this, R.string.CerrarSesion, Toast.LENGTH_SHORT).show();
        }

    }



    private void goMainScreem() {

        Intent intent = new Intent(this, MainActivity.class);   //
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (firebaseAuthListener !=null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
