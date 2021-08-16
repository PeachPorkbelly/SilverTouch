package card_maker;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.silvertouch.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class card_main extends AppCompatActivity {

    Button btn_left, btn_right, btn_close, btn_emoji, btn_clear, btn_ok, btn_check;
    TextView tx_title;
    LinearLayout layout_bottom_1, layout_bottom_2, card_image;

    int bgmax = 9;
    int[] card_bg = new int[bgmax];
    double[] card_size = new double[bgmax];
    int nowbg = 0;

    public static Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }

    private Uri saveImageExternal(Bitmap image) {
        Context context = getApplicationContext();
        //TODO - Should be processed in another thread
        Uri uri = null;
        try {
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share.png");
            FileOutputStream stream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 90, stream);
            stream.close();
//            uri = Uri.fromFile(file);
            uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file);
        } catch (IOException e) {
            Log.d("bitmapError", "IOException while trying to write file for sharing: " + e.getMessage());
        }
        return uri;
    }

    private void sharingJpge(Bitmap image){

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        Uri screenshotUri = saveImageExternal(image);
        Log.d("uriToString", screenshotUri.toString());
        sharingIntent.setType("image/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
        startActivity(Intent.createChooser(sharingIntent, "Share image using"));

    }


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_main);

        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);
        btn_check = (Button) findViewById(R.id.btn_check);
        tx_title = (TextView) findViewById(R.id.tx_cardbg);
        layout_bottom_1 = (LinearLayout)findViewById(R.id.bottom_1);
        card_image = (LinearLayout) findViewById(R.id.card_image);
        layout_bottom_1.setVisibility(View.VISIBLE);
//        btn_close = (Button) findViewById(R.id.btn_close);
//        btn_emoji = (Button) findViewById(R.id.btn_emoji);
//        btn_clear = (Button) findViewById(R.id.btn_clear);
//        btn_ok = (Button) findViewById(R.id.btn_ok);
//        layout_bottom_2 = (LinearLayout)findViewById(R.id.bottom_2);
//        layout_bottom_2.setVisibility(View.GONE);

        card_bg[0] = R.drawable.card_child;
        card_size[0] = 1;
        card_bg[1] = R.drawable.card_family;
        card_size[1] = 1;
        card_bg[2] = R.drawable.card_friend;
        card_size[2] = 1;
        card_bg[3] = R.drawable.card_happiness;
        card_size[3] = 1;
        card_bg[4] = R.drawable.card_health;
        card_size[4] = 1;
        card_bg[5] = R.drawable.card_love;
        card_size[5] = 1;
        card_bg[6] = R.drawable.card_morning;
        card_size[6] = 1;
        card_bg[7] = R.drawable.card_smile;
        card_size[7] = 1;
        card_bg[8] = R.drawable.card_wish;
        card_size[8] = 1;

        card_image.setBackgroundResource(card_bg[nowbg]);


        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowbg == 0){
                    nowbg = bgmax - 1;
                }
                else{
                    nowbg--;
                }
                card_image.setBackgroundResource(card_bg[nowbg]);
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowbg + 1 == bgmax){
                    nowbg = 0;
                }
                else{
                    nowbg++;
                }
                card_image.setBackgroundResource(card_bg[nowbg]);
            }
        });

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                layout_bottom_1.setVisibility(View.GONE);
//                layout_bottom_2.setVisibility(View.VISIBLE);

                sharingJpge(getBitmapFromView(card_image));

            }
        });

//        btn_close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                layout_bottom_1.setVisibility(View.VISIBLE);
//                layout_bottom_2.setVisibility(View.GONE);
//            }
//        });
    }
}
