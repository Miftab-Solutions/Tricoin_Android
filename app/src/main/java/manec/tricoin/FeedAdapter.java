package manec.tricoin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {

    private Context mContext;
    private List<Feed> feedList;

    FeedAdapter(Context mContext, List<Feed> feedList) {
        this.mContext = mContext;
        this.feedList = feedList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate new view when we create new items in our recyclerview
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_feed, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // sets all the text and image resources when the card view is bind in our adapter
        final Feed feed = feedList.get(position);
        holder.name.setText(feed.getName());
        holder.location.setText(feed.getLocation());
        holder.description.setText(feed.getDescription());
        holder.timeStamp.setText(feed.getTimeStamp());

        // this is the code for the Glide image library
        Glide.with(mContext)
                .load(feed.getImageUrl())
                .override(1280, 720)
                .fitCenter()
                .priority(Priority.LOW)
                .into(holder.image);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, location, description, timeStamp;
        public ImageView image;

        MyViewHolder(View view) {

            super(view);
            name = view.findViewById(R.id.cardView_name);
            location = view.findViewById(R.id.cardView_location);
            description = view.findViewById(R.id.cardView_description);
            timeStamp = view.findViewById(R.id.cardView_timestamp);
            image = view.findViewById(R.id.cardView_image);

        }

    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

}
