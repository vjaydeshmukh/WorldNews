package com.example.marwa.worldnews.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.marwa.worldnews.R;
import com.example.marwa.worldnews.data.NewsContract.NewsEntry;

/**
 * Created by Marwa on 5/7/2018.
 */

public class NewsCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link NewsCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public NewsCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.news_list_item,parent,false);
    }

    /**
     * This method binds the news data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current news can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView title = (TextView) view.findViewById(R.id.title_text_view);
        TextView section = (TextView) view.findViewById(R.id.section_text_view);
        TextView date = (TextView) view.findViewById(R.id.publicationDate_text_view);
        TextView author = (TextView) view.findViewById(R.id.authorName_text_view);
        TextView description = (TextView) view.findViewById(R.id.description_text_view);

        // Find the columns of news attributes that we're interested in
        int idColumnIndex = cursor.getColumnIndex(NewsEntry._ID);
        int titleColumnIndex = cursor.getColumnIndex(NewsEntry.COLUMN_NEWS_TITLE);
        int sectionColumnIndex = cursor.getColumnIndex(NewsEntry.COLUMN_NEWS_SECTION);
        int dateColumnIndex = cursor.getColumnIndex(NewsEntry.COLUMN_NEWS_DATE);
        int authorColumnIndex = cursor.getColumnIndex(NewsEntry.COLUMN_NEWS_AUTHOR);
        int descriptionColumnIndex = cursor.getColumnIndex(NewsEntry.COLUMN_NEWS_DESC);


        // Read the medicine attributes from the Cursor for the current medicine
        final int rowId = cursor.getInt(idColumnIndex);
        String newsTitle = cursor.getString(titleColumnIndex);
        String newsSection = cursor.getString(sectionColumnIndex);
        String newsDate = cursor.getString(dateColumnIndex);
        String newsAuthor = cursor.getString(authorColumnIndex);
        String newsDesc = cursor.getString(descriptionColumnIndex);


        // Update the TextViews with the attributes for the current news
        title.setText(newsTitle);
        section.setText(newsSection);
        date.setText(newsDate);
        author.setText(newsAuthor);
        description.setText(newsDesc);

    }


}
