package nl.endhoven.bart.studentportal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalItemAdapter extends RecyclerView.Adapter<PortalItemAdapter.ViewHolder> {

    public List<PortalItem> mPortalItems;
    private OnClickListener mOnClickListener;


    public PortalItemAdapter(List<PortalItem> mPortalItems, OnClickListener mOnClickListener) {
        this.mPortalItems = mPortalItems;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public PortalItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        return new PortalItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PortalItemAdapter.ViewHolder holder, int position) {
        // Gets a single item in the list from its position
        final PortalItem portalObject = mPortalItems.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.titleText.setText(portalObject.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPortalItems.size();
    }

    public interface OnClickListener {
        void OnClickListener(int position);
    }

    //Class ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleText;

        public ViewHolder(View itemView) {
            super(itemView);
            this.titleText = itemView.findViewById(R.id.titleTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.OnClickListener(clickedPosition);
        }
    }
}
