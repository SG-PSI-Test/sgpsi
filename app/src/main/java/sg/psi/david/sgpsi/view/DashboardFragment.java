package sg.psi.david.sgpsi.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import api.model.ErrorResponse;
import api.model.GetPsiResponse;
import api.model.PsiItems;
import engine.BaseEngine;
import presenter.BasePresenter;
import presenter.PsiInfoPresenter;
import sg.psi.david.sgpsi.R;
import sg.psi.david.sgpsi.view.adapters.RegionSmxyAdapter;


public class DashboardFragment extends BaseFragment implements
        BasePresenter.PresenterCallback, RegionSmxyAdapter.OnEvent {

    private RecyclerView rcRegionSmxyDetails;
    private RegionSmxyAdapter regionSmxyAdapter;
    private List<PsiItems> psiItemsList = new ArrayList<>();

    private PsiInfoPresenter psiInfoPresenter;

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public DashboardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        init(view);
        getPsiInfo();
        return view;
    }

    private void init(View view) {

        rcRegionSmxyDetails = view.findViewById(R.id.rv_dashboard_smxy_details);
        rcRegionSmxyDetails.setHasFixedSize(true);

        psiInfoPresenter = new PsiInfoPresenter(getContext(), this);
        regionSmxyAdapter = new RegionSmxyAdapter(getContext(), psiItemsList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),
                1, GridLayoutManager.VERTICAL, false);
        //TODO Enhance UI
       /* gridLayoutManager.setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return (position == 0 ? 1 : 2);
                    }
                }
        );*/

        rcRegionSmxyDetails.setLayoutManager(gridLayoutManager);
        rcRegionSmxyDetails.setAdapter(regionSmxyAdapter);
    }

    private void getPsiInfo() {
        psiInfoPresenter.getPsiInfoWholeDay();
        showProgressMeterDialog("");
    }


    @Override
    public <J, K> void onDone(J classType, K callbackObj) {
        if (callbackObj instanceof GetPsiResponse) {
            GetPsiResponse getPsiResponse = (GetPsiResponse) callbackObj;
            regionSmxyAdapter.updatePsiList(getPsiResponse.getItems());

        }
        hideProgressMeterDialog();
    }

    @Override
    public <J> void onError(J classType, ErrorResponse errorResponse) {
        hideProgressMeterDialog();
    }

    @Override
    public void onItemClick(PsiItems psiItems) {
        //TODO: Display more details
    }
}
