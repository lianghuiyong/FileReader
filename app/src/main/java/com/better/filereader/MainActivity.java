package com.better.filereader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class MainActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {

    private PDFView pdfView;
    private String assetFileName = "人月神话.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = (PDFView) findViewById(R.id.pdfView);

        displayFromAsset(assetFileName);
    }

    private void displayFromAsset(String assetFileName) {
        pdfView.fromAsset(assetFileName)
                .onPageChange(this)
                .swipeHorizontal(true)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .load();
    }


    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void loadComplete(int nbPages) {

    }
}
