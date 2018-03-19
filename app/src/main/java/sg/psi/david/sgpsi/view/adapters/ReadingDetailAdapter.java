package sg.psi.david.sgpsi.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import api.model.SubIndexDetails;
import constants.Constants;
import sg.psi.david.sgpsi.R;


/**
 * Created by Hexa-David.Foo on 3/18/2018.
 */

public class ReadingDetailAdapter extends RecyclerView.Adapter<ReadingDetailAdapter.ItemHolder> {

    public List<Pair<Constants.ItemIndex, SubIndexDetails>> mapReadingsList = new ArrayList<>();
    private Context context;

    public ReadingDetailAdapter(Context context, List<Pair<Constants.ItemIndex, SubIndexDetails>> mapReadingsList) {
        this.mapReadingsList = mapReadingsList;
        this.context = context;
    }

    public void updateList(List<Pair<Constants.ItemIndex, SubIndexDetails>> mapDetailTypeList) {
        this.mapReadingsList.clear();
        this.mapReadingsList.addAll(mapDetailTypeList);
        notifyDataSetChanged();

    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_card_detail, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.tvCardTitle.setText(mapReadingsList.get(position).first.getName(context));
        holder.tvDescTopLeftTitle.setText(context.getString(R.string.global_lbl_central));
        holder.tvDescTopRightTitle.setText(context.getString(R.string.global_lbl_west));
        holder.tvDescBottomLeftTitle.setText(context.getString(R.string.global_lbl_east));
        holder.tvDescBottomRightTitle.setText(context.getString(R.string.global_lbl_north));
        holder.tvDescBottomLeft2Title.setText(context.getString(R.string.global_lbl_south));
        holder.tvDescTopLeftValue.setText(mapReadingsList.get(position).second.getCentral().toString());
        holder.tvDescTopRightValue.setText(mapReadingsList.get(position).second.getWest().toString());
        holder.tvDescBottomLeftValue.setText(mapReadingsList.get(position).second.getEast().toString());
        holder.tvDescBottomRightValue.setText(mapReadingsList.get(position).second.getNorth().toString());
        holder.tvDescBottomLeft2Value.setText(mapReadingsList.get(position).second.getSouth().toString());
    }

    @Override
    public int getItemCount() {
        return mapReadingsList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private TextView tvCardTitle;
        private TextView tvCardSubTitle;
        private TextView tvDescTopLeftTitle;
        private TextView tvDescTopRightTitle;
        private TextView tvDescBottomLeftTitle;
        private TextView tvDescBottomRightTitle;
        private TextView tvDescTopLeftValue;
        private TextView tvDescTopRightValue;
        private TextView tvDescBottomLeftValue;
        private TextView tvDescBottomRightValue;
        private TextView tvDescBottomLeft2Title;
        private TextView tvDescBottomLeft2Value;


        ItemHolder(View itemView) {
            super(itemView);
            tvCardTitle = (TextView) itemView.findViewById(R.id.tv_item_card_title);
            tvCardSubTitle = (TextView) itemView.findViewById(R.id.tv_item_card_subtitle);
            tvDescTopLeftTitle = (TextView) itemView.findViewById(R.id.tv_item_topleft_title);
            tvDescTopRightTitle = (TextView) itemView.findViewById(R.id.tv_item_topright_title);
            tvDescBottomLeftTitle = (TextView) itemView.findViewById(R.id.tv_item_bottomleft_title);
            tvDescBottomLeft2Title = (TextView) itemView.findViewById(R.id.tv_item_bottomleft_2_title);
            tvDescBottomRightTitle = (TextView) itemView.findViewById(R.id.tv_item_bottomright_title);
            tvDescTopLeftValue = (TextView) itemView.findViewById(R.id.tv_item_topleft_value);
            tvDescTopRightValue = (TextView) itemView.findViewById(R.id.tv_item_topright_value);
            tvDescBottomLeftValue = (TextView) itemView.findViewById(R.id.tv_item_bottomleft_value);
            tvDescBottomRightValue = (TextView) itemView.findViewById(R.id.tv_item_bottomright_value);
            tvDescBottomLeft2Value = (TextView) itemView.findViewById(R.id.tv_item_bottomleft_2_value);

        }
    }
}
