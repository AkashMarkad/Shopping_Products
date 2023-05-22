package com.example.shoppingproducts;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSelectedProducts;
    private SelectedProductAdapter selectedProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerViewSelectedProducts = findViewById(R.id.recyclerViewSelectedProducts);
        recyclerViewSelectedProducts.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> selectedProducts = getIntent().getParcelableArrayListExtra("selectedProducts");

        selectedProductAdapter = new SelectedProductAdapter(selectedProducts);
        recyclerViewSelectedProducts.setAdapter(selectedProductAdapter);

        // Add item decoration to show a divider between selected products
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        if (dividerDrawable != null) {
            ((DividerItemDecoration) dividerItemDecoration).setDrawable(dividerDrawable);
            recyclerViewSelectedProducts.addItemDecoration(dividerItemDecoration);
        }
    }
}
