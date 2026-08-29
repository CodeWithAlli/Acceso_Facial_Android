package com.tuapp.accesofacial; // Asegúrate de mantener el nombre real de tu paquete

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Solicitar permiso de cámara al usuario
        if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 100);
        }

        webView = findViewById(R.id.webView);

        // 2. Configuración de JavaScript y almacenamiento
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false); // Permite la reproducción automática de video de la cámara

        // 3. Evitar que abra el navegador externo
        webView.setWebViewClient(new WebViewClient());

        // 4. Conceder permisos de cámara al sitio web dentro del WebView
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                request.grant(request.getResources());
            }
        });

        // 5. Cargar tu aplicación en Vercel
        webView.loadUrl("https://acceso-facial.vercel.app/");
    }

    // Navegación hacia atrás dentro de la web
    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}