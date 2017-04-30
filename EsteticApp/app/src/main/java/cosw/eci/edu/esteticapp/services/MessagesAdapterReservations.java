package cosw.eci.edu.esteticapp.services;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cosw.eci.edu.esteticapp.R;

/**
 * Created by USUARIO on 25/04/2017.
 */

public class MessagesAdapterReservations extends RecyclerView.Adapter<MessagesAdapterReservations.ViewHolder> {

    private final Context context;

    private List<Reservation> reservations = new ArrayList<>();

    public MessagesAdapterReservations(Context context )
    {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.recyclerview_reservations, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position )
    {
        Reservation reservation = reservations.get( position );
        viewHolder.name.setText( reservation.getProfessional() );
        viewHolder.services.setText( reservation.getServices() );
        viewHolder.state.setText(reservation.getState());
        viewHolder.price.setText(reservation.getPrice());
        viewHolder.date.setText(reservation.getDate());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView name = (TextView) v.findViewById(R.id.nameProfessional);
                TextView state = (TextView)v.findViewById(R.id.state_reservations);
                new AlertDialog.Builder(context)
                        .setTitle(name.getText().toString())
                        .setMessage("The reservation is:"+state.getText().toString())
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNeutralButton("Modify",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        if ( reservation.getImageUrl() != null )
        {
            viewHolder.name.setVisibility( View.GONE );
            viewHolder.services.setVisibility( View.GONE );
            viewHolder.imageView.setVisibility( View.VISIBLE );
            Picasso.with( context ).load( reservation.getImageUrl() ).into( viewHolder.imageView );
        }
        else
        {
            viewHolder.name.setVisibility( View.VISIBLE );
            viewHolder.services.setVisibility( View.VISIBLE );
        }
    }

    @Override
    public int getItemCount()
    {
        return reservations.size();
    }

    public void addMessage( Reservation message )
    {
        reservations.add( 0, message );
        notifyDataSetChanged();
    }

    public void removeMessage( Professional message )
    {
        reservations.remove( message );
        notifyDataSetChanged();
    }

    static class ViewHolder  extends RecyclerView.ViewHolder
    {
        @BindView( R.id.nameProfessional )
        TextView name;

        @BindView( R.id.services)
        TextView services;

        @BindView( R.id.state_reservations)
        TextView state;

        @BindView(R.id.price)
        TextView price;

        @BindView(R.id.date)
        TextView date;

        @BindView( R.id.circleView )
        ImageView imageView;

        ViewHolder( View view )
        {
            super( view );
            ButterKnife.bind( this, view );
        }
    }

}
