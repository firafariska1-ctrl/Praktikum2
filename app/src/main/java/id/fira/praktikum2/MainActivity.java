package id.fira.praktikum2;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

        private EditText edNama, edNIM, edAlamat;
        private Button btsimpan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            edNama = findViewById(R.id.ed_nama);
            edNIM = findViewById(R.id.ed_nim);
            edAlamat = findViewById(R.id.ed_alamat);
            btsimpan = findViewById(R.id.btsimpan);

            btsimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    simpan();
                }
            });
        }

        private void simpan() {
            String s = "Nama saya adalah : " + edNama.getText().toString() + "\n" +
                    "NIM saya adalah : " + edNIM.getText().toString() + "\n" +
                    "dan Alamat rumah saya adalah di " + edAlamat.getText().toString();

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.mydialog);

            TextView tvjudl = dialog.findViewById(R.id.txtJudulAlert);
            TextView tvisi = dialog.findViewById(R.id.dialog_text);
            Button btYa = dialog.findViewById(R.id.dialog_ok);

            btYa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            tvjudl.setText("Informasi");
            tvisi.setText(s);
            dialog.show();

            Window window = dialog.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }