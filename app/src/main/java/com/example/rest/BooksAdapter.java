package com.example.rest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {
    private Context mContext;
    private List<Book> mBooksList;

    public BooksAdapter(Context context, List<Book> booksList) {
        mContext = context;
        mBooksList = booksList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = mBooksList.get(position);
        holder.titleTextView.setText(book.getTitle());
        holder.authorTextView.setText(book.getAuthors());
        holder.publisherTextView.setText(book.getPublisher());
        holder.publishedDateTextView.setText(book.getPublishedDate());
        holder.descriptionTextView.setText(book.getDescription());
    }

    @Override
    public int getItemCount() {
        return mBooksList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView authorTextView;
        public TextView publisherTextView;
        public TextView publishedDateTextView;
        public TextView descriptionTextView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            authorTextView = itemView.findViewById(R.id.author_text_view);
            publisherTextView = itemView.findViewById(R.id.publisher_text_view);
            publishedDateTextView = itemView.findViewById(R.id.published_date_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
        }
    }
}

