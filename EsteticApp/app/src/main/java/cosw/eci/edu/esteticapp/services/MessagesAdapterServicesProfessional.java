package cosw.eci.edu.esteticapp.services;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cosw.eci.edu.esteticapp.R;

/**
 * Created by USUARIO on 25/04/2017.
 */

public class MessagesAdapterServicesProfessional extends RecyclerView.Adapter<MessagesAdapterServicesProfessional.ViewHolder> {

    private static final int REQUEST_SIGNUP = 0;
    private final Context context;
    private List<Service> services = new ArrayList<>();
    public MessagesAdapterServicesProfessional(Context context )
    {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.recyclerview_servicices_professional, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position )
    {
        final Service service = services.get( position );
        viewHolder.name.setText( service.getName() );
        viewHolder.description.setText( service.getDescription() );
        viewHolder.price.setText(service.getPrice());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final TextView name = (TextView) v.findViewById(R.id.nameService);
                final TextView descripction = (TextView)v.findViewById(R.id.descripction);
                final TextView price = (TextView)v.findViewById(R.id.price);
                new AlertDialog.Builder(context)
                        .setTitle(name.getText().toString())
                        .setMessage("Selecto one the option:")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNeutralButton("Update",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                /*Alert update price new service*/
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle("Update a service");
                                builder.setMessage("Set price of the service");
                                final EditText input = new EditText(context);
                                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                                builder.setView(input);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        price.setText("$"+input.getText().toString());
                                    }
                                });
                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });

                                builder.show();
                            }
                        })
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                services.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
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
        @BindView( R.id.nameService )
        TextView name;

        @BindView( R.id.descripction)
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
