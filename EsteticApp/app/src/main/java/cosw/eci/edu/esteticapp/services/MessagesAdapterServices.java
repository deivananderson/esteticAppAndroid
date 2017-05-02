package cosw.eci.edu.esteticapp.services;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.activities.client.NewReservationActivity;

/**
 * Created by USUARIO on 25/04/2017.
 */

public class MessagesAdapterServices extends RecyclerView.Adapter<MessagesAdapterServices.ViewHolder> {

    private static final int REQUEST_SIGNUP = 0;
    private final Context context;
    private List<Professional> professionals = new ArrayList<>();
    public MessagesAdapterServices(Context context )
    {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.recyclerview_servicios, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position )
    {
        Professional professional = professionals.get( position );
        viewHolder.name.setText( professional.getName() );
        viewHolder.services.setText( professional.getServices() );
        viewHolder.email.setText(professional.getEmail());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView name = (TextView) v.findViewById(R.id.nameProfessional);
                TextView email = (TextView) v.findViewById(R.id.email);
                TextView service = (TextView)v.findViewById(R.id.services);
                Toast.makeText(context, "You select: "+name.getText().toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, NewReservationActivity.class);
                intent.putExtra("nameProfessional",name.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("services",service.getText().toString());
                context.startActivity(intent);
            }
        });

        if ( professional.getImageUrl() != null )
        {
            viewHolder.name.setVisibility( View.GONE );
            viewHolder.services.setVisibility( View.GONE );
            viewHolder.imageView.setVisibility( View.VISIBLE );
            Picasso.with( context ).load( professional.getImageUrl() ).into( viewHolder.imageView );
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
        return professionals.size();
    }

    public void addMessage( Professional message )
    {
        professionals.add( 0, message );
        notifyDataSetChanged();
    }

    public void removeMessage( Professional message )
    {
        professionals.remove( message );
        notifyDataSetChanged();
    }

    static class ViewHolder  extends RecyclerView.ViewHolder
    {
        @BindView( R.id.nameProfessional )
        TextView name;

        @BindView( R.id.services)
        TextView services;

        @BindView( R.id.email)
        TextView email;

        @BindView( R.id.circleView )
        ImageView imageView;

        ViewHolder( View view )
        {
            super( view );
            ButterKnife.bind( this, view );
        }
    }

}
