package tw.brad.sk_barcodefragmenttest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class Page2Activity extends AppCompatActivity
        implements BarcodeReader.BarcodeReaderListener{
    private FragmentManager fmgr;
    private BarcodeReader barcodeReader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA,
                            },
                    123);
        }else{
            init();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        init();
    }

    private void init(){
        fmgr = getSupportFragmentManager();
        barcodeReader = (BarcodeReader) fmgr.findFragmentById(
                R.id.barcode_fragment);

    }


    @Override
    public void onScanned(Barcode barcode) {
//        String barcodeString = barcode.toString();
//        String rawValue = barcode.rawValue;
//        String displayValue = barcode.displayValue;
//        Log.v("brad", "s1 = " + barcodeString);
//        Log.v("brad", "s2 = " + rawValue);
//        Log.v("brad", "s3 = " + displayValue);
//        finish();
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
        for (Barcode barcode : barcodes){
            String rawValue = barcode.rawValue;
            Log.v("brad", "s2 = " + rawValue);
        }
        finish();
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {
        Log.v("brad", "X1:" + errorMessage);
    }

    @Override
    public void onCameraPermissionDenied() {
        Log.v("brad", "XXX");
    }
}
