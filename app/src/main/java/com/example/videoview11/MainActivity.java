package com.example.videoview11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;
    private static final int RQ = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView =findViewById(R.id.video);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    RQ);
        } else {
            // Si ya se tienen permisos, continuar con la lógica de la aplicación
            // ...
            video();
        }
    }



    // Verificar si se tienen permisos para leer archivos externos
    //de forma alternativa si queremos un streaming usar
    //


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Verificar si el requestCode es el mismo que se utilizó al solicitar permisos
        if (requestCode == RQ) {
            // Verificar si el permiso fue concedido
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Si se concedió el permiso, continuar con la lógica de la aplicación
                // ...
                video();
            } else {
                // Si se negó el permiso, mostrar un mensaje al usuario o cerrar la aplicaciónes
                // ...
                Toast.makeText(this, "Se ha negado el permiso", Toast.LENGTH_SHORT).show();
            }
        }
    }
public void video(){
    mVideoView.setVideoPath("/sdcard/Cats.mp4");
    //mVideoView.setVideoURI(Uri.parse("https://tescoacalco-my.sharepoint.com/:v:/g/personal/jose_eduardo_itic_tesco_edu_mx/EQRZTlTKL7ZKmfv6nTzmFccBVpE8U0FyyFgv9LBey6BhuQ"));
    mVideoView.setMediaController(new MediaController(this));
    mVideoView.start();
    mVideoView.requestFocus();
}




}