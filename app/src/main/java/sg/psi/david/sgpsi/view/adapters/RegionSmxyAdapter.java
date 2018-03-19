package sg.psi.david.sgpsi.view.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import api.model.PsiItems;
import api.model.Readings;
import sg.psi.david.sgpsi.R;

/**
 * Created by Hexa-David.Foo on 3/18/2018.
 */

public class RegionSmxyAdapter extends RecyclerView.Adapter<RegionSmxyAdapter.ItemHolder> {

    private List<PsiItems> psiItemsList;
    private RegionSmxyAdapter.OnEvent onEventListener;
    private Context context;

    public RegionSmxyAdapter(Context context, List<PsiItems> psiItemsList, RegionSmxyAdapter.OnEvent onEventListener) {
        this.psiItemsList = psiItemsList;
        this.onEventListener = onEventListener;
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_card_detail, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, int position) {
        holder.bind(psiItemsList.get(position), onEventListener);
        holder.tvCardTitle.setText(psiItemsList.get(position).getTimeStamp());

        holder.tvCardSubTitle.setText(context.getString(R.string.global_lbl_psi));
        holder.tvDescTopLeftTitle.setText(context.getString(R.string.global_lbl_central) + ":");
        holder.tvDescTopRightTitle.setText(context.getString(R.string.global_lbl_west) + ":");
        holder.tvDescBottomLeftTitle.setText(context.getString(R.string.global_lbl_east) + ":");
        holder.tvDescBottomRightTitle.setText(context.getString(R.string.global_lbl_north) + ":");
        holder.tvDescBottomLeft2Title.setText(context.getString(R.string.global_lbl_south) + ":");
        double index = 0l;
        index = psiItemsList.get(position).getReadings().getPsi_24Hourly().getCentral();
        holder.tvDescTopLeftValue.setText(String.valueOf(index));
        holder.tvDescTopLeftValue.setTextColor(mapColorIndicator(index));
        index = psiItemsList.get(position).getReadings().getPsi_24Hourly().getWest();
        holder.tvDescTopRightValue.setText(String.valueOf(index));
        holder.tvDescTopRightValue.setTextColor(mapColorIndicator(index));
        index = psiItemsList.get(position).getReadings().getPsi_24Hourly().getEast();
        holder.tvDescBottomLeftValue.setText(String.valueOf(index));
        holder.tvDescBottomLeftValue.setTextColor(mapColorIndicator(index));
        index = psiItemsList.get(position).getReadings().getPsi_24Hourly().getNorth();
        holder.tvDescBottomRightValue.setText(String.valueOf(index));
        holder.tvDescBottomRightValue.setTextColor(mapColorIndicator(index));
        index = psiItemsList.get(position).getReadings().getPsi_24Hourly().getSouth();
        holder.tvDescBottomLeft2Value.setText(String.valueOf(index));
        holder.tvDescBottomLeft2Value.setTextColor(mapColorIndicator(index));
    }

    @Override
    public int getItemCount() {
        return psiItemsList.size();
    }

    public void updatePsiList(List<PsiItems> psiItemsList) {
        this.psiItemsList.clear();
        this.psiItemsList.addAll(psiItemsList);
        notifyDataSetChanged();
    }

    private int mapColorIndicator(Double value) {
        if (value <= 50) {
            return Color.GREEN;
        } else if (value > 50 && value <= 100) {
            return Color.BLUE;
        } else if (value > 100 && value <= 200) {
            return Color.MAGENTA;
        } else if (value > 200 && value <= 300) {
            return Color.YELLOW;
        } else {
            return Color.RED;
        }
    }


    public enum Region {
        NONE, NATIONAL, NORTH, SOUTH, CENTRAL, EAST, WEST;
    }

    private Pair<Region, Double> getCriticalReadings(PsiItems psiItems) {
        double tempIndex = 0;
        Region region = Region.NONE;
        Readings readings = psiItems.getReadings();
        double centralIndex = 0;
        double nationalIndex = 0;
        double northIndex = 0;
        double eastIndex = 0;
        double westIndex = 0;
        double southIndex = 0;

        centralIndex = readings.getPsi_24Hourly().getCentral();
        nationalIndex = readings.getPsi_24Hourly().getNational();
        northIndex = readings.getPsi_24Hourly().getNorth();
        eastIndex = readings.getPsi_24Hourly().getEast();
        southIndex = readings.getPsi_24Hourly().getSouth();
        westIndex = readings.getPsi_24Hourly().getWest();

        if (nationalIndex > tempIndex) {
            tempIndex = nationalIndex;
            region = Region.NATIONAL;
        } else if (centralIndex > tempIndex) {
            tempIndex = centralIndex;
            region = Region.CENTRAL;
        } else if (northIndex > tempIndex) {
            tempIndex = northIndex;
            region = Region.NORTH;
        } else if (eastIndex > tempIndex) {
            tempIndex = eastIndex;
            region = Region.EAST;
        } else if (westIndex > tempIndex) {
            tempIndex = westIndex;
            region = Region.WEST;
        } else if (southIndex > tempIndex) {
            tempIndex = southIndex;
            region = Region.SOUTH;
        }

        if (region != Region.NONE) {
            return Pair.create(region, tempIndex);
        } else {
            return null;
        }
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

        public void bind(final PsiItems psiItems, final OnEvent onEventListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onEventListener.onItemClick(psiItems);
                }
            });
        }
    }

    public interface OnEvent {
        void onItemClick(PsiItems psiItems);
    }

}


