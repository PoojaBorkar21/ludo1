package pooja.borkar.ludo1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class welcome1 extends AppCompatActivity {
ImageView imageViewd1,imageViewd2;
Button button;
MediaPlayer mediaPlayer_dice;
    int [] diceImages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);
        imageViewd1=findViewById(R.id.imagedice1);
        imageViewd2=findViewById(R.id.imagedice2);
        button=findViewById((R.id.btnroll));
        mediaPlayer_dice=MediaPlayer.create(this,R.raw.dice_sound);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int random_num=random.nextInt(6);
                imageViewd1.setImageResource(diceImages[random_num]);
                 random_num=random.nextInt(6);
                 imageViewd2.setImageResource(diceImages[random_num]);
                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(5)
                        .playOn(findViewById(R.id.imagedice1));
                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(5)
                        .playOn(findViewById(R.id.imagedice2));
                mediaPlayer_dice.start();
            }
        });
    }
}
