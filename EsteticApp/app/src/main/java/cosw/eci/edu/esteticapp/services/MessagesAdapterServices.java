package cosw.eci.edu.esteticapp.services;

import android.content.Context;
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

public class MessagesAdapterServices extends RecyclerView.Adapter<MessagesAdapterServices.ViewHolder> {

    private final Context context;

    private List<Professional> professionals = new ArrayList<>();

    public MessagesAdapterServices(Context context )
    {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.reciclerview_servicios, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position )
    {
        Professional professional = professionals.get( position );
        viewHolder.name.setText( professional.getName() );
        viewHolder.services.setText( professional.getServices() );
        viewHolder.email.setText(professional.getEmail());
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
