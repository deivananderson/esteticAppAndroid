package cosw.eci.edu.esteticapp.services;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.activities.client.NewReservationActivity;

/**
 * Created by USUARIO on 25/04/2017.
 */

public class MessagesAdapterReservationsProfessional extends RecyclerView.Adapter<MessagesAdapterReservationsProfessional.ViewHolder> {

    private final Context context;

    private List<Reservation> reservations = new ArrayList<>();

    public MessagesAdapterReservationsProfessional(Context context )
    {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.recyclerview_reservations_professional, parent, false );
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
        viewHolder.imageView.setImageBitmap(reservation.getImageUrl());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final TextView name = (TextView) v.findViewById(R.id.nameProfessional);
                final TextView state = (TextView)v.findViewById(R.id.state_reservations);
                final  ImageView imageView = (ImageView)v.findViewById(R.id.circleView);
                new AlertDialog.Builder(context)
                        .setTitle(name.getText().toString())
                        .setMessage("The reservation is:"+state.getText().toString())
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNeutralButton("Modify",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(context, NewReservationActivity.class);
                                intent.putExtra("nameProfessional",name.getText().toString());
                                intent.putExtra("email",name.getText().toString()+"@mail.com");
                                intent.putExtra("services","");
                                imageView.buildDrawingCache();
                                Bitmap image= imageView.getDrawingCache();
                                intent.putExtra("BitmapImage",image);
                                context.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                state.setText("Cancel");
                                state.setTextColor(Color.RED);
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        if ( reservation.getImageUrl() != null )
        {
            viewHolder.name.setVisibility( View.VISIBLE );
            viewHolder.services.setVisibility( View.VISIBLE );
            viewHolder.imageView.setVisibility( View.VISIBLE );
            //Picasso.with( context ).load( reservation.getImageUrl() ).into( viewHolder.imageView );
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
