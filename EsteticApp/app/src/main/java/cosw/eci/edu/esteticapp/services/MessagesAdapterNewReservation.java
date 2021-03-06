package cosw.eci.edu.esteticapp.services;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cosw.eci.edu.esteticapp.R;

/**
 * Created by USUARIO on 25/04/2017.
 */

public class MessagesAdapterNewReservation extends RecyclerView.Adapter<MessagesAdapterNewReservation.ViewHolder> {

    private static final int REQUEST_SIGNUP = 0;
    private final Context context;
    private List<Service> services = new ArrayList<>();
    private TextView cost;
    private int acount;
    public MessagesAdapterNewReservation(Context context,TextView cost)
    {
        this.context = context;
        this.cost=cost;
        cost.setText("0");
        acount = 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.recyclerview_new_reserve_client, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position )
    {
        Service service = services.get( position );
        viewHolder.name.setText( service.getName() );
        viewHolder.price.setText( service.getPrice());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView status = (TextView)v.findViewById(R.id.status);
                TextView textView;
                View row = (View) v.findViewById(R.id.row);
                if(!status.getText().toString().equals(">")){
                    status.setText(">");
                    row.setBackgroundColor(Color.parseColor("#61d698"));
                    textView = (TextView)v.findViewById(R.id.price);
                    int value = Integer.parseInt(textView.getText().toString());
                    acount = Integer.parseInt(cost.getText().toString());
                    acount = acount +value;
                    cost.setText(""+acount);
                }else {
                    row.setBackgroundColor(0x00000000);
                    textView = (TextView)v.findViewById(R.id.price);
                    int value = Integer.parseInt(textView.getText().toString());
                    acount = Integer.parseInt(cost.getText().toString());
                    acount = acount - value;
                    cost.setText(""+acount);
                    status.setText("");
                }

            }
        });
        viewHolder.name.setVisibility( View.GONE);
        viewHolder.price.setVisibility( View.GONE );
        viewHolder.name.setVisibility( View.VISIBLE );
        viewHolder.price.setVisibility( View.VISIBLE );
    }

    @Override
    public int getItemCount()
    {
        return services.size();
    }

    public void addMessage( Service message )
    {
        services.add( 0, message );
        notifyDataSetChanged();
    }

    public void removeMessage( Professional message )
    {
        services.remove( message );
        notifyDataSetChanged();
    }

    static class ViewHolder  extends RecyclerView.ViewHolder
    {
        @BindView( R.id.name )
        TextView name;

        @BindView( R.id.price)
        TextView price;

        ViewHolder( View view )
        {
            super( view );
            ButterKnife.bind( this, view );
        }
    }

}
