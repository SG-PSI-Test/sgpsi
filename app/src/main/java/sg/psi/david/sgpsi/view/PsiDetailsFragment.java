package sg.psi.david.sgpsi.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.model.ErrorResponse;
import api.model.GetPsiResponse;
import api.model.PsiItems;
import api.model.Readings;
import api.model.SubIndexDetails;
import constants.Constants;
import presenter.BasePresenter;
import presenter.PsiInfoPresenter;
import sg.psi.david.sgpsi.R;
import sg.psi.david.sgpsi.view.adapters.ReadingDetailAdapter;
import sg.psi.david.sgpsi.view.adapters.RegionSmxyAdapter;


public class PsiDetailsFragment extends BaseFragment  {

    private static String ARG_KEY_READINGS = "ARG_KEY_READINGS";

    private RecyclerView rvDetails;
    private ReadingDetailAdapter readingDetailAdapter;
    List<Pair<Constants.ItemIndex, SubIndexDetails>> mapDetailTypeList = new ArrayList<>() ;

    private Readings readings;

    public static PsiDetailsFragment newInstance(Readings readings) {
        PsiDetailsFragment fragment = new PsiDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_KEY_READINGS, readings);
        fragment.setArguments(args);
        return fragment;
    }

    public PsiDetailsFragment() {
    }

    @Override
    public void onStart(){
        super.onStart();
        if(getArguments() != null){
            readings = getArguments().getParcelable(ARG_KEY_READINGS);
            mapDetails();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        rvDetails = view.findViewById(R.id.rv_dashboard_smxy_details);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        readingDetailAdapter = new ReadingDetailAdapter(getContext(),  mapDetailTypeList);
        rvDetails.setLayoutManager(manager);
        rvDetails.setAdapter(readingDetailAdapter);
    }

    private void mapDetails(){
        mapDetailTypeList.clear();
        if(readings != null){
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.PSI_24_HOURLY, readings.getPsi_24Hourly()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.O3_SUB_INDEX, readings.getO3SubIndex()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.O3_8_HOUR_MAX, readings.getO3_8HourMax()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.PM25_24_HOURLY, readings.getPm25_24Hourly()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.PM25_SUB_INDEX, readings.getPm25SubIndex()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.SO2_24_HOURLY, readings.getSo2_24Hourly()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.SO2_SUB_INDEX, readings.getSo2SubIndex()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.NO2_1_HOUR_MAX, readings.getNo2_1HourMax()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.CO_8_HOUR_MAX, readings.getCo8HourMax()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.PM10_24_HOURLY, readings.getPm10_24hourly()));
            mapDetailTypeList.add(new Pair<>(Constants.ItemIndex.PM10_SUB_INDEX, readings.getPm10SubIndex()));

            readingDetailAdapter.updateList(mapDetailTypeList);
        }
    }

}
