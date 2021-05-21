package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation


/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 * */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all  the views for a data iem in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Creates new view holders for the RecyclerView when there are no existing view holders that
     * can be reused (invoked by the layout manager).
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Create a new view.
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder (adapterLayout)
    }

    /**
     * Called by the layout manager in order to replace the contents of a list item view
     * (invoked by the layout manager).
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // Returns the given position in the dataset
        val item = dataset[position]

        // Setting the text of the TextView to display the Affirmations string for this item
        holder.textView.text =  context.resources.getString(item.stringResourceId)

        //Setting the Image of the View to display the Affirmation Image for the current item
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * Returns the size of the your dataset (invoked by the layout manager).
     * */
    override fun getItemCount() = dataset.size
}