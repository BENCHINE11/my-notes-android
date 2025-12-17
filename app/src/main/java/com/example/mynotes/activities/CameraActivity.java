package com.example.mynotes.activities;

import android.Manifest;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.mynotes.R;
import com.example.mynotes.utils.PhotoStore;

import java.io.File;

public class CameraActivity extends AppCompatActivity {

    private ImageView ivPreview;
    private Uri photoUri;

    private final ActivityResultLauncher<String> requestCameraPermission =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), granted -> {
                if (granted) takePhoto();
                else Toast.makeText(this, "Permission caméra refusée.", Toast.LENGTH_SHORT).show();
            });

    private final ActivityResultLauncher<Uri> takePictureLauncher =
            registerForActivityResult(new ActivityResultContracts.TakePicture(), success -> {
                if (success && photoUri != null) {
                    ivPreview.setImageURI(photoUri);
                    PhotoStore.addPhotoUri(this, photoUri.toString());
                    Toast.makeText(this, "Photo enregistrée ✅", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Capture annulée.", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ivPreview = findViewById(R.id.ivPreview);
        Button btnTake = findViewById(R.id.btnTakePhoto);
        Button btnOpenGallery = findViewById(R.id.btnOpenGallery);

        btnTake.setOnClickListener(v -> requestCameraPermission.launch(Manifest.permission.CAMERA));

        btnOpenGallery.setOnClickListener(v ->
                startActivity(new android.content.Intent(this, GalleryActivity.class))
        );
    }

    private void takePhoto() {
        try {
            File dir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "MyNotes");
            if (!dir.exists()) dir.mkdirs();

            File photoFile = File.createTempFile("note_", ".jpg", dir);

            photoUri = FileProvider.getUriForFile(
                    this,
                    getPackageName() + ".fileprovider",
                    photoFile
            );

            takePictureLauncher.launch(photoUri);
        } catch (Exception e) {
            Toast.makeText(this, "Erreur: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
