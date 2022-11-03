package com.if3b.putripabuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNamaLengkap;
    EditText etNomorPendaftaran;
    Button btnDaftar;
    CheckBox cbKonfirmasiPendaftaran;
    Spinner spJalurPendaftaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNomorPendaftaran = findViewById(R.id.et_Nomor_Pendaftaran);
        etNamaLengkap = findViewById(R.id.et_Nama_Lengkap);
        btnDaftar = findViewById(R.id.btn_Daftar);
        cbKonfirmasiPendaftaran = findViewById(R.id.cb_Konfirmasi_Pendaftaran);
        spJalurPendaftaran = findViewById(R.id.sp_Jalur_Pendaftaran);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NamaLengkap = etNamaLengkap.getText().toString();
                String NomorPendaftaran = etNomorPendaftaran.getText().toString();
                String KonfirmasiPendaftaran = cbKonfirmasiPendaftaran.getText().toString();
                String JalurPendaftaran = String.valueOf(spJalurPendaftaran.getSelectedItem());

                if (NamaLengkap.trim().equals("")) {
                    etNamaLengkap.setError("Nama Harus Diisi");
                }
                else if (NomorPendaftaran.trim().equals("")) {
                    etNomorPendaftaran.setError("Nomor Pendaftaran Harus Diisi");
                }
                else if (JalurPendaftaran.equalsIgnoreCase("Jalur Pendaftaran")) {
                    Toast.makeText(MainActivity.this,"Silahkan Di Pilih Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                }
                else if (!cbKonfirmasiPendaftaran.isChecked()) {
                    Toast.makeText(MainActivity.this,"Silahkan Di Centang Dulu!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent daftar = new Intent(MainActivity.this, SecondActivity.class);
                    daftar.putExtra("xnama", NamaLengkap);
                    daftar.putExtra("xnomor", NomorPendaftaran);
                    daftar.putExtra("xconfirm",KonfirmasiPendaftaran);
                    daftar.putExtra("xpendaftaran", JalurPendaftaran);
                    startActivity(daftar);
                }
            }
        });
    }
}