package com.example.shoppingproducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> productList = createProductList();
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);

        btnProceed = findViewById(R.id.btnProceed);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceedToNextPage(view);
            }
        });

        // Add item decoration to show a divider between selected and non-selected products
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        Drawable dividerDrawable = new ColorDrawable(Color.DKGRAY);
        dividerItemDecoration.setDrawable(dividerDrawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void proceedToNextPage(View view) {
        List<Product> selectedProducts = new ArrayList<>();
        for (Product product : productAdapter.productList) {
            if (product.isSelected()) {
                selectedProducts.add(product);
            }
        }

        Intent intent = new Intent(this, CartActivity.class);
        intent.putParcelableArrayListExtra("selectedProducts", new ArrayList<>(selectedProducts));
        startActivity(intent);
    }

    private List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(R.drawable.image_1, 10));
        productList.add(new Product(R.drawable.image_2, 15));
        productList.add(new Product(R.drawable.image_3, 8));
        productList.add(new Product(R.drawable.image_4, 5));
        productList.add(new Product(R.drawable.image_5, 12));
        productList.add(new Product(R.drawable.image_6, 20));
        productList.add(new Product(R.drawable.image_7, 22));
        productList.add(new Product(R.drawable.image_8, 10));
        productList.add(new Product(R.drawable.image_9, 15));
        productList.add(new Product(R.drawable.image_10, 23));
        productList.add(new Product(R.drawable.image_11, 19));
        productList.add(new Product(R.drawable.image_12, 8));
        return productList;
    }
}