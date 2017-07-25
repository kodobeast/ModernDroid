package ru.test.droidmodern.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import ru.test.droidmodern.R;
import ru.test.droidmodern.model.SomeData;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final OnItemClickListener listener;
    private List<SomeData> data;
    private Context context;

    public Adapter(Context context, List<SomeData> data, OnItemClickListener listener) {

        this.data = data;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {

        holder.click(data.get(position), listener);
        holder.textItem.setText(data.get(position).getName());

        String images = data.get(position).getBackground();

        Glide.with(context)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.background);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener {
        void onClick(SomeData item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textItem;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            textItem = (TextView) itemView.findViewById(R.id.item);
            background = (ImageView) itemView.findViewById(R.id.image);

        }
//TODO: заменить на лямбду
        public void click(final SomeData someData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(someData);
                }
            });
        }
    }


}
