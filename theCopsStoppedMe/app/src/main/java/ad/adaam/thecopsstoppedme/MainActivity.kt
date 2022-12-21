package ad.adaam.thecopsstoppedme

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gotStopped = findViewById<Button>(R.id.gotStopped)

        gotStopped.setOnClickListener {
            Toast.makeText(this, "gimme shelter. I'm made", Toast.LENGTH_LONG).show()
        }


    }
}


//
//b.setOnClickListener(new OnClickListener() {
//    public void onClick(View v) {
//        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
//    }
//});
//}
//
//protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//    if (requestCode == CAMERA_PIC_REQUEST) {
//        Bitmap image = (Bitmap) data.getExtras().get("data");
//        ImageView imageview = (ImageView) findViewById(R.id.ImageView01); //sets imageview as the bitmap
//        imageview.setImageBitmap(image);
//    }
//}

