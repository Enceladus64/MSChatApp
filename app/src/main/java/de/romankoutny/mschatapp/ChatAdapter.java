package de.romankoutny.mschatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roman on 06.04.17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>
{

    Context context;
    List<String> messageList;
    boolean rightPos = true;


    public ChatAdapter(Context context)
    {
        this.context = context;
        messageList = new LinkedList<>();
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v;
        if(rightPos)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_right, parent, false);
        }
        else
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_left, parent, false);
        }
        rightPos = !rightPos;

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void add(int position, String item)
    {
        messageList.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position)
    {
        String msg = messageList.get(position);
        holder.textview.setText(msg);

/*
        final Image image = list.get(position);
        Picasso.with(context)
            .load(image.getPreviewURL())
            .resize((int) context.getResources().getDimension(R.dimen.image_size),
                (int) context.getResources().getDimension(R.dimen.image_size))
            .centerCrop()
            .into(holder.thumbnail);
        holder.username.setText(image.getUser());
        holder.tags.setText(image.getTags());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                context.startActivity(DetailActivtiy.createIntent(context, image));
            }
        });
*/

    }

    @Override
    public int getItemCount()
    {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.textView)
        TextView textview;

        public ViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
