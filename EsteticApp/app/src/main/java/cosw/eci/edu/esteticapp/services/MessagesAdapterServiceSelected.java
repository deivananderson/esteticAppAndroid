package cosw.eci.edu.esteticapp.services;

import android.content.Context;
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

public class MessagesAdapterServiceSelected extends RecyclerView.Adapter<MessagesAdapterServiceSelected.ViewHolder> {

    private static final int REQUEST_SIGNUP = 0;
    private final Context context;
    private List<Service> services = new ArrayList<>();
    public MessagesAdapterServiceSelected(Context context )
    {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.recyclerview_new_service_professional, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position )
    {
        Service service = services.get( position );
        viewHolder.name.setText( service.getName() );
        viewHolder.description.setText( service.getDescription() );
        viewHolder.price.setText(service.getPrice());
        viewHolder.name.setVisibility( View.VISIBLE );
        viewHolder.description.setVisibility( View.VISIBLE );
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

    public void removeMessage( Service message )
    {
        services.remove( message );
        notifyDataSetChanged();
    }

    static class ViewHolder  extends RecyclerView.ViewHolder
    {
        @BindView( R.id.name )
        TextView name;

        @BindView( R.id.description)
        TextView description;

        @BindView( R.id.price)
        TextView price;

        ViewHolder( View view )
        {
            super( view );
            ButterKnife.bind( this, view );
        }
    }
}
