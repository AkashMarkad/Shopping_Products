package com.example.shoppingproducts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SelectedProductAdapter extends RecyclerView.Adapter<SelectedProductAdapter.ViewHolder> {

    private List<Product> selectedProducts;

    public SelectedProductAdapter(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = selectedProducts.get(position);
        holder.imgSelectedProduct.setImageResource(product.getImageRes());
        holder.tvSelectedQuantity.setText("Quantity Left: " + product.getQuantityLeft());
    }

    @Override
    public int getItemCount() {
        return selectedProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSelectedProduct;
        TextView tvSelectedQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSelectedProduct = itemView.findViewById(R.id.imgSelectedProduct);
            tvSelectedQuantity = itemView.findViewById(R.id.tvSelectedQuantity);
        }
    }
}